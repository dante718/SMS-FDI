package GestionDeInformatica.GDI.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import GestionDeInformatica.GDI.Controlador.GDI_Controlador;
import GestionDeInformatica.GDI.Modelo.DaoEmpleados;
import GestionDeInformatica.GDI.Modelo.DaoPlantillas;
import GestionDeInformatica.GDI.Modelo.TransferEmpleados;
import GestionDeInformatica.GDI.Modelo.TransferPlantilla;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JMenuBar;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GDI_VistaListaEstudios extends JFrame {

	private JPanel contentPane;
	public boolean mod;
	public int fila=-1;
	public ArrayList<TransferPlantilla> arrayPlantillas = new ArrayList<TransferPlantilla>();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDI_VistaListaEstudios frame = new GDI_VistaListaEstudios();
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
	public GDI_VistaListaEstudios() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 181));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 228, 225));
		desktopPane.setBounds(20, 36, 447, 411);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);
		
		
		
		
		JButton btnNuevoEstudio = new JButton("NUEVO");
		btnNuevoEstudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mod = false;
				TransferPlantilla plan = new TransferPlantilla("","","");
				dispose();
				GDI_Controlador.getInstancia().pantalla5(mod, plan,-1,arrayPlantillas);
			}
		});
		btnNuevoEstudio.setBounds(10, 377, 95, 23);
		desktopPane.add(btnNuevoEstudio);
		
		JButton btnBack = new JButton("ATRAS");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				GDI_Controlador.getInstancia().pantalla1();
				
			}
		});
		btnBack.setBounds(348, 377, 89, 23);
		desktopPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 33, 376, 236);
		desktopPane.add(scrollPane);
		
		// creo la tabla con los estudios
		// En el object celdas hay ....size() -1       -1     y en el for tambien
		
		
		
		
		//DaoPlantillas DAO = new DaoPlantillas();
		arrayPlantillas = GDI_Controlador.getInstancia().leerListaEstudios(arrayPlantillas);
				
		
		Object titulos []={"ID", "NOMBRE","ETAPA",};
		Object celdas [][]=new Object[arrayPlantillas.size()-1][3];
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table_1 = new JTable(celdas, titulos);
		
		
		table_1.addMouseListener(new MouseAdapter() {
			
			@Override
			///////////////////////////////////////////////////////////////////////////////////lectura de la fila
			public void mouseClicked(MouseEvent arg0) {

				int filaSeleccionada = table_1.rowAtPoint(arg0.getPoint());
				//System.out.println(table_1.getValueAt(filaSeleccionada,0).toString());
				//System.out.println(filaSeleccionada);
				fila=filaSeleccionada;
			}
		});
		
		for(int j=0;j<arrayPlantillas.size()-1;j++) {
			
			celdas[j][0] = arrayPlantillas.get(j).getID();
			celdas[j][1] = arrayPlantillas.get(j).getNOM();
			celdas[j][2] = arrayPlantillas.get(j).getETA();


			}
		
		
		scrollPane.setViewportView(table_1);
		
		JButton btnDelete = new JButton("ELIMINAR");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(fila>-1) {
					
					GDI_Controlador.getInstancia().eliminarEstudio(arrayPlantillas, fila);
					
					dispose();
					GDI_Controlador.getInstancia().pantalla2();
				}  
				
				
			}
		});
		btnDelete.setBounds(249, 377, 89, 23);
		desktopPane.add(btnDelete);
		
		JButton btnNewModificar = new JButton("MODIFICAR");
		btnNewModificar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(fila!=-1) {TransferPlantilla est = new TransferPlantilla(arrayPlantillas.get(fila).getID(),arrayPlantillas.get(fila).getNOM(),arrayPlantillas.get(fila).getETA());
				
				mod=true;
				dispose();
				GDI_Controlador.getInstancia().pantalla5(mod,est,fila,arrayPlantillas);}
			}
		});
		btnNewModificar.setBounds(115, 377, 122, 23);
		desktopPane.add(btnNewModificar);
		
		
		
		
		
		
		
		JLabel lblLogo = new JLabel("Informatico");
		lblLogo.setBounds(412, 11, 72, 14);
		contentPane.add(lblLogo);
	}
}
