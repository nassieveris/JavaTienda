package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class MantModificarCocina extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JComboBox cmbModelo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtQuemadores;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnGrabarMMC;
	private JButton btnCerrarMMC;
	
	int modelo; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantModificarCocina dialog = new MantModificarCocina();
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
	public MantModificarCocina() {
		setTitle("Modificar Cocina");
		setBounds(100, 100, 600, 245);
		getContentPane().setLayout(null);
		
		cmbModelo = new JComboBox();
		cmbModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cmbModelo.addActionListener(this);
		cmbModelo.setBounds(116, 11, 359, 22);
		getContentPane().add(cmbModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(115, 44, 360, 20);
		getContentPane().add(txtPrecio);
		
		txtAncho = new JTextField();
		txtAncho.setColumns(10);
		txtAncho.setBounds(116, 75, 359, 20);
		getContentPane().add(txtAncho);
		
		txtAlto = new JTextField();
		txtAlto.setColumns(10);
		txtAlto.setBounds(116, 106, 359, 20);
		getContentPane().add(txtAlto);
		
		txtFondo = new JTextField();
		txtFondo.setColumns(10);
		txtFondo.setBounds(116, 137, 359, 20);
		getContentPane().add(txtFondo);
		
		txtQuemadores = new JTextField();
		txtQuemadores.setColumns(10);
		txtQuemadores.setBounds(115, 168, 360, 20);
		getContentPane().add(txtQuemadores);
		
		lblNewLabel = new JLabel("Quemadores");
		lblNewLabel.setBounds(10, 171, 95, 14);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Fondo(cm)");
		lblNewLabel_1.setBounds(10, 140, 96, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Alto (cm)");
		lblNewLabel_2.setBounds(10, 109, 96, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Ancho (cm)");
		lblNewLabel_3.setBounds(10, 78, 96, 14);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Precio (S/)");
		lblNewLabel_4.setBounds(10, 47, 95, 14);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Modelo");
		lblNewLabel_5.setBounds(10, 15, 96, 14);
		getContentPane().add(lblNewLabel_5);
		
		btnGrabarMMC = new JButton("Grabar");
		btnGrabarMMC.addActionListener(this);
		btnGrabarMMC.setBounds(485, 11, 89, 23);
		getContentPane().add(btnGrabarMMC);
		
		btnCerrarMMC = new JButton("Cerrar");
		btnCerrarMMC.addActionListener(this);
		btnCerrarMMC.setBounds(485, 43, 89, 23);
		getContentPane().add(btnCerrarMMC);
		
		entradaDeDatos();
		consultarCocinas();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabarMMC) {
			actionPerformedBtnGrabarMMC(e);
		}
		if (e.getSource() == cmbModelo) {
			actionPerformedCmbModelo(e);
		}
		if (e.getSource() == btnCerrarMMC) {
			actionPerformedBtnCerrarMMC(e);
		}
	}
	protected void actionPerformedBtnCerrarMMC(ActionEvent e) {
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
	
	void modificarCocinas() {
		switch (modelo) {
			case 0: 
				Tienda.precio0 = Double.parseDouble(txtPrecio.getText());
				Tienda.ancho0 = Double.parseDouble(txtAncho.getText());
				Tienda.alto0 = Double.parseDouble(txtAlto.getText());
				Tienda.fondo0 = Double.parseDouble(txtFondo.getText());
				Tienda.quemadores0 = Integer.parseInt(txtQuemadores.getText());
				break;
			case 1:
				Tienda.precio1 = Double.parseDouble(txtPrecio.getText());
				Tienda.ancho1 = Double.parseDouble(txtAncho.getText());
				Tienda.alto1 = Double.parseDouble(txtAlto.getText());
				Tienda.fondo1 = Double.parseDouble(txtFondo.getText());
				Tienda.quemadores1 = Integer.parseInt(txtQuemadores.getText());
				break;
			case 2:
				Tienda.precio2 = Double.parseDouble(txtPrecio.getText());
				Tienda.ancho2 = Double.parseDouble(txtAncho.getText());
				Tienda.alto2 = Double.parseDouble(txtAlto.getText());
				Tienda.fondo2 = Double.parseDouble(txtFondo.getText());
				Tienda.quemadores2 = Integer.parseInt(txtQuemadores.getText());
				break;
			case 3:
				Tienda.precio3 = Double.parseDouble(txtPrecio.getText());
				Tienda.ancho3 = Double.parseDouble(txtAncho.getText());
				Tienda.alto3 = Double.parseDouble(txtAlto.getText());
				Tienda.fondo3 = Double.parseDouble(txtFondo.getText());
				Tienda.quemadores3 = Integer.parseInt(txtQuemadores.getText());
				break;
			case 4:
				Tienda.precio4 = Double.parseDouble(txtPrecio.getText());
				Tienda.ancho4 = Double.parseDouble(txtAncho.getText());
				Tienda.alto4 = Double.parseDouble(txtAlto.getText());
				Tienda.fondo4 = Double.parseDouble(txtFondo.getText());
				Tienda.quemadores4 = Integer.parseInt(txtQuemadores.getText());
				break;
			default:
			
			}
		
	}
	protected void actionPerformedCmbModelo(ActionEvent e) {
		entradaDeDatos();
		consultarCocinas();
	}
	protected void actionPerformedBtnGrabarMMC(ActionEvent e) {
		modificarCocinas();
	}
}
