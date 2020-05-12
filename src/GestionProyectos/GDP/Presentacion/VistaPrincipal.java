package GestionProyectos.GDP.Presentacion;

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
	private static VistaPrincipal instancia=null;
	private JLabel titulo ;
	private JButton cp, mei, cvd, cef,spm; 
	private JPanel panel= new JPanel();
    private VistaPrincipal() {
    	 initVista();
    }
    
    public static VistaPrincipal getInstancia() {
    	if(instancia==null) {
    		instancia= new VistaPrincipal();
    	}
    	return instancia;
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
        cp.setBounds(250, 150, 250, 30);
        cp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VistaCrearProyecto.getInstancia().setVisible(true);
			}
        	
        });
	    panel.add(cp);
	    mei=new JButton("Modificar Estado Investigador");	
	    mei.setBounds(250, 250, 250, 30);
	    mei.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaModEstadoInvest.getInstancia().setVisible(true);
			}
	    	
	    });
	    panel.add(mei);
	    cvd=new JButton("Confirmar Version de Desarrrollo");
	    cvd.setBounds(250, 350, 250, 30);
	    cvd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaNuevaVersionDeProyecto.getInstancia().setVisible(true);
			}
	    	
	    });
	    panel.add(cvd);
	    cef=new JButton("Confirmar Estado de Fabricaci�n");
	    cef.setBounds(250, 450, 250, 30);
	    cef.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaA�adirFabricacion.getInstancia().setVisible(true);			
			}
	    	
	    });
	    panel.add(cef);
	    spm=new JButton("Solicitar Partida de Medicamentos");
	    spm.setBounds(250, 550, 250, 30);
	    spm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VistaSolicitarPartidaDeMedicamentos.getInstancia().setVisible(true);
			}
	    	
	    });
	    panel.add(spm);
		panel.setBackground(Color.CYAN);
		
		this.getContentPane().add(panel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
