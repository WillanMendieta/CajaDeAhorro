package ec.edu.ups.est.ProyectoFinal.business;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;


import ec.edu.ups.est.ProyectoFinal.model.TipoMovimiento;
@Local
public interface TipoMovimientoONLocal {
	
	public void crear(TipoMovimiento tipoMovimiento)  throws Exception;
	public TipoMovimiento buscar(int id);
}
