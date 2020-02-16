import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class MergeSort {


	/**
	 * @param datos
	 * @param left
	 * @param middle
	 * @param right
	 */
	void merge(int datos[], int left, int middle, int right) 
	{  
		// Busca el tamano de las dos partes a juntar
		int n1 = middle - left + 1; 
		int n2 = right - middle; 

		// Crea datos temporales
		int L[] = new int [n1]; 
		int R[] = new int [n2]; 

		// copia los datos a la variable temporal
		for (int i=0; i<n1; ++i) 
			L[i] = datos[left + i]; 
		for (int j=0; j<n2; ++j) 
			R[j] = datos[middle + 1+ j]; 


		int i = 0, j = 0; 


		int k = left; 
		while (i < n1 && j < n2) 
		{ 
			if (L[i] <= R[j]) 
			{ 
				datos[k] = L[i]; 
				i++; 
			} 
			else
			{ 
				datos[k] = R[j]; 
				j++; 
			} 
			k++; 
		} 

		// Copia los elementos restantes de L[] si hay
		while (i < n1) 
		{ 
			datos[k] = L[i]; 
			i++; 
			k++; 
		} 

		// Copia los elementos restantes de R[] si hay
		while (j < n2) 
		{ 
			datos[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 


	// Funcion que organiza los datos[left...right] usando el metodo merge()
	/**
	 * @param datos
	 * @param l
	 * @param r
	 */
	void sort(int datos[], int left, int right) 
	{ 
		if (left < right) 
		{ 
			// Find the middle point 
			int m = (left+right)/2; 

			// Sort first and second halves 
			sort(datos, left, m); 
			sort(datos , m+1, right); 

			// Merge the sorted halves 
			merge(datos, left, m, right); 
		} 
	} 


	/**
	 * @param datos
	 */

	// metodo principal que es llamado desde la main
	public void mergeSort(int datos[]) 
	{  
		// LLama al metodo sort
		sort(datos, 0, datos.length-1); 

		System.out.println("Merge Sort");
		System.out.println(Arrays.toString(datos));

		// Guarda los datos ordenados en un archivo de texto
		try {
			// Se crea el archivo donde se guardaran los numeros
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/MergeSortOrdenado.txt"));


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
