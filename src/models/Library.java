/**
 * Jack Singh
 * 647-278-8840
 */


package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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
        //incomplete
        ArrayList<Person> authors = new ArrayList<Person>();
        List<Person> noDuplicates = authors.stream().distinct().collect(Collectors.toList());
        return new ArrayList<>();
    }

    public ArrayList<Book> getBooksByAuthor(Person author){
        //incomplete/incorrect
        ArrayList<Book> booksByAuthor = new ArrayList<Book>();
        return booksByAuthor;
    }

    public int getNumOfBooks()
    {
        return -1;
    }

    public double getValueOfBooks()
    {
        int count= 0;
        for(int i = 0; i < books.size(); i++){
            count += count;
        }
        throw new IllegalArgumentException("there are " + count + "books");
    }

    public void checkOutBook(Book book, Person patron, LocalDate dueDate)
    {
        if (book.isAvailable()){
           // book.checkOutBook();
        }else{
            throw new IllegalArgumentException("Book not available");
        }
    }

    public ArrayList<Book> getCheckedOutBooks()
    {
        return new ArrayList<>();
    }
}
