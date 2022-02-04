package ec.edu.ups.est.ProyectoFinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Ciudad")
public class Ciudad {

	@Id
	@JoinColumn(name = "ciu_codigo")
	@GeneratedValue
	private int id;

	@JoinColumn(name = "ciu_nombre")
	private String nombre;

	@JoinColumn(name = "ciu_interes")
	private String interes;

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

	public String getInteres() {
		return interes;
	}

	public void setInteres(String interes) {
		this.interes = interes;
	}

}
