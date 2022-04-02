package test;

import negocio.ClienteABM;

public class TestEliminarCliente {

	public static void main(String[] args) {
		
		ClienteABM abm = new ClienteABM();
		
		try {
			abm.eliminar(9);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
