package com.hashnet.hellorestletapplication;

import org.restlet.Application;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;

public class HelloRestletApplication extends Application 
{
    public static void main( String[] args ) throws Exception
    {
        Server helloServer = new Server(Protocol.HTTP, 8081);
        helloServer.setNext(new HelloRestletApplication());
        helloServer.start();
    }

	@Override
	public Restlet createInboundRoot() {
		return new Restlet() {
			@Override
			public void handle(Request request, Response response) {
				StringBuilder entity = new StringBuilder();
				entity.append("Method: " + request.getMethod());
				entity.append("\nResource URI: " + request.getResourceRef());
				entity.append("\nClient IP Address: " + request.getClientInfo().getAddress());
				entity.append("\nClient Agent Name: " + request.getClientInfo().getAgentName());
				entity.append("\nClient Agent Version: " + request.getClientInfo().getAgentVersion());
				
				response.setEntity(entity.toString(), MediaType.TEXT_PLAIN);
			}
		};
	}
    
    
}
