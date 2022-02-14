package ec.edu.ups.est.ProyectoFinal.business;

import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.TipoAportacionDAO;
import ec.edu.ups.est.ProyectoFinal.model.TipoAportacion;

public class TipoAportacionON {
	@Inject
	private TipoAportacionDAO tipoAportacionDAO;
	
	/*
	 * El metodo crear tiene como parametros de ingreso un objeto tipoAportacion, realiza 
	 * verificacion si el tipo de aportacion existe si no es el caso ingresa 
	 * 
	 */
	
	public void crear(TipoAportacion tipoAportacion)  throws Exception {
		TipoAportacion tipoAportacionSearched = tipoAportacionDAO.read(tipoAportacion.getId());
		if (tipoAportacionSearched == null) {
			tipoAportacionDAO.insert(tipoAportacion);
			System.out.println("Tipo de aportacion insertado");
		} else {
			throw new Exception("El tipo de aportacion ya existe");
		}
	}
	
	/*
	 * El metodo Buscar, busca en la base de datos un tipo de aportacion y devuelve 
	 * un objeto tipoAportacion.
	 */
	public TipoAportacion buscar(int id) {
		return tipoAportacionDAO.read(id);
	}
}
