import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author edman
 *
 */
public class QuickSortMain {

	/**
	 * @param datos
	 */
	public static void quickS(int datos[]) {

		// Crea una instancia a la clase QuickSort
		QuickSort quickSort = new QuickSort(); 
		quickSort.sort(datos, 0, datos.length-1); 

		// Imprime en pantalla los datos ya ordenados
		System.out.println("Quick Sort");
		System.out.println(Arrays.toString(datos));

		// Guarda los datos ordenados en un archivo de texto
		try {
			// Se crea el archivo donde se guardaran los numeros
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/QuickSortOrdenado.txt"));


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
