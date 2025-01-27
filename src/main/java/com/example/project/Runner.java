package com.example.project;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        // library setup
        BookStore store = new BookStore();
        IdGenerate idGen = new IdGenerate();

        // user setup
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        System.out.println("Welcome to the library! Here are your options!:\n");

        while(option != 0){
            System.out.print("\nPlease select one of the following: \n");
            System.out.print("0: to exit\n");
            System.out.print("1: to add a book\n");
            System.out.print("2: to upgrade the quantity of books\n");
            System.out.print("3: to search a book\n");
            System.out.print("4: to show all books\n");
            System.out.print("5: to register a student\n");
            System.out.print("6: to show all registered students\n");
            System.out.print("7: to checkout a book\n");
            System.out.print("8: to check in a book\n\n");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1){
                option1(scanner, store);
            }
            else if (option == 2){
                option2(scanner, store);
            }
            else if (option == 3){
                option3(scanner, store);
            }
            else if (option == 4){
                option4(scanner, store);
            }
            else if (option == 5){
                option5(scanner, store);
            }
            else if (option == 6){
                option6(scanner, store);
            }
            else if (option == 7){
                option7(scanner, store);
            }
            else if (option == 8){
                option8(scanner, store);
            }
        }

        scanner.close();
    }

    public static void option1(Scanner scanner, BookStore store){
        System.out.println("Enter the name of your book: ");
        String name = scanner.nextLine();

        System.out.println("Enter the author of your book: ");
        String author = scanner.next();

        System.out.println("Enter the year published of your book: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the isbn of your book: ");
        String isbn = scanner.next();

        System.out.println("Enter the quantity of your book: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Book temp = new Book(name, author, year, isbn, quantity);
        store.addBook(temp); 

        System.out.println("Nice it added your book!");
    }

    public static void option2(Scanner scanner, BookStore store){
        int index = pickBook(scanner, store);

        System.out.println("Enter the new quantity of your book: ");
        int quantity = scanner.nextInt();

        store.getBooks()[index].setQuantity(quantity);
        System.out.println("quantity updated!");
    }

    public static void option3(Scanner scanner, BookStore store){
        int index = pickBook(scanner, store);

        if (store.getBooks()[index] != null){
            System.out.println(store.getBooks()[index].bookInfo());
        }
        else{
            System.out.println("Sorry books not found");
        }
    }

    public static void option4(Scanner scanner, BookStore store){
        System.out.println(store.bookStoreBookInfo());
    }

    public static void option5(Scanner scanner, BookStore store){
        System.out.println("Enter the student's name: ");
        String name = scanner.next();

        IdGenerate.generateID();
        User temp = new User(name, IdGenerate.getCurrentId());
        store.addUser(temp);
        System.out.println("student registered!");
    }

    public static void option6(Scanner scanner, BookStore store){
        System.out.println(store.bookStoreUserInfo());
    }

    public static void option7(Scanner scanner, BookStore store){
        int index = pickBook(scanner, store);

        // Find student
        System.out.println("Enter ID of the student checking out: ");
        int Id = scanner.nextInt();
        scanner.nextLine();

        //Merge student books with new books
        Book[] studentBooks = store.getUsers()[Id - 100].getBooks();
        int i = 0;
        while (studentBooks[i] != null && i < studentBooks.length){
            i++;
        }
        studentBooks[i] = store.getBooks()[index];
        store.getUsers()[Id - 100].setBooks(studentBooks);

        //subtract quantity
        store.removeBook(store.getBooks()[index]);
        System.out.println("Book checked out!");
        return;
    }

    public static void option8(Scanner scanner, BookStore store){
        int index = pickBook(scanner, store);

        // Find student
        System.out.println("Enter ID of the student checking in: ");
        int Id = scanner.nextInt();
        scanner.nextLine();

        //subtract student books with new books
        Book[] studentBooks = store.getUsers()[Id - 100].getBooks();
        int i = 0;
        while (studentBooks[i] != store.getBooks()[index] && i < studentBooks.length){
            i++;
        }

        studentBooks[i] = null;
        store.getUsers()[Id - 100].setBooks(studentBooks);

        //add quantity
        store.addBook(store.getBooks()[index]);
        System.out.println("Book checked in!");
        return;
    }

    public static int pickBook(Scanner scanner, BookStore store){
        System.out.print("Enter title to select"); // choose based on title or isbn
        String key = scanner.nextLine();
        for (int i = 0; i < store.getBooks().length; i++){
            if (key.equals(store.getBooks()[i].getTitle())){
                return i;
            }
        } 
        
        return -1;
    }
    
}
