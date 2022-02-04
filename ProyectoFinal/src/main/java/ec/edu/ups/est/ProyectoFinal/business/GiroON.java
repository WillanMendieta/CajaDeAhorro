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

	public void insertarGiro(Giro g) throws Exception {
		giroDAO.insert(g);
		
	}

	public List<Giro> getGiros() {
		return giroDAO.getList();
	}

	public Giro getGiros(int codigo) {
		return giroDAO.read(codigo);
	}

	public Ciudad getCiudad(int codigo) {

		Ciudad ciudad = ciudadDAO.read(codigo);
		return ciudad;

	}
}
