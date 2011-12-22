package servicios;


import dao.DAOFactory;
import dao.SolicitudExoneracionDAO;
import entidades.Boleta;
import entidades.SolicitudExoneracion;

public class SolicitudExoneracionDaoService implements SolicitudExoneracionService {
	private DAOFactory fabrica = null;
	private SolicitudExoneracionDAO exoneraciondao;
	

	public SolicitudExoneracionDaoService(int jpa) {
		// TODO Auto-generated constructor stub
		fabrica = DAOFactory.getDAOFactory(jpa);
        this.exoneraciondao = fabrica.getSolicitudExoneracionDAO();
	}

	@Override
	public boolean CumpleCalendarioExoneracion(int codigoCalendario)
			throws Exception {
		// TODO Auto-generated method stub
		return exoneraciondao.CumpleCalendarioExoneracion(codigoCalendario);
	}

	@Override
	public boolean NoExisteDeudas(Boleta boleta) throws Exception {
		// TODO Auto-generated method stub
		return exoneraciondao.NoExisteDeudas(boleta);
	}

	@Override
	public SolicitudExoneracion buscarSolicitudXAsignatura(
			SolicitudExoneracion exoneracion) throws Exception {
		// TODO Auto-generated method stub
		return exoneraciondao.buscarSolicitudXAsignatura(exoneracion);
	}

	@Override
	public void registrarSolictud(SolicitudExoneracion exoneracion)
			throws Exception {
		// TODO Auto-generated method stub
		exoneraciondao.registrarSolictud(exoneracion);
	}



}
