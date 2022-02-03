package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.GiroDAO;
import ec.edu.ups.est.ProyectoFinal.model.Giro;

@Stateless
public class GiroON {

	@Inject
	private GiroDAO giroDAO;
	
	public void insertarGiro(Giro g) throws Exception{
		giroDAO.insert(g);
	}
	
	public List<Giro> getGiros(){
		return giroDAO.getList();
	}
	
	public Giro getGiros(int codigo) {
		return giroDAO.read(codigo);
	}
	
	

}
