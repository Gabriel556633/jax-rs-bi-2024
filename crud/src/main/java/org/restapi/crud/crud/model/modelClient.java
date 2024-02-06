package org.restapi.crud.crud.model;;

public class modelClient {

	private String id;

    private String nombre;

    private String apellido;

    private Integer edad;

    private String numeroCuenta;

    private String fechaCreacion;

    private modelTransactionsB[] movimientos;

	public modelClient() {
		super();
	}

	public modelClient(String id, String nombre, String apellido, Integer edad, String numeroCuenta,
			String fechaCreacion, modelTransactionsB[] movimientos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.numeroCuenta = numeroCuenta;
		this.fechaCreacion = fechaCreacion;
		this.movimientos = movimientos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public modelTransactionsB[] getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(modelTransactionsB[] movimientos) {
		this.movimientos = movimientos;
	}
    
	
}
