package org.apache.rave.opensocial.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.shindig.auth.AbstractSecurityToken;
import org.apache.shindig.auth.BlobCrypterSecurityToken;
import org.apache.shindig.common.crypto.BasicBlobCrypter;
import org.apache.shindig.common.crypto.BlobCrypter;
import org.apache.shindig.common.crypto.BlobCrypterException;

public class ShindigToken {
	public static final String EMBEDDED_KEY_PREFIX = "embedded:";
	public static final String CLASSPATH_KEY_PREFIX = "classpath:";

	private static final String CONTAINER = "default";
	private static final String DOMAIN = "default";

	private final String gadgetOwner;
	private final String gadgetViewer;

	private final String encryptedToken;
	private final BlobCrypter blobCrypter;

	private static BlobCrypter getBlobCrypter() throws IOException {
		File file = new File(
				"C:\\src\\nakamura\\contrib\\edia-opensocial\\src\\main\\resources\\security_token_encryption_key.txt");
		BlobCrypter crypter = new BasicBlobCrypter(FileUtils.readFileToString(
				file, "UTF-8"));
		return crypter;
	}

	public ShindigToken(final String gadgetOwner, final String gadgetViewer)
			throws IOException, BlobCrypterException {
		this.blobCrypter = getBlobCrypter();
		this.gadgetOwner = gadgetOwner;
		this.gadgetViewer = gadgetViewer;

		String widgetUrl = "http://localhost:8080/demogadgets/friends.xml";

		Map<String, String> values = new HashMap<String, String>();
		values.put(AbstractSecurityToken.Keys.APP_URL.getKey(), widgetUrl);
		values.put(AbstractSecurityToken.Keys.OWNER.getKey(), gadgetOwner);
		values.put(AbstractSecurityToken.Keys.VIEWER.getKey(), gadgetViewer);
		values.put(AbstractSecurityToken.Keys.TRUSTED_JSON.getKey(), "");

		BlobCrypterSecurityToken securityToken = new BlobCrypterSecurityToken(
				CONTAINER, DOMAIN, null, values);

		
		encryptedToken = blobCrypter.wrap(securityToken.toMap());
	}

	public ShindigToken(final String encryptedToken) throws IOException,
			BlobCrypterException {
		this.blobCrypter = getBlobCrypter();

		this.encryptedToken = encryptedToken;

		Map<String, String> values = blobCrypter.unwrap(encryptedToken);

		this.gadgetOwner = values
				.get(AbstractSecurityToken.Keys.OWNER.getKey());
		this.gadgetViewer = values.get(AbstractSecurityToken.Keys.VIEWER
				.getKey());

	}

	public String getEncryptedTokenForUrl() {
		return CONTAINER + ":" + encryptedToken;
	}

	public String getEncryptedToken() {
		return encryptedToken;
	}

	public String getGadgetOwner() {
		return gadgetOwner;
	}

	public String getGadgetViewer() {
		return gadgetViewer;
	}

	public static void main(String a[]) throws IOException,
			BlobCrypterException {
		String encryptedToken = new ShindigToken("bert1", "bert1")
				.getEncryptedToken();
		System.out.println(encryptedToken);

		System.out.println(new ShindigToken(encryptedToken).getGadgetOwner());

	}
}
