package com.hashnet.hellorestlet;

import java.io.IOException;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class HelloClient {
	public static void main(String[] args) throws ResourceException, IOException {
		ClientResource clientResource = new ClientResource("http://localhost:8080");
		clientResource.get().write(System.out);
	}
}
