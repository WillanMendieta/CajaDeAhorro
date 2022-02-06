package ec.edu.ups.est.ProyectoFinal.business;


import javax.ejb.Local;

import ec.edu.ups.est.ProyectoFinal.model.TipoUsuario;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;
@Local
public interface UsuarioONLocal {
	public void crear(TipoUsuario tipoUsuario)  throws Exception;
	public Usuario getUsuario(String cedula);
}
