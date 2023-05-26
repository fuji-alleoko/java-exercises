package Exercise7;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TableDAO {
	private Connection connection;

	public TableDAO(Connection connection) {
		this.connection = connection;
	}

	  public void updateUnitCost(String code, double unitCost) {
	      String sql = "UPDATE javaexercise SET Unit_Cost = ?, Total = Units * ? WHERE Code = ?";
	           
	            try( PreparedStatement statement = connection.prepareStatement(sql)) {
	            	statement.setDouble(1, unitCost);
	            	statement.setDouble(2, unitCost);
	            	statement.setString(3, code);
				    
	            	statement.executeUpdate();
		            System.out.println("Table entry updated successfully.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        
	    }

	public List<Table> getAllByRegion(String region) throws SQLException {
		   List<Table> tableList = new ArrayList<>();
	        String query = "SELECT * FROM javaexercise WHERE Region = ?";

	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, region);
	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                Table table = new Table();
	                // Retrieve data from the resultSet and set it to the dataObject
	                table.setId(resultSet.getInt("ID"));
					table.setCode(resultSet.getString("Code"));
					table.setOrderDate(resultSet.getDate("OrderDate"));
					table.setRegion(resultSet.getString("Region"));
					table.setRep(resultSet.getString("Rep"));
					table.setItem(resultSet.getString("Item"));
					table.setUnits(resultSet.getDouble("Units"));
					table.setUnitCost(resultSet.getDouble("Unit_Cost"));
					table.setTotal(resultSet.getDouble("Total"));


	                tableList.add(table);
	            }
	        }

	        return tableList;
	}
	

	public List<Table> getTableByCode(String code) throws SQLException {
		 List<Table> tableList = new ArrayList<>();
	        String query = "SELECT * FROM javaexercise WHERE Code = ?";

	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, code);
	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                Table table = new Table();
	                // Retrieve data from the resultSet and set it to the dataObject
	                table.setId(resultSet.getInt("ID"));
					table.setCode(resultSet.getString("Code"));
					table.setOrderDate(resultSet.getDate("OrderDate"));
					table.setRegion(resultSet.getString("Region"));
					table.setRep(resultSet.getString("Rep"));
					table.setItem(resultSet.getString("Item"));
					table.setUnits(resultSet.getDouble("Units"));
					table.setUnitCost(resultSet.getDouble("Unit_Cost"));
					table.setTotal(resultSet.getDouble("Total"));


	                tableList.add(table);
	            }
	        }

	        return tableList;
	}
	


	public List<Table> getAllTables() throws SQLException {
		List<Table> tableList = new ArrayList<>();
		String query = "SELECT * FROM javaexercise";

		try (PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				Table table = new Table();
				table.setId(resultSet.getInt("ID"));
				table.setCode(resultSet.getString("Code"));
				table.setOrderDate(resultSet.getDate("OrderDate"));
				table.setRegion(resultSet.getString("Region"));
				table.setRep(resultSet.getString("Rep"));
				table.setItem(resultSet.getString("Item"));
				table.setUnits(resultSet.getDouble("Units"));
				table.setUnitCost(resultSet.getDouble("Unit_Cost"));
				table.setTotal(resultSet.getDouble("Total"));

				tableList.add(table);
			}
		}

		return tableList;
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	public void insertTable(Table table) throws SQLException {
		String query = "INSERT INTO javaexercise (Code, OrderDate, Region, Rep, Item, Units, Unit_Cost, Total) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, table.getCode());
			statement.setDate(2, table.getOrderDate());
			statement.setString(3, table.getRegion());
			statement.setString(4, table.getRep());
			statement.setString(5, table.getItem());
			statement.setDouble(6, table.getUnits());
			statement.setDouble(7, table.getUnitCost());
			statement.setDouble(8, table.getUnits()*table.getUnitCost());

			statement.executeUpdate();

			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				table.setId(generatedKeys.getInt(1));
			}
		}
	}

	public void deleteTable(int id) throws SQLException {
		String query = "DELETE FROM javaexercise WHERE ID=?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		}
	}

}
