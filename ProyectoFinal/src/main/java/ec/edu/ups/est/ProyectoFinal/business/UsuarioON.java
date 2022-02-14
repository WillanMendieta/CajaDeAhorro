package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.UsuarioDAO;
import ec.edu.ups.est.ProyectoFinal.model.TipoUsuario;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Stateless
public class UsuarioON implements UsuarioONLocal {

	@Inject
	private UsuarioDAO usuarioDAO;
	
	/*
	 * El metodo insertarUsuario tiene como parametrsos un objeto de tipo usuario 
	 * destro de este metodo se valida varios campos como: existencia de usuario en la base de datos, contraseña, correo, telefono
	 * una vez concluida las verificaciones inserta en la base de datos.
	 */

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
		if(!this.validarCedulaRepetida(u.getCedula()))
			throw new Exception("Cedula Repetida");
		
		usuarioDAO.insert(u);
	}
	
	/*
	 * El metodo validarCedulaRepetida realiza una lectura de la base de datos y devuelve un boleano.
	 */
	public boolean validarCedulaRepetida(String cedula) {
		Usuario usuario = usuarioDAO.read(cedula);
		if (usuario == null) {
			return true;
		}
		return false;
	}
	
	/*
	 * El metodo getUsuario lista todos los usuarios que tenemos en la base de datos.
	 */
	
	public List<Usuario> getUsuarios() {
		return usuarioDAO.getList();
	}
	
	/*
	 * El metodo getUsuario recibe como parametro un String donde ingresa el numero de cedula del usuario,
	 * Dando como resultado un objeto de tipo usuario con todos sus datos.
	 */
	public Usuario getUsuario(String cedula) {
		return usuarioDAO.read(cedula);
	}

	/*
	 * El metodo validarCedula recibe como parametros un String donde ingresa la cedula y verifica cuantos dijitos tiene 
	 * da como resultado un boleano.
	 */
	public boolean validaCedula(String cedula) {
		if (cedula.length() == 10) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * El metodo validarCorreo recibe como parametros un String donde ingresa el correo y verifica que los dijitos ingresados tiene un @
	 * da como resultado un boleano.
	 */
	public boolean validarCorreo(String correo) {
		if (correo.contains("@")) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * El metodo validarContrasena recibe como parametros un String donde ingresa la contraseña y verifica cuantos dijitos tiene 
	 * da como resultado un boleano.
	 */
	public boolean validarContrasena(String contrasena) {
		if (contrasena.length() >= 8) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * El metodo validarContrasenaCarac recibe como parametros un String donde ingresa la contraseña y verifica que dijitos se estan ingresando.
	 * da como resultado un boleano.
	 */
	public boolean validarContrasenaCarac(String contrasena) {
		if (contrasena.contains("@") || contrasena.contains("*") || contrasena.contains("-")) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * El metodo validarTelefono recibe como parametros un String donde ingresa el telefono y verifica cuantos dijitos tiene 
	 * da como resultado un boleano.
	 */

	public boolean validarTelefono(String telefono) {
		if (telefono.length() == 10) {
			return true;
		} else {
			return false;
		}
	}

}
