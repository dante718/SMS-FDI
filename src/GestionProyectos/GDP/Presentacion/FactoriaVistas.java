package GestionProyectos.GDP.Presentacion;

import java.util.List;


import GestionProyectos.GDP.FactoriaAbstracta.FactoriaAbstracta;
import GestionProyectos.GDP.Negocio.TPersona;
import GestionProyectos.GDP.Negocio.TProyecto;

public class FactoriaVistas implements FactoriaAbstracta<TPersona,TProyecto>{
    private static FactoriaVistas instancia=null;
	
	public static FactoriaVistas getInstancia() {
		if(instancia==null) {
			instancia=new FactoriaVistas();
		}
		return instancia;
	}


	@Override
	public TPersona CrearObjetoPersona(List<Object> datos) {
		return null;
	}

	@Override
	public TProyecto CrearObjetoProyecto(List<Object> datos) {
		return null;
	}

	@Override
	public IVista CrearObjetoVista(String tipo) {
		if(tipo.toLowerCase().equals("vistaprincipal")) {
			return VistaPrincipal.getInstancia();
		}
		else if(tipo.toLowerCase().equals("crearproyecto")) {
			return VistaCrearProyecto.getInstancia();
		}
		else if(tipo.toLowerCase().equals("modificarinvestigador")) {
			return VistaModEstadoInvest.getInstancia();
		}
		else if(tipo.toLowerCase().equals("nuevaversiondeproyecto")) {
			return VistaNuevaVersionDeProyecto.getInstancia();
		}
		else if(tipo.toLowerCase().equals("añadirfabricacion")) {
			return VistaAnnadirFabricacion.getInstancia();
		}
		else if(tipo.toLowerCase().equals("solicitarmedicamentos")) {
			return VistaSolicitarPartidaDeMedicamentos.getInstancia();
		}
		else if(tipo.toLowerCase().equals("añadirinvestigador")) {
			return VistaAddInvestigador.getInstancia();
		}
		else if(tipo.toLowerCase().equals("añadirtrabajador")) {
			return VistaAddTrabajador.getInstancia();
		}
		else if(tipo.toLowerCase().equals("añadiraproyecto")) {
			return VistaAnnadirAProyecto.getInstancia();
		}
		else if(tipo.toLowerCase().equals("cambiarproyecto")) {
			return VistaCambiarProyecto.getInstancia();
		}
		else if(tipo.toLowerCase().equals("añadirpedido")) {
			return VistaAnnadirPedido.getInstancia();
		}
		else {
			return null;
		}
	}
	
	
}
