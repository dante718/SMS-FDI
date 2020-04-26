package GestionMedicos.GDM_Vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GestionMedicos.Complementos.button;
import GestionMedicos.GDM.Controlador.ControladorMed;

public class PantallaPrincipal extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public	PantallaPrincipal(){
		super("Subsistema medicos");
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		this.setBounds(0,0,800,800);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.yellow);
		//encabezado
		JPanel PanelPrincipal=new JPanel();
		JPanel PanelTitulo=new JPanel();
		JPanel PanelBotonesAcciones=new JPanel();
		JPanel PanelInferior=new JPanel(new BorderLayout());
		JPanel Paneliz=new JPanel();
		PanelTitulo.setPreferredSize(new Dimension (300,200));
		PanelInferior.setBackground(Color.red);
		Paneliz.setBackground(Color.red);
		PanelPrincipal.setLayout(new BoxLayout(PanelPrincipal,BoxLayout.Y_AXIS));
		PanelBotonesAcciones.setLayout(new BoxLayout(PanelBotonesAcciones,BoxLayout.Y_AXIS));
		
		button botonPedido =new button("REALIZAR PEDIDO    ",30,0,0, 0, 0);
		button botonHacerEstudio =new button("REALIZAR ESTUDIO  ",30,0,0, 0, 0);
		button botonInforme =new button("INFORME DE ERROR",30,0,0,0, 0);
		
		JLabel titulo=this.createLabel("Hospital ",Color.blue,100,0,0 ,0 ,0 );
		titulo.setIcon(new ImageIcon("cruz.png"));
		PanelTitulo.add(Box.createRigidArea(new Dimension(10,0)));
		PanelTitulo.add(Box.createHorizontalGlue());
		PanelTitulo.add(titulo);
		
		PanelBotonesAcciones.add(Box.createVerticalStrut(100));
		PanelBotonesAcciones.add(botonPedido);
		PanelBotonesAcciones.add(Box.createVerticalStrut(40));
		PanelBotonesAcciones.add(botonHacerEstudio);
		PanelBotonesAcciones.add(Box.createVerticalStrut(40));
		PanelBotonesAcciones.add(botonInforme);		
		
		
		PanelPrincipal.add(PanelTitulo);
		PanelPrincipal.add(PanelBotonesAcciones);
	
		JPanel PanelOpciones=new JPanel(new BorderLayout());
		JPanel PanelEtiquetasOpciones=new JPanel(new FlowLayout());
		JPanel PanelOpcionesBotones=new JPanel(new FlowLayout());
		JLabel etiquetaSalir = this.createLabel("Salir",Color.black,15,1510, 900,120, 30);
		JLabel etiquetaContinuar = this.createLabel("Continuar",Color.black,15,1615,900,120, 30);
		
		button botonSalir =new button(" ",15,1535,875,80, 30);
		button botonContinuar =new button(" ",15,1635,875, 95, 30);
		botonSalir.setIcon(new ImageIcon("salir.jpg"));
		botonContinuar.setIcon(new ImageIcon("continuar.png"));
		
		PanelEtiquetasOpciones.add(Box.createRigidArea(new Dimension(20,0)));
		PanelEtiquetasOpciones.add(etiquetaSalir);
		PanelEtiquetasOpciones.add(Box.createRigidArea(new Dimension(20,0)));
		PanelEtiquetasOpciones.add(etiquetaContinuar,FlowLayout.LEFT);
		
		PanelOpcionesBotones.add(botonSalir);
		PanelOpcionesBotones.add(botonContinuar,FlowLayout.LEFT);
		
		PanelOpciones.add(PanelOpcionesBotones,BorderLayout.NORTH);
		PanelOpciones.add(PanelEtiquetasOpciones,BorderLayout.SOUTH);
	
		
		
		
		PanelInferior.add(PanelOpciones,BorderLayout.EAST);
	
		this.add(PanelPrincipal,BorderLayout.NORTH);
		this.add(PanelInferior,BorderLayout.PAGE_END);
		//pulso boton de hace Estudio:
			botonHacerEstudio.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {// aqui debo hacer la llamada al controlador  
					PantallaSeleccion p=new PantallaSeleccion(ControladorMed.getInstancia());
				}
			});
	this.pack();
	
	}
	

	public JLabel createLabel(String caption, Color color, int tam,int x, int y, int w, int h){
		JLabel label = new JLabel(caption); // se crea la etiqueta
		label.setBounds(x,y,w,h); // se coloca y da tama�o
		label.setHorizontalAlignment(JLabel.CENTER); // se centra en su rect�ngulo
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
