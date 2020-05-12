package GestionProyectos.GDP.Presentacion;

import javax.swing.JFrame;

public class FactoriaVistas{
    private static FactoriaVistas instancia=null;
	
	public static FactoriaVistas getInstancia() {
		if(instancia==null) {
			instancia=new FactoriaVistas();
		}
		return instancia;
	}
				
	public IVista getVista(String nombrevista) {
		if(nombrevista.toLowerCase().equals("vistaprincipal")) {
			return VistaPrincipal.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("crearproyecto")) {
			return VistaCrearProyecto.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("modificarinvestigador")) {
			return VistaModEstadoInvest.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("nuevaversiondeproyecto")) {
			return VistaNuevaVersionDeProyecto.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("añadirfabricacion")) {
			return VistaAnnadirFabricacion.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("solicitarmedicamentos")) {
			return VistaSolicitarPartidaDeMedicamentos.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("añadirinvestigador")) {
			return VistaAddInvestigador.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("añadirtrabajador")) {
			return VistaAddTrabajador.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("añadiraproyecto")) {
			return VistaAnnadirAProyecto.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("cambiarproyecto")) {
			return VistaCambiarProyecto.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("añadirproducto")) {
			return VistaAnnadirProducto.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("formulariomedicamentos")) {
			return VistaFormularioMedicamentos.getInstancia();
		}
		else {
			return null;
		}
		
	}
	
	
}
