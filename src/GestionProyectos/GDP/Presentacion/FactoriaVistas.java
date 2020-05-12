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
		else if(nombrevista.toLowerCase().equals("a�adirfabricacion")) {
			return VistaAnnadirFabricacion.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("solicitarmedicamentos")) {
			return VistaSolicitarPartidaDeMedicamentos.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("a�adirinvestigador")) {
			return VistaAddInvestigador.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("a�adirtrabajador")) {
			return VistaAddTrabajador.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("a�adiraproyecto")) {
			return VistaAnnadirAProyecto.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("cambiarproyecto")) {
			return VistaCambiarProyecto.getInstancia();
		}
		else if(nombrevista.toLowerCase().equals("a�adirproducto")) {
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
