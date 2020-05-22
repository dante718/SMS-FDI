package GestionMedicos.FactoriaDAO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class ModeloPlantilla {

	
	public ArrayList<String>leerDatos(String ruta) throws IOException{
		ArrayList<String> l=new ArrayList<String>();
		BufferedReader buffer=new BufferedReader(new InputStreamReader(new FileInputStream(ruta)));
		String cadena=" ";
		while((cadena=buffer.readLine())!=null) {
			
			l.add(cadena);
			
		}
		buffer.close();
		
		return l;
		
	}
	
	public void agregarDato(String datos,String d, String ruta) throws IOException {
		FileWriter fichero = null;
		fichero = new FileWriter(ruta);
		String info=datos+"\n"+d+"\n";
		fichero.write(info);
		
		fichero.close();
		
		
	}
	
	public abstract void crearDatos(String dato);
	public abstract void convertirDatos();
}

