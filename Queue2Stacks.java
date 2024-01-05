import java.util.Stack;

public class Queue2Stacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    //constructor
    public Queue2Stacks (){
        stack1= new Stack<>();
        stack2 = new Stack<>();
        size = 0;
    }
    // Function to enqueue an item to the queue O(1).
    public void enQueue(int x) {
      stack1.push(x);
      size++;
    }

    // Function to deQueue an item from queue O(N) in general
    public int deQueue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (stack2.isEmpty()){
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        size--;
        return  stack2.pop();
    }
    // Function returns true if the queue is empty,
    // otherwise it returns false.
    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        return false;
    } // O(1).
    // Function returns the number of items, stored in the queue.
    public int size(){
        return size;
    }// O(1).
}


