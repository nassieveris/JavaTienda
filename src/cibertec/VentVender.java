package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class VentVender extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JComboBox cmbModelo;
	private JButton btnVenderVV;
	private JButton btnCerrarVV;
	private JTextField txtPrecio;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtCantidad;
	private JTextArea txaBoleta;
	
	int modelo;
	
	public static int uso = 0;
	public static double sumaPagos = 0;
	
	public static int uso0 = 0;
	public static int cantVenta0 = 0;
	public static double pago0 = 0;
	public static double cuota0 = 0;
	
	public static int uso1 = 0;
	public static int cantVenta1 = 0;
	public static double pago1 = 0;
	public static double cuota1 = 0;
	
	public static int uso2 = 0;
	public static int cantVenta2 = 0;
	public static double pago2 = 0;
	public static double cuota2 = 0;
	
	public static int uso3 = 0;
	public static int cantVenta3 = 0;
	public static double pago3 = 0;
	public static double cuota3 = 0;
	
	public static int uso4 = 0;
	public static int cantVenta4 = 0;
	public static double pago4 = 0;
	public static double cuota4 = 0;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentVender dialog = new VentVender();
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
	public VentVender() {
		setTitle("Vender");
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Modelo");
		lblNewLabel.setBounds(10, 15, 96, 14);
		getContentPane().add(lblNewLabel);
		
		cmbModelo = new JComboBox();
		cmbModelo.addActionListener(this);
		cmbModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cmbModelo.setBounds(116, 11, 359, 22);
		getContentPane().add(cmbModelo);
		
		btnVenderVV = new JButton("Vender");
		btnVenderVV.addActionListener(this);
		btnVenderVV.setBounds(485, 11, 89, 23);
		getContentPane().add(btnVenderVV);
		
		btnCerrarVV = new JButton("Cerrar");
		btnCerrarVV.addActionListener(this);
		btnCerrarVV.setBounds(485, 43, 89, 23);
		getContentPane().add(btnCerrarVV);
		
		txtPrecio = new JTextField();
		txtPrecio.addActionListener(this);
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(115, 44, 360, 20);
		getContentPane().add(txtPrecio);
		
		lblNewLabel_1 = new JLabel("Precio (S/)");
		lblNewLabel_1.setBounds(10, 47, 95, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Cantidad");
		lblNewLabel_2.setBounds(10, 78, 95, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(115, 75, 360, 20);
		getContentPane().add(txtCantidad);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 564, 138);
		getContentPane().add(scrollPane);
		
		txaBoleta = new JTextArea();
		scrollPane.setViewportView(txaBoleta);
		
		entradaDeDatos();
		consultarCocinas();

	}
	
	void entradaDeDatos() {
		modelo = cmbModelo.getSelectedIndex();  
	}
	
	void consultarCocinas() {
		switch (modelo) {
		case 0:
			txtPrecio.setText(String.valueOf(Tienda.precio0));
			
			break;
		case 1:
			txtPrecio.setText(String.valueOf(Tienda.precio1));
			
			break;
		case 2:
			txtPrecio.setText(String.valueOf(Tienda.precio2));
			
			break;
		case 3:
			txtPrecio.setText(String.valueOf(Tienda.precio3));
			
			break;
		case 4:
			txtPrecio.setText(String.valueOf(Tienda.precio4));
			
			break;
		default:
		
		}
	}
	
	public void actionPerformedBtnVenderVV(ActionEvent e) {
		int cantidad;
		double precio, total, dscto, pago, porcentajeCuota;
		String modeloStr, obsequio, msjBox;
		
		modelo = getModelo();
		modeloStr = getModeloStr();
		precio = getPrecio();
		cantidad = getCantidad();
		
		total = calcTotal(precio, cantidad);
		dscto = calcDscto(cantidad, total);
		pago = calcPago(total, dscto);
		obsequio = calcObsequio(cantidad);
		
		showResultados(modeloStr, precio, cantidad, total, dscto, pago, obsequio);
		
		Tienda.contador++; 
	    uso = Tienda.contador;
	    
	    sumaPagos += pago;
	    porcentajeCuota = (sumaPagos*100)/Tienda.cuotaDiaria;
	    
	    msjBox = "Venta Nro. " + uso + " \n" +
	    		"Importe total general acumulado: S/." + sumaPagos + "\n" +
	    		"Porcentaje cuota diaria: " + porcentajeCuota + "%";
		
		if (uso % 3 == 0) {
			JOptionPane.showMessageDialog(null, msjBox);
		}
		
		switch(modelo) {
			case 0:
				uso0++;
				cantVenta0 += cantidad;
				pago0 += pago;
				cuota0 = (pago0*100)/Tienda.cuotaDiaria;
				break;
			case 1:
				uso1++;
				cantVenta1 += cantidad;
				pago1 += pago;
				cuota1 = (pago1*100)/Tienda.cuotaDiaria;
				break;
			case 2:
				uso2++;
				cantVenta2 += cantidad;
				pago2 += pago;
				cuota2 = (pago2*100)/Tienda.cuotaDiaria;
				break;
			case 3:
				uso3++;
				cantVenta3 += cantidad;
				pago3 += pago;
				cuota3 = (pago3*100)/Tienda.cuotaDiaria;
				break;
			case 4:
				uso4++;
				cantVenta4 += cantidad;
				pago4 += pago;
				cuota4 = (pago4*100)/Tienda.cuotaDiaria;
				break;
			default:
				break;
		}
	}
	
	int getModelo() {
		return cmbModelo.getSelectedIndex();  
	}
	
	String getModeloStr() {
	    return (String) cmbModelo.getSelectedItem();
	}
	
	double getPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}

	int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	double calcTotal(double precio, int cantidad) {
		return precio * cantidad;
	}
	
	double calcDscto(int cantidad, double total) {
		if (cantidad >= 1 && cantidad < 6) {
			return total * Tienda.porcentaje1 * 0.01;
		} else if (cantidad >= 6 && cantidad < 11) {
			return total * Tienda.porcentaje2 * 0.01;
		} else if (cantidad >= 11 && cantidad < 16) {
			return total * Tienda.porcentaje3 * 0.01;
		} else if (cantidad >= 16) {
			return total * Tienda.porcentaje4 * 0.01;
		} else {
			return 0.0;
		}
	}
	
	double calcPago(double total, double dscto) {
		return total - dscto;
	}
	
	String calcObsequio(int cantidad) {
		if (cantidad == 1) {
			return Tienda.obsequio1;
		} else if (cantidad > 1 && cantidad <= 5) {
			return Tienda.obsequio2;
		} else if (cantidad > 5) {
			return Tienda.obsequio3;
		} else {
			return "No hay obsequio";
		}
	}
	
	void showResultados(String modeloStr, double precio, int cantidad, double total, double dscto, double pago, String obsequio) {
		txaBoleta.setText("");
		imprimir("BOLETA DE VENTA");
		imprimir("");
		imprimir("Modelo: " + modeloStr);
		imprimir("Precio: S/." + precio);
		imprimir("Cantidad: " + cantidad);
		imprimir("Importe compra: S/." + total);
		imprimir("Importe dscto: S/." + dscto);
		imprimir("Importe pagar: S/." + pago);
		imprimir("Obsequio: " + obsequio);
	}
	
	void imprimir(String cad) {
		txaBoleta.append(cad + "\n");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmbModelo) {
			actionPerformedCmbModelo(e);
		}
		
		if (e.getSource() == btnVenderVV) {
			actionPerformedBtnVenderVV(e);
		}
		if (e.getSource() == btnCerrarVV) {
			actionPerformedBtnCerrarVV(e);
		}
	}
	protected void actionPerformedBtnCerrarVV(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedCmbModelo(ActionEvent e) {
		entradaDeDatos();
		consultarCocinas();
	}
}
