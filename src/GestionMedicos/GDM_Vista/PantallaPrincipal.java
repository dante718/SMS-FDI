package GestionMedicos.GDM_Vista;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import GestionMedicos.Complementos.button;
import GestionMedicos.GDM.Controlador.ControladorMed;

public class PantallaPrincipal extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public	PantallaPrincipal(){
		super("Subsistema médicos");
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(0,0);
		this.setBounds(0,0,800,500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.yellow);
		//encabezado
		JLabel titulo=this.createLabel("Hospital",Color.blue,80, 500,0 ,400 ,150 );
		titulo.setIcon(new ImageIcon("cruz.png"));
		
		
		button botonPedido =new button("REALIZAR PEDIDO",20,800,300, 400, 80);
		button botonHacerEstudio =new button("REALIZAR ESTUDIO",20,800,400, 400, 80);
		button botonInforme =new button("INFORME DE ERROR",20,800,500, 400, 80);
		
		JLabel etiquetaSalir = this.createLabel("Salir",Color.black,15,1510, 900,120, 30);
		JLabel etiquetaContinuar = this.createLabel("Continuar",Color.black,15,1615,900,120, 30);
		button botonSalir =new button(" ",15,1535,875,80, 30);
		button botonContinuar =new button(" ",15,1635,875, 95, 30);
		botonSalir.setIcon(new ImageIcon("salir.jpg"));
		botonContinuar.setIcon(new ImageIcon("continuar.png"));
		//pulso boton de hace Estudio:
			botonHacerEstudio.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {// aqui debo hacer la llamada al controlador  
					
					
					PantallaSeleccion p=new PantallaSeleccion(ControladorMed.getInstancia());
					
				}
				
				
				
			});
		
		this.add(titulo);
		this.add(botonSalir);
		this.add(botonContinuar);
		this.add(etiquetaSalir);
		this.add(etiquetaContinuar);
		this.add(botonPedido);
		this.add(botonHacerEstudio);
		this.add(botonInforme);
		
	
	}
	

	public JLabel createLabel(String caption, Color color, int tam,int x, int y, int w, int h){
		JLabel label = new JLabel(caption); // se crea la etiqueta
		label.setBounds(x,y,w,h); // se coloca y da tamaño
		label.setHorizontalAlignment(JLabel.CENTER); // se centra en su rectángulo
		label.setForeground(color); // se le da color a la fuente
		Font fuente = new Font("Arial",Font.ITALIC,tam);
		label.setFont(fuente);
		return label;
		
			}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("has pulsado el boton");
		
		
	}
	
	
}
