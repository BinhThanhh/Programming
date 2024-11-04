import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);

    public void menu() throws SQLException {
        Employee ep = new Employee();
        Department dp = new Department();
        System.out.println("-----------Employee management----------");
        System.out.println("|-1. Employee list----------------------|");
        System.out.println("|-2. Add a Employee---------------------|");
        System.out.println("|-3. Update a Employee------------------|");
        System.out.println("|-4. Delete a Employee------------------|");
        System.out.println("|-5. Search by id-----------------------|");
        System.out.println("|-6. Cancel-----------------------------|");
        System.out.println("|_______________________________________|");
        System.out.print("==> Input a number in menu to select: ");
        int menu = input.nextInt();
        switch (menu) {
            case 1:
                System.out.println("==> Employee list!");
                ep.getEP();
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
                ep.addEP();
                System.out.println("Add completed!");
            case 3:
                //get all employee
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
                ep.updateEP(idUpdate);
        }
    }
}
