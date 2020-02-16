import java.util.Arrays;


/**
 * @author edman
 *
 */
public class QuickSort {
	
	/**
	 * @param data
	 * @param low
	 * @param high
	 * @return
	 */
	int partition(int data[], int low, int high) {
		
		int pivot = data[high];
		int i = (low-1);  // Indice del elemento mas bajo
		
		for(int j = low; j < high; j++) {
			
			// Si el elemento actual es mas pequeno que el pivote
			if(data[j] < pivot) {
				i++;
				
				// Cambiar data[i] y data[j]
				int temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			}
		}
		
		// Cambiar data[i+1] y data[high] (o pivote)
		int temp = data[i+1];
		data[i+1] = data[high];
		data[high] = temp;
		
		return i+1;
	}
	
	
	void sort(int data[], int low, int high) {
		if(low < high) {
			int pi = partition(data, low, high);
			
			sort(data, low, pi-1);
			sort(data, pi+1, high);
			
		}
	}
}






















