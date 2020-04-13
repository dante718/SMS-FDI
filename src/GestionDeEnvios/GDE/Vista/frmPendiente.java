package GestionDeEnvios.GDE.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frmPendiente extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtPara;
	private JTextField txtEstadoDeEnvio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPendiente frame = new frmPendiente();
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
	public frmPendiente() {
		setTitle("Pendientes");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 651, 416);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pendientes");
		lblNewLabel.setForeground(new Color(102, 102, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(217, 33, 196, 31);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Para", "Estado"
			}
		));
		table.setBounds(12, 143, 376, 64);
		contentPane.add(table);
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(400, 144, 90, 13);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Aceptar");
		btnNewButton_1_1.setBounds(400, 162, 90, 13);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Aceptar");
		btnNewButton_1_2.setBounds(400, 194, 90, 13);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Aceptar");
		btnNewButton_1_2_1.setBounds(400, 179, 90, 13);
		contentPane.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2_2 = new JButton("Rechazar");
		btnNewButton_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_2_2.setBounds(495, 144, 105, 13);
		contentPane.add(btnNewButton_1_2_2);
		
		JButton btnNewButton_1_2_3 = new JButton("Rechazar");
		btnNewButton_1_2_3.setBounds(495, 162, 105, 13);
		contentPane.add(btnNewButton_1_2_3);
		
		JButton btnNewButton_1_2_4 = new JButton("Rechazar");
		btnNewButton_1_2_4.setBounds(495, 194, 105, 13);
		contentPane.add(btnNewButton_1_2_4);
		
		JButton btnNewButton_1_2_5 = new JButton("Rechazar");
		btnNewButton_1_2_5.setBounds(495, 179, 105, 13);
		contentPane.add(btnNewButton_1_2_5);
		
		txtPara = new JTextField();
		txtPara.setHorizontalAlignment(SwingConstants.CENTER);
		txtPara.setText("Para");
		txtPara.setBounds(43, 112, 114, 19);
		contentPane.add(txtPara);
		txtPara.setColumns(10);
		
		txtEstadoDeEnvio = new JTextField();
		txtEstadoDeEnvio.setHorizontalAlignment(SwingConstants.CENTER);
		txtEstadoDeEnvio.setText("Estado de Envio");
		txtEstadoDeEnvio.setBounds(231, 112, 114, 19);
		contentPane.add(txtEstadoDeEnvio);
		txtEstadoDeEnvio.setColumns(10);
	}
}
