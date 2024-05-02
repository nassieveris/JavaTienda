package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfConfigurarDescuentos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txt4;
	private JTextField txt3;
	private JTextField txt2;
	private JTextField txt1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnAceptarCCD;
	private JButton btnCerrarCCD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfConfigurarDescuentos dialog = new ConfConfigurarDescuentos();
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
	public ConfConfigurarDescuentos() {
		setTitle("Configurar Porcentajes de Descuentos");
		setBounds(100, 100, 600, 170);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("1 a 5 unidades");
		lblNewLabel.setBounds(10, 14, 171, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("6 a 10 unidades");
		lblNewLabel_1.setBounds(10, 45, 171, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("11 a 15 unidades");
		lblNewLabel_2.setBounds(10, 76, 171, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("M\u00E1s de 15 unidades");
		lblNewLabel_3.setBounds(10, 107, 171, 14);
		getContentPane().add(lblNewLabel_3);
		
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(191, 104, 77, 20);
		getContentPane().add(txt4);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(191, 73, 77, 20);
		getContentPane().add(txt3);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(191, 42, 77, 20);
		getContentPane().add(txt2);
		
		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBounds(191, 11, 77, 20);
		getContentPane().add(txt1);
		
		lblNewLabel_4 = new JLabel("%");
		lblNewLabel_4.setBounds(278, 14, 34, 14);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("%");
		lblNewLabel_5.setBounds(278, 45, 34, 14);
		getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("%");
		lblNewLabel_6.setBounds(278, 76, 34, 14);
		getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("%");
		lblNewLabel_7.setBounds(278, 107, 34, 14);
		getContentPane().add(lblNewLabel_7);
		
		btnAceptarCCD = new JButton("Aceptar");
		btnAceptarCCD.addActionListener(this);
		btnAceptarCCD.setBounds(485, 10, 89, 23);
		getContentPane().add(btnAceptarCCD);
		
		btnCerrarCCD = new JButton("Cerrar");
		btnCerrarCCD.addActionListener(this);
		btnCerrarCCD.setBounds(485, 41, 89, 23);
		getContentPane().add(btnCerrarCCD);
		
		consultarDescuento();

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptarCCD) {
			actionPerformedBtnAceptarCCD(e);
		}
		if (e.getSource() == btnCerrarCCD) {
			actionPerformedBtnCerrarCCD(e);
		}
	}
	protected void actionPerformedBtnCerrarCCD(ActionEvent e) {
		dispose();
	}
	
	
	
	void consultarDescuento() {
		txt1.setText(String.valueOf(Tienda.porcentaje1));
		txt2.setText(String.valueOf(Tienda.porcentaje2));
		txt3.setText(String.valueOf(Tienda.porcentaje3));
		txt4.setText(String.valueOf(Tienda.porcentaje4));
	}
	
	void modificarDecuento() {
		Tienda.porcentaje1 = Double.parseDouble(txt1.getText());
		Tienda.porcentaje2 = Double.parseDouble(txt2.getText());
		Tienda.porcentaje3 = Double.parseDouble(txt3.getText());
		Tienda.porcentaje4 = Double.parseDouble(txt4.getText());
	}
	
	
	protected void actionPerformedBtnAceptarCCD(ActionEvent e) {
		modificarDecuento();
	}
}
