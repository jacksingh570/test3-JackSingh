/**
 * Jack Singh
 * 647-278-8840
 */


package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book)
    {
        books.add(book);
    }

    public ArrayList<Person> getAuthors()
    {
        return new ArrayList<>();
    }

    public ArrayList<Book> getBooksByAuthor(Person author){
        return new ArrayList<>();
    }

    public int getNumOfBooks()
    {
        return -1;
    }

    public double getValueOfBooks()
    {
        return -1;
    }

    public void checkOutBook(Book book, Person patron, LocalDate dueDate)
    {
    }

    public ArrayList<Book> getCheckedOutBooks()
    {
        return new ArrayList<>();
    }
}
