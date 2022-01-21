package ec.edu.ups.est.ProyectoFinal.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class MovimientoTest {

	@Test
	public void testMovimiento() {
		
	
		Date fecha = new Date();
		
		Movimiento m = new Movimiento();
		//m.setCuenta("1000784589");
		m.setFecha(fecha);
		m.setIdMovimiento(1);
		m.setMonto(100.5);
		
		//assertTrue(m.getCuenta()== "1000784589");
		assertTrue(m.getIdMovimiento()== 1);
		assertTrue(m.getMonto()== 100.5);
		assertTrue(m.getFecha() == fecha);
	}
	
	@Test
	public void testCuenta() {
		Usuario u = new Usuario();
		u.setCedula("03023065432");
		u.setNombre("Byron");
		u.setApellido("Vasquez");
		u.setDireccion("Cuenca");
		u.setTelefono("0987815997");
		u.setCorreo("bvasquezs@gmail.com");
		u.setContra("byron123");
						

		
		Cuenta c = new Cuenta();
		//c.setNumero_cuenta(10);
		//c.setTipo_cuenta("Ahorros");
		c.setUsuario(u);
		
		assertTrue(u.getCedula()== "03023065432");
		assertTrue(u.getNombre()== "Byron");
		assertTrue(u.getApellido()=="Vasquez");
		assertTrue(u.getDireccion()=="Cuenca");
		assertTrue(u.getTelefono()=="0987815997");
		assertTrue(u.getCorreo()=="bvasquezs@gmail.com");
		assertTrue(u.getContra()=="byron123");
		
	//	assertTrue(c.getNumero_cuenta()==10);
	//	assertTrue(c.getTipo_cuenta()=="Ahorros");
		assertTrue(c.getUsuario()==u);
		
		
		
	}

	

}
