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
        firstName = firstName.trim();
        if(firstName.length() >= 2){
            firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
            this.firstName = firstName;
        }else{
            throw new IllegalArgumentException("There must be at least 2 blank spaces");
        }
    }

    public void setLastName(String lastName) {
        lastName = lastName.trim();
        if(lastName.length() >= 2){
            lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
            this.lastName = lastName;
        }else{
            throw new IllegalArgumentException("There must be at least 2 blank spaces");
        }
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