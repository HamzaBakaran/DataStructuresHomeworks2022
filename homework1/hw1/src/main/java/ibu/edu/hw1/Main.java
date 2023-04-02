package ibu.edu.hw1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Dijkstra's Two-Stack Algorithm ");
		System.out.println("Please be aware of that (parenthesis, number or operator) is separated by a whitespace.)	");	
		System.out.println("Also take care of paranthesis, every opened once must be closed	");	
		System.out.println("Enter expression: ");
		
		Scanner scan = new Scanner(System.in);				//input of expression by user							

		while(true) {																	
			String expression = scan.nextLine();										
			if (checkWhitespace(expression) && checkParenthesis(expression)) {			
				Algorithm twoStackAlgorithm = new Algorithm(expression);				
				twoStackAlgorithm.calculate();											
				break;																	
			}
			else {
				System.out.println("Invalid input! Try again.");						
			}
		}
		
		scan.close();																	
	}
	
	
	public static boolean checkWhitespace(String exp) {									//function checks whether tokens are separated by whitespace
		String[] expArr = exp.split("");												//create String array of all characters
		int count = 0;																	//initialize count
		for (String token : expArr) {													//for-each loop to iterate through array
			if (token.equals(" ")) {													//if there is a whitespace
				count++;																//increment count
			}
		}
		String[] expNoWhitespace = exp.split(" ");										//create String array of all characters without whitespace	
		if (count == expNoWhitespace.length-1) {										//number of whitespace should be 1 less than number of characters
			return true;
		}
		return false;
	}
	
	public static boolean checkParenthesis(String exp) {								//function checks whether every parenthesis is closed
		String[] expArr = exp.split("");												//create String array of all characters
		int count1 = 0;																	//initialize count1 and count2
		int count2 = 0;
		for (String token : expArr) {
			if (token.equals("(")) {													//increment count1 for every opened parenthesis
				count1++;
			}
			else if (token.equals(")")) {												//increment count2 for every closed parenthesis
				count2++;
			}
		}
		if (count1 == count2) {															//if there is the same number of opened and closed 
			return true;																//parenthesis then input is valid
		}
		return false;
	}

}