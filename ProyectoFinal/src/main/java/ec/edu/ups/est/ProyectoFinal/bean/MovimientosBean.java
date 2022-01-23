package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.MovimientoONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Movimiento;

@Named
@RequestScoped
public class MovimientosBean {
	
	@Inject
	private MovimientoONLocal movimientoON;
	
	private List<Movimiento> movimientos;
	private String numeroCuenta;
	
	@PostConstruct
	public void init() {
		this.loadMovimientos();
	}
	
	public void loadDataPorCuenta() {
		if(this.numeroCuenta == null)
			return;
		this.movimientos = movimientoON.getMovimientosPorCuenta(this.numeroCuenta);
	}
	
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public void loadMovimientos() {
		this.movimientos = movimientoON.getMovimientos();
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
}
