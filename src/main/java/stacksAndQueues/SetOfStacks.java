package stacksAndQueues;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class SetOfStacks<T> {
    private static final int THRESHOLD = 10;
    private static int count = 0;
    private static int currentStack = 0;
    private final ArrayList<MyStack<T>> stacks;

    public SetOfStacks(){
        stacks = new ArrayList<>();
        MyStack<T> t = new MyStack<>();
        stacks.add(t);
    }
    public int getStacksCount(){
        return currentStack;
    }
    public T peek(){
        return stacks.get(currentStack).peek();
    }
    public T popAt(int index){
        if(stacks.size() < index) throw new NoSuchElementException();

        return stacks.get(index).pop();
    }
    public void push(T data){
        if(count == THRESHOLD){
            count = 0;
            MyStack<T> myStack = new MyStack<>();
            stacks.add(myStack);
            currentStack++;
        }
        stacks.get(currentStack).push(data);
        count++;
    }
    public T pop(){
        T t = stacks.get(currentStack).pop();
        if(stacks.get(currentStack).isEmpty()){
            System.out.println("Emptied");
            stacks.remove(currentStack);
            currentStack--;
        }
        return t;
    }
}
