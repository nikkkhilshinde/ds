package stacksAndQueues;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class QueueViaStacks<T> {
    private final MyStack<T> s1;
    private final MyStack<T> s2;

    public QueueViaStacks(){
        s1 = new MyStack<>();
        s2 = new MyStack<>();
    }

    public T remove(){
        if(s1.isEmpty() && s2.isEmpty()) throw new NoSuchElementException();
        try {
            while(true){
                s2.push(s1.pop());
            }
        }catch (EmptyStackException e){
            return s2.pop();
        }
    }

    public void add(T data){
        try{
            while(true){
                s1.push(s2.pop());
            }
        }catch (EmptyStackException e){
            s1.push(data);
        }
    }
}
