package com.javatpoint.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
@Path("/hello")
public class HelloService{
 	@GET
	public Response getMsg() {
 		String output = "Jersey say : ";
 		Manager.listEmployees();
 		return Response.status(200).entity(output).build();
 	}
}