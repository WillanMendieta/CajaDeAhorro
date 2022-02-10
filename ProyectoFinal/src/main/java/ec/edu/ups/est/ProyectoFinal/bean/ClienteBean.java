package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.CajeroONLocal;
import ec.edu.ups.est.ProyectoFinal.business.CuentasONLocal;
import ec.edu.ups.est.ProyectoFinal.business.UsuarioONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Cajero;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Named
@RequestScoped
public class ClienteBean {
 
	private Usuario newusuario = new Usuario();
	private Cuenta newcuenta = new Cuenta();
	private List<Usuario> usuarios;
	private double saldo;
	private String numerCuenta;
	private String tipoCuenta;
	
	public Usuario getNewUsuario() {
		return newusuario;
	}
	
	public void setNewUsuario(Usuario newusuario) {
		this.newusuario = newusuario;
	}
	
	@Inject
	private UsuarioONLocal usuarioON;
	
	@Inject
	private CajeroONLocal cajeroON;
	
	@Inject
	private CuentasONLocal cuentasON;
	
	@PostConstruct
	public void init() {
		usuarios = usuarioON.getUsuarios();
		
	}
	
	
	
	public String guardarCliente() {
		
		String numeroCuentaValidar = generarNumCuenta();
		
		Cuenta cuenta = cuentasON.getCuenta(numeroCuentaValidar);
		
		while(cuenta!= null) {
			numeroCuentaValidar = generarNumCuenta();
			cuenta = cuentasON.getCuenta(numeroCuentaValidar);
		}
		newcuenta.setSaldo(saldo);
		newcuenta.setNumeroCuenta(generarNumCuenta());
		newcuenta.setTipoCuenta(tipoCuenta);
		newcuenta.setUsuario(newusuario);
		try {
			
			this.newusuario.setTipoUsuario("Usuario");			
			usuarioON.insertarUsuario(newusuario);
			cuentasON.insertarCuenta(newcuenta);

		}
		catch(Exception e){
			e.printStackTrace();
			return "mensaje-error?faces-redirect=true&texto=" + e.getMessage();
		}
		
		return "mensaje-exito?faces-redirect=true&texto=Se ha creado el usuario y se ha generado la cuenta "+ newcuenta.getNumeroCuenta()+" con éxito";
	}
	
	public String generarNumCuenta() {
		
		int valorinicial=11111;
		int valorFinal = 99999;		
		int numeroGenerado = (int)(Math.random()*(valorFinal-valorinicial)+valorinicial);
		String numeroCuentaFinal =Integer.toString(numeroGenerado);
		return numeroCuentaFinal;

	}
	
	
	
	
	public String guardarClienteAdmin() {
		try {
			usuarioON.insertarUsuario(newusuario);

			
			String cajerotxt = newusuario.getTipoUsuario();
			
			String cajeroBase = new String ("Cajero");
			
			
			if (cajerotxt.equals(cajeroBase)) {
				System.out.println("Entra al if ");
				Cajero cajero = new Cajero();
				cajero.setCedula(newusuario.getCedula());
				cajero.setEstado("Pendiente");
				try {
					cajeroON.guardar(cajero);
					//cuentasON.insertarCuenta(newcuenta);
					System.out.println("Se guardo correctamente");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("no se guardo");
				}
				
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return "mensaje-exito?faces-redirect=true&texto=Usuario Creado con exito";
	}

	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNumerCuenta() {
		return numerCuenta;
	}

	public void setNumerCuenta(String numerCuenta) {
		this.numerCuenta = numerCuenta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	
	

}