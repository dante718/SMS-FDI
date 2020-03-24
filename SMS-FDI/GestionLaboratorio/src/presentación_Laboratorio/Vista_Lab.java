package presentación_Laboratorio;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import negocio_Laboratorio.TransferProducto_Lab;
public class Vista_Lab {
	private JFrame marco;
	private JLabel titulo;
	private JPanel panel;
	private JPanel superior;
	private JPanel medio;
	private JButton confirmar;
	private JButton ok;
	private JButton eliminar;
	private JLabel id_cod;
	private JLabel cant;
	private JTextField id_codT;
	private JTextField cantT;
	private JTextArea infoPedido;
	public Vista_Lab() {
		
	 marco =new JFrame(" Gestion de Laboratorio ");
	 panel =new JPanel(new BorderLayout());
	 marco.setMaximumSize(new Dimension(700, 600));
	 marco.setMinimumSize(new Dimension(700, 600));
	 marco.setPreferredSize(new Dimension(700, 600));
	 
	 superior =new JPanel(new BorderLayout());
	 titulo= new JLabel("                    Gestion de pedido Laboratorio ");
	 titulo.setFont(new Font("Serif",Font.PLAIN,30));
	 superior.add(titulo,BorderLayout.CENTER);
	 infoPedido= new JTextArea("        InfoPedido");
	 infoPedido.setPreferredSize(new Dimension(350,300));
	 //-----------------------------------------------------------------------------------
	 medio = new JPanel(new GridBagLayout());
	 medio.setPreferredSize(new Dimension(350,300));
	 id_cod= new JLabel("Id Codigo: ");
	 cant=new JLabel("Cantidad: ");
	 id_codT =new JTextField(10);
	 cantT =new JTextField(10);
	 ok=new JButton("Add Producto");
	 eliminar= new JButton("Eliminar Producto");
	 GridBagConstraints gc= new GridBagConstraints();
	 //--------------Primera linea----------
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
	 //--------------Segunda linea-----------
	 gc.weightx=1;
	 gc.weighty=0.1;
	 
	 gc.gridx=0;
	 gc.gridy=1;
	 gc.anchor=GridBagConstraints.LINE_END;
	 medio.add(cant,gc);
	 
	 gc.gridx=1;
	 gc.gridy=1;
	 gc.anchor=GridBagConstraints.LINE_START;
	 medio.add(cantT,gc);
	 //---------------Tercera linea------------
	 gc.weightx=1;
	 gc.weighty=0.1;
	 gc.gridx=0;
	 gc.gridy=2;
	 gc.anchor=GridBagConstraints.FIRST_LINE_START;
	 medio.add(ok,gc);
	 gc.gridx=1;
	 gc.gridy=2;
	 medio.add(eliminar,gc);
	
	 //----------------------------------------------------------------------------------------
	 confirmar= new JButton("Confirmar");
	 
	 panel.add(confirmar,BorderLayout.SOUTH);
	 panel.add(medio,BorderLayout.WEST);
	 panel.add(infoPedido,BorderLayout.EAST);
	 panel.add(superior,BorderLayout.NORTH);
	 
	 marco.getContentPane().add(panel);
	 marco.pack();
	 marco.setVisible(true);
	 
	 confirmar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Controlador_Lab.getInstancia().guardarPedido();
		}
		 
	 });
	 ok.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try{
				Controlador_Lab.getInstancia().addProducto(Integer.parseInt(id_codT.getText()), Integer.parseInt(cantT.getText()));
				List<TransferProducto_Lab>lista=Controlador_Lab.getInstancia().listarPedido();
				infoPedido.setText("Id_Pedido: "+Controlador_Lab.getInstancia().Id_Pedido()+"\n");
				for(int i =0;i<lista.size();i++) {
					infoPedido.append("  Id_Codigo: "+ lista.get(i).get_idProducto() +" Cantidad :" + lista.get(i).get_cantidad()+"\n");
				}
			
				
			}
			catch(IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(marco, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	 });
	 eliminar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			try{
				Controlador_Lab.getInstancia().borrarProducto(Integer.parseInt(id_codT.getText()));
				List<TransferProducto_Lab>lista=Controlador_Lab.getInstancia().listarPedido();
				infoPedido.setText("Id_Pedido: "+Controlador_Lab.getInstancia().Id_Pedido()+"\n");
				for(int i =0;i<lista.size();i++) {
					infoPedido.append("  Id_Codigo: "+ lista.get(i).get_idProducto() +" Cantidad :" + lista.get(i).get_cantidad()+"\n");
				}
			
				
			}
			catch(IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(marco, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		
		}
	 });
		
	}
	
	
	
	/*public static void main(String[] args) {
		new Vista_Lab();

	}*/

}
