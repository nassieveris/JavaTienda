package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class VentGenerarReportes extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblTipoDeReporte;
	private JComboBox cmbReporte;
	private JButton btnCerrarVGR;
	private JTextArea txaBoleta;
	private JScrollPane scrollPane;
	
	DecimalFormat df = new DecimalFormat("#.##");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentGenerarReportes dialog = new VentGenerarReportes();
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
	public VentGenerarReportes() {
		setTitle("Generar Reportes");
		setBounds(100, 100, 621, 400);
		getContentPane().setLayout(null);
		
		lblTipoDeReporte = new JLabel("Tipo de Reporte");
		lblTipoDeReporte.setBounds(10, 15, 103, 14);
		getContentPane().add(lblTipoDeReporte);
		
		cmbReporte = new JComboBox();
		cmbReporte.addActionListener(this);
		cmbReporte.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Ventas en relación a la venta óptima", "Precios en relación al precio promedio", "Promedios, mayores y menores"}));
		cmbReporte.setBounds(123, 11, 359, 22);
		getContentPane().add(cmbReporte);
		
		btnCerrarVGR = new JButton("Cerrar");
		btnCerrarVGR.addActionListener(this);
		btnCerrarVGR.setBounds(506, 11, 89, 23);
		getContentPane().add(btnCerrarVGR);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 585, 310);
		getContentPane().add(scrollPane);
		
		txaBoleta = new JTextArea();
		scrollPane.setViewportView(txaBoleta);
		
		actionPerformedCmbReporte(new ActionEvent(cmbReporte, ActionEvent.ACTION_PERFORMED, null));

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmbReporte) {
			actionPerformedCmbReporte(e);
		}
		if (e.getSource() == btnCerrarVGR) {
			actionPerformedBtnCerrarVGR(e);
		}
	}
	protected void actionPerformedBtnCerrarVGR(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedCmbReporte(ActionEvent e) {
		int reporte;
		String obtReporte;
		reporte = getReporte();
		obtReporte = obtenerReporte(reporte);
		showResultados(obtReporte);
	}
	
	int getReporte() {
		return cmbReporte.getSelectedIndex();  
	}
	
	String case00() {
	    String resultado = "VENTAS POR MODELO \n";
	    
	    resultado += "\n" + generarReporte00(Tienda.modelo0, VentVender.uso0, VentVender.cantVenta0, VentVender.pago0, VentVender.cuota0);
	    resultado += "\n" + generarReporte00(Tienda.modelo1, VentVender.uso1, VentVender.cantVenta1, VentVender.pago1, VentVender.cuota1);
	    resultado += "\n" + generarReporte00(Tienda.modelo2, VentVender.uso2, VentVender.cantVenta2, VentVender.pago2, VentVender.cuota2);
	    resultado += "\n" + generarReporte00(Tienda.modelo3, VentVender.uso3, VentVender.cantVenta3, VentVender.pago3, VentVender.cuota3);
	    resultado += "\n" + generarReporte00(Tienda.modelo4, VentVender.uso4, VentVender.cantVenta4, VentVender.pago4, VentVender.cuota4);

	    return resultado;
	}

	String generarReporte00(String modelo, int uso, int cantVenta, double pago, double cuota) {
	    String modeloFormat = String.format("%-30s", "Modelo");
	    String usoFormat = String.format("%-30s", "Cantidad de ventas");
	    String cantVentaFormat = String.format("%-30s", "Cantidad de unidades vendidas");
	    String pagoFormat = String.format("%-30s", "Importe total vendido");
	    String cuotaFormat = String.format("%-30s", "Aporte a la cuota diaria");
	    return modeloFormat + ": " + modelo + "\n" +
	           usoFormat + ": " + uso + "\n" +
	           cantVentaFormat + ": " + cantVenta + "\n" +
	           pagoFormat + ": S/." + df.format(pago) + "\n" + 
	    	   cuotaFormat + ": " + df.format(cuota) + "% \n";
	}
	
	String case01() { 
	    String resultado = "VENTAS EN RELACIÓN A LA VENTA ÓPTIMA \n";
	    
	    int cantOptima = Tienda.cantidadOptima;
	    
	    int cantVenta0 = VentVender.cantVenta0;
	    int cantVenta1 = VentVender.cantVenta1;
	    int cantVenta2 = VentVender.cantVenta2;
	    int cantVenta3 = VentVender.cantVenta3;
	    int cantVenta4 = VentVender.cantVenta4;

	    String modelo0 = Tienda.modelo0;
	    String modelo1 = Tienda.modelo1;
	    String modelo2 = Tienda.modelo2;
	    String modelo3 = Tienda.modelo3;
	    String modelo4 = Tienda.modelo4;

	    resultado += "\n" + generarReporte01(modelo0, cantVenta0, cantOptima);
	    resultado += "\n" + generarReporte01(modelo1, cantVenta1, cantOptima);
	    resultado += "\n" + generarReporte01(modelo2, cantVenta2, cantOptima);
	    resultado += "\n" + generarReporte01(modelo3, cantVenta3, cantOptima);
	    resultado += "\n" + generarReporte01(modelo4, cantVenta4, cantOptima);

	    return resultado;
	}
	
	String generarReporte01(String modelo, int cantVenta, int cantOptima) {
	    int diferencia = cantVenta - cantOptima;
	    String estado;
	    if (diferencia > 0) {
	        estado = diferencia + " más";
	    } else if (diferencia < 0) {
	        estado = Math.abs(diferencia) + " menos";
	    } else {
	        estado = "igual";
	    }
	    String modeloFormat = String.format("%-30s", "Modelo");
	    String cantVentaFormat = String.format("%-30s", "Cantidad de unidades vendidas");
	    return 
	    		modeloFormat + ": " + modelo + "\n" +
	    		cantVentaFormat + ": " + cantVenta + " (" + estado + " que la cantidad óptima) \n";
	}
	
	String case02() {
		double precioPromedio = (Tienda.precio0 + Tienda.precio1 + Tienda.precio2 + Tienda.precio3 + Tienda.precio4) / 5;
		String comparacion0, comparacion1, comparacion2, comparacion3, comparacion4;
		String resultado = "PRECIOS EN RELACIÓN AL PRECIO PROMEDIO \n";
		
		if (Tienda.precio0 > precioPromedio) {
            comparacion0 = "Mayor al promedio";
        } else if (Tienda.precio0 < precioPromedio) {
            comparacion0 = "Menor al promedio";
        } else {
            comparacion0 = "Igual al promedio";
        }
		if (Tienda.precio1 > precioPromedio) {
            comparacion1 = "Mayor al promedio";
        } else if (Tienda.precio1 < precioPromedio) {
            comparacion1 = "Menor al promedio";
        } else {
            comparacion1 = "Igual al promedio";
        }
		if (Tienda.precio2 > precioPromedio) {
            comparacion2 = "Mayor al promedio";
        } else if (Tienda.precio2 < precioPromedio) {
            comparacion2 = "Menor al promedio";
        } else {
            comparacion2 = "Igual al promedio";
        }
		if (Tienda.precio3 > precioPromedio) {
            comparacion3 = "Mayor al promedio";
        } else if (Tienda.precio3 < precioPromedio) {
            comparacion3 = "Menor al promedio";
        } else {
            comparacion3 = "Igual al promedio";
        }
		if (Tienda.precio4 > precioPromedio) {
            comparacion4 = "Mayor al promedio";
        } else if (Tienda.precio4 < precioPromedio) {
            comparacion4 = "Menor al promedio";
        } else {
            comparacion4 = "Igual al promedio";
        }
		
	    
	    resultado += "\n" + generarReporte02(Tienda.modelo0, Tienda.precio0, comparacion0) + "\n";
	    resultado += "\n" + generarReporte02(Tienda.modelo1, Tienda.precio1, comparacion1) + "\n";
	    resultado += "\n" + generarReporte02(Tienda.modelo2, Tienda.precio2, comparacion2) + "\n";
	    resultado += "\n" + generarReporte02(Tienda.modelo3, Tienda.precio3, comparacion3) + "\n";
	    resultado += "\n" + generarReporte02(Tienda.modelo4, Tienda.precio4, comparacion4);

	    return resultado; 
	}
	
	String generarReporte02(String modelo, double precio, String comparacion) {
	    String modeloFormat = String.format("%-10s", "Modelo");
	    String precioFormat = String.format("%-10s", "Precio");
	    return modeloFormat + ": " + modelo + "\n" +
	           precioFormat + ": S/." + precio + " (" + comparacion + ")";
	}
	
	String case03() { 
	    double precioPromedio = (Tienda.precio0 + Tienda.precio1 + Tienda.precio2 + Tienda.precio3 + Tienda.precio4) / 5;
	    double precioMayor = Math.max(Tienda.precio0, Math.max(Tienda.precio1, Math.max(Tienda.precio2, Math.max(Tienda.precio3, Tienda.precio4))));
	    double precioMenor = Math.min(Tienda.precio0, Math.min(Tienda.precio1, Math.min(Tienda.precio2, Math.min(Tienda.precio3, Tienda.precio4))));
	    
	    double anchoPromedio = (Tienda.ancho0 + Tienda.ancho1 + Tienda.ancho2 + Tienda.ancho3 + Tienda.ancho4) / 5;
	    double anchoMayor = Math.max(Tienda.ancho0, Math.max(Tienda.ancho1, Math.max(Tienda.ancho2, Math.max(Tienda.ancho3, Tienda.ancho4))));
	    double anchoMenor = Math.min(Tienda.ancho0, Math.min(Tienda.ancho1, Math.min(Tienda.ancho2, Math.min(Tienda.ancho3, Tienda.ancho4))));
	    
	    double altoPromedio = (Tienda.alto0 + Tienda.alto1 + Tienda.alto2 + Tienda.alto3 + Tienda.alto4) / 5;
	    double altoMayor = Math.max(Tienda.alto0, Math.max(Tienda.alto1, Math.max(Tienda.alto2, Math.max(Tienda.alto3, Tienda.alto4))));
	    double altoMenor = Math.min(Tienda.alto0, Math.min(Tienda.alto1, Math.min(Tienda.alto2, Math.min(Tienda.alto3, Tienda.alto4))));
	    
	    double fondoPromedio = (Tienda.fondo0 + Tienda.fondo1 + Tienda.fondo2 + Tienda.fondo3 + Tienda.fondo4) / 5;
	    double fondoMayor = Math.max(Tienda.fondo0, Math.max(Tienda.fondo1, Math.max(Tienda.fondo2, Math.max(Tienda.fondo3, Tienda.fondo4))));
	    double fondoMenor = Math.min(Tienda.fondo0, Math.min(Tienda.fondo1, Math.min(Tienda.fondo2, Math.min(Tienda.fondo3, Tienda.fondo4))));
	    
	    String resultado = "PROMEDIOS, MENORES Y MAYORES \n";
	    
	    resultado += "\n" + generarReporte03("Precio promedio", "S/." + df.format(precioPromedio));
	    resultado += generarReporte03("Precio mayor", "S/." + df.format(precioMayor));
	    resultado += generarReporte03("Precio menor", "S/." + df.format(precioMenor)) + "\n";
	    resultado += generarReporte03("Ancho promedio", df.format(anchoPromedio) + " cm");
	    resultado += generarReporte03("Ancho mayor", df.format(anchoMayor) + " cm");
	    resultado += generarReporte03("Ancho menor", df.format(anchoMenor) + " cm") + "\n";
	    resultado += generarReporte03("Alto promedio", df.format(altoPromedio) + " cm");
	    resultado += generarReporte03("Alto mayor", df.format(altoMayor) + " cm");
	    resultado += generarReporte03("Alto menor", df.format(altoMenor) + " cm") + "\n";
	    resultado += generarReporte03("Fondo promedio", df.format(fondoPromedio) + " cm");
	    resultado += generarReporte03("Fondo mayor", df.format(fondoMayor) + " cm");
	    resultado += generarReporte03("Fondo menor", df.format(fondoMenor) + " cm");

	    return resultado;  
	}
	
	String generarReporte03(String descriptor, String valor) {
	    String descriptorFormat = String.format("%-30s", descriptor);
	    return descriptorFormat + ": " + valor + "\n";
	} 
	
	String obtenerReporte(int reporte) {
		switch(reporte) {
			case 0:
				return case00();
			case 1:
				return case01();
			case 2:
				return case02();
			case 3:
				return case03();
			default:
				return "No hay nada";
		}
	}
	
	void imprimir(String cad) {
		txaBoleta.append(cad + "\n");
	}
	
	void showResultados (String obtReporte) {
		txaBoleta.setText(""); 
		imprimir("" + obtReporte);
	}
}

