package com.hashnet.hellofilter.filter;

import java.util.Random;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Status;
import org.restlet.routing.Filter;

public class Blocker extends Filter {
	private final Random rand;
	
	public Blocker(Context context) {
		super(context);
		
		rand = new Random(System.currentTimeMillis());
	}

	@Override
	protected int beforeHandle(Request request, Response response) {
		if(rand.nextBoolean()) {
			response.setStatus(Status.CLIENT_ERROR_FORBIDDEN);
			
			return Filter.STOP;
		} else {
			return Filter.CONTINUE;
		}
	}
}
