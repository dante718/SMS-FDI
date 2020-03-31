package GestionDeEnvios.GDE.Controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Controlador {

	
	public static void main(String[] args) {
		String nom = null;
		System.out.println("hola");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Introduce tu nombre--->");
		try {
			nom = br.readLine();
		}catch(Exception e){
		}
		System.out.println(nom);
	}
}
