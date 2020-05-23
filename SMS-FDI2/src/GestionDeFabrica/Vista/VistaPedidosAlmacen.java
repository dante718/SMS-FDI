package GestionDeFabrica.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import GestionDeFabrica.Controlador.ControladorDeFabrica;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class VistaPedidosAlmacen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private ControladorDeFabrica _ctrl;
	
	public VistaPedidosAlmacen() {
		
		setTitle("Gestoria de Fabrica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 600);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPedidosAlmacen = new JLabel("Pedidos Almacen");
		lblPedidosAlmacen.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblPedidosAlmacen.setBounds(300, 30, 318, 47);
		contentPane.add(lblPedidosAlmacen);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(20, 88, 860, 35);
		contentPane.add(toolBar);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setOrientation(SwingConstants.VERTICAL);
		toolBar_1.setBounds(824, 147, 56, 357);
		contentPane.add(toolBar_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 515, 844, 35);
		contentPane.add(panel);
		
		JPanel vistaPedidosAlmacen = createViewPanel( new JTable( new TablaPedidosAlmacen(_ctrl)), "Inventario");
		vistaPedidosAlmacen.setPreferredSize( new Dimension(500, 200));
		contentPane.add(vistaPedidosAlmacen);
		
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
