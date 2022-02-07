package ec.edu.ups.est.ProyectoFinal.business;


import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.est.ProyectoFinal.model.TipoUsuario;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;
@Local
public interface UsuarioONLocal {
	public Usuario getUsuario(String cedula);
	public void insertarUsuario(Usuario u) throws Exception;
	public List<Usuario> getUsuarios();
	public boolean validaCedula(String cedula);
	public boolean validarCorreo(String correo);
	public boolean validarContrasena(String contrasena);
	public boolean validarContrasenaCarac(String contrasena);
	public boolean validarTelefono(String telefono);
}
