package hotel;

//Name: Ameesha Senanayake
//UOW ID: w1810205
//IIT ID: 2019771

//Task 4

public class Person {
    private int guestNum;
    private String firstName;
    private String lastName;
    private long cardNum;


    //constructor for the person class
    public Person(){
        guestNum=0;
        firstName=null;
        lastName=null;
        cardNum=0;
    }

    //set method for first name
    public void setFirstName(String name){

        firstName=name;
    }

    //set method for last name
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    //set method for the number of guests
    public void setGuestNum(int guestNum) {

        this.guestNum = guestNum;
    }

    //set method for the credit card number
    public void setCardNum(long cardNum) {

        this.cardNum = cardNum;
    }

    //get method for first name
    public String getFirstName() {

        return firstName;
    }

    //get method for last name
    public String getLastName() {

        return lastName;
    }

    //get method for credit card num
    public long getCardNum() {

        return cardNum;
    }

    //get method for number of guests
    public int getGuestNum() {

        return guestNum;
    }

    //toString to print all the data
    public String toString(){
        return "first Name is "+getFirstName()
                +"\n Last name is "+getLastName()
                +"\n car Num is "+getCardNum()
                +"\n No of Guests are " +getGuestNum()
                + "\n";
    }
}
