package com.example.project;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        // library setup
        BookStore store = new BookStore();

        // user setup
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        System.out.println("Welcome to the library! Here are your options!:\n");

        while(option != 0){
            System.out.println("Please select one of the following: \n");
            System.out.println("0: to exit\n");
            System.out.println("1: to add a book\n");
            System.out.println("2: to upgrade the quantity of books\n");
            System.out.println("3: to search a book\n");
            System.out.println("4: to show all books\n");
            System.out.println("5: to register a student\n");
            System.out.println("6: to show all registered students\n");
            System.out.println("7: to checkout a book\n");
            System.out.println("8: to check in a book\n\n");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1){
                option1(scanner, store);
            }
            else if (option == 2){

            }
            else if (option == 3){

            }
            else if (option == 4){

            }
            else if (option == 5){

            }
            else if (option == 6){

            }
            else if (option == 7){

            }
            else if (option == 8){

            }
        }

        scanner.close();
    }

    public static void option1(Scanner scanner, BookStore store){
        System.out.println("Enter the name of your book: ");
        String name = scanner.next();

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
        System.out.println("Enter the index of your book (starting at 0): ");
        int index = scanner.nextInt();

        
    }

    
}
