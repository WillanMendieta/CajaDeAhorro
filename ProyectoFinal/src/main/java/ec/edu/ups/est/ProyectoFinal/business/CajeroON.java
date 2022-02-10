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
	
	
	public void guardar(Cajero p) throws Exception {
		if(cajeroDAO.read(p.getId())== null)
			cajeroDAO.insert(p);
		else 
			cajeroDAO.update(p);
		
	}
	
	public void aprobarCajero(int idCajero) {
	
		Cajero cajero = cajeroDAO.read(idCajero);
		cajero.setEstado("Aprobado");
		cajeroDAO.update(cajero);
	}
	
	
	public void negarCajero(int idCajero) {
		Cajero cajero = cajeroDAO.read(idCajero);
		cajero.setEstado("Negado");
		cajeroDAO.update(cajero);
	}
	
	
	public List<Cajero> getCajeros() {
		return cajeroDAO.getList();
		
	}
	
	public Cajero getCajeroId(int Codigo) {
		return cajeroDAO.read(Codigo);
	}

}
