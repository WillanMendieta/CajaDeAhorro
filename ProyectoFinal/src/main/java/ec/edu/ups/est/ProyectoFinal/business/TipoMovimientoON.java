package ec.edu.ups.est.ProyectoFinal.business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.TipoMovimientoDAO;
import ec.edu.ups.est.ProyectoFinal.model.TipoMovimiento;

@Stateless
public class TipoMovimientoON implements TipoMovimientoONLocal {
	@Inject
	private TipoMovimientoDAO tipoMovimientoDAO;
	
	public void crear(TipoMovimiento tipoMovimiento)  throws Exception {
		TipoMovimiento tipoMovimientoSearched = tipoMovimientoDAO.read(tipoMovimiento.getId());
		if (tipoMovimientoSearched == null) {
			tipoMovimientoDAO.insert(tipoMovimiento);
			System.out.println("Tipo de movimiento insertado");
		} else {
			throw new Exception("El tipo de movimiento ya existe");
		}
	}
	
	public TipoMovimiento buscar(int id) {
		return tipoMovimientoDAO.read(id);
	}
}
