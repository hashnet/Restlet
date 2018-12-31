package com.hashnet.hellofilter.application;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.Protocol;

import com.hashnet.hellofilter.filter.Blocker;
import com.hashnet.hellofilter.target.Tracer;

public class HelloFilterApp extends Application {
	public static void main(String[] args) throws Exception {
		Server server = new Server(Protocol.HTTP, 8082);
		server.setNext(new HelloFilterApp());
		server.start();
	}

	@Override
	public Restlet createInboundRoot() {
		Blocker blocker = new Blocker(getContext());
		blocker.setNext(new Tracer(getContext()));
		
		return blocker;
	}
}
