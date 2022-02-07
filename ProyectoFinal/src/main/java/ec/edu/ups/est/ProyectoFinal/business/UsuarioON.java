package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.UsuarioDAO;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Stateless
public class UsuarioON {

	@Inject
	private UsuarioDAO usuarioDAO;


	public void insertarUsuario(Usuario u) throws Exception {
		if (!this.validaCedula(u.getCedula()))
			throw new Exception("Cedula Incorrecta");
		if (!this.validarCorreo(u.getCorreo()))
			throw new Exception("Correo Incorrecto Debe Contener @ ");
		if (!this.validarContrasena(u.getContra()))
			throw new Exception("Contraseña Incorrecta Debe Contener 8 Caracteres Minimo");
		if (!this.validarContrasenaCarac(u.getContra()))
			throw new Exception("Contraseña Incorrecta Debe Contener ( @ * - )");
		if (!this.validarTelefono(u.getTelefono()))
			throw new Exception("Teléfono Incorrecto Son 10 Números");
		
		usuarioDAO.insert(u);
	}

	public List<Usuario> getUsuarios() {
		return usuarioDAO.getList();
	}

	public Usuario getUsuario(String cedula) {
		return usuarioDAO.read(cedula);
	}

	public boolean validaCedula(String cedula) {
		if (cedula.length() == 10) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validarCorreo(String correo) {
		if (correo.contains("@")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validarContrasena(String contrasena) {
		if (contrasena.length() >= 8) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validarContrasenaCarac(String contrasena) {
		if (contrasena.contains("@") || contrasena.contains("*") || contrasena.contains("-")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validarTelefono(String telefono) {
		if (telefono.length() == 10) {
			return true;
		} else {
			return false;
		}
	}

}
