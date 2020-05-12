package GestionProyectos.GDP.Main;

import GestionProyectos.GDP.Presentacion.FactoriaVistas;


public class initGUI {
       public static void mainProyectos(String [] args) {
    	   FactoriaVistas.getInstancia().CrearObjetoVista("VistaPrincipal").Visibilizar();;
       }
}
