package selectionsort;

import ibu.edu.hw3.AbstractSort;

//selection sort implementation with Comparable type
public class SelectionSort extends AbstractSort {
	
@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] elements){
	  for (int i = 0; i < elements.length; i++){
  	  int min = i;
        for (int j = i + 1; j < elements.length; j++){
            if(less(elements[j], elements[min])){
                min = j;
            } 
        }
        swap(elements, i, min);
    }
	}
}