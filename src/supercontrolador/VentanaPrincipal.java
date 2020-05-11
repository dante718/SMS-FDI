package supercontrolador;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import GestionDeEnvios.GDE.Controlador.ControladorEnvio;
import GestionDeFabrica.Vista.MainFabrica;
import GestionDeFabrica.Vista.VistaFabrica;
import GestionLaboratorio.presentacion_Laboratorio.Vista_Lab;
import GestionMedicos.GDM_Vista.InterfazVista;
import GestionProyectos.GDP.Main.initGUI;

public class VentanaPrincipal extends JFrame{
    
	private JButton GDP, GDM, GDL, GDF, GDE, GDA;
	private JLabel gdp, gdm, gdl, gdf, gde, gda, clinicos;
	
	public VentanaPrincipal() {
		initVentana();
	}

	private void initVentana() {
		setSize(950, 1000);
		setLayout(null);
		clinicos=  new JLabel("Clinicos");
		clinicos.setBounds(300, 50, 400, 70);
		clinicos.setFont(new Font("comic sans ms", 3, 70));
		clinicos.setForeground(Color.BLUE);
		getContentPane().add(clinicos);
		gdp=new JLabel("Gestion de Proyectos: ");
		gdp.setBounds(100, 150, 150, 50);
		getContentPane().add(gdp);
		GDP= new JButton();
		GDP.setBounds(100, 200, 100, 100);
		ImageIcon imagen1= new ImageIcon("ImagenGDP.jpg");
		GDP.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(GDP.getWidth(),GDP.getHeight(), Image.SCALE_SMOOTH)));
		getContentPane().add(GDP);
		gdm=new JLabel("Gestion de Medicos: ");
		gdm.setBounds(650, 150, 150, 50);
		getContentPane().add(gdm);
		GDM= new JButton();
		GDM.setBounds(650, 200, 100, 100);
		ImageIcon imagen2= new ImageIcon("ImagenGDM.jpg");
		GDM.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(GDM.getWidth(),GDM.getHeight(), Image.SCALE_SMOOTH)));
		getContentPane().add(GDM);
		gdl=new JLabel("Gestion de Laboratorio: ");
		gdl.setBounds(100, 350, 150, 50);
		getContentPane().add(gdl);
		GDL= new JButton();
		GDL.setBounds(100, 400, 100, 100);
		ImageIcon imagen3= new ImageIcon("ImagenGDL.jpg");
		GDL.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(GDL.getWidth(),GDL.getHeight(), Image.SCALE_SMOOTH)));
		getContentPane().add(GDL);
		gdf=new JLabel("Gestion de Fabrica: ");
		gdf.setBounds(650, 350, 150, 50);
		getContentPane().add(gdf);
		GDF= new JButton();
		GDF.setBounds(650, 400, 100, 100);
		ImageIcon imagen4= new ImageIcon("ImagenGDF.jpg");
		GDF.setIcon(new ImageIcon(imagen4.getImage().getScaledInstance(GDF.getWidth(),GDF.getHeight(), Image.SCALE_SMOOTH)));
		getContentPane().add(GDF);
		gde=new JLabel("Gestion de Envios: ");
		gde.setBounds(100, 550, 150, 50);
		getContentPane().add(gde);
		GDE= new JButton();
		GDE.setBounds(100, 600, 100, 100);
		ImageIcon imagen5= new ImageIcon("ImagenGDE.jpg");
		GDE.setIcon(new ImageIcon(imagen5.getImage().getScaledInstance(GDE.getWidth(),GDE.getHeight(), Image.SCALE_SMOOTH)));
		getContentPane().add(GDE);
		gda=new JLabel("Gestion de Almacen: ");
		gda.setBounds(650, 550, 150, 50);
		getContentPane().add(gda);
		GDA= new JButton();
		GDA.setBounds(650, 600, 100, 100);
		ImageIcon imagen6= new ImageIcon("ImagenGDA.jpg");
		GDA.setIcon(new ImageIcon(imagen6.getImage().getScaledInstance(GDA.getWidth(),GDA.getHeight(), Image.SCALE_SMOOTH)));
		getContentPane().add(GDA);		
		
		GDP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				initGUI.mainProyectos(null);			
			}
			
		});
		
		GDM.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InterfazVista medicos=new InterfazVista();
				medicos.mainMedicos();		
			}
			
		});
		GDL.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Vista_Lab();		
			}
			
		});
		GDF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFabrica vistaFabrica = new MainFabrica();
				vistaFabrica.initGUI();
			}
			
		});
		GDE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorEnvio envio = new ControladorEnvio();
				envio.iniciar();			
			}
			
		});
		GDA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		
		
		getContentPane().setBackground(Color.YELLOW);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
