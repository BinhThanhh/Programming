import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {
    //Attributes
    private int id;
    private String fullname;
    private String email;
    private String phone;
    private String address;
    private float salary;
    private int role_id;
    private int department_id;
    private String status;
    public DatabaseConnection connection;

    //Contructor
    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //Method get data from db
    public void getDP() throws SQLException {
        //Connect to db
        Connection connection = DatabaseConnection.openConnection();
        //Write SQL to get data from department
        String sql = "SELECT * FROM employees";
        //Create Statement
        Statement statement = connection.createStatement();
        //Run SQl
        ResultSet results = statement.executeQuery(sql);
        //Display data was given
        while (results.next()){
            //get ID
            int id = results.getInt("id");
            //get fullname
            String fullname = results.getString("fullname");
            //display
            System.out.println("ID: " + id + ", department_name: " + fullname);
            //close
        }
        DatabaseConnection.closeConnection(connection);
    }

    //method add data to db
    public void addDP() throws SQLException {
        //Connect DB
        Connection connection = DatabaseConnection.openConnection();
        //Get data from keyboard
        String fullname = this.fullname;
        //Write SQL add data
        String sql = "INSERT INTO departments(department_name) VALUES (" + fullname + ")";
        //Run sql
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //Close SQL
        DatabaseConnection.closeConnection(connection);
    }

    //metod update data
    public void updateDP(int id) throws SQLException {
        //Connect Db
        Connection connection = DatabaseConnection.openConnection();
        //Get data input
        String fullname = this.fullname;
        //Write a query update data with id
        String sql = "UPDATE departments SET department_name = '" + fullname + "'WHERE id = " + id;
        //Run query
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //Close SQL
        DatabaseConnection.closeConnection(connection);
    }

    //method delete data in db
    public void deleteDP(int id) throws SQLException {
        //Connect Db
        Connection connection = DatabaseConnection.openConnection();
        //Write a query update data with id
        String sql = "DELETE FROM departments WHERE id = " + id;
        //Run query
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //Close SQL
        DatabaseConnection.closeConnection(connection);
    }

    //method search by id
    public void searchbyId(int id) throws SQLException {
        //Connect DB
        Connection connection = DatabaseConnection.openConnection();
        //Write query to search by id
        String sql = "SELECT * FROM Departments WHERE id = " + id;
        //Run query
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(sql);
        //Display data was given
        while (results.next()){
            //get department_name
            String department_name = results.getString("department_name");
            //display
            System.out.println("ID: " + id + ", department_name: " + department_name);
            //close
        }
    }
}
