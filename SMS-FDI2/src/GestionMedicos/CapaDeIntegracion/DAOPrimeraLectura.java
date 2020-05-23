package GestionMedicos.CapaDeIntegracion;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DAOPrimeraLectura {
	
	public DAOPrimeraLectura() {
		
	}
	public ArrayList<String> leerPrimeravez(String ruta) {
		ArrayList<String>lista=new ArrayList<String>();
		String cadena=" ";
		BufferedReader buffer;
		try {

			buffer=new BufferedReader(new InputStreamReader(new FileInputStream(ruta)));
			while((cadena=buffer.readLine())!=null) {
				lista.add(cadena);
				
			}
			buffer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return lista;	
	}

}
