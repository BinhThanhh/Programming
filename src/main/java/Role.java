import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Role {
    private int id;
    private String role_name;
    public DatabaseConnection connection;

    public Role() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    //Method get data from db
    public void getRole() throws SQLException {
        //Connect to db
        Connection connection = DatabaseConnection.openConnection();
        //Write SQL to get data from department
        String sql = "SELECT * FROM roles";
        //Create Statement
        Statement statement = connection.createStatement();
        //Run SQl
        ResultSet results = statement.executeQuery(sql);
        //Display data was given
        while (results.next()){
            //get ID
            int id = results.getInt("id");
            //get department_name
            String role_name = results.getString("role_name");
            //display
            System.out.println("ID: " + id + ", department_name: " + role_name);
            //close
        }
        DatabaseConnection.closeConnection(connection);
    }

    //method add data to db
    public void addRole() throws SQLException {
        //Connect DB
        Connection connection = DatabaseConnection.openConnection();
        //Get data from keyboard
        String role_name = this.role_name;
        //Write SQL add data
        String sql = "INSERT INTO roles(role_name) VALUES ('" + role_name + "')";
        //Run sql
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //Close SQL
        DatabaseConnection.closeConnection(connection);
        System.out.println("Add completed!");
    }

    //metod update data
    public void updateRole(int id) throws SQLException {
        //Connect Db
        Connection connection = DatabaseConnection.openConnection();
        //Get uid department before delete
        String checkUid = "SELECT id FROM roles ORDER BY id DESC";
        //Run sql get uid
        Statement statementUid = connection.createStatement();
        ResultSet results = statementUid.executeQuery(checkUid);
        //Get uid
        results.next();
        int uid = results.getInt("id");
        //Check uid employee
        if (id > uid) {
            System.out.println("ID not found! try again!");
            return;
        }
        //Get data input
        String role_name = this.role_name;
        //Write a query update data with id
        String sql = "UPDATE departments SET department_name = '" + role_name + "'WHERE id = " + id;
        //Run query
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //Close SQL
        DatabaseConnection.closeConnection(connection);
        System.out.println("Update completed!");
    }

    //method delete data in db
    public void deleteRole(int id) throws SQLException {
        //Connect Db
        Connection connection = DatabaseConnection.openConnection();
        //Get uid department before delete
        String checkUid = "SELECT id FROM roles ORDER BY id DESC";
        //Run sql get uid
        Statement statementUid = connection.createStatement();
        ResultSet results = statementUid.executeQuery(checkUid);
        //Get uid
        results.next();
        int uid = results.getInt("id");
        //Check uid employee
        if (id > uid) {
            System.out.println("ID not found! try again!");
            return;
        }
        //Write a query update data with id
        String sql = "DELETE FROM roles WHERE id = " + id;
        //Run query
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //Close SQL
        DatabaseConnection.closeConnection(connection);
        System.out.println("Delete completed!");
    }
}
