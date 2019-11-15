import java.util.EmptyStackException;
import java.util.stream.StreamSupport;

public class Stack {
    int myStack[];
    int SIZE;
    int top = -1;

    public Stack(int size) {
        if(size < 0) {
            throw new IllegalArgumentException("Stack's capacity must be positive");
        }
        this.myStack = new int[size]; // create a stack of size
        this.SIZE = size;//update the size
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
    public int pop() {
       if(this.isEmpty())
           throw new EmptyStackException();
       return myStack[top--];
    }

    public int peek() {
        if(this.isEmpty())
            throw new EmptyStackException();
        return myStack[top];
    }

    public static void main(String[] args) {
        try {
            Stack stack = new Stack(3);


            stack.push(0);
            stack.push(5);
            stack.push(2);
            stack.push(2);
            stack.push(2);
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
        }
        catch (StackIsFullException e) {
            System.out.println(e.getMessage());
        }
        catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }
    }
}
