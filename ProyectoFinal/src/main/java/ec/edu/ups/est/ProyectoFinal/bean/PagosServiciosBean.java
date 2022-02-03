package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.PagoServicioONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Movimiento;
import ec.edu.ups.est.ProyectoFinal.model.PagoServicio;

@Named
@RequestScoped
public class PagosServiciosBean {
	
	@Inject
	private PagoServicioONLocal pagoServicioON;
	private List<PagoServicio> pagosServicios;
	private String numeroCuenta;
	@PostConstruct
	public void init() {
		this.loadMovimientos();
	}
	
	public void loadDataPorCuenta() {
		if(this.numeroCuenta == null)
			return;
		this.pagosServicios = pagoServicioON.getPagoServiciosCuenta(numeroCuenta);
	}
	

	public List<PagoServicio> getPagosServicios() {
		return pagosServicios;
	}

	public void setPagosServicios(List<PagoServicio> pagosServicios) {
		this.pagosServicios = pagosServicios;
	}

	public void loadMovimientos() {
		this.pagosServicios = pagoServicioON.getPagoServicios();
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

}
