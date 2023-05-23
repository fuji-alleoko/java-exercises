package Exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
	choosePythagoreanOrTriangle();
	}

	private static void choosePythagoreanOrTriangle() {
		System.out.println("*****  Pythagorean Theorem and Area of Triangle  *****");
		Scanner scannerMenu = new Scanner(System.in);	
		System.out.println("1: Pythagorean Theorem");
		System.out.println("2: Area of Triangle");
		System.out.print("Choose a number to process: ");
		try {
			int intMenu = scannerMenu.nextInt();
			if (intMenu == 1) {
				getPythagorean();
			} else if (intMenu == 2) {
				getAreaOfTriangle();
			} else {
				System.out.println("ERROR: Invalid input! Try Again");
				choosePythagoreanOrTriangle();
			}
		} catch (InputMismatchException e) {
			System.out.println("\nERROR: Invalid input! Try Again");
			choosePythagoreanOrTriangle();
		}
	}

	private static void getPythagorean() {
		System.out.println("\n*****  Pythagorean Theorem  *****");		
		try {
			Scanner inputPythagorean = new Scanner(System.in);
			System.out.print("Input right side of triangle: ");
			double rightSide = inputPythagorean.nextDouble();
			System.out.print("Input left side of triangle: ");
			double leftSide = inputPythagorean.nextDouble();
			double allSides = rightSide * rightSide + leftSide * leftSide;
			double hypotenuse = Math.sqrt(allSides);
			System.out.print("The hypotenuse is: ");
			System.out.printf("%.2f", hypotenuse);
			doTryAgain();

		}catch (InputMismatchException e) {
			System.out.println("");
			System.out.println("ERROR: Invalid input! Try Again");
			getPythagorean();
		}
	}

	private static void getAreaOfTriangle() {
		System.out.println("\n*****  Area of Triangle  *****");
		
		try {
			Scanner inputTriangle = new Scanner(System.in);

			System.out.print("Input triangle base: ");
			double base = inputTriangle.nextDouble();

			System.out.print("Input triangle height: ");
			double height = inputTriangle.nextDouble();

			//Formula Area=1/2 x Base x Height
			double area = 0.5 * base * height;

			System.out.print("The area of the triangle is: ");
			System.out.printf("%.2f", area);
			doTryAgain();
		}catch(InputMismatchException e){
			System.out.println("");
			System.out.println("ERROR: Invalid input! Try Again");
			getAreaOfTriangle();
		}		
	}

	private static void doTryAgain() {
		System.out.print("\nDo you want to try again? Y/N :");
		Scanner inputScanner = new Scanner(System.in);
		String input = inputScanner.nextLine();
		
		if (input.contains("Y") || input.contains("y")) {
			choosePythagoreanOrTriangle();
		} else {
			System.out.println("Application Ended");
			System.exit(0);
		}
	}
	
}
