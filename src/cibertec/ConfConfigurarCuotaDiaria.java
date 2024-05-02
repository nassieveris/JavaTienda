package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfConfigurarCuotaDiaria extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblCuotaDiariaEsperada;
	private JTextField txt1;
	private JButton btnAceptarCCCD;
	private JButton btnCerrarCCCD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfConfigurarCuotaDiaria dialog = new ConfConfigurarCuotaDiaria();
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
	public ConfConfigurarCuotaDiaria() {
		setBounds(100, 100, 600, 120);
		getContentPane().setLayout(null);
		
		lblCuotaDiariaEsperada = new JLabel("Cuota Diaria Esperada (S/.)");
		lblCuotaDiariaEsperada.setBounds(10, 14, 218, 14);
		getContentPane().add(lblCuotaDiariaEsperada);
		
		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBounds(238, 11, 118, 20);
		getContentPane().add(txt1);
		
		btnAceptarCCCD = new JButton("Aceptar");
		btnAceptarCCCD.addActionListener(this);
		btnAceptarCCCD.setBounds(485, 10, 89, 23);
		getContentPane().add(btnAceptarCCCD);
		
		btnCerrarCCCD = new JButton("Cerrar");
		btnCerrarCCCD.addActionListener(this);
		btnCerrarCCCD.setBounds(485, 47, 89, 23);
		getContentPane().add(btnCerrarCCCD);
		
		consultarCuota();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptarCCCD) {
			actionPerformedBtnAceptarCCCD(e);
		}
		if (e.getSource() == btnCerrarCCCD) {
			actionPerformedBtnCerrarCCCD(e);
		}
	}
	protected void actionPerformedBtnCerrarCCCD(ActionEvent e) {
		dispose();
	}
	void consultarCuota() {
		txt1.setText(String.valueOf(Tienda.cuotaDiaria)); 
	}

	void modificarCuota() {
		Tienda.cuotaDiaria = Double.parseDouble(txt1.getText());
	}
	protected void actionPerformedBtnAceptarCCCD(ActionEvent e) {
		modificarCuota();
	}
}
