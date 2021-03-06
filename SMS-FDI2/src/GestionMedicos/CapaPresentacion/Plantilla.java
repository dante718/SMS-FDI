package GestionMedicos.CapaPresentacion;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;


import GestionMedicos.Complementos.button;
import GestionMedicos.Complementos.etiqueta;


public class Plantilla extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ControladorMed Contr;
	
	private tableModelDatosPlantilla modeloTabla;
	 private button agregar,modificar,eliminar,actualizar;
	JTable tabla;
	JTextArea usuario,fallo;
	JTextArea descripcion;
	public Plantilla(String s) {
		super(s);
		this.Contr=ControladorMed.getInstancia();
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		this.setSize(600,400);
		this.setBackground(Color.yellow);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.yellow);		
	
		this.modeloTabla=new tableModelDatosPlantilla(this.Contr);
		
		tabla=new JTable(); 
		tabla.setModel(this.modeloTabla);
		fallo=new JTextArea(1,10);
		fallo.setEditable(false);
		fallo.setVisible(false);
		descripcion=new JTextArea();
		descripcion.setEditable(false);
		descripcion.setVisible(true);
		descripcion.setText("  Agregar: Debe colocar la informacion que se le pide en el area de texto se parados con un espacio\n"
				+ "  Modificar: Debe colocar el IDENTIFICADOR seguido el nombre del parametro y el valor por el que lo va a cambiar\n"
				+ "  Eliminar: Debe colocar el IDENTIFICADOR\n");
		this.agregar=new button("agregar",12);
		this.eliminar=new button("eliminar",12);
		this.modificar=new button("modificar",12);
		this.actualizar=new button("actualizar",12);
		this.actualizar.addActionListener(this);
		this.agregar.addActionListener(this);
		this.eliminar.addActionListener(this);
		this.modificar.addActionListener(this);
		JPanel panelbotones=new JPanel();
		JPanel panelUsuario=new JPanel();
		panelUsuario.setLayout(new BorderLayout());
		panelbotones.setBackground(Color.yellow);
		panelbotones.setLayout(new FlowLayout());
		
		panelbotones.add(agregar);
		panelbotones.add(eliminar);
		panelbotones.add(modificar,FlowLayout.LEFT);
		panelbotones.add(actualizar);
	
		panelbotones.add(fallo);
		this.usuario=new JTextArea(1,100);
		panelUsuario.add(Box.createVerticalStrut(10));
		panelUsuario.add(descripcion,BorderLayout.NORTH);
		panelUsuario.add(Box.createVerticalStrut(10));
		panelUsuario.add(this.usuario,BorderLayout.SOUTH);
		this.add(new JScrollPane(tabla),BorderLayout.NORTH);
		this.add(panelUsuario,BorderLayout.AFTER_LINE_ENDS);
		this.add(panelbotones,BorderLayout.SOUTH);
		this.setBackground(Color.YELLOW);
		this.pack();
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String []aux=this.usuario.getText().split(" ");
		
		if(aux==null||aux[0].equals("")||
				aux[0].equals(" ")) {
			if(e.getSource()==this.actualizar) {
				this.modeloTabla.actualizar();
				this.modeloTabla.fireTableDataChanged();
				fallo.setText(" Tabla actualizada ");
				
			}else {
				fallo.setText(" IDENTIFICADOR NO VALIDO ");
			}	
			fallo.setVisible(true);
			}
		
		else {
			
			if(e.getSource()==this.agregar) {
				
				agregarDatos(aux);
				
				
			}
			if(e.getSource()==this.eliminar) {
				eliminarDatos(aux);
			}
			if(e.getSource()==this.modificar) {
				modificarDatos(aux);
				
			}
		}
		this.modeloTabla.actualizar();
		this.modeloTabla.fireTableDataChanged();
		
		
	}
	
	private void agregarDatos(String[] aux) {
	
		if(aux.length==5) {
		this.Contr.agregarDatos(aux[0],aux[1], Integer.parseInt(aux[2]), aux[3],Integer.parseInt(aux[4]));
		fallo.setVisible(false);
		}
		else {
			this.fallo.setText("numero de argumentos erroneo");
			fallo.setVisible(true);
		}
		

	
	}
	
	private void eliminarDatos(String[] aux) {
		
		this.fallo.setText(this.Contr.eliminarElemento(aux[0]));
		this.fallo.setVisible(true);
	
	}
	private void modificarDatos(String[] aux) {
		
		
		fallo.setText(this.Contr.modificarDatos(aux));
		fallo.setVisible(true);
	
	}
	
	

	
}
