package ec.edu.ups.est.ProyectoFinal.business;



import java.util.List;

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
	
	/*
	 * El metodo insertarMovimiento recibe como parametros un objeto movimiento he inserta en la base de datos.
	 */
	
	public void insertarMovimientos(Movimiento m) {
		daoMovimiento.insert(m);
	}
	
	/*
	 * El metodo retiro recibew como parametros un ubjeto de tipo movimiento el cual inserta a la tabla un movimiento de tipo retiro,
	 * antes de eso verificando que tenga saldo la cuenta.
	 * 
	 */
	
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
	
	/*
	 * El metodo deposito recibe como parametros un objeto de tipo movimiento el cual inserta a la tabla movimiento de tipo de deposito
	 * 
	 */
	
	public void deposito(Movimiento movimiento)  throws Exception {
		Cuenta cuenta = movimiento.getCuenta();
		Double saldoCuenta = cuenta.getSaldo();
		Double montoTransferencia = movimiento.getMonto();
		System.out.println("Id MOVIMIENTO !!!!!!!" + movimiento.getIdMovimiento());
			cuenta.setSaldo(saldoCuenta + montoTransferencia);
			daoMovimiento.insert(movimiento);
			cuentaDAO.upgrade(cuenta);
		
	}
	
	/*
	 * El metodo getMovimiento obtiene una lista de los movimentos de la base de datos.
	 * 
	 */
	
	public List<Movimiento> getMovimientos() {
		return daoMovimiento.getList();
	}
	
	/*
	 * El metodo getMovimientoPorCuenta obtiene una lista de los movimientos pero buscad por el numero de cuenta 
	 */
	
	public List<Movimiento> getMovimientosPorCuenta(String numeroCuenta) {
		return daoMovimiento.getListPorCuenta(numeroCuenta);
	}
	
	
}
