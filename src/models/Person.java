/**
 * Jack Singh
 * 647-278-8840
 */

package models;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String firstName, lastName, email;
    private String gender;
    private LocalDate birthday;

    public Person(String firstName, String lastName, String email, String gender, LocalDate birthday) {
        setFirstName(firstName);
        setBirthday(birthday);
        setLastName(lastName);
        setBirthday(birthday);
        setEmail(email);
        setGender(gender);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
    }

    public void setLastName(String lastName) {
    }

    public void setBirthday(LocalDate birthday) {
    }

    public void setGender(String gender) {
    }
  
    public void setEmail(String email) {
    }

    public String getInitials()
    {
        return null;
    }

    public int getAge()
    {
        return -1;
    }
    
    @Override
    public String toString()
    {
        return null;
    }
}