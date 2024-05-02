package cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcercaDe extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JLabel lblNewLabel_1;
	private JButton btnAcercaCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AcercaDe dialog = new AcercaDe();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Tienda v.01");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(149, 32, 128, 14);
		getContentPane().add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(51, 57, 343, 1);
		getContentPane().add(separator);
		
		lblNewLabel_1 = new JLabel("<html><center>Geraldine Venturo (I202400870)<br><br>Gino Nassi (I202400697)<br><br>Julio Loayza (I202400xxx)</center></html>");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(119, 80, 205, 95);
		getContentPane().add(lblNewLabel_1);
		
		btnAcercaCerrar = new JButton("Cerrar");
		btnAcercaCerrar.addActionListener(this);
		btnAcercaCerrar.setBounds(171, 186, 89, 23);
		getContentPane().add(btnAcercaCerrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAcercaCerrar) {
			actionPerformedBtnAcercaCerrar(e);
		}
	}
	protected void actionPerformedBtnAcercaCerrar(ActionEvent e) {
		dispose();
	}
}
