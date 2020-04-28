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

import GestionProyectos.GDP.Modelo.GDP_ModeloTabla;
import GestionProyectos.GDP.Modelo.GDP_TPersona;
import GestionProyectos.GDP.Modelo.GDP_TableModel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;


@SuppressWarnings("serial")
public class GDP_VistaAddInvestigador extends JFrame{
	 private GDP_ModeloTabla tabla;
	 private JTable table;
	 private int contador;
	 private JPanel panel= new JPanel();
	 private GDP_VistaCrearProyecto vp;
     public GDP_VistaAddInvestigador(GDP_ModeloTabla tabla, GDP_VistaCrearProyecto vp) {
    	 this.vp=vp;
    	 contador=vp.getParticipantes().size();
    	 this.tabla=tabla;
    	 this.table= new JTable(this.tabla);
    	 iniciarVentana();
     }

	private void iniciarVentana() {
		setTitle("Investigadores Disponibles");
		setSize(500,300);
		panel.setLayout(new BorderLayout());
		JLabel eti=new JLabel("Investigadores:");
		eti.setFont(new Font("arial", 1, 12));
		panel.add(eti, BorderLayout.NORTH);
		table.setFont(new Font("arial", 3, 10));
		MouseListener mousetabla= new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 addPersona();
			}
			@Override
			public void mousePressed(MouseEvent e) {};

			@Override
			public void mouseReleased(MouseEvent e) {};

			@Override
			public void mouseEntered(MouseEvent e) {};

			@Override
			public void mouseExited(MouseEvent e) {};
    		  
    	  };
    	table.addMouseListener(mousetabla);
		panel.add(new JScrollPane(table), BorderLayout.CENTER);
	    JPanel botones = new JPanel();
		JButton boton1 = new JButton("Aceptar");
		boton1.setFont(new Font("arial", 3, 10));
		boton1.setForeground(Color.white);
		boton1.setBackground(Color.green);
		boton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				    cerrar();
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
				    eliminarpersona();
				    cerrar();
			}
			
		});
		botones.add(boton2);
		panel.add(botones, BorderLayout.SOUTH);
		getContentPane().add(panel);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
  
    public void cerrar() {
    	dispose();
    }
    public void eliminarpersona() {
    	List<GDP_TPersona> personas = new ArrayList<GDP_TPersona>();
    	personas=vp.getParticipantes();
    	if(personas.size()>contador) {
    		vp.subPersona();
    	}
    }
    public void addPersona() {
    	List<GDP_TPersona> personas = new ArrayList<GDP_TPersona>();
    	personas=vp.getParticipantes();
    	if(personas.size()>contador) {
    		personas.remove(personas.size()-1);
    	}
    	boolean pertenece=false;
        GDP_TPersona persona= new GDP_TPersona((String) tabla.getValueAt(table.getSelectedRow(), 0), (String)tabla.getValueAt(table.getSelectedRow(), 1),(String) (String)tabla.getValueAt(table.getSelectedRow(), 2),
    			(String) tabla.getValueAt(table.getSelectedRow(), 3), (String) tabla.getValueAt(table.getSelectedRow(), 4),
        		(String) tabla.getValueAt(table.getSelectedRow(), 5),(String) tabla.getValueAt(table.getSelectedRow(), 6));
           for(int i=0; i<personas.size() && !pertenece;i++) {
        	   if(personas.get(i).getDNI().equals(persona.getDNI())) {
        		   pertenece=true;
        	   }
           }
           if(!pertenece) {
        	   if(persona.getEstado().toLowerCase().equals("disponible")) {
        		   vp.addPersona(persona); 
        	   }
        	   else {
        		   JOptionPane.showMessageDialog(null, "Investigador no disponible");
        	   }
           }
           else {
        	   JOptionPane.showMessageDialog(null, "Selecciona otro investigador que no hayas agregado ya");
           }
    	}
    
}
