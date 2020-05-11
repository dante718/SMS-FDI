package GestionProyectos.GDP.Main;

import GestionProyectos.GDP.Presentacion.FabricaVistas;


public class initGUI {
       public static void mainProyectos(String [] args) {
    	   FabricaVistas.getInstancia().getVista("VistaPrincipal").Visibilizar();;
       }
}
