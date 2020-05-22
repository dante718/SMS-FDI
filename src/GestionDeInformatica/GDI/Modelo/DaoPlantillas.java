package GestionDeInformatica.GDI.Modelo;

import java.util.ArrayList;

import General.Factoria_Transfers;
import GestionDeInformatica.GDI.Controlador.GDI_Controlador;

import java.io.*;

public class DaoPlantillas {



public ArrayList<TransferPlantilla> leerListaEstudios(ArrayList<TransferPlantilla> arrayEstudios) {
	
	//ArrayList<TransferPlantilla> arrayEstudios = new ArrayList<TransferPlantilla>();
	
	File archivo1 = null, archivo2=null,archivo3=null;
	FileReader fr1 = null,fr2=null,fr3=null;
	BufferedReader br1 = null,br2=null,br3=null;
	
	
	try {
		
		archivo1 = new File ("src/BaseDatos/estudios.txt");
		fr1 = new FileReader (archivo1);
		br1 = new BufferedReader(fr1);
		
		archivo2 = new File ("src/BaseDatos/farmacos.txt");
		fr2 = new FileReader (archivo2);
		br2 = new BufferedReader(fr2);
		
		archivo3 = new File ("src/BaseDatos/etapas.txt");
		fr3 = new FileReader (archivo3);
		br3 = new BufferedReader(fr3);
		// Lectura del fichero
		
		
		
		int i=0;

		String line="ID";

		while(line!=null) {				
			
				line=br1.readLine();//leo el id
				String ID=line;

				
				line=br2.readLine();//leo el nombre
				String NOMBRE=line;
				
				
				line=br3.readLine();//leo el etapa
				String ETAPA=line;
				
				
				TransferPlantilla plantilla =Factoria_Transfers.getInstanicaInf().crearTPlantilla(ID,NOMBRE,ETAPA);
				//TransferPlantilla plantilla = new TransferPlantilla(ID,NOMBRE,ETAPA);
				arrayEstudios.add(i,plantilla);
				
				
				//System.out.println(persona.getDni());
				i++;
			}
		
		br1.close();
		br2.close();
		br3.close();
		
	} catch (IOException e) {			
			e.printStackTrace();
		}
	
	
	
	
	return arrayEstudios;
}



	public void eliminarEstudio(ArrayList<TransferPlantilla> arrayPlantilla,int fila) {

		arrayPlantilla.remove(fila);
		
		BufferedWriter bw1 = null,bw2=null,bw3=null;
	    FileWriter fw1 = null,fw2=null,fw3=null;
	    
	    try {
	        File file1 = new File("src/BaseDatos/estudios.txt");
	        File file2 = new File("src/BaseDatos/farmacos.txt");
	        File file3 = new File("src/BaseDatos/etapas.txt");
	        // Si el archivo no existe, se crea!
	        if (!file1.exists()) {
	            file1.createNewFile();
	        }
	        if (!file2.exists()) {
	            file2.createNewFile();
	        }
	        if (!file3.exists()) {
	            file3.createNewFile();
	        }
	        
	        int i=0;
	        
	        fw1 = new FileWriter(file1.getAbsoluteFile(), false);
	        fw2 = new FileWriter(file2.getAbsoluteFile(), false);
	        fw3 = new FileWriter(file3.getAbsoluteFile(), false);
	        bw1 = new BufferedWriter(fw1);
	        bw2 = new BufferedWriter(fw2);
	        bw3 = new BufferedWriter(fw3);
	        
	        while(i<arrayPlantilla.size()-1) {
		        bw1.write(arrayPlantilla.get(i).getID());
		        bw2.write(arrayPlantilla.get(i).getNOM());
		        bw3.write(arrayPlantilla.get(i).getETA());
		       	        
		        
		        if(i!=arrayPlantilla.size()-1) { bw1.newLine();bw2.newLine();bw3.newLine();
		        }
		        
		        i++;

	        }
	        

	} catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (bw1 != null)
                bw1.close();
            if (bw2 != null)
                bw2.close();
            if (bw3 != null)
                bw3.close();
            if (fw1 != null)
                fw1.close();
            if (fw2 != null)
                fw2.close();
            if (fw3 != null)
                fw3.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
	

	
	}
	
	
	public void anadirEstudio(TransferPlantilla estudio) {
		
		String ID = estudio.getID();
		String NOMBRE = estudio.getNOM();
		String ETAPA = estudio.getETA();
		
		ArrayList<TransferPlantilla> arrayEstudios = new ArrayList<TransferPlantilla>();
		//GDI_Controlador Controlador = new GDI_Controlador();
		arrayEstudios = GDI_Controlador.getInstancia().leerListaEstudios(arrayEstudios);
		
		TransferPlantilla estudio1 =Factoria_Transfers.getInstanicaInf().crearTPlantilla(ID,NOMBRE,ETAPA);
		//TransferPlantilla estudio1 = new TransferPlantilla(ID,NOMBRE,ETAPA);
		
		arrayEstudios.add(arrayEstudios.size()-1,estudio1);
		
		BufferedWriter bw1 = null,bw2=null,bw3=null;
	    FileWriter fw1 = null,fw2=null,fw3=null;
	    
	    try {
	        File file1 = new File("src/BaseDatos/estudios.txt");
	        File file2 = new File("src/BaseDatos/farmacos.txt");
	        File file3 = new File("src/BaseDatos/etapas.txt");
	         //Si el archivo no existe, se crea!
	        if (!file1.exists()) {
	            file1.createNewFile();
	        }
	        if (!file2.exists()) {
	            file2.createNewFile();
	       }
	        if (!file3.exists()) {
	            file3.createNewFile();
	        }
	    
int i=0;
	        
	        fw1 = new FileWriter(file1.getAbsoluteFile(), false);
	        fw2 = new FileWriter(file2.getAbsoluteFile(), false);
	        fw3 = new FileWriter(file3.getAbsoluteFile(), false);
	        bw1 = new BufferedWriter(fw1);
	        bw2 = new BufferedWriter(fw2);
	        bw3 = new BufferedWriter(fw3);
	        
	        while(i<arrayEstudios.size()-1) {
		        bw1.write(arrayEstudios.get(i).getID());
		        bw2.write(arrayEstudios.get(i).getNOM());
		        bw3.write(arrayEstudios.get(i).getETA());
		       	        
		        
		        if(i!=arrayEstudios.size()-1) { bw1.newLine();bw2.newLine();bw3.newLine();
		        }
		        
		        i++;

	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (bw1 != null)
	                bw1.close();
	            if (bw2 != null)
	                bw2.close();
	            if (bw3 != null)
	                bw3.close();
	            if (fw1 != null)
	                fw1.close();
	            if (fw2 != null)
	                fw2.close();
	            if (fw3 != null)
	                fw3.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	        
	    
	    
	    
	}
	
	
	public void anadirPlantilla(String id, String nombre, String etapa, ArrayList<String> variables) {
	
		String fichero="src/BaseDatos/parametros_"+id+"_"+nombre+"_"+etapa+".txt.";
		BufferedWriter bw = null;
		FileWriter fw = null;	
		try {
	        File file = new File(fichero);
	        if (!file.exists()) {
	            file.createNewFile();
	        }
		
	        fw = new FileWriter(file.getAbsoluteFile(), false);
	        bw = new BufferedWriter(fw);
		int i=0;
	        while(i<variables.size()) {
	        bw.write(variables.get(i));
	        if(i!=variables.size()-1) { bw.newLine();;
	        }
	        i++;
	        }
	        
		
	}catch (IOException e) {
        e.printStackTrace();
	}finally {
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
	
	
	
	public ArrayList<String> leerPlantilla(String id, String nombre, String etapa,ArrayList<String> variables) {
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String fichero="src/BaseDatos/parametros_"+id+"_"+nombre+"_"+etapa+".txt.";
		try {
			archivo = new File (fichero);
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			int i=0;

			String line="hola";
			while(line!=null) {		
				
				line=br.readLine();//leo cada parametro
				variables.add(i,line);
				i++;
			}
			br.close();
		
	}catch (IOException e) {			
		e.printStackTrace();
	}
		return variables;
}
}