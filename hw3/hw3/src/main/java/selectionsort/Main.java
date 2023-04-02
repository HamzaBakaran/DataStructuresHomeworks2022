package selectionsort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import ibu.edu.hw3.IPAddress;

//same Main class as in hw3
public class Main {

	public static void main(String[] args) throws IOException {
		
		IPAddress[] ipAddresses = new IPAddress[10000];
		int i = 0;
		
		BufferedReader csvReader = new BufferedReader(new FileReader("src/unsorted.csv"));
		while (i < ipAddresses.length) {

			String row = csvReader.readLine();

			row = row.replace(", ", " ");

		    String[] rowSplit = row.split(",");

		    ipAddresses[i] = new IPAddress(Long.parseLong(rowSplit[0].substring(1, rowSplit[0].length()-1)), 
		    		Long.parseLong(rowSplit[1].substring(1, rowSplit[1].length()-1)),
					rowSplit[2].substring(1, rowSplit[2].length()-1),
					rowSplit[3].substring(1, rowSplit[3].length()-1),
					rowSplit[4].substring(1, rowSplit[4].length()-1),
					rowSplit[5].substring(1, rowSplit[5].length()-1));
		    i++;
	
		}

		csvReader.close();

		System.out.println("Initializing sort...");
		long start = System.currentTimeMillis();

		SelectionSort.sort(ipAddresses);
		
        System.out.println("Sorted. Time elapsed: " + ((System.currentTimeMillis() - start)/1000));
        System.out.println("Writing to file...");

		FileWriter writer = new FileWriter("src/sortedwithselection.csv");
		for (int i1=0; i1 < ipAddresses.length; i1++) {
			writer.write(ipAddresses[i1].toString()+"\n");
		}
		writer.flush();
		writer.close();
		
		
		
	}
}
