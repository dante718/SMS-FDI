package GestionDeFabrica.PresentacionVista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import GestionDeFabrica.PresentacionControlador.ControladorDeFabrica;

public class VistaPrincipal extends JFrame {

	private JPanel panelPrincipal;
	
	private ControladorDeFabrica _ctrl;
	
	private JToolBar barraPrincipal;
	private JButton botonExit;
	
	private JPanel barraInferior;
	private JLabel vistaActual;
	private JLabel fechaActual;
	
	private JLabel titulo;
	private JButton botonProyecto;
	private JButton botonLaboratorio;
	private JButton botonAlmacen;
	private JButton botonInventario;
	private JButton botonEnvio;
	private JButton botonUsuario;
	
	private VistaPedidoProyecto vistaProyecto;
	private VistaPedidoLaboratorio vistaLaboratorio;
	private VistaPedidoAlmacen vistaAlmacen;
	private VistaPedidoInventario vistaInventario;
	private VistaPedidoEnvio vistaEnvio;
	private VistaPedidoUsuario vistaUsuario;
	
	public VistaPrincipal(ControladorDeFabrica controlador) {
		
		this._ctrl = controlador;
		
		vistaProyecto = new VistaPedidoProyecto(controlador);
		vistaLaboratorio = new VistaPedidoLaboratorio(controlador);
		vistaAlmacen = new VistaPedidoAlmacen(controlador);
		vistaInventario = new VistaPedidoInventario(controlador);
		vistaEnvio = new VistaPedidoEnvio(controlador);
		vistaUsuario = new VistaPedidoUsuario(controlador);
		
	}
	
	public void initGUI() {
		
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.ORANGE);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		titulo = new JLabel("FABRICA");
		titulo.setForeground(Color.BLACK);
		titulo.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		titulo.setBounds(397, 38, 246, 90);
		panelPrincipal.add(titulo);
		
		barraPrincipal = new JToolBar();
		barraPrincipal.setBounds(20, 150, 950, 50);
		barraPrincipal.setLayout(new BorderLayout());
		panelPrincipal.add(barraPrincipal);
		
		botonExit = new JButton();
		botonExit.setToolTipText("Cerrar Sesion");
		
		ImageIcon iconExit = new ImageIcon("resources/icons/gift.png");
		Image imgExit = iconExit.getImage() ;  
		Image newimgExit = imgExit.getScaledInstance( 32, 32,  java.awt.Image.SCALE_SMOOTH ) ;  
		iconExit = new ImageIcon( newimgExit );
		botonExit.setIcon(iconExit);
		
		botonExit.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame f2 = (JFrame) SwingUtilities.getWindowAncestor(VistaPrincipal.this);
				
				ImageIcon icon = new ImageIcon("resources/icons/stop_exit.png");
				Image img = icon.getImage() ;  
				Image newimg = img.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;  
				icon = new ImageIcon( newimg );
				
				int status = JOptionPane.showOptionDialog(f2,"Are sure you want to quit?",
						"Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, null, null);
				
				if (status == 0) {//si quiere salir
					
					System.exit(0);
				}
			}
		});
		barraPrincipal.addSeparator();	
		barraPrincipal.add(botonExit, BorderLayout.LINE_END);
		
		botonProyecto = new JButton("GESTION PROYECTO");
		botonProyecto.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		botonProyecto.setBackground(new Color(211,211,211));
		botonProyecto.setForeground(Color.BLACK);
		botonProyecto.setBounds(150, 250, 250, 60);
		botonProyecto.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		botonProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				_ctrl.solicitaPedidos();
				vistaProyecto.setVisible(true);
			}
		});
		panelPrincipal.add(botonProyecto);
		
		botonInventario = new JButton("GESTION INVENTARIO");
		botonInventario.addActionListener( 
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						_ctrl.solicitaPedidos();
						vistaInventario.setVisible(true);
					}
				});
		
		botonInventario.setBackground(new Color(211,211,211));
		botonInventario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		botonInventario.setBounds(150, 360, 250, 60);
		botonInventario.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		panelPrincipal.add(botonInventario);
		
		botonEnvio = new JButton("GESTION ENVIOS");
		botonEnvio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		botonEnvio.setBackground(new Color(211,211,211));
		botonEnvio.setForeground(Color.BLACK);
		botonEnvio.setBounds(150, 480, 250, 60);
		botonEnvio.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		botonEnvio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				_ctrl.solicitaPedidos();
				vistaEnvio.setVisible(true);
			}
		});
		panelPrincipal.add(botonEnvio);
		
		botonUsuario = new JButton("GESTION USUARIOS");
		botonUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		botonUsuario.setBackground(new Color(211,211,211));
		botonUsuario.setForeground(Color.BLACK);
		botonUsuario.setBounds(600, 480, 250, 60);
		botonUsuario.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		botonUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				_ctrl.loadUsuarios();
				vistaUsuario.setVisible(true);
			}
		});
		panelPrincipal.add(botonUsuario);
		
		
		botonLaboratorio = new JButton("PEDIDOS LABORATORIO");
		botonLaboratorio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		botonLaboratorio.setBackground(new Color(211,211,211));
		botonLaboratorio.setForeground(Color.BLACK);
		botonLaboratorio.setBounds(600, 250, 250, 60);
		botonLaboratorio.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		botonLaboratorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				_ctrl.solicitaPedidos();
				vistaLaboratorio.setVisible(true);
			}
		});
		panelPrincipal.add(botonLaboratorio);
		
		
		botonAlmacen = new JButton("PEDIDOS ALMACEN");
		botonAlmacen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		botonAlmacen.setBackground(new Color(211,211,211));
		botonAlmacen.setForeground(Color.BLACK);
		botonAlmacen.setBounds(600, 360, 250, 60);
		botonAlmacen.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		botonAlmacen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				_ctrl.solicitaPedidos();
				vistaAlmacen.setVisible(true);
			}
		});
		panelPrincipal.add(botonAlmacen);
		
		barraInferior = new JPanel();
		barraInferior.setBounds(20, 600, 950, 50);
		barraInferior.setLayout(new BorderLayout(0, 0));
		
		vistaActual = new JLabel("Pagina Principal");
		vistaActual.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		barraInferior.add(vistaActual, BorderLayout.WEST);
		
		fechaActual = new JLabel("Madrid, 26 de abril del 2020");
		fechaActual.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		barraInferior.add(fechaActual, BorderLayout.EAST);
		
		panelPrincipal.add(barraInferior);
		
		this.setVisible(true);
	}
}
