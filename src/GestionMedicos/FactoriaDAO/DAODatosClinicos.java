package GestionMedicos.FactoriaDAO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import GestionMedicos.FactoriaServAplicacion.TransDatosClinicos;
import GestionMedicos.FactoriaServAplicacion.TransPlantilla;

public class DAODatosClinicos {
	private ArrayList<String> plantillaDatosClinicos;
	public DAODatosClinicos(String ruta) throws IOException{
		plantillaDatosClinicos=new ArrayList<String>();
		CargarDatosClinicos(ruta);
	}

	public ArrayList<String> getDatosClinicos(){
		return this.plantillaDatosClinicos;
	}
	private void CargarDatosClinicos(String ruta) throws IOException {
		
		BufferedReader buffer=new BufferedReader(new InputStreamReader(new FileInputStream(ruta)));
		String cadena=" ";
		while((cadena=buffer.readLine())!=null) {
			
			plantillaDatosClinicos.add(cadena);
			
		}
		buffer.close();
		
		
		
	}
	public TransDatosClinicos CrearDatos(String id,String sexo,int edad,String fecha,int cantidad) {
		// TODO Auto-generated method stub
		//se crear� el objeto Plantilla para ser Completada
		 
		return new TransDatosClinicos( id,sexo , edad, fecha,cantidad) ;
	}
	
	public void guardarDatosEnAlmacen(TransPlantilla plantilla, TransDatosClinicos  tablaDatos) {   
		//aqui realizar� una serializacion de los datos 
		//aqui debo escribir en un fichero cuya ruta es Estudio pastilla etapa la linea
		//de datos
		String Estudio=plantilla.getEstudio();
		String Pastilla=plantilla.getFarmaco();
		String Etapa=plantilla.getEtapa();
		String ruta="src/BaseDatos/"+Estudio+"_"+Pastilla+"_"+Etapa+".txt";

		FileWriter fichero = null;
		String datos="";
		int cont=0;
	
		try {
			String n = " ";
			BufferedReader buffer = null;
			buffer = new BufferedReader(new InputStreamReader(new FileInputStream(ruta)));
			while((n=buffer.readLine())!=null) {
		           datos+=n+"\n";
		           cont++;
				 }
		           
		           System.out.print(datos);

				
				fichero = new FileWriter(ruta);
				
				// Escribimos linea a linea en el fichero
				//for (int i =0;i<cont ; i++) {
					fichero.write(datos);
				//}
				
				fichero.write(tablaDatos.getId()+" "+tablaDatos.getSexo()+" "+tablaDatos.getEdad()
						+" "+tablaDatos.getFecha());

				fichero.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	
		 catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}


		
		


	
	}

}
