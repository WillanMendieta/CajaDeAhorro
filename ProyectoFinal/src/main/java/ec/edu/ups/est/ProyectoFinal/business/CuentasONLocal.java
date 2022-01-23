package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Local
public interface CuentasONLocal {
	public void insertarCuenta(Cuenta c);
	public List<Cuenta> getCuentas();
	public Cuenta getCuentaPorNumero(String numero);
	public Cuenta getCuenta(String numero);
	public Usuario getUsuario(String cedula);
}
