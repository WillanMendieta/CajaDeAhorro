package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.GiroON;
import ec.edu.ups.est.ProyectoFinal.model.Giro;

@Named
@RequestScoped
public class GiroBean {

	private Giro newgiro = new Giro();
	private List<Giro> giros;
	
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
	}
	
	public String guardarGiro()	{
		try {
			giroON.insertarGiro(newgiro);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "lista-giros?faces-redirect=true";
	}
	
	public List<Giro> getGiros() {
		return giros;
	}

	public void setGiros(List<Giro> giros) {
		this.giros = giros;
	}
	
	
	

}
