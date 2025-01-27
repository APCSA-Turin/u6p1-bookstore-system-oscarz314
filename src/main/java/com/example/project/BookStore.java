package com.example.project;
import java.util.Scanner;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users)
    Book[] books = new Book[5];
    User[] users = new User[10]; 

    //requires 1 empty constructor
    public BookStore(){}

    // public getUsers(){}
    public User[] getUsers(){
        return users;
    }

    // public setUsers(){}
    public void setUsers(User[] newUsers){
        users = new User[newUsers.length];

        for (int i = 0; i < users.length; i++){
            users[i] = newUsers[i];
        }
    }

    // public  getBooks(){}
    public Book[] getBooks(){
        return books;
    }

    // public void addUser(User user){}
     public void addUser(User newUser){
        int i = 0;
        while (users[i] != null && i < users.length){
            i++;
        }
        users[i] = newUser;
     }

    // public void removeUser(User user){}
    public void removeUser(User user){
        int i = 0;
        while (users[i] != user && i < users.length){
            i++;
        }

        users[i] = null;
        consolidateUsers();
    }

    // public void consolidateUsers(){}
    public void consolidateUsers(){
        for (int i = 0; i < users.length; i++){ //shifts until the element is no longer null
            int j = i + 1;
            while (users[i] == null && j < users.length){
                users[i] = users[j];
                users[j] = null;
                j++;
            }
        }
    }

    // public void addBook(Book book){}
    public void addBook(Book newBook){
        int i = 0;
        while (books[i] != null && i < books.length){
            i++;
        }

        books[i] = newBook;
     }

    // public void insertBook(Book book, int index){}
    public void insertBook(Book book, int index){
        if (books[index] == null){
            books[index] = book;
        }
        else
        {
            Book temp = books[index];
            books[index] = book;
            addBook(temp);
        }
    }

    // public void removeBook(Book book){}
    public void removeBook(Book book){
        int index = 0;
        while (books[index] != book && index < books.length){
            index++;
        }
        
        if (books[index] == book){
            books[index].setQuantity(books[index].getQuantity() - 1);

            if (books[index].getQuantity() == 0){
                Book[] tempList = new Book[books.length - 1];
    
                for (int i = 0; i < tempList.length; i++){
                    if (i < index){
                        tempList[i] = books[i];
                    }
                    else if (i >= index){
                        tempList[i] = books[i + 1];
                    }
                }
        
                books = new Book[tempList.length];
        
                for (int i = 0; i < tempList.length; i++){
                    books[i] = tempList[i];
                }
            }
        }
        
    }
    
       
    // public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes
    public String bookStoreBookInfo(){
        String text = "";
        for (int i = 0; i < books.length; i++){
            if (books[i] != null){
                text += books[i].bookInfo() + "\n";
            }
            else{
                text += "null\n";
            }
        }

        return text;
    }

    // public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes
    public String bookStoreUserInfo(){
        String text = "";
        for (int i = 0; i < users.length; i++){
            if (users[i] != null){
                text += users[i].userInfo() + "\n";
            }
            else{
                text += "null\n";
            }
        }

        return text;
    }
}