package org.restapi.crud.crud.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.restapi.crud.crud.model.modelClient;
import org.restapi.crud.crud.model.modelTransactionsB;


import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.ws.rs.core.Response;

public class crudservice {

	public crudservice() {

		try {
			System.out.println("CONEFCTANDO");

		} catch (Exception e) {
			System.out.println(e + "data insert unsuccess.");
		}
	}
	
	/////////////////////////////////////////////////datos para pruebas sin base////////////////
	private static ArrayList<modelTransactionsB> listaTransacciones = new ArrayList<modelTransactionsB>() {
		{
			add(new modelTransactionsB(1500,1500,2000,500));
			add(new modelTransactionsB(5000,2000,10000,500));
			add(new modelTransactionsB(3000,2000,4000,1000));			
		}
	};
	
	private static List<modelClient> listaClientes = new ArrayList<modelClient>() {	
	};

	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	////////////////////////////////////////////////////////////////////////ALL
	public Response getClients() throws URISyntaxException, IOException {
		listaClientes.add(getJson());
		modelClient client2 = new modelClient();
		client2=getJson();
		client2.setId("0013845280");
		client2.setNombre("RIKARDO");
		listaClientes.add(client2);
		return Response.ok(listaClientes).build();
	}
	
	///////////////////////////////////////////////////////////////////////////by ID

	public Response getClientById(String id) throws URISyntaxException, IOException {
		listaClientes.add(getJson());
		if (id.length() > 10) {
			return Response.status(500, "ERROR NO PUEDE SER MAYOR DE 10 DIGITOS EL CODIGO").build();
		}
		if (id.length() < 10) {
			return Response.status(500, "ERROR NO PUEDE SER MENOR DE 10 DIGITOS EL CODIGO").build();
		}
		int count = 0;
		boolean existe;
		for (int j = 0; j < listaClientes.size(); j++) {
			existe = listaClientes.get(j).getId().contains(id);
			if (existe) {
				count = count + 1;
			}			
		}

		if (count == 0) {
			return Response.status(500, "ERROR NO EXISTE CLIENTE").build();
		}
		if (count > 1) {
			count = 0;
			return Response.status(500, "ERROR EXISTE MAS DE UN USUARIO EN UNA BUSQUEDA DE SOLO UNO").build();
		}
		
		int indice=0;
		for (int j = 0; j < listaClientes.size(); j++) {
			existe = listaClientes.get(j).getId().equals(id);
			if(existe==true) {
				indice=j;
				break;
			}
		}
		
		float saldo1 = 0;
		
		for(int x=0; x < listaClientes.get(indice).getMovimientos().size(); x++ ) {
			 saldo1 = listaClientes.get(indice).getMovimientos().get(x).getPositivo1()+
					 listaClientes.get(indice).getMovimientos().get(x).getPositivo2()-
					 listaClientes.get(indice).getMovimientos().get(x).getCredito()-
					 listaClientes.get(indice).getMovimientos().get(x).getDebito();
			 listaClientes.get(indice).setSaldo(saldo1);
			 System.out.println
			 (listaClientes.get(indice).getMovimientos().get(x).getPositivo1()+"+"+
					 listaClientes.get(indice).getMovimientos().get(x).getPositivo2()+"-"+
					 listaClientes.get(indice).getMovimientos().get(x).getCredito()+"-"+
					 listaClientes.get(indice).getMovimientos().get(x).getDebito()+"+");
			 }
		System.out.println("SALDO = "+saldo1);
		return Response.ok(listaClientes.get(indice)).build();}
	
	
	//////////////////////////////////////////leer JSON//////////
	

	public modelClient getJson() throws URISyntaxException, IOException {		
	

        byte[] jsonData = Files.readAllBytes(Paths.get("C:\\GBM\\jax-rs\\rest-api-using-jax-rs-crud-operation-\\rest api using jax-rs\\crud\\cliente.json"));
        ObjectMapper objectMapper = new ObjectMapper();

        modelClient client = objectMapper.readValue(jsonData, modelClient.class);

        System.out.println("Employee Object\n"+client.getApellido());
        System.out.println(client.getId());
		System.out.println(client.getNombre());
		System.out.println(client.getApellido());
		System.out.println(client.getEdad());
		System.out.println(client.getNumeroCuenta());
		System.out.println(client.getMovimientos());
		System.out.println(client.getSaldo());
		return client;	
	}
	


}

	

