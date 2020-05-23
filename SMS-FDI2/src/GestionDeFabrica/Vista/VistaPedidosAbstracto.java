package GestionDeFabrica.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import GestionDeFabrica.Modelo.FabricaObservadora;

public abstract class VistaPedidosAbstracto extends JFrame implements FabricaObservadora{

	protected ControladorDeFabrica controlador;
	protected JPanel contentPane;
	
	protected JLabel labelTitulo;
	protected String titulo;
	
	protected JToolBar barraPrincipal;
	protected JToolBar barraLateral;
	
	protected JPanel barraInferior;
	protected JLabel labelPagina;
	
	protected JButton botonHome;
	protected JButton botonAtras;
	protected JButton botonExit;
	protected JButton botonAceptar;
	protected JButton botonEditar;
	protected JButton botonEliminar;
	
	protected String textoBotonAceptar;
	protected String textoBotonEliminar;
	
	protected TableModel tabla;
	protected Border borde;
	
	public VistaPedidosAbstracto(ControladorDeFabrica controlador) {
		
		super("Gestoria De Fabrica");
		this.controlador = controlador;
		//this.controlador.addObserver(this);
		//this.initGUI();
	}
	
	protected void initGUI() {
		
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelTitulo = new JLabel(titulo);
		labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		labelTitulo.setBounds(300, 10, 600, 79);
		contentPane.add(labelTitulo);
		
		barraPrincipal = new JToolBar();
		barraPrincipal.setBounds(20, 80, 950, 50);
		
		//Botones Barra Principal
		botonHome = new JButton();
		botonHome.setToolTipText("Regresa a la pantalla principal");
		//TODO
		ImageIcon iconHome = new ImageIcon("resources/icons/home_button.png");
		Image img = iconHome.getImage() ;  
		Image newimg = img.getScaledInstance( 32, 32,  java.awt.Image.SCALE_SMOOTH ) ;  
		iconHome = new ImageIcon( newimg );
		botonHome.setIcon(iconHome);
		
		botonHome.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				setVisible(false);
			}
		});
		
		botonAtras = new JButton();
		botonAtras.setToolTipText("Ir a la pagina de atras");
		
		ImageIcon iconAtras = new ImageIcon("resources/icons/atras_button.png");
		Image imgAtras = iconAtras.getImage() ;  
		Image newimgAtras = imgAtras.getScaledInstance( 32, 32,  java.awt.Image.SCALE_SMOOTH ) ;  
		iconAtras = new ImageIcon( newimgAtras );
		botonAtras.setIcon(iconAtras);
		
		botonAtras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				VistaPedidosAbstracto.this.setVisible(false);
			}
		});
		
		botonExit = new JButton();
		botonExit.setToolTipText("Salir de la aplicacion");
		
		ImageIcon iconExit = new ImageIcon("resources/icons/gift.png");
		Image imgExit = iconExit.getImage() ;  
		Image newimgExit = imgExit.getScaledInstance( 32, 32,  java.awt.Image.SCALE_SMOOTH ) ;  
		iconExit = new ImageIcon( newimgExit );
		botonExit.setIcon(iconExit);
		
		botonExit.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame f2 = (JFrame) SwingUtilities.getWindowAncestor(VistaPedidosAbstracto.this);
				
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
		
		barraPrincipal.add(botonHome);
		barraPrincipal.add(botonAtras);
		barraPrincipal.addSeparator();
		barraPrincipal.add(Box.createGlue());
		barraPrincipal.add(botonExit);
		
		contentPane.add(barraPrincipal);
		
		
		//Barra Lateral
		barraLateral = new JToolBar();
		barraLateral.setOrientation(SwingConstants.VERTICAL);
		barraLateral.setBounds(920, 150, 50, 200);
		
		botonAceptar = new JButton();
		botonAceptar.setToolTipText(textoBotonAceptar);
		
		ImageIcon iconAceptar = new ImageIcon("resources/icons/aceptar_button.png");
		Image imgAceptar = iconAceptar.getImage() ;  
		Image newimgAceptar = imgAceptar.getScaledInstance( 32, 32,  java.awt.Image.SCALE_SMOOTH ) ;  
		iconAceptar = new ImageIcon( newimgAceptar );
		botonAceptar.setIcon(iconAceptar);
		
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				accionAceptar();
			}
			
		});
		
		botonEditar = new JButton();
		botonEditar.setToolTipText("Editar");
		ImageIcon iconEditar = new ImageIcon("resources/icons/editar_button.png");
		Image imgEditar = iconEditar.getImage() ;  
		Image newimgEditar = imgEditar.getScaledInstance( 32, 32,  java.awt.Image.SCALE_SMOOTH ) ;  
		iconEditar = new ImageIcon( newimgEditar );
		botonEditar.setIcon(iconEditar);
		
		botonEditar.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				accionModifica();
			}
		});
		
		botonEliminar = new JButton();
		botonEliminar.setToolTipText(textoBotonEliminar);
		
		ImageIcon iconEliminar = new ImageIcon("resources/icons/eliminar_button.png");
		Image imgEliminar = iconEliminar.getImage() ;  
		Image newimgEliminar = imgEliminar.getScaledInstance( 32, 32,  java.awt.Image.SCALE_SMOOTH ) ;  
		iconEliminar = new ImageIcon( newimgEliminar );
		botonEliminar.setIcon(iconEliminar);
		
		botonEliminar.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				accionElimina();
			}
		});
		
		barraLateral.add(botonAceptar);
		barraLateral.add(botonEditar);
		barraLateral.add(botonEliminar);
		
		contentPane.add(barraLateral);
		
		//JPanel de abajo
		barraInferior = new JPanel();
		barraInferior.setBounds(20, 650, 950, 50);
		barraInferior.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		labelPagina = new JLabel(this.titulo);
		labelPagina.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		barraInferior.add(labelPagina);
		//TODO agregar la fecha
		contentPane.add(barraInferior);
		
		JPanel vistaTabla = this.createViewPanel( new JTable( tabla), this.titulo);
		vistaTabla.setPreferredSize( new Dimension(500, 200));
		contentPane.add(vistaTabla);
		
		this.setVisible(false);
	}
	
	protected abstract void accionAceptar();
	protected abstract void accionElimina();
	
	protected JPanel createViewPanel (JComponent c, String title) {
		
		JPanel p = new JPanel( new BorderLayout() );
		p.setBounds(40, 150, 850, 460);
		
		Border borde = BorderFactory.createTitledBorder(title);
		
		p.setBorder(borde);
		
		c.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		p.add( new JScrollPane(c));
		
		return p;
	}
	
	protected abstract void accionModifica();
}
