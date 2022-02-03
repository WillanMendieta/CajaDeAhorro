package ec.edu.ups.est.ProyectoFinal.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import ec.edu.ups.est.ProyectoFinal.business.PagoServicioONLocal;

@Named
@RequestScoped
public class PagoServicioBean {
	
	@Inject
	private PagoServicioONLocal pagoServicioON;
	

	
	private int idPago;
	private String NumeroCuenta;
	private String servicio;
	private Double monto;
	private boolean estado=false;
	
	
	
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
	
	public  String AgregarPago() {
		try {
			pagoServicioON.guardarPago(monto, servicio, NumeroCuenta);
		} catch (Exception e) {
			e.printStackTrace();
			return "mensaje-error?faces-redirect=true&texto=" + e.getMessage();
		}
		return "mensaje-exito?faces-redirect=true&texto=Se ha solicitado el crédito con éxito";
	}
	
	public String realizarPago() {
		try {
			pagoServicioON.pagarServicio(idPago);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mensaje-exito?faces-redirect=true&texto=Se ha realizado el pago del credito";
	}
}
