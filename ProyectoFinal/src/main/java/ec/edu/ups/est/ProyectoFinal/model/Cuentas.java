package ec.edu.ups.est.ProyectoFinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "TBL_Cuentas")
public class Cuentas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "cue_num")
	private int numero_cuenta;
	
	@Column(name = "cue_tipo")
	private String tipo_cuenta;
	
	@Column(name = "cue_ced")
	private String cedula;

	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public int getNumero_cuenta() {
		return numero_cuenta;
	}
	public void setNumero_cuenta(int numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}
	public String getTipo_cuenta() {
		return tipo_cuenta;
	}
	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}
	
	
	
	
	
	
}
