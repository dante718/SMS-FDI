package GestionDeEnvios.GDE.Vista;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;


public class frmListadoEnvio extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmListadoEnvio frame = new frmListadoEnvio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmListadoEnvio() {
		java.util.Date fecha = new Date();
		System.out.println (fecha);
		setTitle("Listado de Env\u00EDos");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 651, 416);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listado de Env\u00EDos");
		lblNewLabel.setForeground(new Color(102, 102, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(178, 30, 232, 32);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 102));
		panel.setBackground(new Color(255, 255, 153));
		panel.setBounds(10, 114, 493, 115);
		contentPane.add(panel);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(255, 255, 153));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID: AAAA", "Para: \"Hospital X\"", "Estado: Entregado", "Asignado a : Pepito Campos"},
				{"ID: BBBB", "Para: \"Almac\u00E9n\"", "Estado: Enviado", "Asignado a : Sutanito Perez"},
				{"ID: CCCC", "Para: \"Famaceutico A\"", "Estado: Entregado", "Asignado a : Pedro Jackson"},
				{"ID: DDDD", "Para: \"Hospital Y\"", "Estado: Enviado", "Asignado a : Pedrito Cano"},
				{"ID: EEEE", "Para: \"Hospital Z\"", "Estado: Entregado", "Asignadoa : Menganito Pe\u00F1a"},
			},
			new String[] {
				"ID", "Para", "Estado", "Asignado"
			}
		));
		table_1.getColumnModel().getColumn(0).setMinWidth(33);
		table_1.getColumnModel().getColumn(0).setMaxWidth(2147483643);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(135);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(103);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(162);
		table_1.getColumnModel().getColumn(3).setMinWidth(17);
		panel.add(table_1);
		
		JButton btnNewButton = new JButton("Fecha: 11/04/19");
		btnNewButton.setBackground(new Color(153, 153, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(492, 114, 133, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modificar Env\u00EDo");
		btnNewButton_1.setBackground(new Color(153, 153, 153));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              frmModificarEnvio verventana = new frmModificarEnvio();
				
				verventana.show();
			}
		});
		btnNewButton_1.setBounds(492, 131, 133, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Fecha: 11/01/19");
		btnNewButton_2.setBackground(new Color(153, 153, 153));
		btnNewButton_2.setBounds(492, 148, 133, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Modificar Env\u00EDo");
		btnNewButton_3.setBackground(new Color(153, 153, 153));
		btnNewButton_3.setBounds(492, 165, 133, 23);
		contentPane.add(btnNewButton_3);
		frmModificarEnvio verventana = new frmModificarEnvio();
		verventana.show();
		
		JButton btnNewButton_4 = new JButton("Fecha: 09/09/19");
		btnNewButton_4.setBackground(new Color(153, 153, 153));
		btnNewButton_4.setBounds(492, 185, 133, 23);
		contentPane.add(btnNewButton_4);
		
	
	}

	
}
