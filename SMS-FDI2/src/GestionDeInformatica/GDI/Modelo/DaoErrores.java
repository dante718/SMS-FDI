package GestionDeInformatica.GDI.Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import General.Factoria_Transfers;

public class DaoErrores {
	
	
	public ArrayList<TransferError> leerListaErrores(ArrayList<TransferError> arrayErrores) {
		
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File ("src/BaseDatos/IncidenciasInformatico.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			// Lectura del fichero
			
			int i=0;

			String line="hola";
			while(line!=null) {
				
				line=br.readLine();//leo incidencia
				String error=line;
				TransferError ERROR = Factoria_Transfers.getInstanicaInf().crearTError(error);
				//TransferError ERROR = new TransferError(error);
				arrayErrores.add(i,ERROR);
				i++;
			}
			br.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		return arrayErrores;
	}

	public void eliminarError(ArrayList<TransferError> estudios,int fila) {
		
		estudios.remove(fila);
		BufferedWriter bw = null;
	    FileWriter fw = null;
	    try {
	        File file = new File("src/BaseDatos/IncidenciasInformatico.txt");
	        // Si el archivo no existe, se crea!
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        int i=0;
	        fw = new FileWriter(file.getAbsoluteFile(), false);
	        bw = new BufferedWriter(fw);
	        while(i<estudios.size()-1) {
	        	bw.write(estudios.get(i).getE());
	        	if(i!=estudios.size()-1) { bw.newLine();}
	        	i++;
	        }
	        	
	        }catch (IOException e) {
		        e.printStackTrace();
	        } finally {
		        try {
		            if (bw != null)
		                bw.close();
		            if (fw != null)
		                fw.close();
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		    }
	}
	
	
}
