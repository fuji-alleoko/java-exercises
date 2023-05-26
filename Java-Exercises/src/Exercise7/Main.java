package Exercise7;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static String url = "jdbc:postgresql://localhost:5432/mydatabase";
	private static String username = "postgres";
	private static String password = "root";

	public static void main(String[] args) {
		startApp();

	}
	private static void startApp() {
		Scanner input = new Scanner(System.in);
		System.out.println("Select a process\n  1: Exercise 7 (Display Info of Code)\n  2: Exercise 8 (Display all list by region)\n  3: Exercise 9 (Update Unit Cost)");
		int userInput = input.nextInt();
		
		switch (userInput) {
		case 1: {
			getDataByCode();
			break;
		}case 2:{
			getAllDataByRegion();
			break;
		}case 3:{
			updateData();
			break;
		}default:
			System.out.println("Invalid input");
		}
	}

	// Exercise 7
	private static void getDataByCode() {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			TableController tableController = new TableController(connection);

			Scanner input = new Scanner(System.in);
			System.out.println("Enter Code: ");
			String code = input.nextLine();

			// View all by region tables
			List<Table> allTables = tableController.getTableByCode(code);
			 System.out.println("Code\tDate\t\tRegion\t\tRep\t\tItem\t\tUnits\t\tUnit Cost\tTotal");
		
			for (Table table : allTables) {
			
				
				System.out.println(
						
						table.getCode() +"\t"
					 	+ table.getOrderDate()+"\t" 
					   	+ table.getRegion()+"\t\t"
						 + table.getRep() +"\t\t"
						 + table.getItem() +"\t\t"
						 + table.getUnits()+"\t\t"
						 + table.getUnitCost()+"\t\t"
						 + table.getTotal());
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERR: Invalid input");
			getDataByCode();
		}

	}
	

	// Exercise 8
	private static void getAllDataByRegion() {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			TableController tableController = new TableController(connection);

			Scanner input = new Scanner(System.in);
			System.out.print("What is your preferred region?: ");
			String region = input.nextLine();

			// View all by region tables
			List<Table> allTables = tableController.getAllTablesByRegion(region);
			System.out.println("All Tables By Region:");
			 System.out.println("Code\tDate\t\tRegion\t\tRep\t\tItem\t\tUnits\t\tUnit Cost\tTotal");
			for (Table table : allTables) {
				
				
				
			System.out.println(
					
					table.getCode() +"\t"
				 	+ table.getOrderDate()+"\t" 
				   	+ table.getRegion()+"\t\t"
					 + table.getRep() +"\t\t"
					 + table.getItem() +"\t\t"
					 + table.getUnits()+"\t\t"
					 + table.getUnitCost()+"\t\t"
					 + table.getTotal());
		}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERR: Invalid input");
			getAllDataByRegion();
		}

	}

	// Exercise 9
	private static void updateData() {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			TableController tableController = new TableController(connection);

			Scanner input = new Scanner(System.in);
			System.out.print("What code you want to update?: ");
			String code = input.nextLine();

			// View information of code
			List<Table> allTables = tableController.getTableByCode(code);
			 System.out.println("Code\tDate\t\tRegion\t\tRep\t\tItem\t\tUnits\t\tUnit Cost\tTotal");
				for (Table table : allTables) {
				System.out.println(
						
						table.getCode() +"\t"
					 	+ table.getOrderDate()+"\t" 
					   	+ table.getRegion()+"\t\t"
						 + table.getRep() +"\t\t"
						 + table.getItem() +"\t\t"
						 + table.getUnits()+"\t\t"
						 + table.getUnitCost()+"\t\t"
						 + table.getTotal());
				System.out.print("What is the new cost of unit?: ");
				double new_cost = input.nextDouble();

				String idToUpdate = code; // ID of the entry to update
				double newUnitCost = new_cost; // Updated unit cost value
				tableController.updateUnitCost(idToUpdate, newUnitCost);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERR: Invalid input");
			updateData();
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void getAllData() {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			TableController tableController = new TableController(connection);

			// View all tables
			List<Table> allTables = tableController.getAllTables();
			System.out.println("All Tables:");
			System.out.println("Code | Date ");
			for (Table table : allTables) {
				System.out.println(table.getCode() + " | " + table.getOrderDate() + " | " + table.getRegion() + " | "
						+ table.getRep() + " | " + table.getItem() + " | " + table.getUnits() + " | "
						+ table.getUnitCost() + " | " + table.getTotal());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	private static void insertData() {

		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			TableController tableController = new TableController(connection);
			// Insert a new table
			Table newTable = new Table();
			newTable.setCode("ABCD");
			newTable.setOrderDate(Date.valueOf("2023-05-23"));
			newTable.setRegion("Central");
			newTable.setRep("Pedro");
			newTable.setItem("Notebook");
			newTable.setUnits(5.0);
			newTable.setUnitCost(10.0);
			

			tableController.insertTable(newTable);
			System.out.println("New table inserted. ID: " + newTable.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void deleteData() {
		try (Connection connection = DriverManager.getConnection(url, username, password)) {
			TableController tableController = new TableController(connection);
			// Delete a table
			int tableIdToDelete = 12;
			tableController.deleteTable(tableIdToDelete);
			System.out.println("Table deleted. ID: " + tableIdToDelete);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
