package ec.edu.ups.est.ProyectoFinal.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Giro")
public class Giro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@JoinColumn(name = "gir_codigo")
	private int codigo;

	@OneToOne
	@JoinColumn(name = "gir_cuenta")
	private Cuenta cuenta;

	@Column(name = "gir_valor")
	private double valor;

	@Column(name = "gir_banco")
	private String banco;

	/*
	 * @Column(name = "gir_pais") private String pais;
	 */

	@Column(name = "gir_interes")
	private double interes;

	@Column(name = "gir_monto_final")
	private double montoFinal;

	@ManyToOne
	@JoinColumn(name = "gir_ciudad")
	private Ciudad ciudad;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getMontoFinal() {
		return montoFinal;
	}

	public void setMontoFinal(double montoFinal) {
		this.montoFinal = montoFinal;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

}
