import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
//        Department dp = new Department();
//        dp.getDP();
//        System.out.println("--------------------------------");
//        System.out.print("Input department name: ");
//        dp.setDepartment_name(input.nextLine());
//        dp.addDP();
//        dp.getDP();

        //Update data
//        System.out.println("Select department to update: ");
//        int id = input.nextInt();
//        System.out.println("Input update department");
//        System.out.print("Department name: ");
//        input.nextLine();
//        dp.setDepartment_name(input.nextLine());
//        System.out.println();
//        dp.updateDP(id);
//        dp.getDP();

        //Delete data
//        System.out.print("Select id to delete: ");
//        dp.deleteDP(input.nextInt());
//        System.out.println("list after delete");
//        dp.getDP();

        Menu menu = new Menu();
        menu.menu();
    }
}
