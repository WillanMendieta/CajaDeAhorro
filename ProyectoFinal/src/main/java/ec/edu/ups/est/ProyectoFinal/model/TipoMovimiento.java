package ec.edu.ups.est.ProyectoFinal.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Tipo_Movimiento")
public class TipoMovimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tip_mov_id")
	private int id;

	@Column(name = "tip_mov_nombre")
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

