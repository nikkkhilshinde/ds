package stacksAndQueues;

import java.util.EmptyStackException;

public class MyStackWithMin<T> extends MyStack<T>{

    private final MyStack<Integer> minStack;

    public MyStackWithMin(){
        super();
        minStack = new MyStack<>();
    }

    public void push(T data){
        if(!minStack.isEmpty()){
            if((Integer)data <= minStack.peek()){
                minStack.push((Integer) data);
            }
        }else{
            minStack.push((Integer) data);
        }
        super.push(data);
    }

    public T pop(){
        T t = super.pop();
        if(t == minStack.peek()){
            minStack.pop();
        }
        return t;
    }

    public Integer min(){
        if(isEmpty()) throw new EmptyStackException();
        return minStack.peek();
    }
}
