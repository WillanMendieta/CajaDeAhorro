package ec.edu.ups.est.ProyectoFinal.business;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CuentaDAO;
import ec.edu.ups.est.ProyectoFinal.dao.PagoServicioDAO;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.PagoServicio;


@Stateless
public class PagoServicioON {

	@Inject
	private PagoServicioDAO servicioDAO;
	
	@Inject
	private CuentaDAO cuentaDAO;
	

	
	public void guardarPago(double monto,String servicio, String numeroCuenta) throws Exception {
		PagoServicio ps= new PagoServicio();
		ps.setMonto(monto);
		ps.setServicio(servicio);
		ps.setEstado(false);
		Cuenta cuenta = cuentaDAO.read(numeroCuenta);
		if (cuenta == null) {
			throw new Exception("La cuenta no existe");
		}
		ps.setCuenta(cuenta);
		servicioDAO.insert(ps);
	}
	
	public void pagarServicio(int idPago)  throws Exception {
		PagoServicio ps=servicioDAO.read(idPago);
		Cuenta cuenta = ps.getCuenta();
		Double saldoCuenta = cuenta.getSaldo();
		Double montoPago = ps.getMonto();
		System.out.println("Id MOVIMIENTO !!!!!!!" + ps.getIdPagoServico());
			cuenta.setSaldo(saldoCuenta - montoPago);
			ps.setEstado(true);
			servicioDAO.upgrade(ps);
			cuentaDAO.upgrade(cuenta);
		
	}

	public List<PagoServicio> getPagoServicios() {
		return servicioDAO.getList();
	}
	
	public List<PagoServicio> getPagoServiciosCuenta(String numeroCuenta) {
		return servicioDAO.getListPorCuenta(numeroCuenta);
	}
}
