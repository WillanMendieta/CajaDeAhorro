package ec.edu.ups.est.ProyectoFinal.business;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CreditoDAO;
import ec.edu.ups.est.ProyectoFinal.dao.UsuarioDAO;
import ec.edu.ups.est.ProyectoFinal.model.Amortizacion;
import ec.edu.ups.est.ProyectoFinal.model.Credito;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Stateless
public class CreditoON implements CreditoONLocal {
	@Inject
	private CreditoDAO creditoDAO;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	public void solicitarCredito(double montoSolicitado, int numeroCuotas, String cedulaPersona) throws Exception {
		Credito credito = new Credito();
		credito.setInteres(0.08);
		credito.setMontoSolicitado(montoSolicitado);
		credito.setFecha(new Date());
		credito.setPlazosCredito(numeroCuotas);
		Usuario usuario = usuarioDAO.read(cedulaPersona);
		if (usuario == null) {
			throw new Exception("El usuario para el crédito no existe");
		}
		List<Credito> creditosUsuario = usuario.getCreditos();
		creditosUsuario.add(credito);
		usuario.setCreditos(creditosUsuario);
		usuarioDAO.upgrade(usuario);
	}
	
	public void pagarCredito(int idCredito) throws Exception {
		Credito creditoGuardado = creditoDAO.read(idCredito);
		System.out.println("CREDITO GUARDADO ES:  !!!!   " + creditoGuardado.getMontoSolicitado());
		if (creditoGuardado != null) {
			List<Amortizacion> amortizacionesCredito = creditoGuardado.getAmortizaciones();
			Amortizacion nuevaAmortizacion = new Amortizacion();
			nuevaAmortizacion.setFechaPago(new Date());
			double montoInteres = creditoGuardado.getMontoSolicitado() * (creditoGuardado.getInteres() / (double)creditoGuardado.getPlazosCredito());
			double montoMensual = creditoGuardado.getMontoSolicitado() / (double)creditoGuardado.getPlazosCredito();
			nuevaAmortizacion.setMontoPagado(montoInteres + montoMensual);
			amortizacionesCredito.add(nuevaAmortizacion);
			creditoGuardado.setAmortizaciones(amortizacionesCredito);
			
			creditoDAO.upgrade(creditoGuardado);
		}
	}
	
	public List<Amortizacion> cargarAmortizaciones(int idCredito) {
		return creditoDAO.read(idCredito).getAmortizaciones();
	}
}
