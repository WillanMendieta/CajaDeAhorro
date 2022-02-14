package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CiudadDAO;
import ec.edu.ups.est.ProyectoFinal.dao.GiroDAO;
import ec.edu.ups.est.ProyectoFinal.model.Ciudad;
import ec.edu.ups.est.ProyectoFinal.model.Giro;

@Stateless
public class GiroON {

	@Inject
	private GiroDAO giroDAO;

	@Inject
	private CiudadDAO ciudadDAO;
	
	/*
	 * El metodo insertarGiro tiene como parametros el objeto Giro.
	 * El metodo da como resultado el ingreso del giro dentro de la base de datos.
	 */

	public void insertarGiro(Giro g) throws Exception {
		giroDAO.insert(g);
		
	}
	
	/*
	 * El metodo getGiros obtiene todos los giros que se encuentran en la base de datos en una lista.
	 */

	public List<Giro> getGiros() {
		return giroDAO.getList();
	}
	
	/*
	 * El metodo getGiros tiene como parámetros el id del giro, donde da como resultado el objeto giro.
	 */
	public Giro getGiros(int codigo) {
		return giroDAO.read(codigo);
	}
	
	/*
	 * El metodo getCiudad tiene como parámetros el id de la ciudad.
	 * Da como resultado al objeto Ciudad obtenido de la base de datos.
	 */
	public Ciudad getCiudad(int codigo) {

		Ciudad ciudad = ciudadDAO.read(codigo);
		return ciudad;

	}
}
