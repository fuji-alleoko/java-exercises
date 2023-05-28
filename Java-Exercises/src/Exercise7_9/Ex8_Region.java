package Exercise7_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Ex8_Region {
	private static String url = "jdbc:postgresql://localhost:5432/mydatabase";
	private static String username = "postgres";
	private static String password = "root";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getAllDataByRegion();
	}
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
			 System.out.println("========================================================================================================================");
				
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
}
