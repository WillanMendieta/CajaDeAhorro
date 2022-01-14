package ec.edu.ups.est.ProyectoFinal.business;

import javax.ejb.Local;

import ec.edu.ups.est.ProyectoFinal.model.Movimiento;

@Local
public interface MovimientoONLocal {
	public void insertarMovimientos(Movimiento m);
	public void retiro(Movimiento movimiento) throws Exception;
	public void deposito(Movimiento movimiento)  throws Exception;
}
