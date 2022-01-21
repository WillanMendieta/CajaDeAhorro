package ec.edu.ups.est.ProyectoFinal.business;


import javax.ejb.Local;

import ec.edu.ups.est.ProyectoFinal.model.TipoUsuario;
@Local
public interface TipoUsuarioONLocal {
	public void crear(TipoUsuario tipoUsuario)  throws Exception;
	public TipoUsuario buscar(int id);
}
