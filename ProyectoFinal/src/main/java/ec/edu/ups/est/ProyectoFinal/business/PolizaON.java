package ec.edu.ups.est.ProyectoFinal.business;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CuentaDAO;
import ec.edu.ups.est.ProyectoFinal.dao.PolizaDAO;
import ec.edu.ups.est.ProyectoFinal.dao.UsuarioDAO;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Poliza;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Stateless
public class PolizaON implements PolizaONLocal {
	@Inject
	private PolizaDAO polizaDAO;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Inject
	private CuentaDAO cuentaDAO;
	
	public void generarPoliza(double montoInicio, int numeroCuotas, String cedulaPersona) throws Exception {
		Poliza poliza = new Poliza();
		poliza.setInteres(0.05);
		poliza.setMontoInicio(montoInicio);
		poliza.setMontoCobrar((montoInicio* poliza.getInteres())+ montoInicio);
		poliza.setFecha(new Date());
		poliza.setPlazosPoliza(numeroCuotas);
		poliza.setEstaAprobado(false);
		Usuario usuario = usuarioDAO.read(cedulaPersona);
		if (usuario == null) {
			throw new Exception("El usuario para la poliza no existe");
		}
		poliza.setUsuario(usuario);
		polizaDAO.insert(poliza);
	}
	
	public void aceptarPoliza(double montoInicio, int numeroCuotas, String cedulaPersona) throws Exception {
		Poliza poliza = new Poliza();
		poliza.setInteres(0.05);
		poliza.setMontoInicio(montoInicio);
		poliza.setMontoCobrar(montoInicio* poliza.getInteres()+ montoInicio);
		poliza.setFecha(new Date());
		poliza.setPlazosPoliza(numeroCuotas);
		poliza.setEstaAprobado(true);
		Usuario usuario = usuarioDAO.read(cedulaPersona);
		if (usuario == null) {
			throw new Exception("El usuario para la poliza no existe");
		}
		poliza.setUsuario(usuario);
		polizaDAO.upgrade(poliza);
		//aceptarPoliza2(poliza.getId());
	}
	
	public void aceptarPoliza2(int idPoliza) {
		Poliza polizaGuardado = polizaDAO.read(idPoliza);
		polizaGuardado.setEstaAprobado(true);
		Usuario usuarioPoliza = polizaGuardado.getUsuario();
		Cuenta cuentaUsuario = usuarioPoliza.getCuenta();
		cuentaUsuario.setSaldo(cuentaUsuario.getSaldo() + polizaGuardado.getMontoCobrar());
		polizaDAO.upgrade(polizaGuardado);
		cuentaDAO.upgrade(cuentaUsuario);
	}
	
	public List<Poliza> getPolizas() {
		return polizaDAO.getList();
	}
	
	public Poliza getPoliza(int id) {
		return polizaDAO.read(id);
	}
}
