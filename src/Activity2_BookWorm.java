import java.util.LinkedList;
import java.util.Scanner;

class Book {
    public String author, title, ISBN;
    public Book(String author, String title, String ISBN) {
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
    }
    @Override
    public String toString() {
        return "Author: " + author + ", Title: " + title + ", ISBN: " + ISBN;
    }
}
public class Activity2_BookWorm {
    private LinkedList<Book> books = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addBook() {
        System.out.print("Enter author:");
        String author = scanner.nextLine();
        System.out.print("Enter Title:");
        String title = scanner.nextLine();
        System.out.print("Enter ISBN:");
        String ISBN = scanner.nextLine();
        books.add(new Book(author, title, ISBN));
    }

    public void findAndDisplayBook(String searchBy, String value) {
        for (Book book : books) {
            
            if (searchBy.equalsIgnoreCase("ISBN") && book.ISBN.equalsIgnoreCase(value)) {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
    public static void main(String[] args) {
        Activity2_BookWorm library = new Activity2_BookWorm();
        while (true) {
            System.out.println("Library System Menu:");
            System.out.println("1. Add a book");
            System.out.println("2. Find a book by ISBN");
            System.out.println("3. Display all books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = library.scanner.nextInt();
            library.scanner.nextLine();
            switch (choice) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    System.out.print("Enter ISBN to search: ");
                    library.findAndDisplayBook("ISBN", library.scanner.nextLine());
                    break;
                case 3:
                    library.displayBooks();
                    break;
                case 4:
                    System.out.println("Exiting Library System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}