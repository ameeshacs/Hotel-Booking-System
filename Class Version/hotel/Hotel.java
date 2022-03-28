package hotel;

//Name: Ameesha Senanayake
//UOW ID: w1810205
//IIT ID: 2019771

//Task 4

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Hotel {
    private int roomNum;
    String[] customer=new String[8];
    Scanner in=new Scanner(System.in);
    CircularQueue<String> circularQueue=new CircularQueue(8);


    //method to display the menu and get the input
    public void input(Person[] person){
        try {
            boolean label = true;
            while (label) {
                System.out.println();
                System.out.println("Enter" +
                        "\n V to view rooms " +
                        "\n E to Display empty rooms " +
                        "\n A to add customers " +
                        "\n F to Find customer's room " +
                        "\n O to Sort customers " +
                        "\n D to delete customer " +
                        "\n S to save data " +
                        "\n L to load data " +
                        "\n 6 to stop ");
                String val = in.next();
                System.out.println();

                switch (val.toUpperCase()) {
                    case "V":
                        viewCustomer();
                        break;
                    case "E":
                        emptyRooms();
                        break;
                    case "A":
                        addCustomer(person);
                        break;
                    case "F":
                        findCustomerRoom();
                        break;
                    case "D":
                        deleteCustomer(person);
                        break;
                    case "O":
                        sortCustomer();
                        break;
                    case "S":
                        saveData();
                        break;
                    case "L":
                        loadData();
                        break;
                    case "6":
                        label = false;
                        break;
                    default:
                        System.out.println("Incorrect input");
                        break;
                }//switch
            }//While Loop
        }catch(Exception e){
            System.out.println("Enter the correct input \n");
        }
    }//input method


    //view rooms to see what rooms are empty what rooms are occupied
    public void viewCustomer(){
        for(int i=0;i<customer.length;i++){

            System.out.println("room " +i+ " occupied by " + customer[i]);

        }
        System.out.println();
    }//viewCustomer


    //method to initialise the array so that every room is empty
    public void initialise() {
        for (int x = 0; x < 8; x++ ){
            customer[x] = "e";
            System.out.println( "initialise ");
        }
        System.out.println();
    } //initialise


    //add customers to rooms
    public void addCustomer(Person[] person){
        try {
            boolean isFull = true;
            for (int i = 0; i < 8; i++) {
                if (customer[i].equals("e")) {
                    isFull = false;
                    break;
                }
            }
            //if statement to check whether the room is full
            if (!isFull) {
                System.out.print("Enter a room Number from (0-7) : ");
                this.roomNum = in.nextInt();
                if (customer[roomNum].equals("e")) {
                    System.out.print("Enter the Customer Name: ");
                    customer[roomNum] = in.next();
                    System.out.println(customer[roomNum] + " is added to room number " + roomNum);
                    System.out.println();
                /*getting the input for the first name,last name, number of guests,
                credit card number and adding them to the object array
                */
                    System.out.print("Enter the first name of the payee:");
                    String fName = in.next();
                    person[roomNum].setFirstName(fName);

                    System.out.print("Enter the last name of the payee:");
                    String lName = in.next();
                    person[roomNum].setLastName(lName);

                    System.out.print("Enter the number of guests in the room:");
                    int guest = in.nextInt();
                    person[roomNum].setGuestNum(guest);

                    int s = 1;
                    //loops until a valid card number is entered
                    while (s < 2) {
                        System.out.print("Enter the credit card num:");
                        long card = in.nextLong();
                        System.out.println();
                        //validating the length of the card number
                        if ((theCardSize(card) >= 13 && theCardSize(card) <= 16)) {
                            person[roomNum].setCardNum(card);
                            System.out.println(customer[roomNum] + " is added to room number " + roomNum);
                            System.out.println("The payment for the room is paid by:" + fName + " " + lName);
                            System.out.println("The credit card number is:" + card);
                            System.out.println("The number of guests in the room are:" + guest);
                            s++;
                        } else {
                            System.out.println("Enter a valid card number \n");
                        }
                    }

                } else {
                    System.out.println("Room is occupied, enter another room number");
                }
            } else {
                System.out.println("Rooms are full \n Customer will be added to a waiting list");
                addQueue();
            }
            System.out.println();
        }catch(Exception e){
            System.out.println("Enter the correct input \n");
        }
    }//addCustomer


    //get method to return the customer array
    public String [] getCustomer(){

        return customer;
    }


    //method to enqueue to the circular queue in the CircularQueue class
    public void addQueue(){
        System.out.print("Enter the name: ");
        String name=in.next();
        circularQueue.enqueue(name);
    }


    //method to dequeue to the circular queue in the CircularQueue class
    public void deleteQueue(){
        circularQueue.dequeue();
        System.out.println(circularQueue.getDeQueuedElement() +" in the waiting list will be added to the room");
    }


    //method to find customers
    public void findCustomerRoom(){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the name of the customer:");
        String name=input.next();
        //for loop is used to check each array index for the relevant name
        for(int x=0;x< customer.length;x++) {
            if (customer[x].equals(name)) {
                System.out.println("The room of the customer is "+x);
            }
        }
        System.out.println();
    }//findCustomerRoom


    //method to see the empty rooms
    public void emptyRooms(){
        for(int i=0;i<customer.length;i++){
            // if e is in the array index it will print the room is empty
            if(customer[i].equals("e")){
                System.out.println("Room "+i+" is empty");
            }
        }
        System.out.println();
    }//emptyRooms


    //method to sort customers
    public void sortCustomer(){
        //sorting customers using bubble sort
        String[] hotel1;
        //copying the original array
        hotel1=customer.clone();

        //sorting customers using bubble sort
        for (int i = 0; i < hotel1.length-1; i++)
        {
            for (int j = i+1; j < hotel1.length; j++) {

                //comparing customer names
                if (lessThanString(hotel1[i], hotel1[j])) {
                    String temp = hotel1[i];
                    hotel1[i] = hotel1[j];
                    hotel1[j] = temp;
                }

            }
        }
        System.out.println("Customers in Sorted Order:");
        for (int i = 0; i < 8; i++) {
            if(hotel1[i].equals("e")){
                continue;
            }
            System.out.println(hotel1[i]);
        }
        System.out.println();
    } //sortCustomer


    //method to save data to a file
    public void saveData(){
        try{
            FileOutputStream hotel_file=new FileOutputStream("HotelReservation.txt");
            try (ObjectOutputStream save = new ObjectOutputStream(hotel_file)) {
                save.writeObject(customer);
                save.writeObject(roomNum);
                save.writeObject(customer);
            }
        }catch(IOException e){
            System.out.println("Error Occurred");
            e.printStackTrace();
        }
    }//save data


    //method to load data from a file
    public void loadData(){
        try{
            FileInputStream hotel_file=new FileInputStream("HotelReservation.txt");
            ObjectInputStream save=new ObjectInputStream(hotel_file);
            customer=(String[])save.readObject();
            save.close();
        }catch(Exception exc){
            exc.printStackTrace();
        }
        System.out.println("\n Restored Values:\n");
        System.out.println("\thotel:"+ Arrays.toString(customer));
        System.out.println();
    } //load data


    //method to delete a customer
    public void deleteCustomer(Person[] person){
        boolean isFull=true;
        String del_name;
        for (int i=0;i< 8;i++) {
            if(customer[i].equals("e")){
                isFull=false;
                break;
            }
        }

        Scanner input=new Scanner(System.in);
        System.out.print("Enter the name of the customer to be deleted:");
        del_name = input.next();

        //if all the rooms are not full this block will be interpreted
        if(!isFull) {
            for (int x = 0; x < customer.length; x++) {
                if (customer[x].equals(del_name)) {
                    //replacing the values in the index with its original values
                    customer[x] = "e";
                    person[x].setFirstName(null);
                    person[x].setLastName(null);
                    person[x].setGuestNum(0);
                    person[x].setCardNum(0);
                    System.out.println(del_name+" will be deleted from room "+x);
                }
            }
        }

        //if all the rooms are full this block will be interpreted
        else {
            for(int x=0;x< customer.length;x++) {
                if (customer[x].equals(del_name)) {
                    //replacing the values in the index with its original values
                    customer[x] = "e";
                    person[x].setFirstName(null);
                    person[x].setLastName(null);
                    person[x].setGuestNum(0);
                    person[x].setCardNum(0);
                }
            }
            deleteQueue();

            for (int x = 0; x < customer.length; x++) {
                if (customer[x].equals("e")) {
                    customer[x] = circularQueue.getDeQueuedElement();
                    System.out.print("Enter the first name of the payee:");
                    String fName = in.next();
                    person[x].setFirstName(fName);

                    System.out.print("Enter the last name of the payee:");
                    String lName = in.next();
                    person[x].setLastName(lName);

                    System.out.print("Enter the number of guests in the room:");
                    int guest = in.nextInt();
                    person[x].setGuestNum(guest);

                    System.out.print("Enter the credit card num:");
                    long card = in.nextLong();
                    person[x].setCardNum(card);
                }
            }
        }
    } //delete customer

    //method to validate the length of the card number
    public int theCardSize(long n) {
        String num = n + "";
        return num.length();
    }


    //method to find which first letter of the two strings comes first in the alphabet
    public boolean lessThanString(String s1, String s2) {
        boolean l = true;
        int i, limit;
        String shortString;
        // converting both the strings to lower case
        String first = s1.toLowerCase(), second = s2.toLowerCase();

        // finding the shorter string from both
        if (first.length() <= second.length()) {
            shortString = first;
            limit = first.length();
        } else {
            shortString = second;
            limit = second.length();
        }
        // comparing successively each character one by one if they are same giving the iteration limit as the length of the shorter string
        for (i = 0; i < limit; i++)
            if (first.charAt(i) != second.charAt(i)) {
                if (first.charAt(i) < second.charAt(i))
                    l = false;
                // breaks the loop since the characters are not equal
                break;
            }
        // condition if the same name is in the array
        if (i == limit && first.equals(shortString))
            l = false;
        return l;
    }
}
