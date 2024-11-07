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
    public void getEP() throws SQLException {
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
            //get information
            int id = results.getInt("id");
            String fullname = results.getString("fullname");
            String email = results.getString("email");
            String phone = results.getString("phone");
            String address = results.getString("address");
            float salary = results.getFloat("salary");
            int role_id = results.getInt("role_id");
            int department_id = results.getInt("department_id");
            String status = results.getString("status");
            //display
            System.out.println("ID: " + id + ", Full name: " + fullname + ", Email: " + email + ", Phone: " + phone + ", Address: " + address + ", Salary: " + salary + ", Role id: " + role_id + ", Department id: " + department_id + ", Status: " + status);
        }
        //close
        DatabaseConnection.closeConnection(connection);
    }

    //method add data to db
    public void addEP() throws SQLException {
        //Connect DB
        Connection connection = DatabaseConnection.openConnection();
        //Get data from keyboard
        String fullname = this.fullname;
        String email = this.email;
        String phone = this.phone;
        String address = this.address;
        float salary = this.salary;
        int role_id = this.role_id;
        int department_id = this.department_id;
        String status = this.status;
        //Write SQL add data
        String sql = "INSERT INTO employees(fullname, email, phone, address, salary, role_id, department_id, status) VALUES ('" + fullname + "', '" + email + "', '" + phone + "', '" + address + "', '" + salary + "', '" + role_id + "', '" + department_id + "', '" + status + "')";
        //Run sql
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //Close SQL
        DatabaseConnection.closeConnection(connection);
    }

    //metod update data
    public void updateEP(int id) throws SQLException {
        //Connect Db
        Connection connection = DatabaseConnection.openConnection();
        //Get uid employee before edit
        String checkUid = "SELECT id FROM employees ORDER BY id DESC";
        //Run sql get uid
        Statement statementUid = connection.createStatement();
        ResultSet results = statementUid.executeQuery(checkUid);
        //Get uid
        results.next();
        int uid = results.getInt("id");
        //Check uid employee
        if (id > uid) {
            System.out.println("ID not correct! try again!");
            return;
        }
        //Get data input
        String fullname = this.fullname;
        String email = this.email;
        String phone = this.phone;
        String address = this.address;
        float salary = this.salary;
        int role_id = this.role_id;
        int department_id = this.department_id;
        String status = this.status;
        //Write a query update data with id
        String sql = "UPDATE employees SET fullname = '" + fullname + "', email = '" + email + "', phone = '" + phone + "', address = '" + address + "', salary = '" + salary + "', role_id = '" + role_id + "', department_id = '" + department_id + "', status = '" + status + "' WHERE id = '" + id + "'";
        //Run query
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //Close SQL
        DatabaseConnection.closeConnection(connection);
        System.out.println("Update completed!");
    }

    //method delete employee by id
    public void deleteEP(int id) throws SQLException {
        //Connect Db
        Connection connection = DatabaseConnection.openConnection();
        //Get uid employee before delete
        String checkUid = "SELECT id FROM employees ORDER BY id DESC";
        //Run sql get uid
        Statement statementUid = connection.createStatement();
        ResultSet results = statementUid.executeQuery(checkUid);
        //Get uid
        results.next();
        int uid = results.getInt("id");
        //Check uid employee
        if (id > uid) {
            System.out.println("ID not correct! try again!");
            return;
        }
        //Write a query update data with id
        String sql = "DELETE FROM employees WHERE id = " + id;
        //Run query
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //Close SQL
        DatabaseConnection.closeConnection(connection);
        System.out.println("Delete completed!");
    }

    //method search by id
    public void searchbyId(int id) throws SQLException {
        //Connect DB
        Connection connection = DatabaseConnection.openConnection();
        //Get uid employee before search
        String checkUid = "SELECT id FROM employees ORDER BY id DESC";
        //Run sql get uid
        Statement statementUid = connection.createStatement();
        ResultSet result = statementUid.executeQuery(checkUid);
        //Get uid
        result.next();
        int uid = result.getInt("id");
        //Check uid employee
        if (id > uid) {
            System.out.println("ID not correct! try again!");
            return;
        }
        //Write query to search by id
        String sql = "SELECT * FROM employees WHERE id = '" + id + "'";
        //Run query
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(sql);
        //Display data was given
        while (results.next()){
            //get information
            String fullname = results.getString("fullname");
            String email = results.getString("email");
            String phone = results.getString("phone");
            String address = results.getString("address");
            float salary = results.getFloat("salary");
            int role_id = results.getInt("role_id");
            int department_id = results.getInt("department_id");
            String status = results.getString("status");
            //display
            System.out.println("ID: " + id + ", Full name: " + fullname + ", Email: " + email + ", Phone: " + phone + ", Address: " + address + ", Salary: " + salary + ", Role id: " + role_id + ", Department id: " + department_id + ", Status: " + status);
        }
        //close
        DatabaseConnection.closeConnection(connection);
    }
}
