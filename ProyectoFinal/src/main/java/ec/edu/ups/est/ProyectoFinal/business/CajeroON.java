package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CajeroDAO;
import ec.edu.ups.est.ProyectoFinal.dao.CuentaDAO;
import ec.edu.ups.est.ProyectoFinal.model.Cajero;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;


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
	
	public void guardarCuenta(Cuenta cue) throws Exception{
		if(cuentaDAO.read(cue.getTipoCuenta())==null)
			cuentaDAO.insert(cue);
		else
			cuentaDAO.upgrade(cue);
	}
	
	public List<Cajero> getClientes() {
		return cajeroDAO.getList();
		
	}
	
	public Cajero getCliente(int Codigo) {
		return cajeroDAO.read(Codigo);
	}

}
