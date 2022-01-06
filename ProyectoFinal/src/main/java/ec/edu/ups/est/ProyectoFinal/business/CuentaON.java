package ec.edu.ups.est.ProyectoFinal.business;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CuentaDAO;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;

@Stateless
public class CuentaON {

	@Inject
	private CuentaDAO cuentaDAO;
	
	public void insertarCuenta(Cuenta c) throws Exception {
	cuentaDAO.insert(c);
		
	}
	
}
