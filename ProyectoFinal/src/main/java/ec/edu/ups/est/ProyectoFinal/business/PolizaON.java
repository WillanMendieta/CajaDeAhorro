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
	
	/*
	 * El metodo generarPoliza recibe como parametros el monto inicio, el numero de cuotas y la cedula del cliente
	 * realiza las verificaciones si existe el usuario. 
	 * si existe el usuario se inserta en la base de datos.
	 */
	
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
	
	/*
	 * El metodo aceptarPoliza recibe como parametros monto de incio, numero de cuotas y la cedula de la persona
	 * realiza la verificacion del usuarui. Si supera la verificacion se inserta la poliza
	 * 
	 */
	
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
	
	/*
	 * El metodo aceptarPoliza recibe como parametro el id y actualiza el estado de la poliza
	 */
	public void aceptarPoliza2(int idPoliza) {
		Poliza polizaGuardado = polizaDAO.read(idPoliza);
		polizaGuardado.setEstaAprobado(true);
		Usuario usuarioPoliza = polizaGuardado.getUsuario();
		Cuenta cuentaUsuario = usuarioPoliza.getCuenta();
		cuentaUsuario.setSaldo(cuentaUsuario.getSaldo() + polizaGuardado.getMontoCobrar());
		polizaDAO.upgrade(polizaGuardado);
		cuentaDAO.upgrade(cuentaUsuario);
	}
	/*
	 * El metodo getPolizas obtiene lodas las polizas que se encuentran en la base de datos.
	 */
	
	public List<Poliza> getPolizas() {
		return polizaDAO.getList();
	}
	/*
	 * El metodo getPoliza obtiene la poliza especificando el id de la poliza
	 * 
	 */
	
	public Poliza getPoliza(int id) {
		return polizaDAO.read(id);
	}
	
	/*
	 * El metodo getPolizasUsuario obtiene la lista de las polizas que estan asociado a un usuario especifico. 
	 */
	public List<Poliza> getPolizasUsuario(String numeroCuenta){
		return polizaDAO.getListPorCuenta(numeroCuenta);
	}
	
}
