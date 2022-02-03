package ec.edu.ups.est.ProyectoFinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Pais")
public class Pais {

	@Id
	@JoinColumn(name = "pai_codigo")
	@GeneratedValue
	private int id;
	@JoinColumn(name = "pai_nombre")
	private String nombre;

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

}
