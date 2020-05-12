package GestionProyectos.GDP.Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import GestionProyectos.GDP.Modelo.GDP_TPersona;
import GestionProyectos.GDP.Controlador.GDP_Controlador;
import GestionProyectos.GDP.Modelo.GDP_TProyecto;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class GDP_VistaPrincipal extends JFrame {
    private GDP_Controlador controlador= new GDP_Controlador();
    private List<GDP_TPersona> participantes= new ArrayList<GDP_TPersona>();
	public GDP_VistaPrincipal() {
		addcomponentes();
	}
	private void addcomponentes() {
		setTitle("Crear Proyecto");
		setSize(500,500);
		setLayout(null);
		TableModel modelo1= controlador.iniciarBasedeDatos("investigador");
		JTable tabla1 = new JTable(modelo1);
		tabla1.setBounds(5, 200, 225, 125);
		tabla1.setFont(new Font("arial", 1, 7));
		getContentPane().add(tabla1);
		TableModel modelo2= controlador.iniciarBasedeDatos("trabajador");
		JTable tabla2 = new JTable(modelo2);
		tabla2.setBounds(255, 200, 225, 125);
		tabla2.setFont(new Font("arial", 1, 7));
		getContentPane().add(tabla2);
		JLabel etiqueta1= new JLabel("Crear Investigacion");
		etiqueta1.setBounds(150,20, 200,40);
		etiqueta1.setFont(new Font("arial", 1, 15));
		getContentPane().add(etiqueta1);
		JLabel etiqueta2= new JLabel("Equipo de Investigadores:");
		etiqueta2.setBounds(30,175, 120,30);
		etiqueta2.setFont(new Font("arial", 1, 9));
		getContentPane().add(etiqueta2);
		JLabel etiqueta3= new JLabel("Equipo de Produccion:");
		etiqueta3.setBounds(270,175, 120,30);
		etiqueta3.setFont(new Font("arial", 1, 9));
		getContentPane().add(etiqueta3);
		JLabel etiqueta4= new JLabel("Nombre de estudio:");
		etiqueta4.setBounds(50,50, 110,20);
		etiqueta4.setFont(new Font("arial", 1, 9));
		getContentPane().add(etiqueta4);
		JLabel etiqueta5= new JLabel("Descripcion:");
		etiqueta5.setBounds(80,70, 80,20);
		etiqueta5.setFont(new Font("arial", 1, 9));
		getContentPane().add(etiqueta5);
		JTextField texto1= new JTextField();
		texto1.setBounds(165,50,240,20);
		getContentPane().add(texto1);
		JTextArea texto2 = new JTextArea();
		texto2.setBounds(165,75,240,70);
		texto2.setLineWrap(true);
		texto2.setWrapStyleWord(true);
		getContentPane().add(texto2);
		JButton boton1 = new JButton("A�adir Investigador");
		boton1.setBounds(55,350,120,30);
		boton1.setFont(new Font("arial", 1, 8));
		boton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GDP_VistaAddInvestigador NuevoInvestigador= new GDP_VistaAddInvestigador(modelo1, getThis());	
			}
			
		});
		getContentPane().add(boton1);
		JButton boton2 = new JButton("A�adir Trabajador");
		boton2.setBounds(275,350,120,30);
		boton2.setFont(new Font("arial", 1, 8));
		boton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GDP_VistaAddTrabajador NuevoTrabajador= new GDP_VistaAddTrabajador(modelo2, getThis());	
			}		
		});
		getContentPane().add(boton2);
		JButton boton3 = new JButton("Confrimar");
		boton3.setBounds(175,400,100,40);
		boton3.setFont(new Font("arial", 1, 10));
		boton3.setBackground(Color.black);
		boton3.setForeground(Color.white);
		boton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(texto1.getText().equals("") || texto2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "El proyecto ha de tener nombre y descripcion");
				}
				else if(participantes.size()==0){
					JOptionPane.showMessageDialog(null, "El proyecto ha de tener algun participante");
				}
				else {
					if(controlador.CrearProyecto(new GDP_TProyecto(texto1.getText(), texto2.getText(), participantes.size()), participantes)) {
						cerrar();
					}				
				}
			}		
		});
		getContentPane().add(boton3);
		if(modelo1!=null && modelo2!=null) {
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	}
	public GDP_VistaPrincipal getThis() {
		return this;
	}
	public void cerrar() {
		dispose();
	}
    public void addPersona(GDP_TPersona persona) {
    	this.participantes.add(persona);
    }
    public void subPersona() {
    	this.participantes.remove(participantes.size()-1);
    }
    public List<GDP_TPersona> getParticipantes(){
    	return participantes;
    }
}