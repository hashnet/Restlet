package com.hashnet.hellorestlet;

import org.restlet.Server;
import org.restlet.data.Protocol;

public class HelloServer {
	public static void main(String[] args) throws Exception {
		Server helloServer = new Server(Protocol.HTTP, 8080, HelloServerResource.class);
		helloServer.start();
	}
}
