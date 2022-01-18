package ec.edu.ups.est.ProyectoFinal.business;



import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CuentaDAO;
import ec.edu.ups.est.ProyectoFinal.dao.MovimientoDAO;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Movimiento;

@Stateless			
public class MovimientoON implements MovimientoONLocal {
	@Inject
	private MovimientoDAO daoMovimiento;
	
	@Inject
	private CuentaDAO cuentaDAO;
	
	
	
	public void insertarMovimientos(Movimiento m) {
		
		daoMovimiento.insert(m);
		
	}
	
	
	
	public void retiro(Movimiento movimiento)  throws Exception {
		Cuenta cuenta = movimiento.getCuenta();
		Double saldoCuenta = cuenta.getSaldo();
		Double montoTransferencia = movimiento.getMonto();
		System.out.println("Id MOVIMIENTO !!!!!!!" + movimiento.getIdMovimiento());
		if (saldoCuenta >= montoTransferencia) {
			cuenta.setSaldo(saldoCuenta - montoTransferencia);
			daoMovimiento.insert(movimiento);
			cuentaDAO.upgrade(cuenta);
		} else {
			throw new Exception("La cuenta no tiene saldo suficiente");
		}
	}
	
	public void deposito(Movimiento movimiento)  throws Exception {
		Cuenta cuenta = movimiento.getCuenta();
		Double saldoCuenta = cuenta.getSaldo();
		Double montoTransferencia = movimiento.getMonto();
		System.out.println("Id MOVIMIENTO !!!!!!!" + movimiento.getIdMovimiento());
			cuenta.setSaldo(saldoCuenta + montoTransferencia);
			daoMovimiento.insert(movimiento);
			cuentaDAO.upgrade(cuenta);
		
	}
	
}
