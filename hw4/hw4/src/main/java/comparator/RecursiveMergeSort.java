package comparator;

import java.util.Comparator;

import ibu.edu.hw4.AbstractSort;

//modified RecursiveMergeSort class from hw5.recursiveMerge in order to utilize Comparator and sort by city name
public class RecursiveMergeSort extends AbstractSort {
    
    @SuppressWarnings("rawtypes")
	public static void sort(Comparable[] elements, Comparator comparator) {
        Comparable[] aux = new Comparable[elements.length];           
        sort(elements, aux, 0, elements.length - 1, comparator);   
    }
    
    @SuppressWarnings("rawtypes")
	private static void sort(Comparable[] elements, Comparable[] aux, int low, int high, Comparator comparator) {
        if (high <= low) {                              
            return;                                     
        }
        
        int mid = low + (high - low) / 2;               
        sort(elements, aux, low, mid, comparator);                  
        sort(elements, aux, mid + 1, high, comparator);             
        merge(elements, aux, low, mid, high, comparator);           
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private static void merge(Comparable[] elements, Comparable[] aux, int low, int mid, int high, Comparator comparator) {
        
        for (int k = low; k <= high; k++) {             
            aux[k] = elements[k];                       
        }           
        
        int i = low;                                    
        int j = mid + 1;                                
        for (int k = low; k <= high; k++) {             
            if (i > mid) {                              
                elements[k] = aux[j++];                 
            } else if (j > high) {                      
                elements[k] = aux[i++];                 
            } else if (comparator.compare(aux[j], aux[i]) < 0) {          
                elements[k] = aux[j++];                 
            } else {                                    
                elements[k] = aux[i++];                 
            }
        }
    }
}