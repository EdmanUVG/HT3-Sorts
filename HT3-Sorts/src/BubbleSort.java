import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author edman
 *
 */
public class BubbleSort {


	/**
	 * @param data
	 * @param n
	 */
	static void bubbleSort(int data[], int n) 
	{ 
		// Se crean los variables
		int i, j, temp; 
		boolean swapped; // Verifica si ya fue cambiado de posicion
		for (i = 0; i < n - 1; i++)  
		{ 
			swapped = false; 
			for (j = 0; j < n - i - 1; j++)  
			{ 
				if (data[j] > data[j + 1])  
				{ 
					// Cambia data[j] con data[j+1] 
					temp = data[j]; 
					data[j] = data[j + 1]; 
					data[j + 1] = temp; 
					swapped = true; 
				} 
			} 

			// Si no hay dos numeros
			// Intercambia por el ciclo interno, luego usa break
			if (swapped == false) 
				break; 
		} 
	} 


	// La clase main de la clase
	/**
	 * @param datos
	 */
	public void bubble(int datos[]) 
	{ 

		// LLama al metodo bubbleSort
		bubbleSort(datos, datos.length); 

		// Imprime en pantalla los datos ordenados
		System.out.println("Bubble Sort");
		System.out.println(Arrays.toString(datos));

		// Guarda los datos ordenados en un archivo de texto
		try {
			// Se crea el archivo donde se guardaran los numeros
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/BubbleSortOrdenado.txt"));


			// Se generan los numeros aleatorios y se guardan en una posicion distinta a otras
			for(int i = 0; i < datos.length; i++) {
				writer.write(Integer.toString(datos[i]));
				writer.newLine();
			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
