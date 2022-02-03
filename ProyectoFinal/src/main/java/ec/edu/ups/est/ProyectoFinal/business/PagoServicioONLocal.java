package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.est.ProyectoFinal.model.PagoServicio;

@Local
public interface PagoServicioONLocal {

	public void guardarPago(double monto,String servicio, String numeroCuenta) throws Exception;
	public void pagarServicio(int idPago)  throws Exception;
	public List<PagoServicio> getPagoServicios() ;
	public List<PagoServicio> getPagoServiciosCuenta(String numeroCuenta);
}
