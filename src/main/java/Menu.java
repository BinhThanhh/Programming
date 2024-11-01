import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);

    public void menu() throws SQLException {
        Department dp = new Department();
        System.out.println("1. Employee list");
        System.out.println("2. Add a Employee");
        System.out.println("3. Update a Employee");
        System.out.println("4. Delete a Employee");
        System.out.println("5. Search by id");
        System.out.println("6. Cancel");
        System.out.print("Input a number in menu to select: ");
        int menu = input.nextInt();
        switch (menu) {
            case 1:
                System.out.println("Department list!");
                dp.getDP();
        }
    }
}
