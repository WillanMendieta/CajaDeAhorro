package ec.edu.ups.est.ProyectoFinal.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import ec.edu.ups.est.ProyectoFinal.business.PagoServicioONLocal;
import ec.edu.ups.est.ProyectoFinal.model.PagoServicio;
import ec.edu.ups.est.ProyectoFinal.util.SessionUtils;

@Named
@RequestScoped
public class PagoServicioBean {
	
	@Inject
	private PagoServicioONLocal pagoServicioON;
	

	
	private int idPago;
	private String cedulaPersona;
	private String servicio;
	private Double monto;
	private boolean estado=false;
	
	
	
	public int getIdPago() {
		return idPago;
	}
	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public String getCedulaPersona() {
		return cedulaPersona;
	}
	public void setCedulaPersona(String cedulaPersona) {
		this.cedulaPersona = cedulaPersona;
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
			pagoServicioON.guardarPago(monto, servicio, cedulaPersona);
		} catch (Exception e) {
			e.printStackTrace();
			return "mensaje-error?faces-redirect=true&texto=" + e.getMessage();
		}
		return "mensaje-exito?faces-redirect=true&texto=Se ha agregado el Servicio con Exito";
	}
	public  String AgregarPagoSesion() {
		try {
			String cedulaUsuarioSesion = SessionUtils.getUserCedula();
			pagoServicioON.guardarPago(monto, servicio, cedulaUsuarioSesion);
		} catch (Exception e) {
			e.printStackTrace();
			return "mensaje-error?faces-redirect=true&texto=" + e.getMessage();
		}
		return "mensaje-exito-usuario?faces-redirect=true&texto=Se ha Agregado Servicio con éxito";
	}
	
	public String realizarPago() {
		try {
			pagoServicioON.pagarServicio(idPago);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mensaje-exito?faces-redirect=true&texto=Se ha realizado el pago del Servicio";
	}
	public PagoServicio cargarPago(){
		PagoServicio ps=pagoServicioON.getPagoServicio(idPago);
		return ps;
	}
}
