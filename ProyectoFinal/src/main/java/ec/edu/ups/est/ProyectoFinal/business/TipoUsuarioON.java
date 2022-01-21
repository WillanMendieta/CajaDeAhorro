package ec.edu.ups.est.ProyectoFinal.business;

import javax.inject.Inject;

import ec.edu.ups.est.ProyectoFinal.dao.TipoUsuarioDAO;
import ec.edu.ups.est.ProyectoFinal.model.TipoUsuario;

public class TipoUsuarioON {

		@Inject
		private TipoUsuarioDAO tipoUsuarioDAO;
		
		public void crear(TipoUsuario tipoUsuario)  throws Exception {
			TipoUsuario tipoUsuarioSearched = tipoUsuarioDAO.read(tipoUsuario.getId());
			if (tipoUsuarioSearched == null) {
				tipoUsuarioDAO.insert(tipoUsuario);
				System.out.println("Tipo de usuario insertado");
			} else {
				throw new Exception("El tipo de usuario ya existe");
			}
		}
		
		public TipoUsuario buscar(int id) {
			return tipoUsuarioDAO.read(id);
		}
	}

