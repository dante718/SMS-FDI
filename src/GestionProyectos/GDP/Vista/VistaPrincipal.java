package GestionProyectos.GDP.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaPrincipal extends JFrame{
	private JLabel titulo ;
	private JButton cp, mei, cvd, cef,spm; 
	private JPanel panel= new JPanel();
     public VistaPrincipal() {
    	 initVista();
     }

	private void initVista() {
		setSize(700,700);
		panel.setLayout(null);
		titulo=new JLabel();
		titulo.setText("Gestion de Proyectos");
		titulo.setFont(new Font("comic sans ms", 3, 30));
		titulo.setBounds(200, 50, 400, 50);
		panel.add(titulo);
        cp=new JButton("Crear Proyecto");
        cp.setBounds(250, 150, 200, 30);
        cp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VistaCrearProyecto cp= new VistaCrearProyecto();	
			}
        	
        });
	    panel.add(cp);
	    mei=new JButton("Modificar Estado Investigador");	
	    mei.setBounds(250, 250, 200, 30);
	    mei.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaModEstadoInvest mei= new VistaModEstadoInvest();
			}
	    	
	    });
	    panel.add(mei);
	    cvd=new JButton("Confirmar Version de Desarrrollo");
	    cvd.setBounds(250, 350, 200, 30);
	    panel.add(cvd);
	    cef=new JButton("Confirmar Estado de Fabricación");
	    cef.setBounds(250, 450, 200, 30);
	    panel.add(cef);
	    spm=new JButton("Solicitar Partida de Medicamentos");
	    spm.setBounds(250, 550, 200, 30);
	    panel.add(spm);
		panel.setBackground(Color.CYAN);
		
		this.getContentPane().add(panel);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
