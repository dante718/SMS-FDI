package GestionDeInformatica.GDI.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import GestionDeInformatica.GDI.Controlador.GDI_Controlador;
import GestionDeInformatica.GDI.Modelo.TransferEmpleados;
import GestionDeInformatica.GDI.Modelo.TransferPlantilla;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.DropMode;

public class GDI_VistaNuevoEstudio extends JFrame {

	private JPanel contentPane;
	private JTextField textNewNombre;
	private JTextField textNewId;
	private JTextField textNewEtapa;
	private JTextField textNewParametro;
	private JTextField textString1;
	private JTextField textString2;
	private JTextField textInt3;
	private JTextField textString4;
	private JTextField textInt5;
	public String I,N,E;
	public ArrayList<String> parametros = new  ArrayList<String>();
	public String nuevaVariable;
	boolean nuevo=false;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDI_VistaNuevoEstudio frame = new GDI_VistaNuevoEstudio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public GDI_VistaNuevoEstudio(boolean modificacion, TransferPlantilla estudio, int fila,ArrayList<TransferPlantilla> arrayPlantillas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 222, 173));
		desktopPane.setBounds(0, 0, 684, 461);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(162, 75, 327, 375);
		desktopPane_1.setBackground(new Color(255, 255, 224));
		desktopPane.add(desktopPane_1);
		
		String p1 = "";
		String p2 = "";
		String p3 = "";
		String p4 = "";
		String p5 = "";
		
		if(modificacion == true) {
			 ArrayList<String> variables = new  ArrayList<String>();
			 
			variables=GDI_Controlador.getInstancia().leerPlantilla(estudio.getID(),estudio.getNOM(),estudio.getETA(), variables);
			
			p1=variables.get(0);
			p2=variables.get(1);
			p3=variables.get(2);
			p4=variables.get(3);
			p5=variables.get(4);

		}
		
		
		textString1 = new JTextField();
		textString1.setText(p1);
		textString1.setBounds(89, 47, 113, 20);
		desktopPane_1.add(textString1);
		textString1.setColumns(10);
		
		textString2 = new JTextField();
		textString2.setText(p2);
		textString2.setBounds(89, 100, 113, 20);
		desktopPane_1.add(textString2);
		textString2.setColumns(10);
		
		textInt3 = new JTextField();
		textInt3.setText(p3);
		textInt3.setBounds(89, 158, 113, 20);
		desktopPane_1.add(textInt3);
		textInt3.setColumns(10);
		
		textString4 = new JTextField();
		textString4.setText(p4);
		textString4.setBounds(89, 213, 113, 20);
		desktopPane_1.add(textString4);
		textString4.setColumns(10);
		
		textInt5 = new JTextField();
		textInt5.setText(p5);
		textInt5.setBounds(89, 268, 113, 20);
		desktopPane_1.add(textInt5);
		textInt5.setColumns(10);
		
		 
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("STRING");
		lblNewLabel_1.setBounds(20, 50, 46, 14);
		desktopPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("STRING");
		lblNewLabel_2.setBounds(20, 103, 46, 14);
		desktopPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("INT");
		lblNewLabel_3.setBounds(20, 161, 46, 14);
		desktopPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("STRING");
		lblNewLabel_4.setBounds(20, 216, 46, 14);
		desktopPane_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("INT");
		lblNewLabel_5.setBounds(20, 271, 46, 14);
		desktopPane_1.add(lblNewLabel_5);
		
		
		
		JLabel lblNombreEstudio = new JLabel("Nombre del Estudio: ");
		lblNombreEstudio.setBounds(236, 4, 136, 25);
		lblNombreEstudio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		desktopPane.add(lblNombreEstudio);
		
		
		
		JLabel lblLogo = new JLabel("Informatico");
		lblLogo.setBounds(602, 11, 72, 14);
		desktopPane.add(lblLogo);
		
		
		
		textNewParametro =new JTextField();
		textNewParametro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textNewParametro.setBounds(26, 262, 113, 25);
		desktopPane.add(textNewParametro);
		textNewParametro.setColumns(10);
		
		
		
		
		
		
		
				
		JButton btnNewParametro = new JButton("A\u00F1adir Parametro");
		btnNewParametro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewParametro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nuevaVariable = textNewParametro.getText();
				
				nuevo=true;
			}
		});
		
		btnNewParametro.setBounds(16, 197, 136, 48);
		desktopPane.add(btnNewParametro);
		
		
		
		
		
		
		JButton btnSave = new JButton("GUARDAR");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				String id = textNewId.getText();
				String nombre = textNewNombre.getText();
				String etapa = textNewEtapa.getText();
				
				
				String s1 = textString1.getText();
				String s2 = textString2.getText();
				String i3 = textInt3.getText();
				String s4 = textString4.getText();
				String i5 = textInt5.getText();
				
				parametros.add(s1);
				parametros.add(s2);
				parametros.add(i3);
				parametros.add(s4);
				parametros.add(i5);
				if(nuevo==true)parametros.add(nuevaVariable);
				
				
				
				//DaoEmpleados DAO = new DaoEmpleados();
				TransferPlantilla plantilla = new TransferPlantilla(id,nombre,etapa);
				if(modificacion == true)GDI_Controlador.getInstancia().eliminarEstudio(arrayPlantillas, fila);
				GDI_Controlador.getInstancia().anadirEstudio(plantilla);
				GDI_Controlador.getInstancia().anadirPlantilla(id,nombre,etapa,parametros);
				dispose();
				GDI_Controlador.getInstancia().pantalla6(id);
			}
		});
		btnSave.setBounds(16, 414, 136, 23);
		desktopPane.add(btnSave);
		
		if(modificacion==true) {
			I=estudio.getID();
			N=estudio.getNOM();
			E=estudio.getETA();
			
		}else {
			I="";
			N="";
			E="";
		}
	
		
		JLabel lblNewLabel = new JLabel("Identificador:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 11, 95, 18);
		desktopPane.add(lblNewLabel);
		
		textNewId = new JTextField();
		textNewId.setText(I);
		textNewId.setBounds(16, 42, 136, 22);
		desktopPane.add(textNewId);
		textNewId.setColumns(10);
		
		JLabel lblNewEtapa = new JLabel("Etapa:");
		lblNewEtapa.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewEtapa.setBounds(466, 7, 126, 18);
		desktopPane.add(lblNewEtapa);
		
		textNewEtapa = new JTextField();
		textNewEtapa.setText(E);
		textNewEtapa.setBounds(436, 39, 172, 25);
		desktopPane.add(textNewEtapa);
		textNewEtapa.setColumns(10);
		
		
		
		textNewNombre = new JTextField();
		textNewNombre.setText(N);
		textNewNombre.setBounds(203, 39, 196, 25);
		textNewNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		desktopPane.add(textNewNombre);
		textNewNombre.setColumns(10);
		}
}
