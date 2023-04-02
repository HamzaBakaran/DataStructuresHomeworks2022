package hw6.RadixSort;

import hw6.IPAddress;

public class RadixSort {

	//Public sort method invoking radix sort
	public static void sort(IPAddress[] elements) {
		long max = getMax(elements);							
		
		for (int exp = 1; max / exp > 0; exp *= 10) {		
			sort(elements, exp);							
		}
	}

	//Private sort method implementing digit-wise radix sort
	private static void sort(IPAddress[] elements, int exp) {
		IPAddress[] aux = new IPAddress[elements.length];					
		int[] frequency = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};		
		
		for (int i = 0; i < elements.length; i++) {				
			int digit = (int) ((elements[i].getIpFrom() / exp) % 10);				
			frequency[digit]++;									
		}
		
		for (int i = 1; i < 10; i++) {						
			frequency[i] += frequency[i - 1];					
		}
		
		for (int i = elements.length - 1; i >= 0; i--) {		
			int digit = (int) ((elements[i].getIpFrom() / exp) % 10);				
			aux[frequency[digit] - 1] = elements[i];			
			frequency[digit]--;									
		}
		
		for (int i= 0; i < elements.length; i++) {				
			elements[i] = aux[i];							
		}
	}
	
		//Method that finds maximum element
		private static long getMax(IPAddress[] elements) {
			long max = elements[0].getIpFrom();						
			for (int i = 1; i < elements.length; i++) {		
				if (elements[i].getIpFrom() > max) {				
					max = elements[i].getIpFrom();				
				}
			}
			return max;										
		}
}
