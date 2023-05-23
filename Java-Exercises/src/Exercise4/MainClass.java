package Exercise4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {
	private static Pepperoni pepperoni = new Pepperoni();
	private static Hawaiian hawaiian= new Hawaiian();
	private static Buffalo buffalo= new Buffalo();
	private static Allmeat allmeat= new Allmeat();
	
	public static void main(String[] args) {
		getPizza();
	}

	private static void getPizza() {
		System.out.println("1: Pepperoni Pizza");
		System.out.println("2. Hawaiian Pizza");
		System.out.println("3. Buffalo Pizza");
		System.out.println("4. AllMeat Pizza");
		System.out.print("Pick a pizza : ");
		try {
			Scanner input = new Scanner(System.in);
			int userInput = input.nextInt();

			switch (userInput) {
			case 1:
				String pepperoniData = pepperoni.getName() + "\n" 
						+ pepperoni.getDescription() + "\n"
						+"Price:"+ pepperoni.getPrice() + "\n" 
						+ pepperoni.getIngredients() + "\n" 
						+"Discount:"+ pepperoni.getDicsount()+"%";	
			
				System.out.println("\n*** Pepperoni ***\n" + pepperoniData);
				doTryAgain();
				break;
			case 2:
				String hawaiianData = hawaiian.getName() + "\n" 
						+ hawaiian.getDescription() + "\n" 
						+"Price:"+ hawaiian.getPrice()+ "\n" 
						+ hawaiian.getIngredients() + "\n" 
						+"Discount:"+ hawaiian.getDicsount()+"%"; 
				
				System.out.println("\n*** Hawaiian ***\n" + hawaiianData);
				doTryAgain();
				break;
			case 3:
				String buffaloData = buffalo.getName() + "\n" 
						+ buffalo.getDescription() + "\n" 
						+"Price:"+ buffalo.getPrice()+ "\n" 
						+ buffalo.getIngredients() + "\n" 
						+"Discount:"+ buffalo.getDicsount()+"%"; 
				
				System.out.println("\n*** Buffalo ***\n" + buffaloData);
				doTryAgain();
				break;
				
			case 4:
				String AllMeatData = allmeat.getName() + "\n" 
						+ allmeat.getDescription() + "\n" 
						+"Price:"+ allmeat.getPrice()+ "\n" 
						+ allmeat.getIngredients() + "\n" 
						+"Discount:"+ allmeat.getDicsount()+"%"; 
				
				System.out.println("\n*** AllMeat ***\n" + AllMeatData);
				doTryAgain();
				break;

			default:
				System.out.println("ERROR: Invalid input! Try Again\n");
				getPizza();
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("ERROR: Invalid input! Try Again\n");
			getPizza();
		}
	}

	private static void doTryAgain() {
		System.out.print("\nDo you want to try again? Y/N :");
		Scanner inputScanner = new Scanner(System.in);
		String input = inputScanner.nextLine();

		if (input.contains("Y") || input.contains("y")) {
			getPizza();
		} else {
			System.out.println("Application Ended");
			System.exit(0);
		}
	}
}
