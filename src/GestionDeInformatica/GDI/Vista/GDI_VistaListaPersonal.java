package GestionDeInformatica.GDI.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GestionDeInformatica.GDI.Controlador.GDI_Controlador;
import GestionDeInformatica.GDI.Modelo.DaoEmpleados;
import GestionDeInformatica.GDI.Modelo.DaoPlantillas;
import GestionDeInformatica.GDI.Modelo.TransferEmpleados;
import GestionDeInformatica.GDI.Modelo.TransferPlantilla;

import javax.swing.border.BevelBorder;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GDI_VistaListaPersonal extends JFrame {

	public JPanel contentPane;
	public int fila=-1;
	public ArrayList<TransferEmpleados> arrayPersonas = new ArrayList<TransferEmpleados>();
	/**
	 * Launch the application.

	 */
	
	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDI_VistaListaPersonal frame = new GDI_VistaListaPersonal();
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
	

	

	
	
	public GDI_VistaListaPersonal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 54, 424, 271);
		contentPane.add(scrollPane);
		
		
	//AQUI LLAMO EN EL DAO EMPLEADOS A LEER EL FICHERO
	
//ArrayList<TransferEmpleados> arrayPersonas = new ArrayList<TransferEmpleados>();
		
		arrayPersonas = GDI_Controlador.getInstancia().leerListaEmpleados(arrayPersonas);	
		
		Object titulos []={"DNI", "NOMBRE","APELLIDO 1","APELLIDO 2", "PUESTO"};
		Object celdas [][]=new Object[arrayPersonas.size()][5];
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table_1 = new JTable(celdas, titulos);
		
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			///////////////////////////////////////////////////////////////////////////////////lectura de la fila
			public void mouseClicked(MouseEvent arg0) {

				int filaSeleccionada = table_1.rowAtPoint(arg0.getPoint());
				//System.out.println(table_1.getValueAt(filaSeleccionada,0).toString());
				//System.out.println(filaSeleccionada );
				fila=filaSeleccionada;
			}
		});
		
		for(int j=0;j<arrayPersonas.size();j++) {
		
		celdas[j][0] = arrayPersonas.get(j).getDni();
		celdas[j][1] = arrayPersonas.get(j).getName();
		celdas[j][2] = arrayPersonas.get(j).getAp1();
		celdas[j][3] = arrayPersonas.get(j).getAp2();
		celdas[j][4] = arrayPersonas.get(j).getProf();
		

		}
		
		scrollPane.setViewportView(table_1);
		
	
		JLabel lblLogo = new JLabel("Informatico");
		lblLogo.setBounds(402, 11, 72, 14);
		contentPane.add(lblLogo);
		
		JButton btnGuardar = new JButton("ATRAS");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GDI_Controlador.getInstancia().pantalla1();
			}
		});
		btnGuardar.setBounds(10, 416, 105, 23);
		contentPane.add(btnGuardar);
		
		JButton btnNewPersona = new JButton("NUEVO");
		btnNewPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				
				dispose();
				GDI_Controlador.getInstancia().pantalla7();
			}
		});
		btnNewPersona.setBounds(125, 416, 89, 23);
		contentPane.add(btnNewPersona);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			
			
			
			public void actionPerformed(ActionEvent e) {
				
				if(fila>-1) {
					GDI_Controlador.getInstancia().eliminarEmpleado(arrayPersonas, fila);	
					dispose();
					GDI_Controlador.getInstancia().pantalla3();
					}
				
				}
				
			
		});
		btnEliminar.setBounds(367, 416, 89, 23);
		contentPane.add(btnEliminar);

		}
		
		
	}
