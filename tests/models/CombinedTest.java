package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class CombinedTest {
    private Book book;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private AudioBook audioBook;
    private Person author1;
    private Person author2;
    private Person patron;
    private Person patron1;
    private Person patron2;
    private Person patron3;
    private Library library;

    @BeforeEach
    void setUp() {

        //author and patron (people that visit a library)
        author1 = new Person("Fred", "Flintstone","fred@rocks.com","m", LocalDate.of(1976,01,28));
        patron = new Person("Betty","Rubble","betty@rubble.org","f", LocalDate.of(1996,2,3));

        //Book and AudioBook objects
        audioBook = new AudioBook("Java 101", author1, 19.99,1800);
        book = new Book("Java 101", author1, 19.99);

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
    void setLengthInSec() {
        audioBook.setLengthInSec(100);
        assertEquals(100, audioBook.getLengthInSec());
    }

    @Test
    void setLengthInSecConstructor() {
        assertThrows(IllegalArgumentException.class, ()->
                new AudioBook("Java 101", author1, 19.99,-1));
    }

    @Test
    void setLengthInSecInvalid() {
        assertThrows(IllegalArgumentException.class, ()->
                audioBook.setLengthInSec(-1));
    }

    @Test
    void testForSuperClass(){
        assertEquals(Book.class, AudioBook.class.getSuperclass());
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
                new Book("", author1, 19.99));
    }

    @Test
    void setTitleConstructorInvalid2(){
        assertThrows(IllegalArgumentException.class, ()->
                new Book(" a ", author1, 19.99));
    }

    @Test
    void getAuthor() {
        assertEquals(author1, book.getAuthor());
    }

    @Test
    void setPrice() {
        assertEquals(19.99, book.getPrice(),0.01);
    }

    @Test
    void setPrice2() {
        book = new Book("Java 101", author1, 0);
        assertEquals(0, book.getPrice(),0.01);
    }

    @Test
    void setPriceInvalidConstructor2(){
        assertThrows(IllegalArgumentException.class, ()->
                new Book("Java Rocks", author1, -1));
    }

    @Test
    void setPriceInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                book.setPrice(-0.01));
    }


    @Test
    void checkOutBook() {
        book.checkOutBook(patron1, LocalDate.of(2021,05,04));
        assertEquals(false, book.isAvailable());
    }

    @Test
    void checkOutBookAvailable() {
        assertEquals(true, book.isAvailable());
    }

    @Test
    void checkOutBookReturnDate() {
        book.checkOutBook(patron1, LocalDate.of(2021,05,04));
        assertEquals(LocalDate.of(2021,05,04), book.getReturnDate());
    }

    @Test
    void checkOutBookNotAvailable(){
        book.checkOutBook(patron1, LocalDate.of(2021,05,04));
        assertThrows(IllegalArgumentException.class, ()->
                book.checkOutBook(patron1, LocalDate.of(2022,01,10)));
    }

    @Test
    void checkOutBookInvalidReturnDate(){
        assertThrows(IllegalArgumentException.class, ()->
                book.checkOutBook(patron1, LocalDate.of(2020,01,10)));
    }


    @Test
    void bookToString() {
        assertEquals("Java 101 by Fred Flintstone is available",book.toString());
    }

    @Test
    void bookToStringCheckedOut() {
        book.checkOutBook(patron1, LocalDate.of(2021,05,04));
        assertEquals("Java 101 by Fred Flintstone is due back 2021-05-04",book.toString());
    }

    @Test
    void setFirstName() {
        author1.setFirstName("Alfred");
        assertEquals("Alfred", author1.getFirstName());
    }

    @Test
    void setFirstNameConstructor() {
        assertEquals("Fred", author1.getFirstName());
    }

    @Test
    void setFirstNameConstructorLowerCase() {
        author1 = new Person("fred", "Flintstone","fred@rocks.com","m", LocalDate.of(1976,01,28));
        assertEquals("Fred", author1.getFirstName());
    }

    @Test
    void setFirstNameInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                author1.setFirstName("a"));
    }

    @Test
    void setFirstNameInvalidWithWhiteSpaces(){
        assertThrows(IllegalArgumentException.class, ()->
                author1.setFirstName("  a  "));
    }

    @Test
    void setFirstNameInvalidWithWhiteSpaces2(){
        assertThrows(IllegalArgumentException.class, ()->
                author1.setFirstName("  a  "));
    }

    @Test
    void setLastName() {
        author1.setLastName("Alfred");
        assertEquals("Alfred", author1.getLastName());
    }

    @Test
    void setLastNameConstructor() {
        assertEquals("Flintstone", author1.getLastName());
    }

    @Test
    void setLastNameConstructorLowerCase() {
        author1 = new Person("fred", "flintstone","fred@rocks.com","m", LocalDate.of(1976,01,28));
        assertEquals("Flintstone", author1.getLastName());
    }

    @Test
    void setLastNameInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                author1.setLastName("a"));
    }

    @Test
    void setLastNameInvalidWithWhiteSpaces(){
        assertThrows(IllegalArgumentException.class, ()->
                author1.setLastName("  a  "));
    }

    @Test
    void setLastNameInvalidWithWhiteSpaces2(){
        assertThrows(IllegalArgumentException.class, ()->
                author1.setLastName("  a  "));
    }
    @Test
    void setGenderMConstructor() {
        assertEquals("male", author1.getGender());
    }


    @Test
    void setGenderM() {
        author1.setGender("M");
        assertEquals("male", author1.getGender());
    }

    @Test
    void setGenderF() {
        author1.setGender("f");
        assertEquals("female", author1.getGender());
    }

    @Test
    void setGenderFUpperCase() {
        author1.setGender("F");
        assertEquals("female", author1.getGender());
    }

    @Test
    void setGenderO() {
        author1.setGender("o");
        assertEquals("other", author1.getGender());
    }

    @Test
    void setGenderOUpperCase() {
        author1.setGender("O");
        assertEquals("other", author1.getGender());
    }

    @Test
    void setCourseNameInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                author1.setGender("ale"));
    }


    @Test
    void setEmailConstructor() {
        assertEquals("fred@rocks.com", author1.getEmail());
    }

    @Test
    void setEmailMethod() {
        author1.setEmail("rocker@rocker.com");
        assertEquals("rocker@rocker.com", author1.getEmail());
    }

    @Test
    void setEmailInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                author1.setEmail(""));
    }

    @Test
    void getAgeMethod() {
        assertEquals(45, author1.getAge());
    }

    @Test
    void getAgeMethod2() {
        author1.setBirthday(LocalDate.of(2000,01,12));
        assertEquals(21, author1.getAge());
    }

    /**
     * Test of setName method, of class Author.
     */
    @Test
    public void testSetName() {
        author1.setFirstName("Barney");
        String expResult = "Barney";
        assertEquals(expResult, author1.getFirstName());
    }

    @Test
    public void testSetBirthdayConstructor() {
        assertEquals(LocalDate.of(1976,01,28), author1.getBirthday());
    }

    @Test
    public void testSetBirthday() {
        author1.setBirthday(LocalDate.of(1967,01,28));
        assertEquals(LocalDate.of(1967,01,28), author1.getBirthday());
    }

    @Test
    void setBirthdayInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                author1.setBirthday(LocalDate.now().plusDays(10)));
    }

    @Test
    void personToString() {
        assertEquals("Fred Flintstone", author1.toString());
    }

    @Test
    void personToString2() {
        author1 = new Person("Wilma", "Flintstone","wilma@rocks.com","m", LocalDate.of(1976,01,28));
        assertEquals("Wilma Flintstone", author1.toString());
    }


    @Test
    void getInitials1() {
        assertEquals("F.F.", author1.getInitials());
    }

    @Test
    void getInitials2() {
        author1 = new Person("Wilma", "Flintstone","fred@rocks.com","m", LocalDate.of(2000,01,28));
        assertEquals("W.F.", author1.getInitials());
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