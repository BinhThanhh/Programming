import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);

    public void menu() throws SQLException {
        Employee ep = new Employee();
        Department dp = new Department();
        Role role = new Role();
        System.out.println("|------------------------Employee management----------------------|");
        System.out.println("|-1. Employee list------------------------------------------------|");
        System.out.println("|-2. Add a Employee-----------------------------------------------|");
        System.out.println("|-3. Update a Employee--------------------------------------------|");
        System.out.println("|-4. Delete a Employee--------------------------------------------|");
        System.out.println("|-5. Search by id-------------------------------------------------|");
        System.out.println("|-6. Search employee with department id---------------------------|");
        System.out.println("|-7. Search employee with status: Working-------------------------|");
        System.out.println("|-8. Search employee with status: Offline-------------------------|");
        System.out.println("|-9. Display a list of employee with ascending salary-------------|");
        System.out.println("|-10. Display a list of employee with salary greater 3000$--------|");
        System.out.println("----------------------Department management------------------------");
        System.out.println("|-11. Department list---------------------------------------------|");
        System.out.println("|-12. Add department----------------------------------------------|");
        System.out.println("|-13. Update department-------------------------------------------|");
        System.out.println("|-14. Delete department-------------------------------------------|");
        System.out.println("-------------------------Role management---------------------------");
        System.out.println("|-15. Role list---------------------------------------------------|");
        System.out.println("|-16. Add role----------------------------------------------------|");
        System.out.println("|-17. Update role-------------------------------------------------|");
        System.out.println("|-18. Delete role-------------------------------------------------|");
        System.out.println("----------------------------Function-------------------------------");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("|-0. Cancel-------------------------------------------------------|");
        System.out.println("|_________________________________________________________________|");
        int menu;
        do {
            //Request user select menu option
            System.out.print("==> Input a number in menu to select: ");
            menu = input.nextInt();
            //Menu switch case
            switch ((int) menu) {
                case 1:
                    System.out.println("==> Employee list!");
                    ep.getEP();
                    break;
                case 2:
                    System.out.println("==> Input information of employee:");
                    System.out.print("Full name: ");
                    input.nextLine();
                    ep.setFullname(input.nextLine());
                    System.out.print("Email: ");
                    ep.setEmail(input.nextLine());
                    System.out.print("Phone: ");
                    ep.setPhone(input.nextLine());
                    System.out.print("Address: ");
                    ep.setAddress(input.nextLine());
                    System.out.print("Salary: ");
                    ep.setSalary(input.nextFloat());
                    System.out.print("role_id: ");
                    ep.setRole_id(input.nextInt());
                    System.out.print("Department_id: ");
                    ep.setDepartment_id(input.nextInt());
                    System.out.print("Status (Working, Offline, Training): ");
                    input.nextLine();
                    String status;
                    do {
                        status = input.nextLine();
                        if (status.toLowerCase().compareTo("working") != 0 && status.toLowerCase().compareTo("offline") != 0 && status.toLowerCase().compareTo("training") != 0) {
                            System.out.println("Status not correct, try again!");
                            System.out.print("Status (Working, Offline, Training): ");
                        }

                    } while (status.toLowerCase().compareTo("working") != 0 && status.toLowerCase().compareTo("offline") != 0 && status.toLowerCase().compareTo("training") != 0);
                    ep.setStatus(status);
                    System.out.println();
                    ep.addEP();
                    break;
                case 3:
                    //get all employee
                    System.out.println("==> Employee list!");
                    ep.getEP();
                    //Select id employee want to update
                    System.out.print("Please select id employee want to update: ");
                    int idUpdate = input.nextInt();
                    //Input information want to update
                    System.out.print("Full name: ");
                    input.nextLine();
                    ep.setFullname(input.nextLine());
                    System.out.print("Email: ");
                    ep.setEmail(input.nextLine());
                    System.out.print("Phone: ");
                    ep.setPhone(input.nextLine());
                    System.out.print("Address: ");
                    ep.setAddress(input.nextLine());
                    System.out.print("Salary: ");
                    ep.setSalary(input.nextFloat());
                    System.out.print("role_id: ");
                    ep.setRole_id(input.nextInt());
                    System.out.print("Department_id: ");
                    ep.setDepartment_id(input.nextInt());
                    System.out.print("Status (Working, Offline, Training): ");
                    input.nextLine();
                    do {
                        status = input.nextLine();
                        if (status.toLowerCase().compareTo("working") != 0 && status.toLowerCase().compareTo("offline") != 0 && status.toLowerCase().compareTo("training") != 0) {
                            System.out.println("Status not correct, try again!");
                            System.out.print("Status (Working, Offline, Training): ");
                        }

                    } while (status.toLowerCase().compareTo("working") != 0 && status.toLowerCase().compareTo("offline") != 0 && status.toLowerCase().compareTo("training") != 0);
                    ep.setStatus(status);
                    System.out.println();
                    ep.updateEP(idUpdate);
                    break;
                case 4:
                    //get all employee
                    System.out.println("==> Employee list!");
                    ep.getEP();
                    //get id of employee want to delete
                    System.out.print("Please enter employee id want to delete: ");
                    int idDelete = input.nextInt();
                    //call method delete
                    ep.deleteEP(idDelete);
                case 5:
                    //Search employee by id
                    System.out.print("Enter id to search: ");
                    int searchId = input.nextInt();
                    ep.searchbyId(searchId);
                    break;
                case 6:
                    //Get information of department
                    System.out.println("==> Department list!");
                    dp.getDP();
                    //Select department_id to search
                    System.out.print("Enter id of department want to search: ");
                    int dp_id = input.nextInt();
                    ep.searchbyDP(dp_id);
                    break;
                case 7:
                    ep.searchStatusWithWorking();
                    break;
                case 8:
                    ep.searchStatusWithOffline();
                    break;
                case 9:
                    ep.displayEmployeeWithAscendingSalary();
                    break;
                case 10:
                    ep.displayEmployeeWithSlaryGreater3000();
                    break;
                case 11:
                    //Get all department list
                    System.out.println("==> Department list!");
                    dp.getDP();
                    break;
                case 12:
                    //Add department
                    System.out.print("Input department name: ");
                    input.nextLine();
                    dp.setDepartment_name(input.nextLine());
                    System.out.println();
                    dp.addDP();
                    break;
                case 13:
                    //Update department
                    System.out.print("Select department to update: ");
                    int idDpUpdate = input.nextInt();
                    System.out.print("Department name: ");
                    input.nextLine();
                    dp.setDepartment_name(input.nextLine());
                    System.out.println();
                    dp.updateDP(idDpUpdate);
                    break;
                case 14:
                    //Delete department
                    System.out.print("Select id to delete: ");
                    dp.deleteDP(input.nextInt());
                    break;
                case 15:
                    //Get all department list
                    System.out.println("==> Role list!");
                    role.getRole();
                    break;
                case 16:
                    //Add department
                    System.out.print("Input role name: ");
                    input.nextLine();
                    role.setRole_name(input.nextLine());
                    System.out.println();
                    role.addRole();
                    break;
                case 17:
                    //Update department
                    System.out.print("Select role to update: ");
                    int idRoleUpdate = input.nextInt();
                    System.out.print("Role name: ");
                    input.nextLine();
                    role.setRole_name(input.nextLine());
                    System.out.println();
                    role.updateRole(idRoleUpdate);
                    break;
                case 18:
                    //Delete department
                    System.out.print("Select id to delete: ");
                    role.deleteRole(input.nextInt());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Unknown select!");
                    break;
            }
        } while (menu > 15 || menu < 1);
    }

}
