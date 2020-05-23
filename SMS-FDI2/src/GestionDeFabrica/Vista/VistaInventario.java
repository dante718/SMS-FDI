package GestionDeFabrica.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import GestionDeFabrica.Controlador.ControladorDeFabrica;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class VistaInventario extends JFrame {

	private ControladorDeFabrica _ctrl;
	
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	
	public VistaInventario(ControladorDeFabrica ctrl) {
		
		this._ctrl = ctrl;
		//ctrl.addObserver(this);
		
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInventario = new JLabel("INVENTARIO");
		lblInventario.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblInventario.setBounds(324, 22, 258, 63);
		contentPane.add(lblInventario);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(21, 82, 866, 37);
		contentPane.add(toolBar);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 494, 866, 37);
		contentPane.add(panel);
		
		JPanel vistaInventario = createViewPanel( new JTable( new TablaInventario(_ctrl)), "Inventario");
		vistaInventario.setPreferredSize( new Dimension(500, 200));
		contentPane.add(vistaInventario);
		this.setVisible(true);
	}
	
	private JPanel createViewPanel (JComponent c, String title) {
		
		JPanel p = new JPanel( new BorderLayout() );
		p.setBounds(21, 130, 694, 353);
		
		Border borde = BorderFactory.createTitledBorder(title);
		
		p.setBorder(borde);
		
		p.add( new JScrollPane(c));
		
		return p;
	}
}
