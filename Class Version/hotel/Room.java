package hotel;

//Name: Ameesha Senanayake
//UOW ID: w1810205
//IIT ID: 2019771

//Task 4

public class Room {
    int roomNum;
    String customerName;

    //constructor for room
    public Room(int num,String name){
        roomNum=num;
        customerName=name;
    }

    //get method for roomNum
    public int getRoomNum(){

        return this.roomNum;
    }

    //get method for customer name
    public String getCustomerName(){

        return this.customerName;
    }

    //to String to display the final data for each room
    public String toString() {

        return getCustomerName()+" is in room"+getRoomNum();
    }

}
