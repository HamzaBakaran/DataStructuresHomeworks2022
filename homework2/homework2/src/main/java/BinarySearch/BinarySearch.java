package BinarySearch;

import BinarySearch.IPAddress;

//binary search implementation using the overriden compareTo method
public class BinarySearch {
	
	public static int search(IPAddress[] addresses, long number) {
	    int low = 0;                                   
	    int high = addresses.length - 1;                 
	        
	    while (low <= high) {                           
	        int mid = low + (high - low) / 2;           
	        if (addresses[mid].compareTo(number) == -1) {                  
	            high = mid - 1;                         
	        } else if (addresses[mid].compareTo(number) == 1) {           
	            low = mid + 1;                          
	        } else {                                    
	            return mid;                             
	        }
	    }
	    return -1;                                      
	}
}
