package recursiveMerge;

import ibu.edu.hw4.AbstractSort;

public class RecursiveMergeSort extends AbstractSort {
    
    //Public sort method, which will be used in Main
    @SuppressWarnings("rawtypes")
	public static void sort(Comparable[] elements) {
        Comparable[] aux = new Comparable[elements.length];           
        sort(elements, aux, 0, elements.length - 1);   
    }
    
    //Private sort method for recursion
    @SuppressWarnings("rawtypes")
	private static void sort(Comparable[] elements, Comparable[] aux, int low, int high) {
        if (high <= low) {                              
            return;                                     
        }
        
        int mid = low + (high - low) / 2;               
        sort(elements, aux, low, mid);                  
        sort(elements, aux, mid + 1, high);             
        merge(elements, aux, low, mid, high);           
    }
    
    //Merge method same as in BottomUpMergeSort
    @SuppressWarnings("rawtypes")
	private static void merge(Comparable[] elements, Comparable[] aux, int low, int mid, int high) {
        
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
            } else if (less(aux[j], aux[i])) {          
                elements[k] = aux[j++];                 
            } else {                                    
                elements[k] = aux[i++];                 
            }
        }
    }
}