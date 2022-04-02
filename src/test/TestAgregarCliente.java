package test;

import java.time.LocalDate;
import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args) {
		
		String apellido = "MC";
		String nombre = "Donald";
		int documento = 63541631;
		LocalDate fechaDeNacimiento = LocalDate.of(1988, 3, 14);
		
		ClienteABM abm = new ClienteABM();
		long ultimoIdCliente = -1;
		try {
			ultimoIdCliente = abm.agregar(apellido, nombre, documento, fechaDeNacimiento);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(ultimoIdCliente);
	}
}