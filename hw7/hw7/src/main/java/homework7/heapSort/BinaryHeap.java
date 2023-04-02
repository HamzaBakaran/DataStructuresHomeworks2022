package homework7.heapSort;

public class BinaryHeap<Item extends Comparable<Item>> {
	
	@SuppressWarnings({ "unchecked" })
	public Item[] pq = (Item[]) new Comparable[2];
	public int length = 0;
	
	//inserting an element into heap
	public void insert(Item data) {
		if (pq.length == length + 1) {		//checking if resize is needed	
			resize(2 * pq.length);				
		}
		pq[++length] = data;					
		swim(length);							
	}
	
	//used for promotion
	private void swim(int k) {
		while (k > 1 && less(k/2, k)) {		
			swap(k, k/2);					
			k = k/2;						
		}
	}
	
	//removing the maximum item (root)
	public Item delMax() {
		Item max = pq[1];								
		swap(1, length--);					
		pq[length + 1] = null;							
		  
		if (length > 0 && length == pq.length / 4) {	//checking if resize is needed
			resize(pq.length / 2);			  			
		}
		
		sink(1);									
		return max;										
	}
	
	//used for demotion
	private void sink(int k) { 
		while (2*k <= length) {					
			int j = 2 * k;							
			if (j < length && less(j, j + 1)) {		
				j++;					
			}
			
			if (!less(k, j)) {						
				break;						
			}
			
			swap(k, j);							
			k = j;									
		}
	}
	
	//used for resizing array implementation
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		Item[] copy = (Item[]) new Comparable[capacity];		
		for (int i = 1; i <= length; i++) {					
			copy[i] = pq[i];								
		}												
		pq = copy;											
	}
	
	//check which element is less than the other
	private boolean less(int a, int b) {
		return pq[a].compareTo(pq[b]) < 0;
	}
	
	//swap two given elements
	private void swap(int a, int b) {
		Item temp = pq[a];
		pq[a] = pq[b];
		pq[b] = temp;
	}
	
}

