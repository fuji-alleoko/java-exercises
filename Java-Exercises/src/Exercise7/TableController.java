package Exercise7;

import java.sql.*;
import java.util.List;

public class TableController {
    private TableDAO tableDAO;

    public TableController(Connection connection) {
        this.tableDAO = new TableDAO(connection);
    }
  
    public void updateUnitCost(String code, double unitCost) {
    	tableDAO.updateUnitCost(code, unitCost);
    }
    public List<Table> getAllTablesByRegion(String region) throws SQLException {
        return tableDAO.getAllByRegion(region);
    }
    public List<Table> getTableByCode(String code) throws SQLException {
        return tableDAO.getTableByCode(code);
    }

    public List<Table> getAllTables() throws SQLException {
        return tableDAO.getAllTables();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void insertTable(Table table) throws SQLException {
        tableDAO.insertTable(table);
    }

    public void deleteTable(int id) throws SQLException {
        tableDAO.deleteTable(id);
    }

}
