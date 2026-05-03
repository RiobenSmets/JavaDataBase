import java.util.Scanner;

public class JavaDatabaseDemo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Add");
            System.out.println("2. Display");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Search");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                new AddStudent().execute(scanner);
            } else if (choice == 2) {
                new DisplayStudents().execute();
            } else if (choice == 3) {
                new UpdateStudent().execute(scanner);
            } else if (choice == 4) {
                new DeleteStudent().execute(scanner);
            } else if (choice == 5) {
                new SearchStudent().execute(scanner);
            } else if (choice == 6) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}