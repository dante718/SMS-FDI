package GestionLaboratorio.presentacion_Laboratorio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EliminarPedido extends JFrame{
	private JFrame marco;
	private JPanel panel;
	private JPanel superior;
	private JLabel titulo;
	private JPanel medio;
	private  JLabel id_cod;
	private  JTextField id_codT;
	private  JButton ok;
	
	
	public EliminarPedido(){
		initGUI();
	}

	private void initGUI() {
		 marco = new JFrame(" Gestion de Laboratorio ");
		  panel = new JPanel(new BorderLayout());
		 marco.setMaximumSize(new Dimension(500, 100));
		 marco.setMinimumSize(new Dimension(500, 100));
		 marco.setPreferredSize(new Dimension(500, 100));
		 
		 superior = new JPanel(new BorderLayout());
		  titulo = new JLabel("                    Eliminar Pedido ");
		 titulo.setFont(new Font("Serif",Font.PLAIN,30));
		 superior.add(titulo,BorderLayout.CENTER);
		 //-----------------------------------------------------------------------------------
		  medio = new JPanel(new GridBagLayout());
		 medio.setPreferredSize(new Dimension(100,100));
		  id_cod = new JLabel("Id Pedido: ");
		 id_codT = new JTextField(10);
		 ok = new JButton("Eliminar Pedido");
		 GridBagConstraints gc= new GridBagConstraints();
		 //--------------------------------------------------------------------------------
		 gc.weightx=1;
		 gc.weighty=0.1;
		 
		 gc.gridx=0;
		 gc.gridy=0;
		 gc.fill=GridBagConstraints.NONE;
		 gc.anchor=GridBagConstraints.LINE_END;
		 medio.add(id_cod,gc);
		 
		 gc.gridx=1;
		 gc.gridy=0;
		 gc.anchor=GridBagConstraints.LINE_START;
		 medio.add(id_codT,gc);
		 gc.weightx=1;
		 gc.weighty=0.1;
		 gc.gridx=0;
		 gc.gridy=2;
		 gc.anchor=GridBagConstraints.FIRST_LINE_START;
		 medio.add(ok,gc);
		 panel.add(medio,BorderLayout.CENTER);
		 marco.getContentPane().add(panel);
		 marco.pack();
		 marco.setVisible(true);
		 
		 
		 ok.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					try{
						Controlador_Lab.getInstancia().EliminarPedido(id_codT.getText());
						JOptionPane.showMessageDialog(marco,"Pedido Eliminado");
					}
					catch(IllegalArgumentException ex) {


						JOptionPane.showMessageDialog(marco, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			 });
	}
	
	
	
	
}

