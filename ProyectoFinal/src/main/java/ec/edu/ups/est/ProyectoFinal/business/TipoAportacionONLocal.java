package ec.edu.ups.est.ProyectoFinal.business;

import javax.ejb.Local;

import ec.edu.ups.est.ProyectoFinal.model.TipoAportacion;
@Local
public interface TipoAportacionONLocal {
	public void crear(TipoAportacion tipoAportacion)  throws Exception;
	public TipoAportacion buscar(int id);
}
