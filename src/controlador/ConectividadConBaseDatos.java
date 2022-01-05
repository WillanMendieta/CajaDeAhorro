package controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectividadConBaseDatos {

	public static void main(String[] args) {

		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CajaDeAhorro", "proyecto",
					"proyecto");

			if (conexion != null) {
				System.out.print("Conexion establecida...");

			} else {

				System.out.print("Conexion fallida");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}

