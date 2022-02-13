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
	
	

	public Ciudad getUsuario(int codigo) {
		return ciudadDAO.read(codigo);
	}

	
	public void guardarCiudad(int codigoCiudad ,  double interes) {
		Ciudad ciudad = ciudadDAO.read(codigoCiudad);
		ciudad.setId(codigoCiudad);
		ciudad.setInteres(interes);		
		ciudadDAO.update(ciudad);
	}
	
	public List<Ciudad> listarCiudades() {
		return ciudadDAO.getList();
	}
	
}
