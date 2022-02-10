package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.est.ProyectoFinal.business.CajeroONLocal;
import ec.edu.ups.est.ProyectoFinal.business.CreditoONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Cajero;
import ec.edu.ups.est.ProyectoFinal.model.Credito;

@Path("cajero")
public class CajeroRest {
	@Inject
	private CajeroONLocal cajeroON;
	
	@GET
	@Path("aprobarCajero")
	@Produces(MediaType.APPLICATION_JSON)
	public String aprobarCajero(@QueryParam("id") int id) {
		cajeroON.aprobarCajero(id);
		return "Cajero aprobado";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cajero> listarCajero() {
		List<Cajero> cajeros = cajeroON.getCajeros();

		return cajeros;
	}
	
	@GET
	@Path("negarCajero")
	@Produces(MediaType.APPLICATION_JSON)
	public String negarCajero(@QueryParam("id") int id) {
		cajeroON.negarCajero(id);
		return "Cajero negado";
	}
	
}
