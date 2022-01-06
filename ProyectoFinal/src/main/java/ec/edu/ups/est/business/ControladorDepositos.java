package ec.edu.ups.est.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import java.util.Date;

import ups.edu.ec.modelo.Depositos;

public class ControladorDepositos {
	
	public void guardarDeposito(Depositos deposito) {
		

		Connection conexion = null;
		try {
			
			Class.forName("org.postgresql.Driver");
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CajaDeAhorro", "proyecto",
					"proyecto");

			
			java.sql.Statement st = conexion.createStatement();
			String sql= "Insert into Movimientos (mov_id, mov_monto, mov_fecha_actual, mov_cue_id)"
					+"values('"+deposito.getIdDeposito() +"','"+deposito.getMonto()+"','"+deposito.getFecha()+"','"+deposito.getCuenta()+"')";
			
			ResultSet resultado= st.executeQuery(sql);
			conexion.close();
			st.close();
			JOptionPane.showConfirmDialog(null, "ya" );
			

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	
		
	}
	

}
