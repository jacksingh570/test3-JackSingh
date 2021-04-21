/**
 * Jack Singh
 * 1141574
 */

package models;

import java.time.LocalDate;

public class Book {
    private String title;
    private Person author;
    private double price;
    private LocalDate returnDate;
    private Person libraryPatron;

    public Book(String title, Person author, double price) {
        setTitle(title);
        setAuthor(author);
        setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String bookName) {
        bookName = bookName.trim();
        if(bookName.length() >= 2){
            this.title = bookName;
        }else{
            throw new IllegalArgumentException("Must be greater than 2!");
        }

    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person person) {
        this.author = person;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }else{
            throw new IllegalArgumentException("Price must be greater than zero");
        }
    }

    public void checkOutBook(Person libraryPatron, LocalDate dueDate)
    {
        if(isAvailable()){
            if(dueDate.isAfter(LocalDate.now())){
                this.returnDate = dueDate;
                this.libraryPatron = libraryPatron;
            }else{
                throw new IllegalArgumentException("Due date cannot be in the past from checkout day!");
            }
        }else{
            throw new IllegalArgumentException("Book not available");
        }
    }

    public LocalDate getReturnDate()
    {
        return returnDate;
    }

    public boolean isAvailable()
    {
        if(returnDate == null){
            return true;
        }else{
            return false;
        }
    }


    public String toString()
    {
        return null;
    }
}
