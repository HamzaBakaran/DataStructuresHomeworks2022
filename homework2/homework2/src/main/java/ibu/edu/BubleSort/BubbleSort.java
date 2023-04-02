package ibu.edu.BubleSort;

//implementation of BubbleSort
public class BubbleSort {
	
	static boolean swapped;

	@SuppressWarnings ({"rawtypes", "unchecked"})
	public static void sort(Comparable[] addresses) {
		for (int i = 0; i < addresses.length; i++) {
			for (int j = 1; j < addresses.length - i; j++) {
				if (addresses[j-1].compareTo(addresses[j]) > 0) {
					swap(addresses, j-1, j);
				}
			}
			if (swapped = false) {
				break;
			}
		}
	}
	
	@SuppressWarnings ("rawtypes")
	public static void swap(Comparable[] addresses, int i, int j) {
		Comparable tmp = addresses[i];
		addresses[i] = addresses[j];
		addresses[j] = tmp;
		swapped = true;
		
	}
}