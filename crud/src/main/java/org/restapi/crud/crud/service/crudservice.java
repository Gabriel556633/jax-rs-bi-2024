package org.restapi.crud.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.restapi.crud.crud.model.modelClient;
import org.restapi.crud.crud.model.modelTransactionsB;

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
		{
			add(new modelClient("0013845290", "Gabriel", "Borja", 36, "98583xxx000", "05/02/2024", listaTransacciones,0));
			add(new modelClient("0013845290", "Gabriel", "Borja", 36, "98583xxx000", "05/02/2024", listaTransacciones,0));
			add(new modelClient("0013845280", "Andrea", "Moscoso", 38, "00583xxx000", "01/02/2023",listaTransacciones,0));
			add(new modelClient("0013845270", "Daniela", "TIPSY", 38, "00583xxx000", "01/02/2023",listaTransacciones,0));
		}
	};

	///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	////////////////////////////////////////////////////////////////////////ALL
	public Response getClients() {
		return Response.ok(listaClientes).build();

	}
	
	///////////////////////////////////////////////////////////////////////////by ID

	public Response getClientById(String id) {

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
					 listaClientes.get(indice).getMovimientos().get(x).getDebito());
			 }
		System.out.println("SALDO = "+saldo1);
		return Response.ok(listaClientes.get(indice)).build();}
}

	

