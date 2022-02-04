package ec.edu.ups.est.ProyectoFinal.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Random;

import ec.edu.ups.est.ProyectoFinal.business.CuentasONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Named
@RequestScoped
public class CuentaBean {

	private Cuenta newcuenta = new Cuenta();
	private String cedulaUsuario = "";

	@Inject
	private CuentasONLocal cuentaON;

	@PostConstruct
	private void init() {
		newcuenta = new Cuenta();
		newcuenta.setUsuario(new Usuario());
	}

	public String getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public Cuenta getNewCuenta() {
		return newcuenta;
	}
	public Cuenta getCuenta(String numCue) {
	    newcuenta= this.cuentaON.getCuenta(numCue);
		return newcuenta;
	}

	public void setNewCuenta(Cuenta cuenta) {
		this.newcuenta = cuenta;
	}

	public void guardarCuenta() {
		Usuario usuario = getUsuario();
		usuario.setCuenta(newcuenta);
		newcuenta.setUsuario(usuario);
		cuentaON.insertarCuenta(newcuenta);
	}
	
	public String generarNumCuenta() {
		for(int i = 1; i<=10; i++)
		     System.out.println((int)(Math.random()*(9-1+1)+1));
		return null;
	}
	
	public Usuario getUsuario() {
		Usuario u = cuentaON.getUsuario(this.cedulaUsuario);
		return u;
	}
}
