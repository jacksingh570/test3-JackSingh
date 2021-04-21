package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Book book;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Person author1;
    private Person author2;
    private Person patron1;
    private Person patron2;
    private Person patron3;
    private Library library;

    @BeforeEach
    void setUp() {
        patron1 = new Person("Betty","Rubble","betty@rubble.org","f", LocalDate.of(1996,2,3));
        patron2 = new Person("BamBam","Rubble","bambam@rubble.org","m", LocalDate.of(2020,3,18));
        patron3 = new Person("Wilma","Flintstone","wilma@rocks.com","f", LocalDate.of(1996,10,4));
        author1 = new Person("Fred", "Flintstone","fred@rocks.com","m", LocalDate.of(1976,01,28));
        author2 = new Person("Pebbles", "Flintstone","pebbles@rocks.com","m", LocalDate.of(2020,12,28));
        book = new Book("Java 101", author1, 19.99);
        book1 = new Book("Java 102", author1, 19.99);
        book2 = new Book("Java 103", author1, 19.99);
        book3 = new Book("Java 104", author2, 189.99);
        book4 = new Book("Java 105", author2, 298.33);
        library = new Library();
        library.addBook(book);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }

    @Test
    void getAuthors() {
        ArrayList<Person> expResult = new ArrayList<>();
        expResult.add(author1);
        expResult.add(author2);
        ArrayList<Person> result = library.getAuthors();
        Collections.sort(expResult, (a1, a2)-> String.CASE_INSENSITIVE_ORDER.compare(a1.getFirstName(), a2.getFirstName()));
        Collections.sort(result, (a1, a2)-> String.CASE_INSENSITIVE_ORDER.compare(a1.getFirstName(), a2.getFirstName()));
        assertEquals(expResult, result);
    }

    @Test
    void getBooksByAuthor() {
        ArrayList<Book> expResult = new ArrayList<>();
        expResult.add(book3);
        assertEquals(expResult, library.getBooksByAuthor(author2));
    }

    @Test
    void getBooksByAuthor2() {
        ArrayList<Book> expResult = new ArrayList<>();
        expResult.add(book);
        expResult.add(book1);
        expResult.add(book2);
        assertEquals(expResult, library.getBooksByAuthor(author1));
    }

    @Test
    void getNumOfBooks() {
        assertEquals(4, library.getNumOfBooks());
    }

    @Test
    void getNumOfBooks2() {
        library.addBook(book4);
        assertEquals(5, library.getNumOfBooks());
    }

    @Test
    void getValueOfBooks() {
        assertEquals(249.96, library.getValueOfBooks());
    }

    @Test
    void getValueOfBooks2() {
        library.addBook(book4);
        assertEquals(548.29, library.getValueOfBooks());
    }

    @Test
    void libraryCheckedOutBooks() {
        library.checkOutBook(book, patron1, LocalDate.of(2021,4,30));
        library.checkOutBook(book1, patron1, LocalDate.of(2021,4,30));
        library.checkOutBook(book2, patron2, LocalDate.of(2021,4,30));
        ArrayList<Book> expResult = new ArrayList<>();
        expResult.add(book);
        expResult.add(book1);
        expResult.add(book2);
        assertEquals(expResult, library.getCheckedOutBooks());
    }

    @Test
    void libraryCheckedOutBooks2() {
        library.checkOutBook(book, patron1, LocalDate.of(2021,4,30));
        library.checkOutBook(book1, patron1, LocalDate.of(2021,4,30));
        ArrayList<Book> expResult = new ArrayList<>();
        expResult.add(book);
        expResult.add(book1);
        assertEquals(expResult, library.getCheckedOutBooks());
    }

}