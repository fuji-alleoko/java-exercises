package Exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) {
		getFibonacci();
	}
	
	private static void getFibonacci() {
		System.out.println("*****    Fibonacci    ***** ");
		Scanner inputFibonacciProcess = new Scanner(System.in);
		System.out.print("Please enter a range: ");

		try {
			int numberOfRange = inputFibonacciProcess.nextInt();
			int firstNumber = 1;
			int secondNumber = 2;
			int nextNumber = 0;

			for (int i = 1; i <= numberOfRange; i++) {
				System.out.print( firstNumber + " ");
				nextNumber = firstNumber + secondNumber;
				firstNumber = secondNumber;
				secondNumber = nextNumber;
			}
			doTryAgain();
		} catch (InputMismatchException e) {
			System.out.println("ERROR: Invalid input! Try Again");
			System.out.println("");
			getFibonacci();
		}
	}

	private static void doTryAgain() {
		System.out.println("");
		System.out.print("Do you want to try again? Y/N :");

		Scanner inputScanner = new Scanner(System.in);
		String input = inputScanner.nextLine();

		if (input.contains("Y") || input.contains("y")) {
			getFibonacci();
		} else {
			System.out.println("Application End");
			System.exit(0);
		}
	}
}
