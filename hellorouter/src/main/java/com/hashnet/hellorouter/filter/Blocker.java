package com.hashnet.hellorouter.filter;

import java.util.Random;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Status;
import org.restlet.routing.Filter;

import com.hashnet.hellorouter.target.Tracer;

public class Blocker extends Filter {
	private final Random rand;
	
	public Blocker(Context context) {
		super(context);
		
		rand = new Random(System.currentTimeMillis());
		
		this.setNext(new Tracer(context));
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
