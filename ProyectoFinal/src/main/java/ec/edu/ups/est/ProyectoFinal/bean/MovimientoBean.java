package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.CuentasONLocal;
import ec.edu.ups.est.ProyectoFinal.business.MovimientoONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Movimiento;


@Named
@RequestScoped
public class MovimientoBean {
	@Inject
	private MovimientoONLocal movimientoON;
	
	@Inject
	private CuentasONLocal cuentaON;
	
	private String numeroCuenta;
	private Double cantidadRetirada;
	private Double cantidadDepositada;
	private String nombreUsuario;
	private String cedulaUsuario;

	
	@PostConstruct
	public void init() {
		this.createFakeData();
	}
	
	public void createFakeData() {}
	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
	
	
	//Retiro

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public Double getCantidadRetirada() {
		return cantidadRetirada;
	}

	public void setCantidadRetirada(Double cantidadRetirada) {
		this.cantidadRetirada = cantidadRetirada;
	}
	
	//Deposito

	public Double getCantidadDepositada() {
		return cantidadDepositada;
	}

	public void setCantidadDepositada(Double cantidadDepositada) {
		this.cantidadDepositada = cantidadDepositada;
	}
	
	//Metodos

	public String retirarFondos() {
		try {
			Cuenta cuenta = cuentaON.getCuenta(numeroCuenta);
			Movimiento movimiento = new Movimiento();
			movimiento.setCuenta(cuenta);
			movimiento.setFecha(new Date());
			movimiento.setMonto(cantidadRetirada);
			movimiento.setTipoMovimiento("Retiro");
			movimientoON.retiro(movimiento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "estado-de-cuenta?faces-redirect=true&numero-cuenta=" + numeroCuenta;
	}
	
	public String depositarFondos() {
		try {
			Cuenta cuenta = cuentaON.getCuenta(numeroCuenta);
			
			Movimiento movimiento = new Movimiento();
			
			movimiento.setCuenta(cuenta);
			movimiento.setFecha(new Date());
			movimiento.setMonto(cantidadDepositada);
			movimiento.setTipoMovimiento("Depósito");
			
			movimientoON.deposito(movimiento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "estado-de-cuenta?faces-redirect=true&numero-cuenta=" + numeroCuenta;
	}
	
	public void cargarDatosDeCuenta() {
		if (numeroCuenta != null) {
			Cuenta cuenta = cuentaON.getCuenta(numeroCuenta);
			if (cuenta != null) {
				System.out.println(cuenta.getUsuario().getNombre() + " " + cuenta.getUsuario().getApellido());
				nombreUsuario = cuenta.getUsuario().getNombre() + " " + cuenta.getUsuario().getApellido();
				cedulaUsuario = cuenta.getUsuario().getCedula();
				System.out.println(nombreUsuario);
			}	
		}
		
	}
}
