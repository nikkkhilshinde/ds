package stacksAndQueues;

import stacksAndQueues.animals.Cat;
import stacksAndQueues.animals.Dog;

import java.util.NoSuchElementException;

public class AnimalShelter<T> {

    private static class AnimalNode<T> {
        private T data;
        public AnimalNode<T> next;

        public AnimalNode(T data) {
            this.data = data;
        }
    }

    AnimalNode<T> oldestDog;
    AnimalNode<T> oldestCat;
    AnimalNode<T> oldestCatPrev;
    AnimalNode<T> oldestDogPrev;
    AnimalNode<T> oldest;
    AnimalNode<T> newest;

    public T dequeAny(){
        if(oldest == null) throw new NoSuchElementException();
        T item = oldest.data;

        oldest = oldest.next;


        return item;
    }

    public T dequeueCat() {
        if(oldest == null) throw new NoSuchElementException();
        T item = oldestCat.data;
        AnimalNode<T> oldestCatCopy = oldestCat;
        AnimalNode<T> prev = null;
        while(oldestCat != null){
            if(oldestCat.data.getClass().isInstance(Cat.class)){
                break;
            }
            prev = oldestCat;
            oldestCat = oldestCat.next;
        }
        if(oldestCatCopy == oldest){
            oldest = oldest.next;
        }
        oldestCatPrev = prev;
        return item;
    }

    public T dequeueDog() {
        if(oldest == null) throw new NoSuchElementException();

        T item = oldestDog.data;
        AnimalNode<T> oldestDogCopy = oldestDog;
        AnimalNode<T> prev = null;
        while(oldestDog != null){
            if(oldestDog.data.getClass().isInstance(Dog.class)){
                break;
            }
            prev = oldestDog;
            oldestDog = oldestDog.next;
        }
        if(oldestDogCopy == oldest){
            oldest = oldest.next;
        }
        oldestDogPrev = prev;
        return item;
    }

    public void enqueue(T data) {
        AnimalNode<T> newAnimal = new AnimalNode<>(data);
        if (oldest == null) {
            oldest = newAnimal;
            newest = newAnimal;
            if (newAnimal.getClass().isInstance(Cat.class)) {
                oldestCat = newAnimal;
            } else {
                oldestDog = newAnimal;
            }
        } else {
            if(oldestDog == null || oldestCat == null){
                if (newAnimal.getClass().isInstance(Cat.class)) {
                    oldestCat = newAnimal;
                    oldestCatPrev = oldest;
                } else {
                    oldestDog = newAnimal;
                    oldestDogPrev = oldest;
                }
            }
            oldest.next = newAnimal;
        }
    }
}
