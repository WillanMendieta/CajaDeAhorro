package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.GiroON;
import ec.edu.ups.est.ProyectoFinal.model.Ciudad;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Giro;

@Named
@RequestScoped
public class GiroBean {

	private Giro newgiro = new Giro();
	private List<Giro> giros;
	private double interes;

	public Giro getNewgiro() {
		return newgiro;
	}

	public void setNewgiro(Giro newgiro) {
		this.newgiro = newgiro;
	}

	@Inject
	private GiroON giroON;

	@PostConstruct
	public void init() {
		giros = giroON.getGiros();
		/*newgiro = new Giro();*/
		newgiro.setCiudad(new Ciudad());
		newgiro.setCuenta(new Cuenta());
		
	}

	public String guardarGiro() {
		newgiro.setInteres(interes);
		try {
			newgiro.setMontoFinal((interes * newgiro.getValor())+newgiro.getValor());
			giroON.insertarGiro(newgiro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return null;
	}

	public List<Giro> getGiros() {
		return giros;
	}

	public void setGiros(List<Giro> giros) {
		this.giros = giros;
	}

	public String cargarCiudad() {
		int codigo = newgiro.getCiudad().getId();
		Ciudad ciudad = giroON.getCiudad(codigo);
		interes = ciudad.getInteres();
		newgiro.setCiudad(ciudad);
		return null;
	}
	
	
	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}
	
	

}
