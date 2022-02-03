package ec.edu.ups.est.ProyectoFinal.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.CuentasONLocal;
import ec.edu.ups.est.ProyectoFinal.business.PagoServicioONLocal;

@Named
@RequestScoped
public class PagoServicioBean {

	@Inject
	private PagoServicioONLocal pagoServicioON;
	
	@Inject
	private CuentasONLocal cuentaON;
}
