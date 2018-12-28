package com.hashnet.hellorestlet;

import java.io.IOException;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class HelloClient {
	public static void main(String[] args) throws ResourceException, IOException {
		ClientResource clientResource = new ClientResource("http://localhost:8080");
		Representation clientRepresentation = clientResource.get();
		clientRepresentation.write(System.out);
	}
}
