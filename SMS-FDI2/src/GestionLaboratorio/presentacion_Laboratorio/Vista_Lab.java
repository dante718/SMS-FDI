package GestionLaboratorio.presentacion_Laboratorio;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;



import javax.swing.JFrame;

public class Vista_Lab extends JFrame{
	private JButton crear,modificar,eliminar;
	private JLabel c,m,e;
	
	public Vista_Lab() {
		initGui();
	}
	
	private void initGui() {
		setSize(950, 1000);
		setLayout(null);
		JLabel gestionlab = new JLabel("Laboratorio");
		gestionlab.setBounds(300, 50, 400, 70);
		gestionlab.setFont(new Font("", 3, 70));
		gestionlab.setForeground(Color.BLACK);
		getContentPane().add(gestionlab);
		c=new JLabel("Crear Pedido ");
		c.setBounds(100, 150, 150, 50);
		getContentPane().add(c);
		crear= new JButton();
		crear.setBounds(100, 200, 100, 100);
		ImageIcon imagen1= new ImageIcon("iconosuma.png");
		crear.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(crear.getWidth(),crear.getHeight(), Image.SCALE_SMOOTH)));
		getContentPane().add(crear);
		m=new JLabel("Modificar Pedido ");
		m.setBounds(650, 150, 150, 50);
		getContentPane().add(m);
		modificar= new JButton();
		modificar.setBounds(650, 200, 100, 100);
		ImageIcon imagen2= new ImageIcon("editar.png");
		modificar.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(modificar.getWidth(),modificar.getHeight(), Image.SCALE_SMOOTH)));
		getContentPane().add(modificar);
		e=new JLabel("Eliminar Pedido ");
		e.setBounds(100, 350, 150, 50);
		getContentPane().add(e);
		eliminar= new JButton();
		eliminar.setBounds(100, 400, 100, 100);
		ImageIcon imagen3= new ImageIcon("borrar.png");
		eliminar.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(eliminar.getWidth(),eliminar.getHeight(), Image.SCALE_SMOOTH)));
		getContentPane().add(eliminar);
		crear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CrearPedido();	
			}
		});
		modificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new BuscarPedido();	
			}
		});
		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EliminarPedido();	
			}
		});
		
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
