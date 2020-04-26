package GestionMedicos.Complementos;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class button extends JButton {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public button(String caption,int tam, int x, int y, int w, int h) {
		super(caption); // se crea el botón
		//super.setPreferredSize(new Dimension(w,h));
		super.setHorizontalAlignment(super.CENTER);
		super.setBounds(x,y,w,h); // se coloca y da tamaño	
		Font fuente = new Font("Arial",Font.ITALIC,tam);
		this.setFont(fuente);
		 
	 }
	
	
}
