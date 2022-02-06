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
@Table(name = "TBL_Poliza")
public class Poliza implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "poli_id")
	private int id;
	
	@Column(name = "poli_interes")
	private double interes;
	
	@Column(name = "poli_monto_inicio")
	private double montoInicio;
	
	@Column(name = "poli_monto_cobrar")
	private double montoCobrar;
	
	@Column(name = "poli_fecha")
	private Date fecha;
	
	@Column(name = "poli_plazos")
	private int plazosPoliza;
	
	@Column(name = "poli_esta_aprobado")
	private boolean estaAprobado;
	
	@ManyToOne
	@JoinColumn(name = "usu_ced")
	private Usuario usuario;
	
	/*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="poli_id")
	private List<Amortizacion> amortizaciones;
	*/

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

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}
	
	public double getMontoInicio() {
		return montoInicio;
	}

	public void setMontoInicio(double montoInicio) {
		this.montoInicio = montoInicio;
	}

	public double getMontoCobrar() {
		return montoCobrar;
	}

	public void setMontoCobrar(double montoCobrar) {
		this.montoCobrar = montoCobrar;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getPlazosPoliza() {
		return plazosPoliza;
	}

	public void setPlazosPoliza(int plazosPoliza) {
		this.plazosPoliza = plazosPoliza;
	}

}
