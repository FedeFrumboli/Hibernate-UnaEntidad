package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();

	public Cliente traer(long idCliente) {
		Cliente c = dao.traer(idCliente);
		return c;
	}

	public Cliente traer(int dni) {
		Cliente c = dao.traer(dni);
		return c;
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
// consultar si existe un cliente con el mismo dni, si existe arrojar la
// Excepcion - HECHO
		if (traer(dni) != null) {
			throw new Exception ("El DNI ya existe en la base de datos.");
		}
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return dao.agregar(c);
	}

	public void modificar(Cliente c) throws Exception{
//implementar antes de actualizar que no exista un cliente con el mismo
//documento a modificar y con el mismo id, lanzar la Exception
		Cliente objeto = traer(c.getDni());
		if (objeto != null && c.getIdCliente() != objeto.getIdCliente()){
			throw new Exception ("Ya existe un cliente con ese DNI.");
		}
		dao.actualizar(c);
	}

	public void eliminar(long idCliente) throws Exception {
//en este caso es física en gral. no se se aplicaría este caso de uso, si
//se hiciera habría que validar que el cliente no tenga dependencias
		if (traer(idCliente) == null) {
			throw new Exception ("No existe un usuario con el ID " + idCliente + ".");
		}
		Cliente c = dao.traer(idCliente);
// Implementar que si es null que arroje la excepción la Excepción
		dao.eliminar(c);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}
}