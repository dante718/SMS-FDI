package GestionDeEnvios.GDE.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class frmCrearEnvio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCrearEnvio frame = new frmCrearEnvio();
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
	public frmCrearEnvio() {
		setType(Type.UTILITY);
		setTitle("Crear Envio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 153));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblIdPedido = new JLabel("ID Pedido");
		lblIdPedido.setBounds(12, 52, 81, 15);
		panel.add(lblIdPedido);
		
		JLabel lblIdEnvio = new JLabel("ID Envio");
		lblIdEnvio.setBounds(12, 79, 70, 15);
		panel.add(lblIdEnvio);
		
		JLabel lblDestinatario = new JLabel("Destinatario");
		lblDestinatario.setBounds(12, 106, 100, 23);
		panel.add(lblDestinatario);
		
		JLabel lblEstadoDeEnvio = new JLabel("Estado de Envio");
		lblEstadoDeEnvio.setBounds(12, 141, 127, 15);
		panel.add(lblEstadoDeEnvio);
		
		textField = new JTextField();
		textField.setBounds(96, 50, 114, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 77, 114, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 139, 114, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(120, 108, 114, 19);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(309, 222, 117, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crear Envio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(173, 222, 117, 25);
		panel.add(btnNewButton_1);
	}
}
