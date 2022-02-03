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
	private String numeroCuentaDestino;
	private Double cantidadRetirada;
	private Double cantidadDepositada;
	private String nombreUsuario;
	private String cedulaUsuario;

	
	@PostConstruct
	public void init() {
		this.createFakeData();
	}
	
	public void createFakeData() {}
	
	
	
	public String getNumeroCuentaDestino() {
		return numeroCuentaDestino;
	}

	public void setNumeroCuentaDestino(String numeroCuentaDestino) {
		this.numeroCuentaDestino = numeroCuentaDestino;
	}

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
	
	public String transferenciasDeCuentas () {
		
	
			
			
			System.out.println("llega al inicio del metodo");
			//Retiro
			
			Cuenta cuentaOrigen = cuentaON.getCuenta(numeroCuenta);
			Movimiento movimiento = new Movimiento();
			movimiento.setCuenta(cuentaOrigen);
			movimiento.setFecha(new Date());
			movimiento.setMonto(cantidadRetirada);
			movimiento.setTipoMovimiento("Transferencia");
			try {
				movimientoON.retiro(movimiento);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Ya retiro");

			//Deposito
			Cuenta cuentaDestino = cuentaON.getCuenta(numeroCuentaDestino);
			Movimiento movimientoDestino = new Movimiento();
			movimientoDestino.setCuenta(cuentaDestino);
			movimientoDestino.setFecha(new Date());
			movimientoDestino.setMonto(cantidadRetirada);
			movimientoDestino.setTipoMovimiento("Transferencia");
			try {
				movimientoON.deposito(movimientoDestino);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("Yan termino ");
			
		
		return "Se realixo";
		
		
	}
	
	public void cargarDatosDeCuenta() {
		if (numeroCuenta != null) {
			System.out.println("numero es "+numeroCuenta);
			Cuenta cuenta = cuentaON.getCuenta(numeroCuenta);
			System.out.println("La CUENTA ES: !!!!  "+cuenta.getNumeroCuenta());
			if (cuenta != null) {
				nombreUsuario = cuenta.getUsuario().getNombre() + " " + cuenta.getUsuario().getApellido();
				cedulaUsuario = cuenta.getUsuario().getCedula();
			}	
		}
		
	}
	
	public void cargarDatosDeCuentaDestino() {
		if (numeroCuentaDestino!= null) {
			System.out.println("numero es "+numeroCuentaDestino);
			Cuenta cuenta = cuentaON.getCuenta(numeroCuentaDestino);
			System.out.println("La CUENTA ES: !!!!  "+cuenta.getNumeroCuenta());
			if (cuenta != null) {
				nombreUsuario = cuenta.getUsuario().getNombre() + " " + cuenta.getUsuario().getApellido();
				cedulaUsuario = cuenta.getUsuario().getCedula();
			}	
		}
		
	}
}
