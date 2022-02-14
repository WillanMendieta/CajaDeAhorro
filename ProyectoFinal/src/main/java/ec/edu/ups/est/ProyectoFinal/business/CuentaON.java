package ec.edu.ups.est.ProyectoFinal.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.CuentaDAO;
import ec.edu.ups.est.ProyectoFinal.dao.UsuarioDAO;
import ec.edu.ups.est.ProyectoFinal.model.Cuenta;
import ec.edu.ups.est.ProyectoFinal.model.Usuario;

@Stateless
public class CuentaON implements CuentasONLocal {

	@Inject
	private CuentaDAO cuentaDAO;

	@Inject
	private UsuarioDAO usuarioDAO;
	
	/*
	 * El metodo insertarCuenta tiene como parametro el objeto Cuenta 
	 * Dentro del metodo tenemos validaciones como : si existe el usuario lo actualice y si no existe lo inserte en la base de datos.
	 */

	public void insertarCuenta(Cuenta c) {
		Cuenta cuenta = cuentaDAO.read(c.getNumeroCuenta());
		if (cuenta == null) {
			Usuario usu = usuarioDAO.read(c.getUsuario().getCedula());
			if (usu == null) {
				usuarioDAO.insert(c.getUsuario());
				
			} else {
				usuarioDAO.upgrade(c.getUsuario());
			}
			
			cuentaDAO.insert(c);
		}
	}
	
	/*
	 * El metodo getUsuario tiene como parametros un String donde se ingresara la cedula del usuario 
	 * El metodo una vez encontrado al usuario debuelve al objeto usuario.
	 */
	public Usuario getUsuario(String cedula) {
		Usuario u = usuarioDAO.read(cedula);
		return u;
	}
	
	
	/*
	 * El metodo getCuenta tiene como parametros un String donde se ingresara la cuenta.
	 * El metodo una vez encontrado al la cuenta debuelve al objeto cuenta.
	 */
	
	public Cuenta getCuenta(String numero) {
		return cuentaDAO.read(numero);
	}
	
	/*
	 * El metodo getCuentaPorNumero recibe como parametro el numero de cuenta.
	 * El metodo devuelve los datos de la cuenta.
	 * Este metodo es utilizado para listar los datos que un usuario en el inicio de sesion.
	 */
	public Cuenta getCuentaPorNumero(String numero) {
		return cuentaDAO.readByNumeroCuenta(numero);
	}


	/*
	 * El metodo getCuentas obtiene el listado de todas las cuentas de la base de datos.
	 */
	public List<Cuenta> getCuentas() {
		return cuentaDAO.getList();
	}

}
