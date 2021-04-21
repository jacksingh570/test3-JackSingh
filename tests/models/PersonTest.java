package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person validPerson;

    @BeforeEach
    void setUp() {
        validPerson = new Person("Fred", "Flintstone","fred@rocks.com","m", LocalDate.of(1976,01,28));
    }

    @Test
    void setFirstName() {
        validPerson.setFirstName("Alfred");
        assertEquals("Alfred", validPerson.getFirstName());
    }

    @Test
    void setFirstNameConstructor() {
        assertEquals("Fred", validPerson.getFirstName());
    }

    @Test
    void setFirstNameConstructorLowerCase() {
        validPerson = new Person("fred", "Flintstone","fred@rocks.com","m", LocalDate.of(1976,01,28));
        assertEquals("Fred", validPerson.getFirstName());
    }

    @Test
    void setFirstNameInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                validPerson.setFirstName("a"));
    }

    @Test
    void setFirstNameInvalidWithWhiteSpaces(){
        assertThrows(IllegalArgumentException.class, ()->
                validPerson.setFirstName("  a  "));
    }

    @Test
    void setFirstNameInvalidWithWhiteSpaces2(){
        assertThrows(IllegalArgumentException.class, ()->
                validPerson.setFirstName("  a  "));
    }

    @Test
    void setLastName() {
        validPerson.setLastName("Alfred");
        assertEquals("Alfred", validPerson.getLastName());
    }

    @Test
    void setLastNameConstructor() {
        assertEquals("Flintstone", validPerson.getLastName());
    }

    @Test
    void setLastNameConstructorLowerCase() {
        validPerson = new Person("fred", "flintstone","fred@rocks.com","m", LocalDate.of(1976,01,28));
        assertEquals("Flintstone", validPerson.getLastName());
    }

    @Test
    void setLastNameInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                validPerson.setLastName("a"));
    }

    @Test
    void setLastNameInvalidWithWhiteSpaces(){
        assertThrows(IllegalArgumentException.class, ()->
                validPerson.setLastName("  a  "));
    }

    @Test
    void setLastNameInvalidWithWhiteSpaces2(){
        assertThrows(IllegalArgumentException.class, ()->
                validPerson.setLastName("  a  "));
    }
    @Test
    void setGenderMConstructor() {
        assertEquals("male", validPerson.getGender());
    }


    @Test
    void setGenderM() {
        validPerson.setGender("M");
        assertEquals("male", validPerson.getGender());
    }

    @Test
    void setGenderF() {
        validPerson.setGender("f");
        assertEquals("female", validPerson.getGender());
    }

    @Test
    void setGenderFUpperCase() {
        validPerson.setGender("F");
        assertEquals("female", validPerson.getGender());
    }

    @Test
    void setGenderO() {
        validPerson.setGender("o");
        assertEquals("other", validPerson.getGender());
    }

    @Test
    void setGenderOUpperCase() {
        validPerson.setGender("O");
        assertEquals("other", validPerson.getGender());
    }

    @Test
    void setCourseNameInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
               validPerson.setGender("ale"));
    }


    @Test
    void setEmailConstructor() {
        assertEquals("fred@rocks.com", validPerson.getEmail());
    }

    @Test
    void setEmailMethod() {
        validPerson.setEmail("rocker@rocker.com");
        assertEquals("rocker@rocker.com", validPerson.getEmail());
    }

    @Test
    void setEmailInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                validPerson.setEmail(""));
    }

    @Test
    void getAgeMethod() {
        assertEquals(45, validPerson.getAge());
    }

    @Test
    void getAgeMethod2() {
        validPerson.setBirthday(LocalDate.of(2000,01,12));
        assertEquals(21, validPerson.getAge());
    }

    /**
     * Test of setName method, of class Author.
     */
    @Test
    public void testSetName() {
        validPerson.setFirstName("Barney");
        String expResult = "Barney";
        assertEquals(expResult, validPerson.getFirstName());
    }

    @Test
    public void testSetBirthdayConstructor() {
        assertEquals(LocalDate.of(1976,01,28), validPerson.getBirthday());
    }

    @Test
    public void testSetBirthday() {
        validPerson.setBirthday(LocalDate.of(1967,01,28));
        assertEquals(LocalDate.of(1967,01,28), validPerson.getBirthday());
    }

    @Test
    void setBirthdayInvalid(){
        assertThrows(IllegalArgumentException.class, ()->
                validPerson.setBirthday(LocalDate.now().plusDays(10)));
    }

    @Test
    void personToString() {
        assertEquals("Fred Flintstone", validPerson.toString());
    }

    @Test
    void personToString2() {
        validPerson = new Person("Wilma", "Flintstone","wilma@rocks.com","m", LocalDate.of(1976,01,28));
        assertEquals("Wilma Flintstone", validPerson.toString());
    }


    @Test
    void getInitials1() {
        assertEquals("F.F.", validPerson.getInitials());
    }

    @Test
    void getInitials2() {
        validPerson = new Person("Wilma", "Flintstone","fred@rocks.com","m", LocalDate.of(2000,01,28));
        assertEquals("W.F.", validPerson.getInitials());
    }

}