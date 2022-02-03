package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.est.ProyectoFinal.model.Giro;

@Local
public interface GiroONLocal {

	public void insertarGiro(Giro g);
	public List<Giro> getGiros();
	public Giro getGiros(int codigo);
	
}
