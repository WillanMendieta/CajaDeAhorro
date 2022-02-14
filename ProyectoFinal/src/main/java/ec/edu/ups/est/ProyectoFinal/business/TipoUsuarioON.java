package ec.edu.ups.est.ProyectoFinal.business;

import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.TipoUsuarioDAO;
import ec.edu.ups.est.ProyectoFinal.model.TipoUsuario;

public class TipoUsuarioON {

	@Inject
	private TipoUsuarioDAO tipoUsuarioDAO;
	
	/*
	 * El metodo crear recibe como parametros un objeto tipo usuario
	 * realiza verificaciones para ver si existe en la base de datos 
	 * si no es el caso se inserta en la base de datos.
	 */
	public void crear(TipoUsuario tipoUsuario) throws Exception {
		TipoUsuario tipoUsuarioSearched = tipoUsuarioDAO.read(tipoUsuario.getId());
		if (tipoUsuarioSearched == null) {
			tipoUsuarioDAO.insert(tipoUsuario);
			System.out.println("Tipo de usuario insertado");
		} else {
			throw new Exception("El tipo de usuario ya existe");
		}
	}
	
	/*
	 * El metodo buscar, busca en la base de datos por medio del id
	 */
	public TipoUsuario buscar(int id) {
		return tipoUsuarioDAO.read(id);
	}
}
