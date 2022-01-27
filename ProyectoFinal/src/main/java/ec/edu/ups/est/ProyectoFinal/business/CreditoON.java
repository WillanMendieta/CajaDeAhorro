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
		credito.setUsuario(usuario);
		creditoDAO.insert(credito);
	}
	
	public void pagarCredito(int idCredito) throws Exception {
		Credito creditoGuardado = creditoDAO.read(idCredito);
		System.out.println("CREDITO GUARDADO!!!!   " + creditoGuardado.getMontoSolicitado());
		if (creditoGuardado != null) {
			List<Amortizacion> amortizacionesCredito = creditoGuardado.getAmortizaciones();
			Amortizacion nuevaAmortizacion = new Amortizacion();
			nuevaAmortizacion.setCredito(creditoGuardado);
			nuevaAmortizacion.setFechaPago(new Date());
			nuevaAmortizacion.setMontoPagado(creditoGuardado.getMontoSolicitado() * (creditoGuardado.getInteres() / (double)creditoGuardado.getPlazosCredito()));
			amortizacionesCredito.add(nuevaAmortizacion);
			creditoGuardado.setAmortizaciones(amortizacionesCredito);
			creditoDAO.upgrade(creditoGuardado);
		}
	}
}
