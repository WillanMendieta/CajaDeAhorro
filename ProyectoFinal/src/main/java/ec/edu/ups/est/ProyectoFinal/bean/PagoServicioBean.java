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
	
	private int idPago;
	private String NumeroCuenta;
	private String servicio;
	private Double monto;
	private boolean estado;
	
	public int getIdPago() {
		return idPago;
	}
	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}
	public String getNumeroCuenta() {
		return NumeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		NumeroCuenta = numeroCuenta;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public String realizarPago() {
		try {
			pagoServicioON.pagarServicio(idPago);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pagoServicio?faces-redirect=true&idPagoServicio=" + idPago;
	}
}
