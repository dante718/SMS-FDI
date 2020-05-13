package GestionProyectos.GDP.Presentacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import GestionProyectos.GDP.Negocio.FactoriaTransfer;
import GestionProyectos.GDP.Negocio.TPersona;
import GestionProyectos.GDP.Negocio.TProyecto;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class VistaCrearProyecto extends JFrame implements IVista{
	private static VistaCrearProyecto instancia=null;
    private List<TPersona> participantes= new ArrayList<TPersona>();
    private JLabel etiqueta1 , etiqueta2, etiqueta3, etiqueta4, etiqueta5;
    private JTextField texto1;
    private JTextArea texto2;
    private JButton boton1, boton2, boton3;
    private JPanel panel=new JPanel();
    private VistaCrearProyecto() {
    	initVista();
    }
	public static VistaCrearProyecto getInstancia() {
		if(instancia==null) {
			instancia= new VistaCrearProyecto();
		}
		return instancia;
	}
	
	private void initVista() {
		setTitle("Crear Proyecto");
		setSize(500,350);
		panel.setLayout(null);
		etiqueta1= new JLabel("Crear Investigacion");
		etiqueta1.setBounds(150,20, 200,40);
		etiqueta1.setFont(new Font("arial", 1, 15));
		panel.add(etiqueta1);
		etiqueta2= new JLabel("Equipo de Investigadores:");
		etiqueta2.setBounds(30,175, 120,30);
		etiqueta2.setFont(new Font("arial", 1, 9));
		panel.add(etiqueta2);
		etiqueta3= new JLabel("Equipo de Produccion:");
		etiqueta3.setBounds(270,175, 120,30);
		etiqueta3.setFont(new Font("arial", 1, 9));
		panel.add(etiqueta3);
		etiqueta4= new JLabel("Nombre de estudio:");
		etiqueta4.setBounds(50,50, 110,20);
		etiqueta4.setFont(new Font("arial", 1, 9));
		panel.add(etiqueta4);
		etiqueta5= new JLabel("Descripcion:");
		etiqueta5.setBounds(80,70, 80,20);
		etiqueta5.setFont(new Font("arial", 1, 9));
		panel.add(etiqueta5);
		texto1= new JTextField();
		texto1.setBounds(165,50,240,20);
		panel.add(texto1);
		texto2 = new JTextArea();
		texto2.setBounds(165,75,240,70);
		texto2.setLineWrap(true);
		texto2.setWrapStyleWord(true);
		panel.add(texto2);
		boton1 = new JButton("Añadir Investigador");
		boton1.setBounds(55,210,120,30);
		boton1.setFont(new Font("arial", 1, 8));
		boton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Controlador.getInstancia().getTamPersonas()>0) {
					FactoriaVistas.getInstancia().CrearObjetoVista("AñadirInvestigador").Visibilizar();
				}
				else {
					JOptionPane.showMessageDialog(null, "No hay ninguna persona registrada en la base de datos");
				}
			}
			
		});
		panel.add(boton1);
		boton2 = new JButton("Añadir Trabajador");
		boton2.setBounds(275,210,120,30);
		boton2.setFont(new Font("arial", 1, 8));
		boton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Controlador.getInstancia().getTamPersonas()>0) {
					FactoriaVistas.getInstancia().CrearObjetoVista("AñadirTrabajador").Visibilizar();
				}
				else {
					JOptionPane.showMessageDialog(null, "No hay ninguna persona registrada en la base de datos");
				}
			}		
		});
		panel.add(boton2);
		boton3 = new JButton("Confirmar");
		boton3.setBounds(175,250,100,40);
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
					List<String> personal= new ArrayList<String>();
					for(int i=0;i<participantes.size();i++) {
						personal.add(participantes.get(i).leerDNI());
					}
					Date date= new Date();
					SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
					String fecha= sdf.format(date);
					if(Controlador.getInstancia().AddProyecto(crearProyecto(personal, fecha))) {
						texto1.setText("");
						texto2.setText("");
						dispose();
					}				
				}
			}

			private TProyecto crearProyecto(List<String> personal, String fecha) {
				List<Object> Datos= new ArrayList<Object>();
				Datos.add(texto1.getText());
				Datos.add(texto2.getText());
				Datos.add("Version "+1);
				Datos.add(fecha);
				Datos.add("NO");
				Datos.add(personal);							
				return FactoriaTransfer.getInstancia().CrearObjetoProyecto(Datos);
			}		
		});
		panel.add(boton3);
		getContentPane().add(panel);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
	}
    public void addPersona(TPersona persona) {
    	this.participantes.add(persona);
    }
    public List<TPersona> getParticipantes(){
    	return participantes;
    }
    @Override
	public void Visibilizar() {
		setVisible(true);	
	}
}
