package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfConfigurarObsequios extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblUnidad;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txt3;
	private JTextField txt2;
	private JTextField txt1;
	private JButton btnAceptarCCO;
	private JButton btnCerrarCCO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfConfigurarObsequios dialog = new ConfConfigurarObsequios();
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
	public ConfConfigurarObsequios() {
		setTitle("Configurar Obsequios");
		setBounds(100, 100, 600, 140);
		getContentPane().setLayout(null);
		
		lblUnidad = new JLabel("1 unidad");
		lblUnidad.setBounds(10, 14, 139, 14);
		getContentPane().add(lblUnidad);
		
		lblNewLabel_1 = new JLabel("2 a 5 unidades");
		lblNewLabel_1.setBounds(10, 45, 139, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("6 a m\u00E1s unidades");
		lblNewLabel_2.setBounds(10, 76, 139, 14);
		getContentPane().add(lblNewLabel_2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(159, 73, 164, 20);
		getContentPane().add(txt3);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(159, 42, 164, 20);
		getContentPane().add(txt2);
		
		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBounds(159, 11, 164, 20);
		getContentPane().add(txt1);
		
		btnAceptarCCO = new JButton("Aceptar");
		btnAceptarCCO.addActionListener(this);
		btnAceptarCCO.setBounds(485, 10, 89, 23);
		getContentPane().add(btnAceptarCCO);
		
		btnCerrarCCO = new JButton("Cerrar");
		btnCerrarCCO.addActionListener(this);
		btnCerrarCCO.setBounds(485, 41, 89, 23);
		getContentPane().add(btnCerrarCCO);
		
		consultarObsequio();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptarCCO) {
			actionPerformedBtnAceptarCCO(e);
		}
		if (e.getSource() == btnCerrarCCO) {
			actionPerformedBtnCerrarCCD(e);
		}
	}
	protected void actionPerformedBtnCerrarCCD(ActionEvent e) {
		dispose();
	}
	
	//// Obsequio por cantidad m�nima de colchones adquiridos
	//public static String obsequio1 = "Cafetera";
	//public static String obsequio2 = "Licuadora";
	//public static String obsequio3 = "Extractor";
	
	void consultarObsequio() {
		txt1.setText(String.valueOf(Tienda.obsequio1));
		txt2.setText(String.valueOf(Tienda.obsequio2));
		txt3.setText(String.valueOf(Tienda.obsequio3));
	}
	
	void modificarObsequio() {
		Tienda.obsequio1 = txt1.getText();
		Tienda.obsequio2 = txt2.getText();
		Tienda.obsequio3 = txt3.getText();

	}
	protected void actionPerformedBtnAceptarCCO(ActionEvent e) {
		modificarObsequio();
	}
}
