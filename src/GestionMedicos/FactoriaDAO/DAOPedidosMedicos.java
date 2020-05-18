package GestionMedicos.FactoriaDAO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DAOPedidosMedicos {
	private ArrayList<String> Listapedidos;
	private String ruta;
	public DAOPedidosMedicos() {
		this.ruta="src/BaseDatos/pedidosMedicos.txt";
		try {
			Listapedidos=cargaPedidos(ruta);
		}
		catch(IOException e) {
			System.out.println("fallo al cargar los ficheros de pedidos");
		}
	}
	private ArrayList<String> cargaPedidos( String r) throws IOException {
		BufferedReader buffer=new BufferedReader(new InputStreamReader(new FileInputStream(r)));
		String cadena=" ";
		ArrayList<String> l=new ArrayList<String>();
		while((cadena=buffer.readLine())!=null) {
			
			l.add(cadena);
			
		}
		buffer.close();
		return l;
		
	}
	public void  realizarPedido(String Pedido) {
		Listapedidos.add(Pedido);
		guardarPedido();
		//guardar
	}
	
	
	
	public String  consultarPedido(String id,String nombre) {
		int i=0;
		boolean encontrado=false;
		ArrayList <String> estadoPedidos=null;
		String []aux = null;
		try {
		 estadoPedidos=cargaPedidos("src/BaseDatos/EstadoPedidosMedicos.txt");
		 while(!encontrado && i<estadoPedidos.size()) {
				aux=estadoPedidos.get(i).split(" ");
				if(id.equals(aux[0])&&(nombre.equals(aux[1]))) {
					encontrado=true;
					
				}
				else{
					i++;
				}
			}
						
		}
		catch(IOException e) {
			System.out.println("fallo al cargar los estados de los pedidos");
		}
		 if(encontrado) {

			 return aux[0]+" "+aux[1]+" "+aux[2]+" "+aux[3];
			  
		 }
		 else{
			 return "no encontrado"+"\n";
		 }
		
		
		
		
		
	}
	public void guardarPedido() {
		

		FileWriter fichero = null;
		String datos="";
	
	
		try {
			
			for(int i=0;i<Listapedidos.size();i++) {
				datos+=Listapedidos.get(i)+"\n";
			}
			
			fichero = new FileWriter(ruta);
			fichero.write(datos);
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
