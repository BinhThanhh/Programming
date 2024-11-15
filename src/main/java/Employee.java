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
    private float coefficient;
    private float totalsalary;
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

    public float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(float coefficient) {
        this.coefficient = coefficient;
    }

    public float getTotalsalary() {
        return totalsalary;
    }

    public void setTotalsalary(float totalsalary) {
        this.totalsalary = totalsalary;
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
            float coefficient = results.getFloat("coefficient");
            float totalsalary = results.getFloat("totalsalary");
            int role_id = results.getInt("role_id");
            int department_id = results.getInt("department_id");
            String status = results.getString("status");
            //display
            System.out.println("ID: " + id + ", Full name: " + fullname + ", Email: " + email + ", Phone: " + phone + ", Address: " + address + ", Salary: " + salary + ", Coefficient: " + coefficient + ", Total Salary: "+ totalsalary +", Role id: " + role_id + ", Department id: " + department_id + ", Status: " + status);
        }
        //close
        DatabaseConnection.closeConnection(connection);
    }

    //method add data to db
    public void addEP() throws SQLException {
        //Connect DB
        Connection connection = DatabaseConnection.openConnection();
        //Get uid role before add
        String checkUidRole = "SELECT id FROM roles ORDER BY id DESC";
        //Run sql get uid
        Statement statementUid = connection.createStatement();
        ResultSet resultRole = statementUid.executeQuery(checkUidRole);
        //Get uid
        resultRole.next();
        int role_uid = resultRole.getInt("id");
        int roleid = this.role_id;
        //Check uid role
        if (roleid > role_uid) {
            System.out.println("Role ID not correct! try again!");
            return;
        }
        //Get uid department before add
        String checkUidDepartment = "SELECT id FROM roles ORDER BY id DESC";
        //Run sql get uid
        Statement statementDepartment = connection.createStatement();
        ResultSet resultDepartment = statementDepartment.executeQuery(checkUidDepartment);
        //Get uid
        resultDepartment.next();
        int department_uid = resultDepartment.getInt("id");
        int departmentid = this.department_id;
        //Check uid department
        if (departmentid > department_uid) {
            System.out.println("Department ID not correct! try again!");
            return;
        }
        //Get data from keyboard
        String fullname = this.fullname;
        String email = this.email;
        String phone = this.phone;
        String address = this.address;
        float salary = this.salary;
        float coefficient = this.coefficient;
        float totalsalary = this.salary*this.coefficient;
        int role_id = this.role_id;
        int department_id = this.department_id;
        String status = this.status;
        //Write SQL add data
        String sql = "INSERT INTO employees(fullname, email, phone, address, salary, coefficient, totalsalary, role_id, department_id, status) VALUES ('" + fullname + "', '" + email + "', '" + phone + "', '" + address + "', '" + salary + "', '" + coefficient +"', '" + totalsalary +"', '" + role_id + "', '" + department_id + "', '" + status + "')";
        //Run sql
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        //Close SQL
        DatabaseConnection.closeConnection(connection);
        System.out.println();
        System.out.println("Add completed!");
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
        float coefficient = this.coefficient;
        float totalsalary = this.salary*this.coefficient;
        int role_id = this.role_id;
        int department_id = this.department_id;
        String status = this.status;
        //Write a query update data with id
        String sql = "UPDATE employees SET fullname = '" + fullname + "', email = '" + email + "', phone = '" + phone + "', address = '" + address + "', salary = '" + salary + "', coefficient = '" + coefficient + "',totalsalary = '" + totalsalary + "', role_id = '" + role_id + "', department_id = '" + department_id + "', status = '" + status + "' WHERE id = '" + id + "'";
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
            System.out.println("ID not found! try again!");
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
            System.out.println("ID not found! try again!");
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
            float coefficient = results.getFloat("coefficient");
            float totalsalary = results.getFloat("totalsalary");
            int role_id = results.getInt("role_id");
            int department_id = results.getInt("department_id");
            String status = results.getString("status");
            //display
            System.out.println("ID: " + id + ", Full name: " + fullname + ", Email: " + email + ", Phone: " + phone + ", Address: " + address + ", Salary: " + salary + ", Coefficient: " + coefficient + ", Total Salary: "+ totalsalary +", Role id: " + role_id + ", Department id: " + department_id + ", Status: " + status);
        }
        //close
        DatabaseConnection.closeConnection(connection);
    }

    //Method search employee based on selected department
    public void searchbyDP(int department_id) throws SQLException {
        //Connect Db
        Connection connection = DatabaseConnection.openConnection();
        //Get uid department before search
        String checkUid = "SELECT id FROM departments ORDER BY id DESC";
        //Run sql get uid
        Statement statementUid = connection.createStatement();
        ResultSet results = statementUid.executeQuery(checkUid);
        //Get uid
        results.next();
        int uid = results.getInt("id");
        //Check uid department
        if (id > uid) {
            System.out.println("ID not found! try again!");
            return;
        }
        //Write sql search employee by department id
        String sql = ("SELECT * FROM employees INNER JOIN departments ON employees.department_id = departments.id WHERE department_id = " + department_id);
        //Run sql get uid
        Statement statementSearch = connection.createStatement();
        ResultSet result = statementUid.executeQuery(sql);
        //Display data was given
        while (result.next()){
            //get information
            int id = results.getInt("id");
            String fullname = results.getString("fullname");
            String email = results.getString("email");
            String phone = results.getString("phone");
            String address = results.getString("address");
            float salary = results.getFloat("salary");
            float coefficient = results.getFloat("coefficient");
            float totalsalary = results.getFloat("totalsalary");
            int role_id = results.getInt("role_id");
            String status = results.getString("status");
            //display
            System.out.println("ID: " + id + ", Full name: " + fullname + ", Email: " + email + ", Phone: " + phone + ", Address: " + address + ", Salary: " + salary + ", Coefficient: " + coefficient + ", Total Salary: "+ totalsalary +", Role id: " + role_id + ", Department id: " + department_id + ", Status: " + status);
        }
        //close
        DatabaseConnection.closeConnection(connection);
    }

    //Method search employee with status working
    public void searchStatusWithWorking() throws SQLException {
        //Connect Db
        Connection connection = DatabaseConnection.openConnection();
        //Write sql to search status with Working
        String sql = ("Select * FROM employees WHERE status = 'working'");
        //Run sql
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        //Display data was given
        while (result.next()){
            //get information
            int id = result.getInt("id");
            String fullname = result.getString("fullname");
            String email = result.getString("email");
            String phone = result.getString("phone");
            String address = result.getString("address");
            float salary = result.getFloat("salary");
            float coefficient = result.getFloat("coefficient");
            float totalsalary = result.getFloat("totalsalary");
            int role_id = result.getInt("role_id");
            int department_id = result.getInt("department_id");
            String status = result.getString("status");
            //display
            System.out.println("ID: " + id + ", Full name: " + fullname + ", Email: " + email + ", Phone: " + phone + ", Address: " + address + ", Salary: " + salary + ", Coefficient: " + coefficient + ", Total Salary: "+ totalsalary +", Role id: " + role_id + ", Department id: " + department_id + ", Status: " + status);
        }
        //close
        DatabaseConnection.closeConnection(connection);
    }

    //Method search employee with status offline
    public void searchStatusWithOffline() throws SQLException {
        //Connect Db
        Connection connection = DatabaseConnection.openConnection();
        //Write sql to search status with Working
        String sql = ("Select * FROM employees WHERE status = 'offline'");
        //Run sql
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        //Display data was given
        while (result.next()){
            //get information
            int id = result.getInt("id");
            String fullname = result.getString("fullname");
            String email = result.getString("email");
            String phone = result.getString("phone");
            String address = result.getString("address");
            float salary = result.getFloat("salary");
            float coefficient = result.getFloat("coefficient");
            float totalsalary = result.getFloat("totalsalary");
            int role_id = result.getInt("role_id");
            int department_id = result.getInt("department_id");
            String status = result.getString("status");
            //display
            System.out.println("ID: " + id + ", Full name: " + fullname + ", Email: " + email + ", Phone: " + phone + ", Address: " + address + ", Salary: " + salary + ", Coefficient: " + coefficient + ", Total Salary: "+ totalsalary +", Role id: " + role_id + ", Department id: " + department_id + ", Status: " + status);
        }
        //close
        DatabaseConnection.closeConnection(connection);
    }

    //method display employee with ascending salary
    public void displayEmployeeWithAscendingSalary() throws SQLException {
        //Connect Db
        Connection connection = DatabaseConnection.openConnection();
        //Write sql to search status with Working
        String sql = ("SELECT * FROM employees ORDER BY totalsalary ASC");
        //Run sql
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        //Display data was given
        while (result.next()){
            //get information
            int id = result.getInt("id");
            String fullname = result.getString("fullname");
            String email = result.getString("email");
            String phone = result.getString("phone");
            String address = result.getString("address");
            float salary = result.getFloat("salary");
            float coefficient = result.getFloat("coefficient");
            float totalsalary = result.getFloat("totalsalary");
            int role_id = result.getInt("role_id");
            int department_id = result.getInt("department_id");
            String status = result.getString("status");
            //display
            System.out.println("ID: " + id + ", Full name: " + fullname + ", Email: " + email + ", Phone: " + phone + ", Address: " + address + ", Salary: " + salary + ", Coefficient: " + coefficient + ", Total Salary: "+ totalsalary +", Role id: " + role_id + ", Department id: " + department_id + ", Status: " + status);
        }
        //close
        DatabaseConnection.closeConnection(connection);
    }


    //Method display employee with salary greater 3000$
    public void displayEmployeeWithSlaryGreater3000() throws SQLException {
        //Connect Db
        Connection connection = DatabaseConnection.openConnection();
        //Write sql to search status with Working
        String sql = ("SELECT * FROM employees WHERE totalsalary > 3000");
        //Run sql
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        //Display data was given
        while (result.next()){
            //get information
            int id = result.getInt("id");
            String fullname = result.getString("fullname");
            String email = result.getString("email");
            String phone = result.getString("phone");
            String address = result.getString("address");
            float salary = result.getFloat("salary");
            float coefficient = result.getFloat("coefficient");
            float totalsalary = result.getFloat("totalsalary");
            int role_id = result.getInt("role_id");
            int department_id = result.getInt("department_id");
            String status = result.getString("status");
            //display
            System.out.println("ID: " + id + ", Full name: " + fullname + ", Email: " + email + ", Phone: " + phone + ", Address: " + address + ", Salary: " + salary + ", Coefficient: " + coefficient + ", Total Salary: "+ totalsalary +", Role id: " + role_id + ", Department id: " + department_id + ", Status: " + status);
        }
        //close
        DatabaseConnection.closeConnection(connection);
    }
}
