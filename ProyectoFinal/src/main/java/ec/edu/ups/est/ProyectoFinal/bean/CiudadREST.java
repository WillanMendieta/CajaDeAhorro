package ec.edu.ups.est.ProyectoFinal.bean;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.est.ProyectoFinal.business.CiudadON;
import ec.edu.ups.est.ProyectoFinal.model.Ciudad;

@Path("interes")
public class CiudadREST {
	@Inject
	private CiudadON ciudadON;

	@GET
	@Path("aumentarInteres")
	@Produces(MediaType.APPLICATION_JSON)
	public String actualizarInteres(@QueryParam("codigo") int codigo, @QueryParam("interes") double interes) {
		System.out.println(codigo);
		System.out.println(interes);
		ciudadON.guardarCiudad(codigo ,  interes);
		return "Interes Aprobado";
	}
}
