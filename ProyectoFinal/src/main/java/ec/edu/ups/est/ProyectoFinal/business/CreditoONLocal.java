package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import ec.edu.ups.est.ProyectoFinal.model.Amortizacion;

public interface CreditoONLocal {
	public void solicitarCredito(double cantidad, int numeroCuotas, String cedulaPersona) throws Exception;
	public void pagarCredito(int idCredito) throws Exception;
	public List<Amortizacion> cargarAmortizaciones(int idCredito);
}
