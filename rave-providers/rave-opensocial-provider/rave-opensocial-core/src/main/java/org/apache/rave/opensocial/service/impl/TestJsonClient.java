package org.apache.rave.opensocial.service.impl;

import java.io.IOException;

import org.apache.rave.opensocial.service.impl.json.Persons;
import org.apache.shindig.common.crypto.BlobCrypterException;

public class TestJsonClient {

	public static void main(String[] args) throws BlobCrypterException, IOException {

		
		Persons p = new JsonClient("http://localhost/system/opensocial/personservice", "bert1", "bert1", "").retrieveJsonObject(Persons.class);
		
		System.out.println(p);

	}

}
