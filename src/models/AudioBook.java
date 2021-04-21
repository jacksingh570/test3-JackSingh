/**
 * Jack Singh
 * 1141574
 */

package models;

public class AudioBook extends Book {
    private int lengthInSec;

    public AudioBook(String bookName, Person author, double price, int lengthInSec) {
        super(bookName, author, price);
        setLengthInSec(lengthInSec);
    }

    public int getLengthInSec() {
        return lengthInSec;
    }

    public void setLengthInSec(int lengthInSec) {
        if (lengthInSec >= 0){
            this.lengthInSec = lengthInSec;
        }else{
            throw new IllegalArgumentException("A book must have a length in Seconds");
        }
    }
}
