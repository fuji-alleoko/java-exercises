package Exercise3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getDensityVolumeMass();
	}
		
		private static void getDensityVolumeMass() {

			System.out.println("  Computation of Density");
			Scanner inputScannerProcess = new Scanner(System.in);

			
				System.out.println("1: Volume");
				System.out.println("2: Mass");
				System.out.println("3: Density");
				System.out.print("Choose a number you want to compute? : ");
				String inputProcess = inputScannerProcess.next();
				
				switch(inputProcess) {
				case "1": 
					System.out.println("\n**** Compute for Volume ****");
					try {
									
						System.out.print("Input number of mass: ");
						double mass = inputScannerProcess.nextDouble();
				
						System.out.print("Input number of density: ");
						double density = inputScannerProcess.nextDouble();

						double volume = mass / density;

						System.out.println("The volume is " + volume );

						doTryAgain();
						
					break;
					} catch (InputMismatchException e) {
						System.out.println("\nERROR: Invalid input! Try Again");
				
						getDensityVolumeMass();
					}
				case "2":
					System.out.println("\n**** Compute for mass ****");
					try {
						
						System.out.print("Input number of density: ");
						double density = inputScannerProcess.nextDouble();
						
						System.out.print("Input number of volume: ");
						double volume = inputScannerProcess.nextDouble();

						double mass = density * volume;

						System.out.println("The mass is " + mass );

						doTryAgain();
					} catch (InputMismatchException e) {
						System.out.println("\nERROR: Invalid input! Try Again");
				
						getDensityVolumeMass();
					}
					break;
					
				case "3":
					System.out.println("\n**** Compute for density ****");
					
					try {
						

						//This mass must be in kilograms
						System.out.print("Input number of mass: ");
						double mass = inputScannerProcess.nextDouble();

						//This volume must be in cubic meter
						System.out.print("Input number of volume: ");
						double volume = inputScannerProcess.nextDouble();

						double density = mass / volume;

						System.out.println("The density is " + density );

						if(density % 2==0) {
							System.out.println("Even Number");
						}else if (!(density % 2==0)) {
							System.out.println("Odd Number");
								
						}
						
						doTryAgain();
						
						
					} catch (InputMismatchException e) {
						System.out.println("\nERROR: Invalid input! Try Again");
						getDensityVolumeMass();
					}
					
					break;
					
					default:
						System.out.println("\nERROR: Invalid input! Try Again");
						getDensityVolumeMass();
						break;
							
				}	

		}
		private static void doTryAgain() {
		
			System.out.print("\nDo you want to try again? Y/N :");

			Scanner inputScanner = new Scanner(System.in);
			String input = inputScanner.nextLine();

			if (input.contains("Y") || input.contains("y")) {
				getDensityVolumeMass();
			} else {
				System.out.println("Application Ended");
				System.exit(0);
			}
		}
	}
