package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CuentaDAO;
import ec.edu.ups.est.ProyectoFinal.dao.UsuarioDAO;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Stateless
public class CuentaON {

	@Inject
	private CuentaDAO cuentaDAO;

	@Inject
	private UsuarioDAO usuarioDAO;

	public void insertarCuenta(Cuenta c) {
		Usuario usu = usuarioDAO.read(c.getUsuario().getCedula());
		if (usu == null) {
			usuarioDAO.insert(c.getUsuario());

		} else {
			usuarioDAO.upgrade(c.getUsuario());
		}

		cuentaDAO.insert(c);

	}

	public Usuario getUsuario(String cedula) {
		Usuario u = usuarioDAO.read(cedula);
		return u;
	}

	public List<Cuenta> getCuenta() {
		return cuentaDAO.getList();
	}

}
