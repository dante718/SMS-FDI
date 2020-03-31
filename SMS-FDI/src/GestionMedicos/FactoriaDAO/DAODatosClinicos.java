package GestionMedicos.FactoriaDAO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import GestionMedicos.FactoriaServAplicacion.TransDatosClinicos;
import GestionMedicos.FactoriaServAplicacion.TransPlantilla;

public class DAODatosClinicos {
	public DAODatosClinicos(){
		
	}

	public TransDatosClinicos CrearDatos(String id,String sexo,int edad,int cantidad,String fecha) {
		// TODO Auto-generated method stub
		//se creará el objeto Plantilla para ser Completada
		 
		return new TransDatosClinicos(id, sexo, edad, cantidad, fecha) ;
	}
	
	public void guardarDatosEnAlmacén(TransPlantilla plantilla, TransDatosClinicos  tablaDatos) {   
		//aqui realizaré una serializacion de los datos 
		//aqui debo escribir en un fichero cuya ruta es Estudio pastilla etapa la linea
		//de datos
		String Estudio=plantilla.getEstudio();
		String Pastilla=plantilla.getFarmaco();
		String Etapa=plantilla.getEtapa();
		String ruta="src/almacen/"+Estudio+"_"+Pastilla+"_"+Etapa+".txt";

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
				
				fichero.write(tablaDatos.getId()+" "+tablaDatos.getSexo()+" "+tablaDatos.getEdad()+
						" "+tablaDatos.getCantidad()+" "+tablaDatos.getFecha());

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
