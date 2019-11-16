import java.util.EmptyStackException;
import java.util.stream.StreamSupport;

public class Stack {
    int myStack[];
    int SIZE;
    int top = -1;

    public Stack(int size) throws IllegalArgumentException{
        if(size < 0) {
            throw new IllegalArgumentException("Stack's capacity must be positive");
        }
        this.myStack = new int[size]; // create a stack of size
        this.SIZE = size;//update the size
    }

    public int getSize(){
        return top + 1;
    }

    public int getCapacity(){
        return SIZE;
    }

    public boolean isEmpty() {
        if(top == -1)
            return true;
        return false;
    }

    public boolean isFull() {
        if(top == SIZE - 1){
            return true;
        }
        return false;
    }

    public void push(int x) throws StackIsFullException {
        if(this.isFull()) {
            throw new StackIsFullException("Stack is full");
        }

        myStack[++top] = x;
    }
    public int pop() throws StackIsEmptyException {
       if(this.isEmpty())
           throw new StackIsEmptyException("Stack is empty");
       return myStack[top--];
    }

    public int peek() throws StackIsEmptyException {
        if(this.isEmpty())
            throw new StackIsEmptyException("Stack is empty");
        return myStack[top];
    }

    public static void main(String[] args) {
        Stack stack = null;
        try {
            stack = new Stack(3);

            stack.push(0);
            stack.push(5);
            stack.push(2);
            System.out.println(stack.peek());
            System.out.println(stack.pop());
            System.out.println(stack.peek());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());


        }catch (IllegalArgumentException e) {
            System.out.println("Illegal stack size");
            System.out.println(e.getMessage());
        }
        catch (StackIsFullException e) {
            System.out.println(e.getMessage());
        }
        catch (StackIsEmptyException e) {
            System.out.println(e.getMessage());
        };
        int size = stack.getSize();
        try{
            for(int i = 0;i<size;i++){
                System.out.println(stack.pop());
            }
        }catch(StackIsEmptyException e){
            System.out.println(e.getMessage());
        }
    }
}
