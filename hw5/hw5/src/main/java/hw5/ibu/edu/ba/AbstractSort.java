package hw5.ibu.edu.ba;

//AbstractSort class implementation from previous hws
public abstract class AbstractSort {

@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean less(Comparable v, Comparable w) {
    if (v.compareTo(w) < 0) {
        return true;
    } else {
        return false;
    }
}

@SuppressWarnings("rawtypes")
	public static void swap (Comparable[] elements, int a, int b) {
	Comparable tmp = elements[a];
    elements[a] = elements[b];
    elements[b] = tmp;
}

}