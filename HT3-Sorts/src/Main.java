import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.awt.event.ActionEvent;

/**
 * @author edman
 *
 */
public class Main {

	private JFrame frame;
	private JLabel test;
	private JLabel lblCantidadLeido;

	// Indica la cantidad de numeros a generar
	int cantidadNumeros = 3000;
	
	private int datos[];
	private JLabel lblSelection;
	private JLabel lblBubble;
	private JLabel lblRadix;
	private JLabel lblQuick;
	private JLabel lblMerge;
	private JLabel lblDatosGuardos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Arreglo 
		datos = new int[cantidadNumeros];
		
		frame = new JFrame();
		frame.setSize(900, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, "name_533044160101900");
		panel.setLayout(null);
		
		JLabel lblAlgoritmosSort = new JLabel("Algoritmos Sort");
		lblAlgoritmosSort.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAlgoritmosSort.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlgoritmosSort.setBounds(10, 11, 826, 32);
		panel.add(lblAlgoritmosSort);
		
		JLabel lblGenerarNumeros = new JLabel("Leer de archivo");
		lblGenerarNumeros.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerarNumeros.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGenerarNumeros.setBounds(0, 156, 846, 26);
		panel.add(lblGenerarNumeros);
		
		JLabel label = new JLabel("Generar 3000 numeros aleatorios");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(10, 54, 826, 26);
		panel.add(label);
		
		JButton button = new JButton("Generar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					// Se crea el archivo donde se guardaran los numeros
					BufferedWriter writer = new BufferedWriter(new FileWriter("src/numeros.txt"));
					
					
					// Se generan los numeros aleatorios y se guardan en una posicion distinta a otras
					for(int i = 0; i < cantidadNumeros; i++) {
						int randomNumbers = (int)(Math.random()*((100-1) + 1)) + 1;
						writer.write(Integer.toString(randomNumbers)+"\n");
						test.setText(cantidadNumeros + " numeros generados exitosamente!");
					}
					writer.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.PLAIN, 14));
		button.setBorder(null);
		button.setBackground(new Color(0, 153, 204));
		button.setBounds(355, 96, 136, 30);
		panel.add(button);
		
		JButton btnNumeros = new JButton("Leer ahora");
		btnNumeros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = 0;
				
				try {
					// Busca y carga el archivo datos.txt donde se guardan los datos.
					BufferedReader in = new BufferedReader(new FileReader("src/numeros.txt"));
					
					// Variable para guardar uno a uno los datos sacados del txt
					String numero;
					
					// Corre mientras hay datos para leer
					while((numero = in.readLine()) != null)
					{ 
						datos[index] = Integer.parseInt(numero);
						
						index++;
					}
					
					for(int j = 0; j<datos.length; j++) {
						System.out.println(datos[j]);
					}
					
					lblCantidadLeido.setText("Leidos exitosamente");
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNumeros.setForeground(Color.WHITE);
		btnNumeros.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNumeros.setBorder(null);
		btnNumeros.setBackground(new Color(0, 153, 204));
		btnNumeros.setBounds(355, 190, 136, 30);
		panel.add(btnNumeros);
		
		test = new JLabel("");
		test.setForeground(new Color(0, 204, 102));
		test.setFont(new Font("Arial", Font.PLAIN, 14));
		test.setBounds(519, 94, 294, 32);
		panel.add(test);
		
		lblCantidadLeido = new JLabel("");
		lblCantidadLeido.setForeground(new Color(0, 204, 102));
		lblCantidadLeido.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCantidadLeido.setBounds(519, 190, 317, 30);
		panel.add(lblCantidadLeido);
		
		JLabel lblOrganizar = new JLabel("Organizar");
		lblOrganizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrganizar.setFont(new Font("Arial", Font.PLAIN, 14));
		lblOrganizar.setBounds(0, 286, 846, 26);
		panel.add(lblOrganizar);
		
		JButton btnOrganizar = new JButton("Organizar");
		btnOrganizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Selection Sort
				SelectionSort selectionSort = new SelectionSort();
				selectionSort.selectionSort(datos);
				lblSelection.setText("Selection Sort ordenado exitosamente");
				
				// Merge Sort
				MergeSort mergeSort = new MergeSort();
				mergeSort.mergeSort(datos);
				lblMerge.setText("Merge Sort ordenado exitosamente");
				
				// Quick Sort
				QuickSortMain sortMain = new QuickSortMain();
				sortMain.quickS(datos);
				lblQuick.setText("Quick Sort ordenado exitosamente");
				
				// Radix Sort
				RadixSort radix = new RadixSort();
				radix.radixSort(datos);
				lblRadix.setText("Radix Sort ordenado exitosamente");
				
				// Bubble Sort
				BubbleSort bubbleSort = new BubbleSort();
				bubbleSort.bubble(datos);
				lblBubble.setText("Bubble Sort ordenado exitosamente");
				
				lblDatosGuardos.setText("Datos guardos en archivos txt");
				
			}
		});
		btnOrganizar.setForeground(Color.WHITE);
		btnOrganizar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnOrganizar.setBorder(null);
		btnOrganizar.setBackground(new Color(0, 153, 204));
		btnOrganizar.setBounds(355, 323, 136, 30);
		panel.add(btnOrganizar);
		
		lblSelection = new JLabel("");
		lblSelection.setForeground(new Color(0, 204, 102));
		lblSelection.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSelection.setBounds(519, 323, 294, 30);
		panel.add(lblSelection);
		
		lblMerge = new JLabel("");
		lblMerge.setForeground(new Color(0, 204, 102));
		lblMerge.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMerge.setBounds(519, 356, 294, 30);
		panel.add(lblMerge);
		
		lblQuick = new JLabel("");
		lblQuick.setForeground(new Color(0, 204, 102));
		lblQuick.setFont(new Font("Arial", Font.PLAIN, 14));
		lblQuick.setBounds(519, 388, 294, 30);
		panel.add(lblQuick);
		
		lblRadix = new JLabel("");
		lblRadix.setForeground(new Color(0, 204, 102));
		lblRadix.setFont(new Font("Arial", Font.PLAIN, 14));
		lblRadix.setBounds(519, 419, 294, 30);
		panel.add(lblRadix);
		
		lblBubble = new JLabel("");
		lblBubble.setForeground(new Color(0, 204, 102));
		lblBubble.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBubble.setBounds(519, 448, 294, 30);
		panel.add(lblBubble);
		
		JLabel label_1 = new JLabel("1");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(257, 96, 46, 30);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("2");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_2.setBounds(257, 190, 46, 30);
		panel.add(label_2);
		
		lblDatosGuardos = new JLabel("");
		lblDatosGuardos.setForeground(Color.GREEN);
		lblDatosGuardos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosGuardos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatosGuardos.setBounds(10, 500, 864, 30);
		panel.add(lblDatosGuardos);
		
		JLabel label_4 = new JLabel("3");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_4.setBounds(257, 323, 46, 30);
		panel.add(label_4);
		
		
	}
}
