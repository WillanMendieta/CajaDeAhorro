package ec.edu.ups.est.view;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import ups.edu.ec.controlador.ConectividadConBaseDatos;
import ups.edu.ec.controlador.ControladorDepositos;
import ups.edu.ec.modelo.Depositos;

public class VntDeposito extends JFrame implements ActionListener {

	private int id;
	private String cuenta;
    private double monto;
    private JTextField idText;
    private JTextField cuentaText;
    private JTextField montoText;
	 
	 
	 

	    public static void main(String[] args) {
	    	VntDeposito v = new VntDeposito();
	    	v.componentes();
	    	v.setVisible(true);
	    }

	    public void componentes() {
	    	
	    	setSize(400,240 );
	            

	    		
	    	Container cp= getContentPane();
	        cp.setLayout(new java.awt.GridBagLayout());
	            
	        GridBagConstraints gb = new GridBagConstraints();
	            
	            
	        JLabel id = new JLabel("id");
	    	gb.gridx=0;
	    	gb.gridy=0;
	    	cp.add(id, gb);
	    	
	    	idText= new JTextField(20);
	    	gb.gridx=1;
	    	gb.gridy=0;
	    	cp.add(idText, gb);
	
	    	JLabel cuenta = new JLabel("cuenta");
	    	gb.gridx=0;
	    	gb.gridy=2;
	    	cp.add(cuenta, gb);
	        
	    	cuentaText = new JTextField(20);
	    	gb.gridx=1;
	    	gb.gridy=2;
	    	cp.add(cuentaText, gb);
	    	
	        JLabel monto = new JLabel("monto");
	    	gb.gridx=0;
	    	gb.gridy=3;
	    	cp.add(monto, gb);
	    	
	    	montoText = new JTextField(20);
	    	gb.gridx=1;
	    	gb.gridy=3;
	    	cp.add(montoText, gb);
	    		
	    	JButton clien= new JButton("registrarCliente");
	    	gb.gridx=1;
	    	gb.gridy=4;
	    	gb.gridwidth=1;
	            clien.addActionListener(this);
	            clien.setActionCommand("nuevoCliente");
	    	cp.add(clien, gb);
	        

	      
	    }

		public void actionPerformed(ActionEvent e) {
			
			
			String comando = e.getActionCommand();
			ControladorDepositos ven2 = new ControladorDepositos() ;
			
			Depositos deposito = new Depositos();
			
			
			
			  id= Integer.parseInt(idText.getText());
	        cuenta= cuentaText.getText();
	        monto= Double.parseDouble(montoText.getText());
			 
			
			deposito.setIdDeposito(id);
			deposito.setCuenta(cuenta);
			
			deposito.setFecha(new Date());
			deposito.setMonto(monto);

        	try {
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        switch(comando){
	           case"nuevoCliente":
	                ven2.guardarDeposito(deposito);
	                break;
	            default:
	                break;
	        }
			
		}
}
