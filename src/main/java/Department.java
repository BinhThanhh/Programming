import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Department {
    //Attributes
    private int id;
    private String department_name;
    public DatabaseConnection connection;

    //Contructor

    public Department() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment_name(String s) {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    //Method get data from db
    public void getDP() throws SQLException {
        //Connect to db
        Connection connection = DatabaseConnection.openConnection();
        //Write SQL to get data from department
        String sql = "SELECT * FROM departments";
        //Create Statement
        Statement statement = connection.createStatement();
        //Run SQl
        ResultSet results = statement.executeQuery(sql);
        //Display data was given
        while (results.next()){
            //get ID
            int id = results.getInt("id");
            //get department_name
            String department_name = results.getString("department_name");
            //display
            System.out.println("ID: " + id + ", department_name: " + department_name);
            //close
        }
        DatabaseConnection.closeConnection(connection);
    }

    //method add data to db
    public void addDP() throws SQLException {
        //Connect DB
        Connection connection = DatabaseConnection.openConnection();
        //Get data from keyboard
        String dp_name = this.department_name;
        //Write SQL add data
        String sql = "INSERT INTO departments(department_name) VALUES ('" + dp_name + "')";
        //Run sql
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //Close SQL
        DatabaseConnection.closeConnection(connection);
        System.out.println("Add completed!");
    }

    //metod update data
    public void updateDP(int id) throws SQLException {
        //Connect Db
        Connection connection = DatabaseConnection.openConnection();
        //Get uid department before delete
        String checkUid = "SELECT id FROM departments ORDER BY id DESC";
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
        String dp_name = this.department_name;
        //Write a query update data with id
        String sql = "UPDATE departments SET department_name = '" + dp_name + "'WHERE id = " + id;
        //Run query
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //Close SQL
        DatabaseConnection.closeConnection(connection);
        System.out.println("Update completed!");
    }

    //method delete data in db
    public void deleteDP(int id) throws SQLException {
        //Connect Db
        Connection connection = DatabaseConnection.openConnection();
        //Get uid department before delete
        String checkUid = "SELECT id FROM departments ORDER BY id DESC";
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
        String sql = "DELETE FROM departments WHERE id = " + id;
        //Run query
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //Close SQL
        DatabaseConnection.closeConnection(connection);
        System.out.println("Delete completed!");
    }
}
