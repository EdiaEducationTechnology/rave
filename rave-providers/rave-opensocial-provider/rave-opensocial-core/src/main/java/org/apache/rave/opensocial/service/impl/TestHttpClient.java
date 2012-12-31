package org.apache.rave.opensocial.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.shindig.common.crypto.BlobCrypterException;

public class TestHttpClient {

	public static void main(String[] args) throws BlobCrypterException {

		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();

			ShindigToken st = new ShindigToken("bert1", "bert1");

			HttpGet getRequest = new HttpGet(
					"http://localhost/system/opensocial/personservice?token="
							+ st.getEncryptedToken());

			StringEntity input = new StringEntity(
					"{\"qty\":100,\"name\":\"iPad 4\"}");
			input.setContentType("application/json");
			// getRequest.setEntity(input);

			HttpResponse response = httpClient.execute(getRequest);

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			httpClient.getConnectionManager().shutdown();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
