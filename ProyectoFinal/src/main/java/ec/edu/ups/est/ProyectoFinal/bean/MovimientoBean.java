package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.CuentasONLocal;
import ec.edu.ups.est.ProyectoFinal.business.MovimientoONLocal;
import ec.edu.ups.est.ProyectoFinal.business.UsuarioONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Movimiento;
import ec.edu.ups.est.ProyectoFinal.util.SessionUtils;


@Named
@RequestScoped
public class MovimientoBean {
	@Inject
	private MovimientoONLocal movimientoON;
	
	@Inject
	private CuentasONLocal cuentaON;
	
	@Inject
	private UsuarioONLocal usuarioON;
	
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
			if (cuenta == null) {
				return "mensaje-error?faces-redirect=true&texto=La cuenta no existe";
			}
			Movimiento movimiento = new Movimiento();
			movimiento.setCuenta(cuenta);
			movimiento.setFecha(new Date());
			movimiento.setMonto(cantidadRetirada);
			movimiento.setTipoMovimiento("Retiro");
			movimientoON.retiro(movimiento);
		} catch (Exception e) {
			return "mensaje-error?faces-redirect=true&texto=" + e.getMessage();
		}
		return "mensaje-exito?faces-redirect=true&texto=Se ha retirado el dinero con éxito";
	}
	
	public String retirarFondosConSesion() {
		String cedulaUsuario = SessionUtils.getUserCedula();
		String numeroCuenta = usuarioON.getUsuario(cedulaUsuario).getCuenta().getNumeroCuenta();
		Cuenta cuenta = cuentaON.getCuenta(numeroCuenta);
		if (cuenta == null) {
			return "mensaje-error?faces-redirect=true&texto=La cuenta no existe";
		}
		Movimiento movimiento = new Movimiento();
		movimiento.setCuenta(cuenta);
		movimiento.setFecha(new Date());
		movimiento.setMonto(cantidadRetirada);
		movimiento.setTipoMovimiento("Retiro");
		try {
			movimientoON.retiro(movimiento);
		} catch (Exception e) {
			return "mensaje-error-usuario?faces-redirect=true&texto=" + e.getMessage();
		}
		return "mensaje-exito-usuario?faces-redirect=true&texto=Se ha retirado el dinero con éxito";
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
		return "mensaje-exito?faces-redirect=true&texto=Se ha depositado el dinero con éxito";
	}
	
	public String depositarFondosConSesion() {
		try {
			String cedulaUsuario = SessionUtils.getUserCedula();
			String numeroCuenta = usuarioON.getUsuario(cedulaUsuario).getCuenta().getNumeroCuenta();
			
			Cuenta cuenta = cuentaON.getCuenta(numeroCuenta);
			Movimiento movimiento = new Movimiento();
			movimiento.setCuenta(cuenta);
			movimiento.setFecha(new Date());
			movimiento.setMonto(cantidadDepositada);
			movimiento.setTipoMovimiento("Depósito");
			movimientoON.deposito(movimiento);
		} catch (Exception e) {
			e.printStackTrace();
			return "mensaje-error-usuario?faces-redirect=true&texto=" + e.getMessage();
		}
		return "mensaje-exito-usuario?faces-redirect=true&texto=Se ha depositado el dinero con éxito";
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
				return "mensaje-error-usuario?faces-redirect=true&texto=" + e.getMessage();
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
				return "mensaje-error-usuario?faces-redirect=true&texto=" + e.getMessage();
			}

		 return "mensaje-exito-usuario?faces-redirect=true&texto=Se ha realizado la tranferencia del dinero con éxito";
	}
	
	public String transferenciasDeCuentasSesion () {
		System.out.println("llega al inicio del metodo");
		//Retiro
		
		
		String cedulaUsuario = SessionUtils.getUserCedula();
		String numeroCuenta = usuarioON.getUsuario(cedulaUsuario).getCuenta().getNumeroCuenta();
		
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
			return "mensaje-error-usuario?faces-redirect=true&texto=" + e.getMessage();
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
			return "mensaje-error-usuario?faces-redirect=true&texto=" + e.getMessage();
		}

	 return "mensaje-exito-usuario?faces-redirect=true&texto=Se ha realizado la tranferencia del dinero con éxito";
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
		System.out.println("LLega hasta aki " + numeroCuentaDestino);
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
