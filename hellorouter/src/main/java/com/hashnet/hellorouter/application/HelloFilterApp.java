package com.hashnet.hellorouter.application;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

import com.hashnet.hellorouter.router.MyRouter;

public class HelloFilterApp extends Application {
	public static void main(String[] args) throws Exception {
		Server server = new Server(Protocol.HTTP, 8083);
		server.setNext(new HelloFilterApp());
		server.start();
	}

	@Override
	public Restlet createInboundRoot() {
		Router router = new MyRouter(getContext());
		
		return router;
	}
}
