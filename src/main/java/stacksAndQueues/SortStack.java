package stacksAndQueues;

public class SortStack<T> {
    private final MyStack<T> unsorted;
    private final MyStack<T> sorted;

    public SortStack() {
        unsorted = new MyStack<>();
        sorted = new MyStack<>();
    }

    public void push(T data) {
        unsorted.push(data);
        sortStack();
    }

    public T pop() {
        return sorted.pop();
    }

    private void sortStack() {
        while (!unsorted.isEmpty()) {
            if (sorted.isEmpty()) {
                sorted.push(unsorted.pop());
            } else {
                int count = 0;
                T t = unsorted.pop();
                while (!sorted.isEmpty() && (Integer) t >= (Integer) sorted.peek()) {
                    unsorted.push(sorted.pop());
                    count++;
                }

                sorted.push(t);
                for (int i = 0; i < count; i++) {
                    sorted.push(unsorted.pop());
                }
            }
        }
    }
}
