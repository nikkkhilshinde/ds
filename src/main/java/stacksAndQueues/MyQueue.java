package stacksAndQueues;

import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

public class MyQueue<T> {
    private static class QueueNode<T>{
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data){
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T data){

        QueueNode<T> item = new QueueNode<>(data);
        if(first == null){
            first = item;
        }else{
            last.next = item;
        }
        last = item;
    }

    public T remove(){
        if(first == null) throw new NoSuchElementException();
        QueueNode<T> item = first;
        first = first.next;
        if(first == null){
            last = null;
        }
        return item.data;
    }

    public T peek(){
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty(){
        return (first == null);
    }
}
