package hw8.hw8.binarysearchtree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import hw8.hw8.Student;


public class Main {

	public static void main(String[] args) throws IOException {
		Student[] students = new Student[1000000];
		int i = 0;
		
		//Using BufferedReader to read csv data and put into an array
		BufferedReader csvReader = new BufferedReader(new FileReader("src/globaluniversitystudents.csv"));
		while (i < students.length) {

			String row = csvReader.readLine();

		    String[] rowSplit = row.split(";");

		    students[i] = new Student(Integer.parseInt(rowSplit[0]), rowSplit[1], rowSplit[2], rowSplit[3], 
		    		rowSplit[4], rowSplit[5], Integer.parseInt(rowSplit[6]));
		    i++;
	
		}

		csvReader.close();
		
		BinarySearchTree<Integer, Student> bst = new BinarySearchTree<Integer, Student>();
		
		//Putting the students from the array into the tree
		for (int j = 0; j < students.length; j++) {
			bst.put(students[j].getStudentID(), students[j]);
		}
		
		//Console prompts
		System.out.println("Enter the ID of the student you want to retrieve: ");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		scan.close();
		Student student = bst.get(id);
		if (student != null) {
			System.out.println(student);
			System.out.println("The student was retrieved from BST in " + bst.getSteps() + " steps");
		} else {
			System.out.println("The student with the given ID does not exist");
			System.out.println("The search was completed in " + bst.getSteps() + " steps");
		}

	}

}