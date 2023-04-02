package homework7.heapSort;

import homework7.IPAddress;
import homework7.heapSort.BinaryHeap;

public class HeapSort {
	
	public static void sort(IPAddress [] elements) {
		BinaryHeap<IPAddress> heap = new BinaryHeap<IPAddress>();
		
		for (int i = 0; i < elements.length; i++) {				
			heap.insert(elements[i]);							
		}
		
		for (int i = elements.length - 1; i >= 0; i--) {		
			elements[i] = heap.delMax();						
		}
	}
}