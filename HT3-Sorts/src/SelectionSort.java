import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author edman
 *
 */
public class SelectionSort {
	
	/**
	 * @param data
	 */
	public static void selectionSort(int data[]) {
		
		int dataLength = data.length;
		
		for(int i = 0; i < dataLength; i++) {
			int min = i;
			
			for(int j = i + 1; j  < dataLength; j++) {
				if(data[j] < data[min]) {
					min = j;
				}
			}
			
			int temp = data[i];
			data[i] = data[min];
			data[min] = temp;
		}
		
		System.out.println("Selection Sort");
		System.out.println(Arrays.toString(data));
		
		// Guarda los datos ordenados en un archivo de texto
		try {
			// Se crea el archivo donde se guardaran los numeros
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/SelectionSortOrdenado.txt"));
			
			
			// Se generan los numeros aleatorios y se guardan en una posicion distinta a otras
			for(int i = 0; i < data.length; i++) {
				writer.write(Integer.toString(data[i]));
				writer.newLine();
			}
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
				
	}
}
