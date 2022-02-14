package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CajeroDAO;
import ec.edu.ups.est.ProyectoFinal.dao.CuentaDAO;
import ec.edu.ups.est.ProyectoFinal.model.Cajero;



@Stateless
public class CajeroON implements CajeroONLocal{
	
	@Inject
	private CajeroDAO cajeroDAO;
	
	@Inject
	private CuentaDAO cuentaDAO;
	
	/*
	 * El metodo guardar tiene como parametros el objeto Cajero.
	 * Este metodo guarda en la base de datos al cajero o actualiza si es que ya existe. 
	 */
	public void guardar(Cajero p) throws Exception {
		if(cajeroDAO.read(p.getId())== null)
			cajeroDAO.insert(p);
		else 
			cajeroDAO.update(p);
		
	}
	
	/*
	 *  El metodo probarCajero recibe como parámetros el ID del cajero el cual se quiere aprobar.
	 *  Como resultado se actualiza el campo estado, intruduciendo aprobado en  tabla del cajero espesifico.
	 */
	
	public void aprobarCajero(int idCajero) {
	
		Cajero cajero = cajeroDAO.read(idCajero);
		cajero.setEstado("Aprobado");
		cajeroDAO.update(cajero);
	}
	
	/*
	 * El metodo negarCajero recibe como parámetros el ID del cajero el cual se quiere negar.
	 * Como resultado se actualiza el campo estado, intruduciendo Negado en  tabla del cajero espesifico.
	 */
	
	public void negarCajero(int idCajero) {
		Cajero cajero = cajeroDAO.read(idCajero);
		cajero.setEstado("Negado");
		cajeroDAO.update(cajero);
	}
	
	/*
	 * Este metodo lista todos los cajeros de la base de datos.
	 */
	
	public List<Cajero> getCajeros() {
		return cajeroDAO.getList();
		
	}
	
	/*
	 * Este metodo obtiene un cajero especifico por medio del ID
	 */
	
	public Cajero getCajeroId(int Codigo) {
		return cajeroDAO.read(Codigo);
	}

}
