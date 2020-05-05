package GestionProyectos.GDP.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import GestionProyectos.GDP.Controlador.Controlador;
import GestionProyectos.GDP.Modelo.ModeloTablaPersona;
import GestionProyectos.GDP.Modelo.TPersona;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;


@SuppressWarnings("serial")
public class VistaAddInvestigador extends JFrame{
	 private static VistaAddInvestigador instancia=null;
	 private ModeloTablaPersona modelo;
	 private JTable tabla;
	 private int contador;
	 private JPanel panel= new JPanel();
     private VistaAddInvestigador() {
    	 TableModel modelo=new ModeloTablaPersona();
 		 modelo=Controlador.getInstancia().creartablaPersonas("Investigador");
    	 contador=VistaCrearProyecto.getInstancia().getParticipantes().size();
    	 this.modelo=(ModeloTablaPersona) modelo;
    	 this.tabla= new JTable(this.modelo);
    	 initVista();
     }
     public static VistaAddInvestigador getInstancia() {
    	 if(instancia==null) {
    		 instancia= new VistaAddInvestigador();
    	 }
    	 return instancia;
     }
     
	private void initVista() {
		setTitle("Investigadores Disponibles");
		setSize(500,300);
		panel.setLayout(new BorderLayout());
		JLabel eti=new JLabel("Investigadores:");
		eti.setFont(new Font("arial", 1, 12));
		panel.add(eti, BorderLayout.NORTH);
		panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
	    JPanel botones = new JPanel();
		JButton boton1 = new JButton("Aceptar");
		boton1.setFont(new Font("arial", 3, 10));
		boton1.setForeground(Color.white);
		boton1.setBackground(Color.green);
		boton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				if(addPersona()) {
					cerrar();
				}				    
			}
			
		});
		botones.add(boton1);	
		JButton boton2 = new JButton("Cancelar");
		boton2.setFont(new Font("arial", 3, 10));
		boton2.setForeground(Color.white);
		boton2.setBackground(Color.red);
		boton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				    cerrar();
			}
			
		});
		botones.add(boton2);
		panel.add(botones, BorderLayout.SOUTH);
		getContentPane().add(panel);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
  
    public void cerrar() {
    	dispose();
    }
    public boolean addPersona() {
    	String Estado=(String) tabla.getValueAt(tabla.getSelectedRow(), 5);
    	if(Estado.toLowerCase().equals("disponible")) {
    		int i=0;
        	String DNI=(String) tabla.getValueAt(tabla.getSelectedRow(), 0);
        	boolean find=false;
        	while(i<modelo.getPersonas().size() && !find) {
        		if(DNI.equals(modelo.getPersonas().get(i).getDNI())) {
        			find=true;
        			VistaCrearProyecto.getInstancia().addPersona(new TPersona(modelo.getPersonas().get(i).getDNI(),modelo.getPersonas().get(i).getNombre(), modelo.getPersonas().get(i).getApellido1(),modelo.getPersonas().get(i).getApellido2(), modelo.getPersonas().get(i).getProfesion(), modelo.getPersonas().get(i).getEstado(), modelo.getPersonas().get(i).getRol()));
        			modelo.getPersonas().remove(i);
        			modelo.fireTableDataChanged();
        		}
        		i++;
        	}
        	return true;
    	}
    	else {
    		JOptionPane.showMessageDialog(null, "Persona no disponible ya está en otro proyecto.");
    		return false;
    	}
    }
    
}
