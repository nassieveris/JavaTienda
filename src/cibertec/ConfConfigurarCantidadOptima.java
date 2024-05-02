package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfConfigurarCantidadOptima extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblCantidadptimaDe;
	private JTextField txt1;
	private JButton btnAceptarCCCO;
	private JButton btnCerrarCCCO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfConfigurarCantidadOptima dialog = new ConfConfigurarCantidadOptima();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ConfConfigurarCantidadOptima() {
		setTitle("Configurar Cantidad \u00D3ptima");
		setBounds(100, 100, 600, 120);
		getContentPane().setLayout(null);
		
		lblCantidadptimaDe = new JLabel("Cantidad óptima de unidades vendidas:");
		lblCantidadptimaDe.setBounds(10, 14, 337, 14);
		getContentPane().add(lblCantidadptimaDe);
		
		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBounds(258, 11, 78, 20);
		getContentPane().add(txt1);
		
		btnAceptarCCCO = new JButton("Aceptar");
		btnAceptarCCCO.addActionListener(this);
		btnAceptarCCCO.setBounds(485, 10, 89, 23);
		getContentPane().add(btnAceptarCCCO);
		
		btnCerrarCCCO = new JButton("Cerrar");
		btnCerrarCCCO.addActionListener(this);
		btnCerrarCCCO.setBounds(485, 47, 89, 23);
		getContentPane().add(btnCerrarCCCO);
		
		consultarCantidad();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptarCCCO) {
			actionPerformedBtnAceptarCCCO(e);
		}
		if (e.getSource() == btnCerrarCCCO) {
			actionPerformedBtnCerrarCCCO(e);
		}
	}
	protected void actionPerformedBtnCerrarCCCO(ActionEvent e) {
		dispose();
	}
	
	void consultarCantidad() {
		txt1.setText(String.valueOf(Tienda.cantidadOptima)); 
	}

	void modificarCantidad() {
		Tienda.cantidadOptima = Integer.parseInt(txt1.getText());
	}
	protected void actionPerformedBtnAceptarCCCO(ActionEvent e) {
		modificarCantidad();
	}
}
