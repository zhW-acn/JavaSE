package Rewriting_data_structures;

public class myQueue {

    private myArray myarray = new myArray();

    public void push(int data) {
        myarray.add(myarray.getLength() + 1, data);
    }

    public int pop() {
        Integer query = myarray.query(1);
        myarray.delete(1);
        return query;
    }

    public static void main(String[] args) {
      myQueue myqueue = new myQueue();
        myqueue.push(1);
        myqueue.push(2);
        myqueue.push(3);
        myqueue.pop();
        myqueue.pop();
        myqueue.myarray.printArray();
    }
}
