package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AudioBookTest {

    private AudioBook audioBook;
    private Person author;

    @BeforeEach
    void setUp() {

        author = new Person("Fred", "Flintstone","fred@rocks.com","m", LocalDate.of(1976,01,28));
        audioBook = new AudioBook("Java 101", author, 19.99,1800);
    }

    @Test
    void setLengthInSec() {
        audioBook.setLengthInSec(100);
        assertEquals(100, audioBook.getLengthInSec());
    }

    @Test
    void setLengthInSecConstructor() {
        assertThrows(IllegalArgumentException.class, ()->
                new AudioBook("Java 101", author, 19.99,-1));
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
}