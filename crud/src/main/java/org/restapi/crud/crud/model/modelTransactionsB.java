package org.restapi.crud.crud.model;;

public class modelTransactionsB {

	private int credito;

    private int debito;

    private int positivo1;

    private int positivo2;

	public modelTransactionsB() {
		super();
	}

	public modelTransactionsB(int credito, int debito, int positivo1, int positivo2) {
		super();
		this.credito = credito;
		this.debito = debito;
		this.positivo1 = positivo1;
		this.positivo2 = positivo2;
	}

	public int getCredito() {
		return credito;
	}

	public void setCredito(int credito) {
		this.credito = credito;
	}

	public int getDebito() {
		return debito;
	}

	public void setDebito(int debito) {
		this.debito = debito;
	}

	public int getPositivo1() {
		return positivo1;
	}

	public void setPositivo1(int positivo1) {
		this.positivo1 = positivo1;
	}

	public int getPositivo2() {
		return positivo2;
	}

	public void setPositivo2(int positivo2) {
		this.positivo2 = positivo2;
	}
    
    
}
