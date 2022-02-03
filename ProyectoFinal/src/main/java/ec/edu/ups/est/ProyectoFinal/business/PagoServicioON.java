package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CuentaDAO;
import ec.edu.ups.est.ProyectoFinal.dao.PagoServicioDAO;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Movimiento;
import ec.edu.ups.est.ProyectoFinal.model.PagoServicio;

@Stateless
public class PagoServicioON {

	@Inject
	private PagoServicioDAO servicioDAO;
	
	@Inject
	private CuentaDAO cuentaDAO;
	
	public void insertarPagoServicio(PagoServicio ps) {
		ps.setEstado(false);
		servicioDAO.insert(ps);
	}
	public void pagoServicio(int idPago)  throws Exception {
		PagoServicio ps=servicioDAO.read(idPago);
		Cuenta cuenta = ps.getCuenta();
		Double saldoCuenta = cuenta.getSaldo();
		Double montoPago = ps.getMonto();
		System.out.println("Id MOVIMIENTO !!!!!!!" + ps.getIdPagoServico());
			cuenta.setSaldo(saldoCuenta - montoPago);
			ps.setEstado(true);;
			servicioDAO.upgrade(ps);;
			cuentaDAO.upgrade(cuenta);
		
	}

	public List<PagoServicio> getPagoServicios() {
		return servicioDAO.getList();
	}
	
	public List<PagoServicio> getPagoServiciosCuenta(String numeroCuenta) {
		return servicioDAO.getListPorCuenta(numeroCuenta);
	}
}
