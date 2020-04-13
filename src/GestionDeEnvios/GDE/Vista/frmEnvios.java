package GestionDeEnvios.GDE.Vista;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmEnvios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmEnvios frame = new frmEnvios();
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
	public frmEnvios() {
		setTitle("Env\u00EDos");
		setBackground(new Color(255, 255, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 416);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Listado de Env\u00EDos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmListadoEnvio verventana = new frmListadoEnvio();
				
				verventana.show();
			}
		});
		btnNewButton.setBackground(new Color(102, 102, 102));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(63, 89, 159, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Crear Envio");
		btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frmCrearEnvio verventana = new frmCrearEnvio();
			
			verventana.show();
		}
	});
		btnNewButton_1.setBackground(new Color(102, 102, 102));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(63, 171, 159, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Status Envio");
		btnNewButton_2.setBackground(new Color(102, 102, 102));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(315, 89, 251, 39);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Env\u00EDos");
		lblNewLabel.setForeground(new Color(102, 102, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(237, 30, 98, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Modificar Envio");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmModificarEnvio verventana = new frmModificarEnvio();
				
				verventana.show();
			}
		});
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(102, 102, 102));
		btnNewButton_3.setBounds(315, 171, 251, 39);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Rechazados");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(102, 102, 102));
		btnNewButton_4.setBounds(63, 253, 159, 31);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Pendientes");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(102, 102, 102));
        btnNewButton_5.setBounds(309, 253, 257, 31);
        contentPane.add(btnNewButton_5);
        
    
	}
}
