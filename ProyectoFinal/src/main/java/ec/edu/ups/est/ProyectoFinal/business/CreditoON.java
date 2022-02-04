package ec.edu.ups.est.ProyectoFinal.business;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CreditoDAO;
import ec.edu.ups.est.ProyectoFinal.dao.CuentaDAO;
import ec.edu.ups.est.ProyectoFinal.dao.UsuarioDAO;
import ec.edu.ups.est.ProyectoFinal.model.Amortizacion;
import ec.edu.ups.est.ProyectoFinal.model.Credito;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Stateless
public class CreditoON implements CreditoONLocal {
	@Inject
	private CreditoDAO creditoDAO;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Inject
	private CuentaDAO cuentaDAO;
	
	public void solicitarCredito(double montoSolicitado, int numeroCuotas, String cedulaPersona) throws Exception {
		Credito credito = new Credito();
		credito.setInteres(0.08);
		credito.setMontoSolicitado(montoSolicitado);
		credito.setFecha(new Date());
		credito.setPlazosCredito(numeroCuotas);
		credito.setEstaPagado(false);
		credito.setEstaAprobado(false);
		Usuario usuario = usuarioDAO.read(cedulaPersona);
		if (usuario == null) {
			throw new Exception("El usuario para el crédito no existe");
		}
		credito.setUsuario(usuario);
		creditoDAO.insert(credito);
	}
	
	public void aprobarCredito(int idCredito) {
		Credito creditoGuardado = creditoDAO.read(idCredito);
		creditoGuardado.setEstaAprobado(true);
		Usuario usuarioCredito = creditoGuardado.getUsuario();
		Cuenta cuentaUsuario = usuarioCredito.getCuenta();
		cuentaUsuario.setSaldo(cuentaUsuario.getSaldo() + creditoGuardado.getMontoSolicitado());
		creditoDAO.upgrade(creditoGuardado);
		cuentaDAO.upgrade(cuentaUsuario);
	}
	
	public List<Credito> getCreditos() {
		return creditoDAO.getList();
	}
	
	public void pagarCredito(int idCredito) throws Exception {
		Credito creditoGuardado = creditoDAO.read(idCredito);
		System.out.println("CREDITO GUARDADO ES:  !!!!   " + creditoGuardado.getMontoSolicitado());
		if (creditoGuardado != null && creditoGuardado.isEstaPagado() == false && creditoGuardado.isEstaAprobado() == true) {
			List<Amortizacion> amortizacionesCredito = creditoGuardado.getAmortizaciones();
			Amortizacion nuevaAmortizacion = new Amortizacion();
			nuevaAmortizacion.setFechaPago(new Date());
			double montoInteres = creditoGuardado.getMontoSolicitado() * (creditoGuardado.getInteres() / (double)creditoGuardado.getPlazosCredito());
			double montoMensual = creditoGuardado.getMontoSolicitado() / (double)creditoGuardado.getPlazosCredito();
			nuevaAmortizacion.setMontoPagado(montoInteres + montoMensual);
			amortizacionesCredito.add(nuevaAmortizacion);
			creditoGuardado.setAmortizaciones(amortizacionesCredito);
			if (amortizacionesCredito.size() == creditoGuardado.getPlazosCredito()) {
				creditoGuardado.setEstaPagado(true);
			}
			
			creditoDAO.upgrade(creditoGuardado);
		} else {
			throw new Error("El crédito no se ha podido encontrar o ya está pagado.");
		}
	}
	
	public List<Amortizacion> cargarAmortizaciones(int idCredito) {
		return creditoDAO.read(idCredito).getAmortizaciones();
	}
	
	public Credito getCredito(int id) {
		return creditoDAO.read(id);
	}
}
