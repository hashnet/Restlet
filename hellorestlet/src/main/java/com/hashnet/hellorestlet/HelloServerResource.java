package com.hashnet.hellorestlet;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloServerResource extends ServerResource {
	@Get
	public String represent() {
		return "Hello world of restlet.";
	}
}
