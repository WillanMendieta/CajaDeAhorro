package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CajeroDAO;
import ec.edu.ups.est.ProyectoFinal.model.Cajero;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;


public interface CajeroONLocal {

	
	
	public void guardar(Cajero p) throws Exception ;
	
	public List<Cajero> getClientes() ;
	
	
	public Cajero getCliente(int Codigo);
	
	public void guardarCuenta(Cuenta cue) throws Exception;

}
