package ec.edu.ups.est.ProyectoFinal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Ciudad")
public class Ciudad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ciu_codigo")
	@GeneratedValue
	private int id;

	@Column(name = "ciu_nombre")
	private String nombre;

	@OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL)
	private List<Giro> giro;

	@Column(name = "ciu_interes")
	private double interes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public List<Giro> getGiro() {
		return giro;
	}

	public void setGiro(List<Giro> giro) {
		this.giro = giro;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

}