package Exercise7_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Ex9_UpdateData {
	private static String url = "jdbc:postgresql://localhost:5432/mydatabase";
	private static String username = "postgres";
	private static String password = "root";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		updateData();
	}
	// Exercise 9
		private static void updateData() {
			try (Connection connection = DriverManager.getConnection(url, username, password)) {
				TableController tableController = new TableController(connection);

				Scanner input = new Scanner(System.in);
				getAllData();
				System.out.print("What code you want to update?: ");
			
				String code = input.nextLine();

				// View information
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
				 System.out.println("Code\tDate\t\tRegion\t\tRep\t\tItem\t\tUnits\t\tUnit Cost\tTotal");
				 System.out.println("========================================================================================================================");
				for (Table table : allTables) {
					System.out.println(table.getCode() +"\t"
						 	+ table.getOrderDate()+"\t" 
						   	+ table.getRegion()+"\t\t"
							 + table.getRep() +"\t\t"
							 + table.getItem() +"\t\t"
							 + table.getUnits()+"\t\t"
							 + table.getUnitCost()+"\t\t"
							 + table.getTotal());
				}
				 System.out.println("========================================================================================================================");
					
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
}
