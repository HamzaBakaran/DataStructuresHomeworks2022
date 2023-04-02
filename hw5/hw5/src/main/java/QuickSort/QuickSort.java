package QuickSort;

import java.util.Random;

import hw5.ibu.edu.ba.AbstractSort;

public class QuickSort extends AbstractSort {
    
    // Public sort method
    @SuppressWarnings("rawtypes")
	public static void sort(Comparable[] elements) {
        shuffle(elements);                              
        sort(elements, 0, elements.length - 1);         
    }
    
    // Knuth shuffle - ensure that the array is not sorted
    @SuppressWarnings("rawtypes")
	private static void shuffle(Comparable[] elements) {
        Random rand = new Random();                             
        for (int i = 0; i < elements.length; i++) {             
            int r = i + rand.nextInt(elements.length - i);      
            swap(elements, i, r);                               
        }
    }
    
    // Recursive sort method
    @SuppressWarnings("rawtypes")
	private static void sort(Comparable[] elements, int low, int high) {
        if (high <= low) {                              
            return;                                     
        }
        int j = partition(elements, low, high);         
        sort(elements, low, j - 1);                     
        sort(elements, j + 1, high);                    
    }
    
    // Partitioning and returning the pivot
    @SuppressWarnings("rawtypes")
	private static int partition(Comparable[] elements, int low, int high) {
        int i = low;                                            
        int j = high + 1;                                       
        while (true) {                                          
            while (less(elements[++i], elements[low])) {        
                if (i == high) {                                
                    break;                                      
                }
            }
            while (less(elements[low], elements[--j])) {        
                if (j == low) {                                 
                    break;                                      
                }
            }
            if (i >= j) {                                       
                break;                                         
            }
            swap(elements, i, j);                             
        }
        swap(elements, low, j);                                 
        return j;                                               
    }
}
