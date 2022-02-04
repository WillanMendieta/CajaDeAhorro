package ec.edu.ups.est.ProyectoFinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PagoServicio")
public class PagoServicio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pas_id")
	private int idPagoServicio;
	
	@Column(name = "pas_servicio")
	private String servicio;
	
	@Column(name = "pas_monto")
	private Double monto;
	
	@Column(name = "pas_estado")
	private boolean estado;

	public int getIdPagoServico() {
		return idPagoServicio;
	}

	public void setIdPagoServico(int idPagoServico) {
		this.idPagoServicio = idPagoServico;
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
	
	
	


}
