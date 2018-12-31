package com.hashnet.hellorouter.router;

import org.restlet.Context;
import org.restlet.routing.Router;

import com.hashnet.hellorouter.filter.Blocker;
import com.hashnet.hellorouter.target.Tracer;

public class MyRouter extends Router {
	public MyRouter(Context context) {
		super(context);
		
		this.attach("http://localhost:8083/", new Tracer(context));
		this.attach("http://localhost:8083/block", new Blocker(context));
	}
}
