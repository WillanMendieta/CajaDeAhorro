package ec.edu.ups.est.ProyectoFinal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@Column(name ="usu_tip_usu")
	private String tipoUsuario;
	
	@OneToOne(mappedBy = "usuario")
	private Cuenta cuenta;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
	private List<Credito> creditos;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY, mappedBy = "usuario")
	private List<PagoServicio> pagoServicios;
	
	
	
	public List<PagoServicio> getPagoServicios() {
		return pagoServicios;
	}

	public void setPagoServicios(List<PagoServicio> pagoServicios) {
		this.pagoServicios = pagoServicios;
	}

	public List<Credito> getCreditos() {
		return creditos;
	}

	public void setCreditos(List<Credito> creditos) {
		this.creditos = creditos;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

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

}
