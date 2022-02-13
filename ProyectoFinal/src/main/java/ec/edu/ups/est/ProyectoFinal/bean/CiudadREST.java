package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.est.ProyectoFinal.business.CiudadON;
import ec.edu.ups.est.ProyectoFinal.model.Ciudad;

@Path("ciudad")
public class CiudadREST {
	@Inject
	private CiudadON ciudadON;

	@GET
	@Path("aumentarInteres")
	@Produces(MediaType.APPLICATION_JSON)
	public String actualizarInteres(@QueryParam("codigo") int codigo, @QueryParam("interes") double interes) {
		ciudadON.guardarCiudad(codigo ,  interes);
		return "Interes Aprobado";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ciudad> listar() {
		List<Ciudad> ciudades = ciudadON.listarCiudades();
		for (Ciudad ciudad : ciudades) {
			ciudad.setGiro(null);
		}
		return ciudades;
	}
}
