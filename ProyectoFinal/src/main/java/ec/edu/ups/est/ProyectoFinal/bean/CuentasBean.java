package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.CuentasONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;

@Named
@RequestScoped
public class CuentasBean {
	
	@Inject
	private CuentasONLocal cuentaON;
	
	private List<Cuenta> cuentas;
	
	@PostConstruct
	public void init() {
		this.loadCuentas();
	}
	
	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public void loadCuentas() {
		this.cuentas = cuentaON.getCuentas();
	}

}
