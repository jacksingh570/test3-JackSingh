package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;
    private Person author;
    private Person patron;

    @BeforeEach
    void setUp() {
        patron = new Person("Betty","Rubble","betty@rubble.org","f", LocalDate.of(1996,2,3));
        author = new Person("Fred", "Flintstone","fred@rocks.com","m", LocalDate.of(1976,01,28));
        book = new Book("Java 101", author, 19.99);
    }

    @Test
    void setTitleConstructor() {
        assertEquals("Java 101", book.getTitle());
    }

    @Test
    void setTitle() {
        book.setTitle("Advanced Java");
        assertEquals("Advanced Java", book.getTitle());
    }

    @Test
    void setTitleConstructorInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                new Book("", author, 19.99));
    }

    @Test
    void setTitleConstructorInvalid2(){
        assertThrows(IllegalArgumentException.class, ()->
                new Book(" a ", author, 19.99));
    }

    @Test
    void getAuthor() {
        assertEquals(author, book.getAuthor());
    }

    @Test
    void setPrice() {
        assertEquals(19.99, book.getPrice(),0.01);
    }

    @Test
    void setPrice2() {
        book = new Book("Java 101", author, 0);
        assertEquals(0, book.getPrice(),0.01);
    }

    @Test
    void setPriceInvalidConstructor2(){
        assertThrows(IllegalArgumentException.class, ()->
                new Book("Java Rocks", author, -1));
    }

    @Test
    void setPriceInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                book.setPrice(-0.01));
    }

    @Test
    void checkOutBook() {
        book.checkOutBook(patron, LocalDate.of(2021,05,04));
        assertEquals(false, book.isAvailable());
    }

    @Test
    void checkOutBookAvailable() {
        assertEquals(true, book.isAvailable());
    }

    @Test
    void checkOutBookReturnDate() {
        book.checkOutBook(patron, LocalDate.of(2021,05,04));
        assertEquals(LocalDate.of(2021,05,04), book.getReturnDate());
    }

    @Test
    void checkOutBookNotAvailable(){
        book.checkOutBook(patron, LocalDate.of(2021,05,04));
        assertThrows(IllegalArgumentException.class, ()->
                book.checkOutBook(patron, LocalDate.of(2022,01,10)));
    }

    @Test
    void checkOutBookInvalidReturnDate(){
        assertThrows(IllegalArgumentException.class, ()->
                book.checkOutBook(patron, LocalDate.of(2020,01,10)));
    }


    @Test
    void bookToString() {
        assertEquals("Java 101 by Fred Flintstone is available",book.toString());
    }

    @Test
    void bookToStringCheckedOut() {
        book.checkOutBook(patron, LocalDate.of(2021,05,04));
        assertEquals("Java 101 by Fred Flintstone is due back 2021-05-04",book.toString());
    }
}