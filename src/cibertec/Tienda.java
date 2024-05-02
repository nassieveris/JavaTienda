package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class Tienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/* Datos mínimos del primera cocina*/
	public static String modelo0 = "Mabe EMP6120PG0";
	public static double precio0 = 949.0; 
	public static double fondo0 = 58.6; 
	public static double ancho0 = 60.0; 
	public static double alto0 = 91.0; 
	public static int quemadores0 = 4; 
	
	// Datos mínimos de la segunda cocina 
	public static String modelo1 = "Indurama Parma"; 
	public static double precio1 = 1089.0; 
	public static double ancho1 = 80.0; 
	public static double alto1 = 94.0;  
	public static double fondo1 = 67.5; 
	public static int quemadores1 = 6; 
	
	// Datos m�nimos de la tercera cocina 
	public static String modelo2 = "Sole COSOL027"; 
	public static double precio2 = 850.0; 
	public static double ancho2 = 60.0; 
	public static double alto2 = 90.0; 
	public static double fondo2 = 50.0; 
	public static int quemadores2 = 4; 
	
	// Datos m�nimos de la cuarta cocina 
	public static String modelo3 = "Coldex CX602"; 
	public static double precio3 = 629.0; 
	public static double ancho3 = 61.6; 
	public static double alto3 = 95.0; 
	public static double fondo3 = 51.5; 
	public static int quemadores3 = 5; 
	
	// Datos m�nimos de la quinta cocina 
	public static String modelo4 = "Reco Dakota"; 
	public static double precio4 = 849.0; 
	public static double ancho4 = 75.4; 
	public static double alto4 = 94.5; 
	public static double fondo4 = 66.0; 
	public static int quemadores4 = 5; 
	
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	
	// Cantidad �ptima de unidades vendidos
	public static int cantidadOptima = 30;
	
	// Cuota Diaria
	public static double cuotaDiaria = 75000;
			
	// Obsequio por cantidad m�nima de colchones adquiridos
	public static String obsequio1 = "Cafetera";
	public static String obsequio2 = "Licuadora";
	public static String obsequio3 = "Extractor";
	
	// N�mero de cliente que recibe el premio sorpresa
	public static int numeroClienteSorpresa = 5;
	
	public static int contador = 0;
	
	// Premio sorpresa
	public static String premioSorpresa = "Un polo";
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	private JMenu mnNewMenu_4;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	private JMenuItem mntmNewMenuItem_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 /**
	 * Create the frame.
	 */
	public Tienda() {
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 399);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.addActionListener(this);
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("Mantenimiento");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("Consultar cocina");
		mntmNewMenuItem_1.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem_2 = new JMenuItem("Modificar cocina");
		mntmNewMenuItem_2.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Listar cocinas");
		mntmNewMenuItem_3.addActionListener(this);
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		mnNewMenu_2 = new JMenu("Ventas");
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_4 = new JMenuItem("Vender");
		mntmNewMenuItem_4.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		mntmNewMenuItem_5 = new JMenuItem("Generar reportes");
		mntmNewMenuItem_5.addActionListener(this);
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		mnNewMenu_3 = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnNewMenu_3);
		
		mntmNewMenuItem_6 = new JMenuItem("Configurar descuentos");
		mntmNewMenuItem_6.addActionListener(this);
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		mntmNewMenuItem_7 = new JMenuItem("Configurar obsequios");
		mntmNewMenuItem_7.addActionListener(this);
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		mntmNewMenuItem_8 = new JMenuItem("Configurar cantidad \u00F3ptima");
		mntmNewMenuItem_8.addActionListener(this);
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		mntmNewMenuItem_9 = new JMenuItem("Configurar cuota diaria");
		mntmNewMenuItem_9.addActionListener(this);
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		mnNewMenu_4 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_4);
		
		mntmNewMenuItem_10 = new JMenuItem("Acerca de Tienda");
		mntmNewMenuItem_10.addActionListener(this);
		mnNewMenu_4.add(mntmNewMenuItem_10);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem_9) {
			actionPerformedMntmNewMenuItem_9(e);
		}
		if (e.getSource() == mntmNewMenuItem_8) {
			actionPerformedMntmNewMenuItem_8(e);
		}
		if (e.getSource() == mntmNewMenuItem_7) {
			actionPerformedMntmNewMenuItem_7(e);
		}
		if (e.getSource() == mntmNewMenuItem_6) {
			actionPerformedMntmNewMenuItem_6(e);
		}
		if (e.getSource() == mntmNewMenuItem_5) {
			actionPerformedMntmNewMenuItem_5(e);
		}
		if (e.getSource() == mntmNewMenuItem_4) {
			actionPerformedMntmNewMenuItem_4(e);
		}
		if (e.getSource() == mntmNewMenuItem_3) {
			actionPerformedMntmNewMenuItem_3(e);
		}
		if (e.getSource() == mntmNewMenuItem_2) {
			actionPerformedMntmNewMenuItem_2(e);
		}
		if (e.getSource() == mntmNewMenuItem_1) {
			actionPerformedMntmNewMenuItem_1(e);
		}
		if (e.getSource() == mntmNewMenuItem_10) {
			actionPerformedMntmNewMenuItem_10(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
		
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedMntmNewMenuItem_10(ActionEvent e) {
		//se crea copia
		AcercaDe d1= new AcercaDe();
		//para colocar en el centro del forulario
		d1.setLocationRelativeTo(this);
		// vara que sea visible en la pantalla
		d1.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_1(ActionEvent e) {
		MantConsultaCocina d2= new MantConsultaCocina();
		d2.setLocationRelativeTo(this);
		d2.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_2(ActionEvent e) {
		MantModificarCocina d3= new MantModificarCocina();
		d3.setLocationRelativeTo(this);
		d3.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_3(ActionEvent e) {
		MantListarCocinas d4= new MantListarCocinas();
		d4.setLocationRelativeTo(this);
		d4.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_4(ActionEvent e) {
		VentVender d5= new VentVender();
		d5.setLocationRelativeTo(this);
		d5.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_5(ActionEvent e) {
		VentGenerarReportes d6= new VentGenerarReportes();
		d6.setLocationRelativeTo(this);
		d6.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_6(ActionEvent e) {
		ConfConfigurarDescuentos d6= new ConfConfigurarDescuentos();
		d6.setLocationRelativeTo(this);
		d6.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_7(ActionEvent e) {
		ConfConfigurarObsequios d6= new ConfConfigurarObsequios();
		d6.setLocationRelativeTo(this);
		d6.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_8(ActionEvent e) {
		ConfConfigurarCantidadOptima d6= new ConfConfigurarCantidadOptima();
		d6.setLocationRelativeTo(this);
		d6.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem_9(ActionEvent e) {
		ConfConfigurarCuotaDiaria d6= new ConfConfigurarCuotaDiaria();
		d6.setLocationRelativeTo(this);
		d6.setVisible(true);
	}
}
