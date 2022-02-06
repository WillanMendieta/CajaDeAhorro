package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import ec.edu.ups.est.ProyectoFinal.model.Poliza;

public interface PolizaONLocal {
	public void solicitarPoliza(double cantidad, int numeroCuotas, String cedulaPersona) throws Exception;
	//public List<Amortizacion> cargarAmortizaciones(int idCredito);
	public void aprobarPoliza(int idPoliza);
	public List<Poliza> getPolizas();
	public Poliza getPoliza(int id);
}
