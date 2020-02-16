import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


/**
 * @author edman
 *
 */
public class RadixSort {

	/**
	 * @param datos
	 * @param n
	 * @return
	 */
	static int getMax(int datos[], int n) 
	{ 
		int mx = datos[0]; 
		for (int i = 1; i < n; i++) 
			if (datos[i] > mx) 
				mx = datos[i]; 
		return mx; 
	} 

	/**
	 * @param datos
	 * @param n
	 * @param exp
	 */
	static void countSort(int datos[], int n, int exp) 
	{ 
		int output[] = new int[n]; // output 
		int i; 
		int count[] = new int[10]; 
		Arrays.fill(count,0); 

		// Guarda los valores de count en count[]
		for (i = 0; i < n; i++) 
			count[ (datos[i]/exp)%10 ]++; 

		// Cambia count[i] para que count[i] ahora contenga
		// la posicion actual de los digitos de salida
		for (i = 1; i < 10; i++) 
			count[i] += count[i - 1]; 

		// Construye los resultados
		for (i = n - 1; i >= 0; i--) 
		{ 
			output[count[ (datos[i]/exp)%10 ] - 1] = datos[i]; 
			count[ (datos[i]/exp)%10 ]--; 
		} 

		// Copia los datos al arreglo datos[], para que ahora el arreglo datos[]
		// contenga los numeros ordenados de acuerdo a sus digitos
		for (i = 0; i < n; i++) 
			datos[i] = output[i]; 
	} 


	/**
	 * @param datos
	 * @param n
	 */
	static void radixsort(int datos[], int n) 
	{ 

		// Encuentra el numero mas grande para saber el numero de los digitos
		int m = getMax(datos, n); 

		for (int exp = 1; m/exp > 0; exp *= 10) 
			countSort(datos, n, exp); 
	} 

	// Metodo principal, llamdo desde la clase main
	public void radixSort (int datos[]) 
	{ 
		// LLama al metodo radixsort
		radixsort(datos, datos.length); 

		// Imprime en consola los datos ya ordenados
		System.out.println("Radix Sort");
		System.out.println(Arrays.toString(datos));

		// Guarda los datos ordenados en un archivo de texto
		try {
			// Se crea el archivo donde se guardaran los numeros
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/RadixSortOrdenado.txt"));


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
