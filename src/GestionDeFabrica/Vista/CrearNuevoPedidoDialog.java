package GestionDeFabrica.Vista;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSeparator;

public class CrearNuevoPedidoDialog extends JDialog {
	public CrearNuevoPedidoDialog() {
		
		JLabel lblCrearNuevoPedido = new JLabel("Crear Nuevo Pedido");
		lblCrearNuevoPedido.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCrearNuevoPedido.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblCrearNuevoPedido, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(35, 14, 63, 14);
		lblIdentificador.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblIdentificador);
		
		textField = new JTextField();
		textField.setBounds(118, 11, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(244, 14, 0, 2);
		panel.add(separator);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(249, 8, 48, 14);
		panel.add(lblNewLabel);
	}

	private int _status;
	private JTextField textField;
}
