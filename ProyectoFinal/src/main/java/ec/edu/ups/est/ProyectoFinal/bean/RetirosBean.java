package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.CuentasONLocal;
import ec.edu.ups.est.ProyectoFinal.business.RetirosONLocal;
import ec.edu.ups.est.ProyectoFinal.business.TipoMovimientoON;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Movimiento;
import ec.edu.ups.est.ProyectoFinal.model.TipoMovimiento;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Named
@RequestScoped
public class RetirosBean {
	
	@Inject
	private RetirosONLocal retirosON;
	
	@Inject
	private CuentasONLocal cuentaON;
	
	@Inject
	private TipoMovimientoON tipoMovimientoON;
	
	private String numeroCuenta;
	private Double cantidadRetirada;
	
	@PostConstruct
	public void init() {
		this.createFakeData();
	}
	
	public void createFakeData() {
		TipoMovimiento tipoMovimiento = new TipoMovimiento();
		tipoMovimiento.setNombre("Retiro");
		TipoMovimiento tipoMovimiento2 = new TipoMovimiento();
		tipoMovimiento2.setNombre("Depósito");
		try {
			tipoMovimientoON.crear(tipoMovimiento);		
			tipoMovimientoON.crear(tipoMovimiento2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Usuario usuario = new Usuario();	
		usuario.setCedula("01");
		usuario.setApellido("");
		usuario.setContra("");
		usuario.setCorreo("");
		usuario.setDireccion("");
		usuario.setNombre("");
		usuario.setTelefono("");
		Cuenta cuenta = new Cuenta();
		cuenta.setNumeroCuenta("1");
		cuenta.setSaldo(650.35);
		cuenta.setTipoCuenta("Ahorros");
		cuenta.setUsuario(usuario);
		cuentaON.insertarCuenta(cuenta);
	}
	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Double getCantidadRetirada() {
		return cantidadRetirada;
	}

	public void setCantidadRetirada(Double cantidadRetirada) {
		this.cantidadRetirada = cantidadRetirada;
	}

	public String retirarFondos() {
		System.out.println("Retirando de cuenta: " + numeroCuenta);
		try {
			Cuenta cuenta = cuentaON.getCuenta(numeroCuenta);
			TipoMovimiento tipoMovimiento = tipoMovimientoON.buscar(0);
			Movimiento movimiento = new Movimiento();
			System.out.println("Id MOVIMIENTO BEAN !!!!!!!" + movimiento.getIdMovimiento());
			movimiento.setCuenta(cuenta);
			movimiento.setFecha(new Date());
			movimiento.setMonto(cantidadRetirada);
			movimiento.setTipoMovimiento(tipoMovimiento);
			retirosON.retiro(movimiento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listado-retiros?faces-redirect=true";
	}
	
}
