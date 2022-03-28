package hotel;
//Name: Ameesha Senanayake
//UOW ID: w1810205
//IIT ID: 2019771

//Task 4

import java.util.Scanner;

public class ClassTester {
    public static void main(String[] args) {
        Hotel hotel=new Hotel();
        Room[]room=new Room[8];
        Person[] person=new Person[8]; //creating person object array to store the data

        Scanner input=new Scanner(System.in);

        hotel.initialise();

        System.out.println("Want to start the process? [y/n]");
        char yn=input.next().charAt(0);

        //initialising the person object array
        for(int i=0;i< person.length;i++){
            person[i]=new Person();
        }
        if(yn=='Y'||yn=='y'){

            hotel.input(person);

        }

        String[] a;
        a=hotel.getCustomer();
        for(int i=0;i<8;i++){
            if(a[i]!=null){
                room[i]=new Room(i,a[i]);
                System.out.println(room[i]); //display the toString in room class
                System.out.println(person[i]); //display the toString in person class
            }

        }

    }
}
