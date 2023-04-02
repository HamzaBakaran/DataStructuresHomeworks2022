package ibu.edu.hw3ShellSort;

import ibu.edu.hw3.AbstractSort;

//shell sort implementation with Comparable type
public class ShellSort extends AbstractSort {
	
  @SuppressWarnings("rawtypes")
	public static void sort(Comparable[] elements) {
      int h = 1;
      while (h < elements.length / 3) {
          h = 3 * h + 1;
      }
      while (h >= 1){
          for(int i = h; i< elements.length; i++){
              for (int j = i; j >= h; j -= h){

                  if(less(elements[j], elements[j - h])){

                      swap(elements, j, j - h);
                  } else {
                      break;
                  }
              }
          }
          h = h / 3;
      }
  }
}
