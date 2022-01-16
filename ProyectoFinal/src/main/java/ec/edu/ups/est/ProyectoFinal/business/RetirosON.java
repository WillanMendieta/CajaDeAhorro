package ec.edu.ups.est.ProyectoFinal.business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CuentaDAO;
import ec.edu.ups.est.ProyectoFinal.dao.MovimientoDAO;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Movimiento;

@Stateless
public class RetirosON implements RetirosONLocal {
	@Inject
	private MovimientoDAO movimientoDAO;
	
	@Inject
	private CuentaDAO cuentaDAO;
	
	public void retiro(Movimiento movimiento)  throws Exception {
		Cuenta cuenta = movimiento.getCuenta();
		Double saldoCuenta = cuenta.getSaldo();
		Double montoTransferencia = movimiento.getMonto();
		if (saldoCuenta >= montoTransferencia) {
			cuenta.setSaldo(saldoCuenta - montoTransferencia);
			movimientoDAO.insert(movimiento);
			cuentaDAO.upgrade(cuenta);
		} else {
			throw new Exception("La cuenta no tiene saldo suficiente");
		}
	}
}
