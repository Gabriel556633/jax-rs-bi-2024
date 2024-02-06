package org.restapi.crud.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.restapi.crud.crud.model.modelClient;

import jakarta.ws.rs.core.Response;

public class crudservice {
	

	
	public crudservice(){
		
		try {
			System.out.println("CONEFCTANDO");
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
	}


    private static List<modelClient> listaClientes = new ArrayList<modelClient>() {
        {
            add(new modelClient("0013845290" ,"Gabriel","Borja",36,
                    "98583xxx000","05/02/2024",null));
            add(new modelClient("0013845290" ,"Gabriel","Borja",36,
                    "98583xxx000","05/02/2024",null));
            add(new modelClient("0013845280" ,"Andrea","Moscoso",38,
                    "00583xxx000","01/02/2023",null));
        }
    };

	
    public Response getClients() {
    	return Response.ok(listaClientes).build();
		
    }
    
	public Response getClientById(String id){
		
		if(id.length()>10 || id.length()<10) {
			return Response.status(500, "ERROR NO PUEDE SER MAYOR DE 10 DIGITOS EL CODIGO").build();
		}
	
		for( int j=0 ; j>=id.length();j++) {
			boolean existe = listaClientes.get(j).getId().equals(id);
			System.out.println("............."+existe);
			if(!existe) {
				return Response.status(500, "ERROR NO EXISTE CLIENTE").build();
			}
		}
		
		try {
		int indice;
		int i=0;
		for( i=0 ; i>id.length();i++) {
			indice = listaClientes.get(i).getId().indexOf(id);
		}	
		System.out.println("............."+listaClientes.get(i));
		 return Response.ok(listaClientes.get(i)).build();
		}catch(Exception e ){
			return Response.status(500, "ERROR EXISTE MAS DE UN USUARIO EN UNA BUSQUEDA DE SOLO UNO ").build();
		}
	}
	
	
	
	
	


}