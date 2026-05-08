import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static EventReader reader = new EventReader("events.csv");

    public static void main(String[] args) {
        while (true) {
            showMenu();
        }
    }

    static void showMenu() {
        System.out.println("\n========================================");
        System.out.println("   Parul University Academic Reminder   ");
        System.out.println("========================================");
        System.out.println("1. Show all events");
        System.out.println("2. Show events by month");
        System.out.println("3. Show events by semester");
        System.out.println("4. Show next upcoming event");
        System.out.println("5. Show only holidays");
        System.out.println("6. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice (1-6): ");

        String input = scanner.nextLine().trim();

        switch (input) {
            case "1":
                reader.showAllEvents();
                break;
            case "2":
                System.out.print("Enter month name (e.g. JUNE): ");
                String month = scanner.nextLine().toUpperCase().trim();
                reader.showEventsByMonth(month);
                break;
            case "3":
                System.out.print("Enter semester (odd/even/both): ");
                String sem = scanner.nextLine().toLowerCase().trim();
                reader.showEventsBySemester(sem);
                break;
            case "4":
                reader.showNextEvent();
                break;
            case "5":
                reader.showHolidays();
                break;
            case "6":
                System.out.println("\nGoodbye! Good luck with your semester.");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Enter 1 to 6.");
        }
    }
}