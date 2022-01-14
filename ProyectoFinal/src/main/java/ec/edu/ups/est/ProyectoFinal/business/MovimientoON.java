package ec.edu.ups.est.ProyectoFinal.business;



import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.MovimientoDAO;
import ec.edu.ups.est.ProyectoFinal.model.Movimiento;

@Stateless			
public class MovimientoON implements MovimientoONLocal {
	@Inject
	private MovimientoDAO daoMovimiento;

	
	public void insertarMovimientos(Movimiento m) {
		
		daoMovimiento.insert(m);
		
	}
	
}
