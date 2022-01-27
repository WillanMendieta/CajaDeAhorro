package ec.edu.ups.est.ProyectoFinal.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class ExitoErrorBean {
	private String mensaje;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		String url = mensaje.replace(" ", "%20");
		this.mensaje = url;
	}
	
	public String getMensajeParseado() {
		String mensaje = this.mensaje;
		mensaje = mensaje.replace("%20", " ");
		return mensaje;
	}
}
