package ec.edu.ups.est.ProyectoFinal.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.GiroON;

@Named
@RequestScoped
public class GiroBean {

	@Inject
	private GiroON giroON;
	
	private int codigo;
	
	/*public void crearGiro() {
		return null;
	}*/

}
