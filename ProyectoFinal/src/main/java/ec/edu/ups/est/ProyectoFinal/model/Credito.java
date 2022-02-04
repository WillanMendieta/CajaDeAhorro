package ec.edu.ups.est.ProyectoFinal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Credito")
public class Credito implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cre_id")
	private int id;
	
	@Column(name = "cre_interes")
	private double interes;
	
	@Column(name = "cre_monto_solicitado")
	private double montoSolicitado;
	
	@Column(name = "cre_fecha")
	private Date fecha;
	
	@Column(name = "cre_plazos")
	private int plazosCredito;
	
	@Column(name = "cre_esta_pagado")
	private boolean estaPagado;
	
	@Column(name = "cre_esta_aprobado")
	private boolean estaAprobado;
	
	@ManyToOne
	@JoinColumn(name = "usu_ced")
	private Usuario usuario;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="cre_id")
	private List<Amortizacion> amortizaciones;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isEstaAprobado() {
		return estaAprobado;
	}

	public void setEstaAprobado(boolean estaAprobado) {
		this.estaAprobado = estaAprobado;
	}

	public boolean isEstaPagado() {
		return estaPagado;
	}

	public void setEstaPagado(boolean estaPagado) {
		this.estaPagado = estaPagado;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getMontoSolicitado() {
		return montoSolicitado;
	}

	public void setMontoSolicitado(double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getPlazosCredito() {
		return plazosCredito;
	}

	public void setPlazosCredito(int plazosCredito) {
		this.plazosCredito = plazosCredito;
	}

	public List<Amortizacion> getAmortizaciones() {
		return amortizaciones;
	}

	public void setAmortizaciones(List<Amortizacion> amortizaciones) {
		this.amortizaciones = amortizaciones;
	}
}
