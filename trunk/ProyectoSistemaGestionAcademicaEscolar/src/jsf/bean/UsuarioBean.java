package jsf.bean;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import entidades.Permiso;
import entidades.Persona;
import entidades.Usuario;

import servicios.ApplicationBusinessDelegate;
import servicios.UsuarioService;

@ManagedBean
public class UsuarioBean {

	
	private static ApplicationBusinessDelegate abd = new ApplicationBusinessDelegate();
	
	//@ManagedProperty(value="#{userService}")
	private static UsuarioService userService = abd.getUsuarioService();
	
	private ArrayList<Permiso> funcionalidades;
	private Permiso funcionalidad;
	private Usuario usuario1;
	private Persona persona1;
	
	public UsuarioBean(){
		System.out.println("Creado UsuarioBean...");
		funcionalidad= new Permiso();
		usuario1= new Usuario();
		persona1= new Persona();
	}

	public String loguearUsuario(){
		System.out.println("En el loguear usuario - UsuarioBean");
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String cadenausuario = params.get("usuario");
		String cadenapassword = params.get("password");

		persona1.setCodpersona(cadenausuario);
		usuario1.setPersona(persona1);
		usuario1.setContrasena(cadenapassword);
		
		try {
			if(userService.validarUsuarioEntrada(usuario1)){
				userService.listarMenusCorresp(usuario1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "bienvenida";
	}

	//getters y setter
	
	public static UsuarioService getUserService() {
		return userService;
	}

	public static void setUserService(UsuarioService userService) {
		UsuarioBean.userService = userService;
	}

	public ArrayList<Permiso> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(ArrayList<Permiso> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

	public Permiso getFuncionalidad() {
		return funcionalidad;
	}

	public void setFuncionalidad(Permiso funcionalidad) {
		this.funcionalidad = funcionalidad;
	}

	public Usuario getUsuario1() {
		return usuario1;
	}

	public void setUsuario1(Usuario usuario1) {
		this.usuario1 = usuario1;
	}

	public Persona getPersona1() {
		return persona1;
	}

	public void setPersona1(Persona persona1) {
		this.persona1 = persona1;
	}
	
	
}