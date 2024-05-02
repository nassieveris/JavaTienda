package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class MantConsultaCocina extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtQuemadores;
	private JComboBox cmbModelo;
	private JButton btnCerrarMCC;
	
	int modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantConsultaCocina dialog = new MantConsultaCocina();
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
	public MantConsultaCocina() {
		setTitle("Consultar Cocina");
		setBounds(100, 100, 600, 245);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 15, 95, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Precio (S/)");
		lblNewLabel_1.setBounds(10, 47, 95, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Ancho (cm)");
		lblNewLabel_2.setBounds(10, 78, 95, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Alto (cm)");
		lblNewLabel_3.setBounds(10, 109, 95, 14);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Fondo(cm)");
		lblNewLabel_4.setBounds(10, 140, 95, 14);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Quemadores");
		lblNewLabel_5.setBounds(10, 171, 95, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtPrecio = new JTextField();
		txtPrecio.setEnabled(false);
		txtPrecio.setBounds(115, 44, 360, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setEnabled(false);
		txtAncho.setBounds(115, 75, 360, 20);
		getContentPane().add(txtAncho);
		txtAncho.setColumns(10);
		
		txtAlto = new JTextField();
		txtAlto.setEnabled(false);
		txtAlto.setBounds(115, 106, 360, 20);
		getContentPane().add(txtAlto);
		txtAlto.setColumns(10);
		
		txtFondo = new JTextField();
		txtFondo.setEnabled(false);
		txtFondo.setBounds(115, 137, 360, 20);
		getContentPane().add(txtFondo);
		txtFondo.setColumns(10);
		
		txtQuemadores = new JTextField();
		txtQuemadores.setEnabled(false);
		txtQuemadores.setBounds(115, 168, 360, 20);
		getContentPane().add(txtQuemadores);
		txtQuemadores.setColumns(10);
		
		cmbModelo = new JComboBox();
		cmbModelo.addActionListener(this);
		cmbModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cmbModelo.setBounds(115, 11, 360, 22);
		getContentPane().add(cmbModelo);
		
		btnCerrarMCC = new JButton("Cerrar");
		btnCerrarMCC.addActionListener(this);
		btnCerrarMCC.setBounds(485, 11, 89, 23);
		getContentPane().add(btnCerrarMCC);
		
		entradaDeDatos();
		consultarCocinas();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmbModelo) {
			actionPerformedCmbModelo(e);
		}
		if (e.getSource() == btnCerrarMCC) {
			actionPerformedBtnCerrarMCC(e);
		}
	}
	protected void actionPerformedBtnCerrarMCC(ActionEvent e) {
		dispose();
	}
	
	void entradaDeDatos() {
		modelo = cmbModelo.getSelectedIndex(); 
	}
	
	void consultarCocinas() {
		switch (modelo) {
		case 0:
			txtPrecio.setText(String.valueOf(Tienda.precio0));
			txtAncho.setText(String.valueOf(Tienda.ancho0));
			txtAlto.setText(String.valueOf(Tienda.alto0));
			txtFondo.setText(String.valueOf(Tienda.fondo0));
			txtQuemadores.setText(String.valueOf(Tienda.quemadores0));
			break;
		case 1:
			txtPrecio.setText(String.valueOf(Tienda.precio1));
			txtAncho.setText(String.valueOf(Tienda.ancho1));
			txtAlto.setText(String.valueOf(Tienda.alto1));
			txtFondo.setText(String.valueOf(Tienda.fondo1));
			txtQuemadores.setText(String.valueOf(Tienda.quemadores1));
			break;
		case 2:
			txtPrecio.setText(String.valueOf(Tienda.precio2));
			txtAncho.setText(String.valueOf(Tienda.ancho2));
			txtAlto.setText(String.valueOf(Tienda.alto2));
			txtFondo.setText(String.valueOf(Tienda.fondo2));
			txtQuemadores.setText(String.valueOf(Tienda.quemadores2));
			break;
		case 3:
			txtPrecio.setText(String.valueOf(Tienda.precio3));
			txtAncho.setText(String.valueOf(Tienda.ancho3));
			txtAlto.setText(String.valueOf(Tienda.alto3));
			txtFondo.setText(String.valueOf(Tienda.fondo3));
			txtQuemadores.setText(String.valueOf(Tienda.quemadores3));
			break;
		case 4:
			txtPrecio.setText(String.valueOf(Tienda.precio4));
			txtAncho.setText(String.valueOf(Tienda.ancho4));
			txtAlto.setText(String.valueOf(Tienda.alto4));
			txtFondo.setText(String.valueOf(Tienda.fondo4));
			txtQuemadores.setText(String.valueOf(Tienda.quemadores4));
			break;
		default:
		
		}
	
	}
	 
	protected void actionPerformedCmbModelo(ActionEvent e) {
		entradaDeDatos();
		consultarCocinas();
		 
	}
}

