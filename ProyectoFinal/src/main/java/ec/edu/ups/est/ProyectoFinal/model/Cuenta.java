package ec.edu.ups.est.ProyectoFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Cuentas")
public class Cuenta {

	@Id
	@Column(name = "cue_num")
	private int numero_cuenta;

	@Column(name = "cue_tipo")
	private String tipo_cuenta;
	
	@Column(name = "cue_saldo")
	private Double saldo;

	@OneToOne
	@JoinColumn(name = "cue_ced")
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
