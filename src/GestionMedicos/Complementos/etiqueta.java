package GestionMedicos.Complementos;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class etiqueta extends JLabel {
	public etiqueta (String caption, Color color, int tam,int x, int y, int w, int h){
		super(caption); // se crea la etiqueta
		super.setBounds(x,y,w,h); // se coloca y da tamaño
		super.setHorizontalAlignment(JLabel.CENTER); // se centra en su rectángulo
		setForeground(color); // se le da color a la fuente
		Font fuente = new Font("Arial",Font.ITALIC,tam);
		super.setFont(fuente);
		}
	
	
}
