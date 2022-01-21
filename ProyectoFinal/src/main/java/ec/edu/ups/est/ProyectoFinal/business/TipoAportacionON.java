package ec.edu.ups.est.ProyectoFinal.business;

import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.TipoAportacionDAO;
import ec.edu.ups.est.ProyectoFinal.model.TipoAportacion;

public class TipoAportacionON {
	@Inject
	private TipoAportacionDAO tipoAportacionDAO;
	
	public void crear(TipoAportacion tipoAportacion)  throws Exception {
		TipoAportacion tipoAportacionSearched = tipoAportacionDAO.read(tipoAportacion.getId());
		if (tipoAportacionSearched == null) {
			tipoAportacionDAO.insert(tipoAportacion);
			System.out.println("Tipo de aportacion insertado");
		} else {
			throw new Exception("El tipo de aportacion ya existe");
		}
	}
	
	public TipoAportacion buscar(int id) {
		return tipoAportacionDAO.read(id);
	}
}
