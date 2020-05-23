package GestionDeInformatica.GDI.Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GestionDeInformatica.GDI.Controlador.GDI_Controlador;
import GestionDeInformatica.GDI.Modelo.TransferError;

import javax.swing.border.BevelBorder;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GDI_VistaListaErrores extends JFrame {

	private JPanel contentPane;
	public int fila=-1;
	public ArrayList<TransferError> arrayErrores = new ArrayList<TransferError>();
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GDI_VistaListaErrores frame = new GDI_VistaListaErrores();
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
	public GDI_VistaListaErrores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 54, 424, 354);
		contentPane.add(scrollPane);
		
		
		
		
		GDI_Controlador.getInstancia().leerListaErrores(arrayErrores);
		Object titulos []={"INFORMES"};
		Object celdas [][]=new Object[arrayErrores.size()][1];
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
		for(int j=0;j<arrayErrores.size();j++) {
			
			celdas[j][0] = arrayErrores.get(j).getE();

			}
			
			scrollPane.setViewportView(table_1);
		
			
			
		JLabel lblLogo = new JLabel("Informatico");
		lblLogo.setBounds(388, 11, 72, 14);
		contentPane.add(lblLogo);
		
		JButton btnBack = new JButton("ATRAS");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GDI_Controlador.getInstancia().pantalla1();
			}
		});
		btnBack.setBounds(362, 427, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fila>-1) {
					GDI_Controlador.getInstancia().eliminarError(arrayErrores, fila);	
					dispose();
					GDI_Controlador.getInstancia().pantalla4();
					}
			}
		});
		btnEliminar.setBounds(42, 427, 89, 23);
		contentPane.add(btnEliminar);
	}
}
