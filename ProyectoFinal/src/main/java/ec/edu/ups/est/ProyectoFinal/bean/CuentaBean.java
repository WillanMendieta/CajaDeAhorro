package ec.edu.ups.est.ProyectoFinal.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Random;

import ec.edu.ups.est.ProyectoFinal.business.CuentaON;
import ec.edu.ups.est.ProyectoFinal.business.CuentasONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Named
@ViewScoped
public class CuentaBean implements Serializable {

	private Cuenta newcuenta = new Cuenta();

	@Inject
	private CuentasONLocal cuentaON;

	@PostConstruct
	private void init() {
		newcuenta = new Cuenta();
		newcuenta.setUsuario(new Usuario());

	}

	public Cuenta getNewCuenta() {
		return newcuenta;
	}

	public void setNewCuenta(Cuenta cuenta) {
		this.newcuenta = cuenta;
	}

	public String guardarCuenta() {
		cuentaON.insertarCuenta(newcuenta);

		return null;
	}
	
	public String generarNumCuenta() {
		for(int i = 1; i<=10; i++)
		     System.out.println((int)(Math.random()*(9-1+1)+1));
		return null;
	}
	
	public String cargarUsuario() {
		String cedula = newcuenta.getUsuario().getCedula();
		Usuario u = cuentaON.getUsuario(cedula);
		newcuenta.setUsuario(u);
		return null;
	}
}
