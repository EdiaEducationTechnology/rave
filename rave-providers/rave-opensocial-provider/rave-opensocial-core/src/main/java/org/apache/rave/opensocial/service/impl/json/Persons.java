
package org.apache.rave.opensocial.service.impl.json;

import java.util.List;

public class Persons{
   	private List<Results> results;

 	public List<Results> getResults(){
		return this.results;
	}
	public void setResults(List<Results> results){
		this.results = results;
	}
	@Override
	public String toString() {
		return "Persons [results=" + results + "]";
	}
}
