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
	

	
	public void guardarPago(double monto,String servicio, String cedulaPersona) throws Exception {
		PagoServicio ps= new PagoServicio();
		ps.setMonto(monto);
		ps.setServicio(servicio);
		ps.setEstado(false);
		Usuario usuario = usuarioDAO.read(cedulaPersona);
		if (usuario == null) {
			throw new Exception("El usuario para el crédito no existe");
		}
		List<PagoServicio> serviciosUsuario = usuario.getPagoServicios();
		serviciosUsuario.add(ps);
		usuario.setPagoServicios(serviciosUsuario);
		usuarioDAO.upgrade(usuario);
	}
	
	public void pagarServicio(int idPago)  throws Exception {
		PagoServicio ps=servicioDAO.read(idPago);
		Double montoPago = ps.getMonto();
		System.out.println("Id MOVIMIENTO !!!!!!!" + ps.getIdPagoServico());
			ps.setEstado(true);
			servicioDAO.upgrade(ps);
		
	}

	public List<PagoServicio> getPagoServicios() {
		return servicioDAO.getList();
	}
	

	public PagoServicio getPagoServicio(int id) {
		return servicioDAO.read(id);
	}
}
