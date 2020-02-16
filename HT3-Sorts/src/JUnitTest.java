import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTest {
	
	SelectionSort selectionSort = new SelectionSort();
	MergeSort mergeSort = new MergeSort();
	QuickSortMain quickSort = new QuickSortMain();
	RadixSort radixSort = new RadixSort();
	BubbleSort bubbleSort = new BubbleSort();
	
	int[] datos = new int[3000];
	
	@Test
	public void SelectionSortTest() {
		
		// Verificar si el metodo existe y funciona
		boolean metodoFunciona =false;
		boolean expected = true;
		
		try {
			selectionSort.selectionSort(datos);
			metodoFunciona = true;
		}catch(NoSuchMethodError e) {
			fail();
		}
		
		assertEquals(metodoFunciona, expected);
		
		
	}
	
	@Test
	public void MergeSortTest() {
		
		// Verificar si el metodo existe y funciona
		boolean metodoFunciona =false;
		boolean expected = true;
		
		try {
			mergeSort.mergeSort(datos);
			metodoFunciona = true;
		}catch(NoSuchMethodError e) {
			fail();
		}
		
		assertEquals(metodoFunciona, expected);
	}
	
	@Test
	public void QuickSortTest() {
		
		// Verificar si el metodo existe y funciona
		boolean metodoFunciona =false;
		boolean expected = true;
		
		try {
			quickSort.quickS(datos);
			metodoFunciona = true;
		}catch(NoSuchMethodError e) {
			fail();
		}
		
		assertEquals(metodoFunciona, expected);
	}
	
	@Test
	public void RadixSortTest() {
		
		// Verificar si el metodo existe y funciona
		boolean metodoFunciona =false;
		boolean expected = true;
		
		try {
			radixSort.radixSort(datos);
			metodoFunciona = true;
		}catch(NoSuchMethodError e) {
			fail();
		}
		
		assertEquals(metodoFunciona, expected);
	}
	
	@Test
	public void BubbleSortTest() {
		
		// Verificar si el metodo existe y funciona
		boolean metodoFunciona =false;
		boolean expected = true;
		
		try {
			bubbleSort.bubble(datos);
			metodoFunciona = true;
		}catch(NoSuchMethodError e) {
			fail();
		}
		
		assertEquals(metodoFunciona, expected);
		
	}

}
