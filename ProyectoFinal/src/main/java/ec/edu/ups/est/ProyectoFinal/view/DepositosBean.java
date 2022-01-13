package ec.edu.ups.est.ProyectoFinal.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.est.ProyectoFinal.business.MovimientoON;
import ec.edu.ups.est.ProyectoFinal.model.Movimiento;


@Named
@RequestScoped
public class DepositosBean {
//	@Inject
//	private MovimientoON movimientoON;
//
//	private Movimiento movimiento = new Movimiento();
//
//	public Movimiento getMovimiento() {
//		return movimiento;
//	}
//
//	public void setMovimiento(Movimiento movimiento) {
//		this.movimiento = movimiento;
//	}
//
//	public String guardarMovimiento() {
//
//		this.movimiento.setFecha(new Date());
//		System.out.println("Guardando" + this.movimiento.getFecha());
//
//		try {
//			movimientoON.insertarMovimientos(movimiento);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return null;
//	}
//
//	public Date transformarStringFecha(String fecha) {
//
//		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//		Date fechaDate = null;
//		try {
//			fechaDate = formato.parse(fecha);
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}
//
//		return fechaDate;
//
//	}
}


