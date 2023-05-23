package Exercise5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    // Database connection parameters
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/mydatabase";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
    	startToOrder();
    }
    private static void startToOrder() {
    	
        try {

            List<GroceryItemClass> groceryItems = new ArrayList<>();
            groceryItems.add(new GroceryItemClass(1, "Apple", 20, 0.02));
            groceryItems.add(new GroceryItemClass(2, "Banana", 5, 0.05));
            groceryItems.add(new GroceryItemClass(3, "Orange", 20, 0.15));
            groceryItems.add(new GroceryItemClass(4, "Mango", 25, 0.20));
            groceryItems.add(new GroceryItemClass(5, "Grapes", 125, 0.20));
            groceryItems.add(new GroceryItemClass(6, "Raspberry", 225, 0.20));
            groceryItems.add(new GroceryItemClass(7, "Strawberry", 105, 0.20));
            groceryItems.add(new GroceryItemClass(8, "Durian", 75, 0.20));
            groceryItems.add(new GroceryItemClass(9, "Rambutan", 55, 0.20));
            groceryItems.add(new GroceryItemClass(10, "Buko", 25, 0.20));
        
            displayGroceryList(groceryItems);

            int itemId = promptItemId(groceryItems);

            int quantity = promptQuantity();

            double totalPrice = computeTotalPrice(groceryItems, itemId, quantity);

            addToCart(itemId, quantity, totalPrice);

            // Display all data from the cart table
            displayCartTable();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    	
    	
    }
    

    private static void displayGroceryList(List<GroceryItemClass> groceryItems) {
        System.out.println("Grocery List:");
        System.out.println("ID\tProduct\t\tPrice\tDiscount");
        System.out.println("------------------------------------");

        for (GroceryItemClass item : groceryItems) {
            System.out.printf("%d\t%s\t\t%.2f\t%.2f\n", item.getId(), item.getProduct(), item.getPrice(), item.getDiscount());
        }

        System.out.println();
    }

    private static int promptItemId(List<GroceryItemClass> groceryItems) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the item to add to the cart: ");
        int itemId = scanner.nextInt();

        // Validate the selected item ID
        boolean validItem = false;
        for (GroceryItemClass item : groceryItems) {
            if (item.getId() == itemId) {
                validItem = true;
                break;
            }
        }

        if (!validItem) {
            System.out.println("Invalid item ID!");
            System.exit(0);
        }

        return itemId;
    }

    private static int promptQuantity() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the quantity of the item: ");
        int quantity = scanner.nextInt();

        return quantity;
    }

    private static double computeTotalPrice(List<GroceryItemClass> groceryItems, int itemId, int quantity) {
        double totalPrice = 0;

        for (GroceryItemClass item : groceryItems) {
            if (item.getId() == itemId) {
                totalPrice = item.getPrice() * quantity * (1 - item.getDiscount());
                break;
            }
        }

        return totalPrice;
    }

    private static void addToCart(int itemId, int quantity, double totalPrice) throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        String query = "INSERT INTO carts (id, product, price, discount, quantity, total_price) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, itemId);

        GroceryItemClass selectedItem = getGroceryItem(itemId);
        statement.setString(2, selectedItem.getProduct());
        statement.setDouble(3, selectedItem.getPrice());
        statement.setDouble(4, selectedItem.getDiscount());
        statement.setInt(5, quantity);
        statement.setDouble(6, totalPrice);

        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    private static GroceryItemClass getGroceryItem(int itemId) {
        List<GroceryItemClass> groceryItems = new ArrayList<>();
        groceryItems.add(new GroceryItemClass(1, "Apple", 20, 0.02));
        groceryItems.add(new GroceryItemClass(2, "Banana", 5, 0.05));
        groceryItems.add(new GroceryItemClass(3, "Orange", 20, 0.15));
        groceryItems.add(new GroceryItemClass(4, "Mango", 25, 0.20));
        groceryItems.add(new GroceryItemClass(5, "Grapes", 125, 0.20));
        groceryItems.add(new GroceryItemClass(6, "Raspberry", 225, 0.20));
        groceryItems.add(new GroceryItemClass(7, "Strawberry", 105, 0.20));
        groceryItems.add(new GroceryItemClass(8, "Durian", 75, 0.20));
        groceryItems.add(new GroceryItemClass(9, "Rambutan", 55, 0.20));
        groceryItems.add(new GroceryItemClass(10, "Buko", 25, 0.20));

        for (GroceryItemClass item : groceryItems) {
            if (item.getId() == itemId) {
                return item;
            }
        }

        return null;
    }

    private static void displayCartTable() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        String query = "SELECT * FROM carts";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        System.out.println("Cart Table:");
        System.out.println("ID\tProduct\t\tPrice\tDiscount\tQuantity\tTotal Price");
        System.out.println("----------------------------------------------------");

        
        double sum=0;
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String product = resultSet.getString("product");
            double price = resultSet.getDouble("price");
            double discount = resultSet.getDouble("discount");
            int quantity = resultSet.getInt("quantity");
            double totalPrice = resultSet.getDouble("total_price");
            sum+=totalPrice;
            
            System.out.printf("%d\t%s\t\t%.2f\t%.2f\t\t%d\t\t%.2f\n", id, product, price, discount, quantity, totalPrice);
        }
        
        System.out.println("Total of all products ---------------------------------------- "+sum);

        resultSet.close();
        statement.close();
        connection.close();

        System.out.println();
        addItemAgain(); 
    }
    private static void addItemAgain() {
    	System.out.println("");
		System.out.print("Do you want to add another product? Y/N :");

		Scanner inputScanner = new Scanner(System.in);
		String input = inputScanner.nextLine();

		if (input.contains("Y") || input.contains("y")) {
			startToOrder();
		} else {
			System.out.println("Application End");
			System.exit(0);
		}
    	
    }

   
}
