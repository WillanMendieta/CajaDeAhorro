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

import ec.edu.ups.est.ProyectoFinal.business.CreditoONLocal;
import ec.edu.ups.est.ProyectoFinal.model.Credito;

@Path("credito")
public class CreditoRest {
	@Inject
	private CreditoONLocal creditoON;
	
	@GET
	@Path("suma")
	@Produces(MediaType.APPLICATION_JSON)
	public double suma(@QueryParam("a") double a, @QueryParam("b") double b) {
		return a + b;
	}
	
	@POST
	@Path("suma")
	@Produces(MediaType.APPLICATION_JSON)
	public double sumaPost(@FormParam("a") double a, @FormParam("b") double b) {
		return a + b;
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String insertarCredito(Credito credito) {
		//creditoON.insertarCredito(credito);
		return "OK";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Credito buscarCredito() {
		return new Credito();
	}
	
}
