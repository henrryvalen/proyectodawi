package servicios;

import dao.DAOFactory;

public class ApplicationBusinessDelegate {

	public AlumnoService getAlumnoService(){
		return new AlumnoDaoService(DAOFactory.JPA);
	}
	
	public UsuarioService getUsuarioService(){
		return new UsuarioDaoService(DAOFactory.JPA);
	}
	
}
