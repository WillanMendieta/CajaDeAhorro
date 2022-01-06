package ec.edu.ups.est.ProyectoFinal.business;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.MovimientoDAO;
import ec.edu.ups.est.ProyectoFinal.model.Movimiento;

@Stateless			
public class MovimientoON implements MovimientoONLocal{
	
	@Inject
	private MovimientoDAO movi;
	
	public void insertarMovimientos(Integer d,String a, Integer b, Double c) {
		Movimiento m = new Movimiento();
		m.setIdMovimiento(d);
		m.setCuenta(a);
		m.setFecha(new Date());
		m.setIdMovimiento(b);
		m.setMonto(c);
		
		
		movi.insert(m);
		
	}
	
}
