package org.apache.rave.opensocial.service.impl;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.shindig.common.crypto.BlobCrypterException;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.MappingJsonFactory;

public class JsonClient {
	private final String url;
	private final String ownerId;
	private final String viewerId;

	public JsonClient(String url, String ownerId, String viewerId) {
		this.url = url;
		this.ownerId = ownerId;
		this.viewerId = viewerId;
	}

	public <T> T retrieveJsonObject(Class<T> objectClass)
			throws BlobCrypterException, IOException {

		DefaultHttpClient httpClient = new DefaultHttpClient();

		ShindigToken st = new ShindigToken(ownerId, viewerId);

		HttpGet getRequest = new HttpGet(url + "?token="
				+ st.getEncryptedToken());

		StringEntity input = new StringEntity(
				"{\"qty\":100,\"name\":\"iPad 4\"}");
		input.setContentType("application/json");

		HttpResponse response = httpClient.execute(getRequest);

		// BufferedReader br = new BufferedReader(new InputStreamReader(
		// (response.getEntity().getContent())));

		// String output;
		// System.out.println("Output from Server .... \n");
		// while ((output = br.readLine()) != null) {
		// System.out.println(output);
		// }

		JsonFactory jsonFactory = new MappingJsonFactory(); // or, for data
															// binding,
															// org.codehaus.jackson.mapper.MappingJsonFactory
		org.codehaus.jackson.JsonParser jp = jsonFactory
				.createJsonParser(response.getEntity().getContent());

		T p = jp.readValueAs(objectClass);

		httpClient.getConnectionManager().shutdown();
		return p;

	}
}
