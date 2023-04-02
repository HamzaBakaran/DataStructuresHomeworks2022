package BinarySearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//initializing variables
		IPAddress[] ipAddresses = new IPAddress[10000];
		int i = 0;
		
		//using BufferedReader to read data from csv file
		BufferedReader csvReader = new BufferedReader(new FileReader("src/unsorted.csv"));
		while (i < ipAddresses.length) {
			
			//read from file
			String row = csvReader.readLine();
			
			//replacing commas within quotation marks
			row = row.replace(", ", " ");
			
			//splitting rows into an array of values
		    String[] rowSplit = row.split(",");
		   
		    //importing data into ipAddresses array
		    //using Long to store ipFrom and ipTo
		    //using substring to remove quotation marks
		    ipAddresses[i] = new IPAddress(Long.parseLong(rowSplit[0].substring(1, rowSplit[0].length()-1)), 
		    		Long.parseLong(rowSplit[1].substring(1, rowSplit[1].length()-1)),
					rowSplit[2].substring(1, rowSplit[2].length()-1),
					rowSplit[3].substring(1, rowSplit[3].length()-1),
					rowSplit[4].substring(1, rowSplit[4].length()-1),
					rowSplit[5].substring(1, rowSplit[5].length()-1));
		    i++;
	
		}
		
		//close BufferedReader
		csvReader.close();
		
		//getting user input
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter IP address for searching: ");
		String address = reader.nextLine();
		reader.close();
		
		//converting IP address (String) to IP number (Long)
		long number = convert(address);
		
		//searching via binary search
		find(ipAddresses,number);
		
	}
	
	//method converts IP address to IP number, both in terms of content and variable type
	public static long convert(String address) {
		String[] ipAddress = address.split("\\.");
		long w = 16777216*Long.parseLong(ipAddress[0]);
		long x = 65536*Long.parseLong(ipAddress[1]);
		long y = 256*Long.parseLong(ipAddress[2]);
		long z = Long.parseLong(ipAddress[3]);
		long ipNumber = w + x + y + z;
		return ipNumber;
	}
	
	//method implements binary search and prints result
	public static void find(IPAddress[] ipAddresses, Long number) {
		int searchResult = BinarySearch.search(ipAddresses, number);
		if (searchResult == -1) {
			System.out.println("Not found!");
		}
		else {
			System.out.println("Contry Code: " + ipAddresses[searchResult].countryCode + ", " +
					   "Country Name: " + ipAddresses[searchResult].countryName + ", " + 
					   "Region Name: " + ipAddresses[searchResult].regionName + ", " + 
					   "City Name: " + ipAddresses[searchResult].cityName);
		}
	}

}