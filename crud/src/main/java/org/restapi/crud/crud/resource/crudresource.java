package org.restapi.crud.crud.resource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.restapi.crud.crud.model.modelClient;
import org.restapi.crud.crud.service.crudservice;


import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/crud")
public class crudresource {
	
	crudservice service = new crudservice();

	@Path("/clients")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response  getClient() throws URISyntaxException, IOException{
		 return service.getClients();		
	}
	
	@Path("/clientById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response  getClient(@PathParam("id") String id) throws URISyntaxException, IOException {
		return service.getClientById(id);
		
	}
	

	
	
}
