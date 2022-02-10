package ec.edu.ups.est.ProyectoFinal.bean;

import java.util.ArrayList;
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

@Path("creditos")
public class CreditoRest {
	@Inject
	private CreditoONLocal creditoON;
	
	@GET
	@Path("aprobar")
	@Produces(MediaType.APPLICATION_JSON)
	public String aprobarCredito(@QueryParam("id") int id) {
		creditoON.aprobarCredito(id);
		return "Credito aprobado";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Credito> listarCreditos() {
		List<Credito> creditos = creditoON.getCreditos();
		for(Credito credito : creditos) {
			credito.setUsuario(null);
			credito.setAmortizaciones(null);
		}
		List<Credito> creditosPorAprobar = new ArrayList<Credito>();
		for(Credito credito : creditos) {
			if (credito.isEstaAprobado() == false) {
				creditosPorAprobar.add(credito);
			}
		}
		return creditosPorAprobar;
	}
	
}
