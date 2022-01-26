package ec.edu.ups.est.ProyectoFinal.business;

public interface CreditoONLocal {
	public void solicitarCredito(double cantidad, int numeroCuotas, String cedulaPersona) throws Exception;
	public void pagarCredito(int idCredito) throws Exception;
}
