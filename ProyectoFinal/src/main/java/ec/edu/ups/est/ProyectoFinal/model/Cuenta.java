package ec.edu.ups.est.ProyectoFinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Cuentas")
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "cue_num")
	private String numeroCuenta;

	@Column(name = "cue_tipo")
	private String tipoCuenta;
	
	@Column(name = "cue_saldo")
	private Double saldo;

	@OneToOne
	@JoinColumn(name = "cue_ced")
	private Usuario usuario;

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
