 
package com.pine.services.web.resource;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
 
@Path("/books")
public class BooksResource {
 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/list")
	public Response list() { 
		return Response.ok().build(); 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/get/{id}")
	public Response get(@PathParam("id") String id) { 
		return Response.ok().build(); 
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(Map<String, Object> entity){ 
		return Response.ok().entity(entity).build(); 
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update") 
	public Response update(Map<String, Object> entity){ 
		return Response.ok().entity(entity).build(); 
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/delete/{id}") 
	public Response delete(@PathParam("id") String id){ 
		return Response.ok().build(); 
	}
}
