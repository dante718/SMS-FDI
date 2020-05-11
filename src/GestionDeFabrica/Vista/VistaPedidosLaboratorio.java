package GestionDeFabrica.Vista;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import GestionDeFabrica.Controlador.ControladorDeFabrica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class VistaPedidosLaboratorio extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private ControladorDeFabrica _ctrl;
	
	public VistaPedidosLaboratorio() {
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 600);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPedidosLaboratorio = new JLabel("Pedidos Laboratorio");
		lblPedidosLaboratorio.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblPedidosLaboratorio.setBounds(300, 11, 353, 79);
		contentPane.add(lblPedidosLaboratorio);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(21, 82, 867, 34);
		contentPane.add(toolBar);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setOrientation(SwingConstants.VERTICAL);
		toolBar_1.setBounds(834, 125, 54, 324);
		contentPane.add(toolBar_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 516, 867, 34);
		contentPane.add(panel);
		
		JPanel vistaPedidosLaboratorio = createViewPanel( new JTable( new TablaPedidosAlmacen(_ctrl)), "Inventario");
		vistaPedidosLaboratorio.setPreferredSize( new Dimension(500, 200));
		contentPane.add(vistaPedidosLaboratorio);
		
		this.setVisible(true);
	}
	
	private JPanel createViewPanel (JComponent c, String title) {
		
		JPanel p = new JPanel( new BorderLayout() );
		p.setBounds(43, 127, 769, 375);
		
		Border borde = BorderFactory.createTitledBorder(title);
		
		p.setBorder(borde);
		
		p.add( new JScrollPane(c));
		
		return p;
	}
}
