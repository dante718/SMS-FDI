package GestionDeInformatica.GDI.Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import General.Factoria_Transfers;
import GestionDeInformatica.GDI.Controlador.GDI_Controlador;

import java.io.*;


public class DaoEmpleados {
	
	
	private static final String Profesion = null;


	public ArrayList<TransferEmpleados> leerListaEmpleados(ArrayList<TransferEmpleados>arrayPersonas) {

			//ArrayList<TransferEmpleados> arrayPersonas = new ArrayList<TransferEmpleados>();

			File archivo = null;
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				archivo = new File ("src/BaseDatos/Personas.txt");
				fr = new FileReader (archivo);
				br = new BufferedReader(fr);
				// Lectura del fichero
				
				
				
				int i=0;

				String line="hola";
				line=br.readLine();
				while(line!=null) {				
					
						String DNI=line;
						line=br.readLine();//leo el nombre
						String Nombre=line;
						line=br.readLine();// leo ap.1
						String Apellido1=line;
						line=br.readLine();//leo ap.2
						String Apellido2=line;
						line=br.readLine();//leo profesion
						String Profesion=line;
						
						line=br.readLine();//leo estado
						String Estado=line;
						
						line=br.readLine();//leo rol
						String Rol=line;
						
						line=br.readLine();//leo dni para el siguiente
						
						TransferEmpleados persona = Factoria_Transfers.getInstanicaInf().crearTEmpleados(DNI, Nombre, Apellido1, Apellido2, Profesion, Estado, Rol);
						//TransferEmpleados persona = new TransferEmpleados(DNI,Nombre,Apellido1,Apellido2,Profesion,Estado,Rol);
						
						
						
						
						arrayPersonas.add(i,persona);
						
						
						//System.out.println(persona.getDni());
						i++;
					}
				
				br.close();
				
			} catch (IOException e) {			
					e.printStackTrace();
				}
			return arrayPersonas;
	
	}
	
	public void anadirEmpleado(TransferEmpleados persona) {
		
		String dni =persona.getDni();
		String nombre =persona.getName();
		String apellido1 =persona.getAp1();
		String apellido2 =persona.getAp2();
		String puesto =persona.getProf();
		String estado =persona.getEst();
		String rol =persona.getRo();
		
		ArrayList<TransferEmpleados> arrayPersonas = new ArrayList<TransferEmpleados>();
		

		arrayPersonas = GDI_Controlador.getInstancia().leerListaEmpleados(arrayPersonas);
		TransferEmpleados persona1 = Factoria_Transfers.getInstanicaInf().crearTEmpleados(dni, nombre, apellido1, apellido2, Profesion, estado, rol);

		//TransferEmpleados persona1 = new TransferEmpleados(dni, nombre, apellido1, apellido2, puesto, estado, rol);
		
		arrayPersonas.add(persona1);
		/*for(int j=0;j<arrayPersonas.size();j++) {
			
			String dni = arrayPersonas.get(j).getDni();
			String nombre = arrayPersonas.get(j).getName();
			String apellido1 = arrayPersonas.get(j).getAp1();
			String apellido2 = arrayPersonas.get(j).getAp2();
			String puesto = arrayPersonas.get(j).getProf();
			System.out.println(dni+" "+nombre+" "+apellido1+" "+apellido2+" "+puesto);
			
		}*/
		
		
		BufferedWriter bw = null;
	    FileWriter fw = null;

	    try {
	        File file = new File("src/BaseDatos/Personas.txt");
	        // Si el archivo no existe, se crea!
	        if (!file.exists()) {
	            file.createNewFile();
	        }

	        fw = new FileWriter(file.getAbsoluteFile(), true);
	        bw = new BufferedWriter(fw);
	        
	        bw.newLine();
	        bw.write(dni);
	        
	        bw.newLine();
	        bw.write(nombre);

	        bw.newLine();
	        bw.write(apellido1);
	        
	        bw.newLine();
	        bw.write(apellido2);
	        
	        bw.newLine();
	        bw.write(puesto);
	        
	        bw.newLine();
	        bw.write(estado);
	        
	        bw.newLine();
	        bw.write(rol);
	        
	        
	        
	    } catch (IOException e) {
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
	
	
	public void eliminarEmpleado(ArrayList<TransferEmpleados> arrayPersonas,int fila) {
		
		
		arrayPersonas.remove(fila); 
		
		BufferedWriter bw = null;
	    FileWriter fw = null;
		try {
	        File file = new File("src/BaseDatos/Personas.txt");
	        // Si el archivo no existe, se crea!
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        int i=0;
	        
	        fw = new FileWriter(file.getAbsoluteFile(), false);
	        bw = new BufferedWriter(fw);
	        while(i<arrayPersonas.size()) {
	        	
	        //bw.newLine();
	        bw.write(arrayPersonas.get(i).getDni());
	        
	        bw.newLine();
	        bw.write(arrayPersonas.get(i).getName());
	        
	        bw.newLine();
	        bw.write(arrayPersonas.get(i).getAp1());
	        
	        bw.newLine();
	        bw.write(arrayPersonas.get(i).getAp2());
	        
	        bw.newLine();
	        bw.write(arrayPersonas.get(i).getProf());
	        
	        bw.newLine();
	        bw.write(arrayPersonas.get(i).getEst());
	        
	        bw.newLine();
	        bw.write(arrayPersonas.get(i).getRo());
	        
	        if(i!=arrayPersonas.size()-1) { bw.newLine();}
	        i++;
	        }
	        
	        
	        
	        
	    } catch (IOException e) {
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
