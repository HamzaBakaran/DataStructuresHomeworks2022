package ibu.edu.hw3;

//abstract class with less and swap methods, which will be implemented in every sort
public abstract class AbstractSort {
  
  /* Returns whether the first element is less than the second one */
  @SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean less(Comparable v, Comparable w) {
      if (v.compareTo(w) < 0) {
          return true;
      } else {
          return false;
      }
  }
  
  /* Swaps the two elements in an array */
  @SuppressWarnings("rawtypes")
	public static void swap (Comparable[] elements, int a, int b) {
  	Comparable tmp = elements[a];
      elements[a] = elements[b];
      elements[b] = tmp;
  }

}