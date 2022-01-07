package ec.edu.ups.est.ProyectoFinal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_Usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "usu_ced")
	private String cedula;

	@Column(name = "usu_nombre")
	private String nombre;

	@Column(name = "usu_apellido")
	private String apellido;

	@Column(name = "usu_direccion")
	private String direccion;

	@Column(name = "usu_telefono")
	private String telefono;

	@Column(name = "usu_correo")
	private String correo;

	@Column(name = "usu_contra")
	private String contra;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Cuenta> cuenta;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Cuenta> getCuenta() {
		return cuenta;
	}

	public void setCuenta(List<Cuenta> cuenta) {
		this.cuenta = cuenta;
	}

}
