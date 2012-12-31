package org.apache.rave.opensocial.service.impl;

import java.io.IOException;

import org.apache.rave.opensocial.service.impl.json.Persons;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.MappingJsonFactory;


public class JSONTest {

	public static void main(String a[]) throws JsonParseException, IOException{
		JsonFactory jsonFactory = new MappingJsonFactory(); // or, for data binding, org.codehaus.jackson.mapper.MappingJsonFactory 
		  org.codehaus.jackson.JsonParser jp = jsonFactory.createJsonParser("{\"results\":[{\"lastName\":\"Janie\",\"_charset_\":\"utf-8\",\"sakai:types\":[\"__MSG__COLLEGE_MATE__\",\"__MSG__SHARES_INTERESTS__\",\"__MSG__CLASSMATE__\"],\"_lastModifiedBy\":\"admin\",\"sakai:contactstorepath\":\"/~bert1/contacts\",\"_createdBy\":\"admin\",\"reference\":\"/~janie/public/authprofile\",\"_path\":\"/~bert1/contacts/janie\",\"sakai:state\":\"ACCEPTED\",\"sling:resourceType\":\"sakai/contact\",\"_created\":1355914481063,\"_id\":\"fWaLcEnKEeK6vNOeCgABPQ+\",\"targetUserId\":\"bert1\",\"_lastModified\":1355914674378,\"firstName\":\"Janie\"},{\"lastName\":\"Arie\",\"_charset_\":\"utf-8\",\"sakai:types\":[\"__MSG__CLASSMATE__\"],\"_lastModifiedBy\":\"admin\",\"sakai:contactstorepath\":\"/~bert1/contacts\",\"_createdBy\":\"admin\",\"reference\":\"/~arie/public/authprofile\",\"_path\":\"/~bert1/contacts/arie\",\"sakai:state\":\"ACCEPTED\",\"sling:resourceType\":\"sakai/contact\",\"_created\":1355927286067,\"_id\":\"TccYMEnoEeK23fSkCgABPQ+\",\"targetUserId\":\"arie\",\"_lastModified\":1355927350640,\"firstName\":\"Arie\"}]}");
		  
		  
		  Persons p =   jp.readValueAs(Persons.class);
		  
		  System.out.println(p);
	}
}
