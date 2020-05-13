package GestionDeFabrica.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToolBar;

public class VistaFarmacos extends JFrame {

	private ControladorDeFabrica _ctrl;
	
	private JPanel contentPane;
	
	public VistaFarmacos(ControladorDeFabrica ctrl) {
		
		_ctrl = ctrl;
		
		//ctrl.addObserver(this);
		
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel vistaFarmaco = createViewPanel( new JTable( new TablaFarmacos(_ctrl)), "Farmacos");
		vistaFarmaco.setPreferredSize( new Dimension(500, 200));
		contentPane.add(vistaFarmaco);
		
		JLabel lblFarmacos = new JLabel("FARMACOS");
		lblFarmacos.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblFarmacos.setBounds(349, 22, 235, 39);
		contentPane.add(lblFarmacos);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 80, 893, 39);
		contentPane.add(toolBar);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 501, 893, 39);
		contentPane.add(panel);
		
		this.setVisible(true);
	}
	
	private JPanel createViewPanel (JComponent c, String title) {
		
		JPanel p = new JPanel( new BorderLayout() );
		p.setBounds(63, 130, 694, 353);
		
		Border borde = BorderFactory.createTitledBorder(title);
		
		p.setBorder(borde);
		
		p.add( new JScrollPane(c));
		
		return p;
	}
}
