package ec.edu.ups.est.ProyectoFinal.bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
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
	public List<Map<String, String>> listarCreditos() {
		List<Credito> creditos = creditoON.getCreditos();
		List<Credito> creditosPorAprobar = new ArrayList<Credito>();
		for(Credito credito : creditos) {
			if (credito.isEstaAprobado() == false) {
				creditosPorAprobar.add(credito);
			}
		}
		List<Map<String, String>> creditosPorAprobarMapeados = new ArrayList<Map<String,String>>();
		
		for(Credito credito : creditosPorAprobar) {
			Map<String, String> creditoMapeado = new HashMap<String, String>();
			String estaAprobado = "0";
			if (credito.isEstaAprobado()) {
				estaAprobado = "1";
			}
			creditoMapeado.put("estaAprobado", estaAprobado);
			creditoMapeado.put("fecha", new SimpleDateFormat("dd-MM-yyyy").format(credito.getFecha()));
			creditoMapeado.put("id", Integer.toString(credito.getId()));
			creditoMapeado.put("interes", Double.toString(credito.getInteres()));
			creditoMapeado.put("montoSolicitado", Double.toString(credito.getMontoSolicitado()));
			creditoMapeado.put("plazosCredito", Integer.toString(credito.getPlazosCredito()));
			creditoMapeado.put("cedulaPersona", credito.getUsuario().getCedula());
			creditoMapeado.put("nombrePersona", credito.getUsuario().getNombre() + " " + credito.getUsuario().getApellido());

			creditosPorAprobarMapeados.add(creditoMapeado);
		}
		return creditosPorAprobarMapeados;
	}
	
}
