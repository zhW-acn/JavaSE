package Rewriting_data_structures;

public class myStack {

    private myArray myarray = new myArray();

    public void push(int data){
        myarray.add(myarray.getLength() + 1,data);
    }
    public int pop(){
        Integer query = myarray.query(myarray.getLength());
        myarray.delete(myarray.getLength());
        return query;
    }

    public static void main(String[] args) {
        myStack mystack = new myStack();
        mystack.push(1);
        mystack.push(2);
        mystack.push(3);
        mystack.pop();
        mystack.pop();
        mystack.myarray.printArray();
    }
}
