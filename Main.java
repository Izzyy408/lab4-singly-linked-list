import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        int choice;

        do {
            System.out.println("\n===== TEXT EDITOR =====");
            System.out.println("1. Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show Current Text");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter text to add: ");
                    String newText = scanner.nextLine();

                    editor.add(newText);
                    System.out.println("Text added.");
                    break;

                case 2:
                    System.out.println("Undo: " + editor.undo());
                    break;

                case 3:
                    System.out.println("Redo: " + editor.redo());
                    break;

                case 4:
                    editor.printCurrent();
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}