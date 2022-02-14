package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CiudadDAO;
import ec.edu.ups.est.ProyectoFinal.model.Ciudad;

@Stateless
public class CiudadON {

	@Inject
	private CiudadDAO ciudadDAO;
	
	/*
	 * El metodo getUsuario tiene como parametros codigo (ID del usuario).
	 * Este metodo devuelve a un usuario que conincida con su id de lo contrario devuelve un null.
	 */

	public Ciudad getUsuario(int codigo) {
		return ciudadDAO.read(codigo);
	}

	
	/*
	 * El metodo guardarCiudad tiene como parametros de ingreso el codigo de la idudad y el interez del mismo.
	 * Este metodo actualiza el interez de una ciudad.
	 */
	public void guardarCiudad(int codigoCiudad ,  double interes) {
		Ciudad ciudad = ciudadDAO.read(codigoCiudad);
		ciudad.setId(codigoCiudad);
		ciudad.setInteres(interes);		
		ciudadDAO.update(ciudad);
	}
	
	/*
	 * El metodo listarCiudades lista todas las ciudades que se encuentran en la base de datos.
	 */
	
	public List<Ciudad> listarCiudades() {
		return ciudadDAO.getList();
	}
	
}
