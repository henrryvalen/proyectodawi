package dao;

import entidades.Persona;
import entidades.Usuario;

public interface PersonaDAO {

	public Persona consultarPersona(Usuario u) throws Exception;

	public void registrarPersona(Persona nueva) throws Exception;
}
