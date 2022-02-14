package ec.edu.ups.est.ProyectoFinal.business;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CuentaDAO;
import ec.edu.ups.est.ProyectoFinal.dao.PagoServicioDAO;
import ec.edu.ups.est.ProyectoFinal.dao.UsuarioDAO;
import ec.edu.ups.est.ProyectoFinal.model.Credito;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.PagoServicio;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;


@Stateless
public class PagoServicioON implements PagoServicioONLocal {

	@Inject
	private PagoServicioDAO servicioDAO;
	
	@Inject
	private CuentaDAO cuentaDAO;
	
	@Inject
	private UsuarioDAO usuarioDAO;
	
	
	/*
	 * El metodo guardarPago rcibe como parametros el monto, el servicio y la cedula de la persona
	 * verifica que la persona exista he ingresa el servicio al usuario.
	 */
	public void guardarPago(double monto,String servicio, String cedulaPersona) throws Exception {
		PagoServicio ps= new PagoServicio();
		ps.setMonto(monto);
		ps.setServicio(servicio);
		ps.setEstado(false);
		Usuario usuario = usuarioDAO.read(cedulaPersona);
		if (usuario == null) {
			throw new Exception("El usuario para el servicio no existe");
		}
		ps.setUsuario(usuario);
		List<PagoServicio> serviciosUsuario = usuario.getPagoServicios();
		serviciosUsuario.add(ps);
		usuario.setPagoServicios(serviciosUsuario);
		usuarioDAO.upgrade(usuario);
	}
	
	/*
	 * El metodo pagar servicio tiene como parametros el id de pago el cual busca en la base de datos 
	 * he actualiza a pagago en el campo correspidiente
	 */
	
	public void pagarServicio(int idPago)  throws Exception {		
		PagoServicio ps=servicioDAO.read(idPago);
		Usuario usuario=ps.getUsuario();
		Cuenta cuenta=usuario.getCuenta();
		Double montoPago = ps.getMonto();
		Double saldo=cuenta.getSaldo();
		cuenta.setSaldo(saldo - montoPago);
		System.out.println("Id MOVIMIENTO !!!!!!!" + ps.getIdPagoServico());
			ps.setEstado(true);
			servicioDAO.upgrade(ps);
			cuentaDAO.upgrade(cuenta);
		
	}
	
	/*
	 * El metodo getPagoServicios nos retorna un listado de todos los servicios que se tenga en la base de datos.
	 */

	public List<PagoServicio> getPagoServicios() {
		return servicioDAO.getList();
	}
	
	/*
	 * El metodo getPagoServicio tiene como parametro el id del servicio donde se obtiene un objeto de  PagoServicio con sus datos respectivos
	 */

	public PagoServicio getPagoServicio(int id) {
		return servicioDAO.read(id);
	}
}
