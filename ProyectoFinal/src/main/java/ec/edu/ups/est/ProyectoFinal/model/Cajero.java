package ec.edu.ups.est.ProyectoFinal.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Cajero")
public class Cajero implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "caj_codigo")
	@GeneratedValue
	private int id;
	
	@Column(name = "caj_estado")
	private String estado;
	//(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@OneToOne
	@JoinColumn(name="usu_ced" )
	private String cedula;
	//private Usuario cajero;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
/*
	public Usuario getCajero() {
		return cajero;
	}

	public void setCajero(Usuario cajero) {
		this.cajero = cajero;
	}*/

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
	
	
}
