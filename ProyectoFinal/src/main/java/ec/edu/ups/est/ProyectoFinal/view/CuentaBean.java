package ec.edu.ups.est.ProyectoFinal.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.CuentaON;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Named
@ViewScoped
public class CuentaBean implements Serializable{

	private Cuenta newcuenta = new Cuenta();

	@Inject
	private CuentaON cuentaON;

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
		try {
			cuentaON.insertarCuenta(newcuenta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
