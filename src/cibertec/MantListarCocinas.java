package cibertec;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class MantListarCocinas extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextArea txaListar;
	private JButton btnCerrarMLC;
	private JButton btnListarMLC;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantListarCocinas dialog = new MantListarCocinas();
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
	public MantListarCocinas() {
		setTitle("Listar Cocinas");
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(null);
		
		btnCerrarMLC = new JButton("Cerrar");
		btnCerrarMLC.addActionListener(this);
		btnCerrarMLC.setBounds(205, 227, 89, 23);
		getContentPane().add(btnCerrarMLC);
		
		btnListarMLC = new JButton("Listar");
		btnListarMLC.addActionListener(this);
		btnListarMLC.setBounds(304, 227, 89, 23);
		getContentPane().add(btnListarMLC);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 564, 209);
		getContentPane().add(scrollPane_1);
		
		txaListar = new JTextArea();
		scrollPane_1.setViewportView(txaListar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListarMLC) {
			actionPerformedBtnListarMLC(e);
		}
		if (e.getSource() == btnCerrarMLC) {
			actionPerformedBtnCerrarMLC(e);
		}
	}
	protected void actionPerformedBtnCerrarMLC(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnListarMLC(ActionEvent e) {
		txaListar.setText("");
		txaListar.append("LISTADO DE COCINAS \n\n");
		
		txaListar.append("Modelo     : " + Tienda.modelo0 + "\n");
		txaListar.append("Precio     : " + Tienda.precio0 + "\n");
		txaListar.append("Profundidad: " + Tienda.fondo0 + "\n");
		txaListar.append("Ancho      : " + Tienda.ancho0 + "\n");
		txaListar.append("Alto       : " + Tienda.alto0 + "\n");
		txaListar.append("Quemadores : " + Tienda.quemadores0 + "\n\n");
		
		txaListar.append("Modelo		: " + Tienda.modelo1 + "\n");
		txaListar.append("Precio		: " + Tienda.precio1 + "\n");
		txaListar.append("Profundidad	: " + Tienda.fondo1 + "\n");
		txaListar.append("Ancho			: " + Tienda.ancho1 + "\n");
		txaListar.append("Alto			: " + Tienda.alto1 + "\n");
		txaListar.append("Quemadores	: " + Tienda.quemadores1 + "\n\n");
		
		txaListar.append("Modelo		: " + Tienda.modelo2 + "\n");
		txaListar.append("Precio		: " + Tienda.precio2 + "\n");
		txaListar.append("Profundidad	: " + Tienda.fondo2 + "\n");
		txaListar.append("Ancho			: " + Tienda.ancho2 + "\n");
		txaListar.append("Alto			: " + Tienda.alto2 + "\n");
		txaListar.append("Quemadores	: " + Tienda.quemadores2 + "\n\n");
		
		txaListar.append("Modelo		: " + Tienda.modelo3 + "\n");
		txaListar.append("Precio		: " + Tienda.precio3 + "\n");
		txaListar.append("Profundidad	: " + Tienda.fondo3 + "\n");
		txaListar.append("Ancho			: " + Tienda.ancho3 + "\n");
		txaListar.append("Alto			: " + Tienda.alto3 + "\n");
		txaListar.append("Quemadores	: " + Tienda.quemadores3 + "\n\n");
		
		txaListar.append("Modelo		: " + Tienda.modelo4 + "\n");
		txaListar.append("Precio		: " + Tienda.precio4 + "\n");
		txaListar.append("Profundidad	: " + Tienda.fondo4 + "\n");
		txaListar.append("Ancho			: " + Tienda.ancho4 + "\n");
		txaListar.append("Alto			: " + Tienda.alto4 + "\n");
		txaListar.append("Quemadores	: " + Tienda.quemadores4);
	}
}
