package ibu.edu.BubleSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		//initializing variables
		IPAddress[] ipAddresses = new IPAddress[10];
		int i = 0;
		
		//using BufferedReader to read data
		BufferedReader csvReader = new BufferedReader(new FileReader("src/unsorted.csv"));
		while (i < ipAddresses.length) {
			
			//read from file
			String row = csvReader.readLine();
			
			//replacing commas within quotation marks
			row = row.replace(", ", " ");
			
			//splitting rows into a string of values
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
		
		//use BubbleSort to sort array
		BubbleSort.sort(ipAddresses);
		
		//write to new file
				FileWriter writer = new FileWriter("src/sorted.csv");
				for (int i1=0; i1 < ipAddresses.length; i1++) {
					writer.write(ipAddresses[i1].toString()+"\n");
				}
				writer.flush();
				writer.close();
		
		
		
	}

}