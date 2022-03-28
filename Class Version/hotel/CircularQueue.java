package hotel;

//Name: Ameesha Senanayake
//UOW ID: w1810205
//IIT ID: 2019771

//Task 4

import java.util.*;

public class CircularQueue<q>{
    //implementing circular queue using generics
    private q deQueuedElement;
    private int front, rear;//rear and front position of the queue
    private int currentSize;//current size of the circular queue
    private q[] circularQueueElements;
    public CircularQueue(int maxSize){
        circularQueueElements=(q[]) new Object[maxSize];//initialising to the maximum size of the queue
        currentSize=0;
        front=-1;
        rear=-1;
    }

    //Enqueue elements to rear end of the circular queue
    public void enqueue(q item) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException("Waiting List is full.No customers cannot be added to the waiting list");
        }
        else {
            rear = (rear + 1) % circularQueueElements.length;
            circularQueueElements[rear] = item;
            currentSize++;

            if (front == -1) {
                front = rear;
            }

        }
    }

    //Dequeue element from front end of the circular queue
    public q dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Waiting List is empty. No customers cannot be retrieved from the waiting list");
        }
        else {
            deQueuedElement = circularQueueElements[front];
            circularQueueElements[front] = null;
            front = (front + 1) % circularQueueElements.length;
            currentSize--;
        }
        return deQueuedElement;
    }

    //Check if the circular queue is full
    public boolean isFull() {
        return (currentSize == circularQueueElements.length);
    }

   //check if the circular queue is empty
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    @Override
    public String toString() {
        return "Waiting List [" + Arrays.toString(circularQueueElements) + "]";
    }

    //return the dequeued elements
    public q getDeQueuedElement() {
        return deQueuedElement;
    }
}


class QueueFullException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QueueFullException(String message) {
        super(message);
    }

}

class QueueEmptyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public QueueEmptyException(String message) {
        super(message);
    }

}
