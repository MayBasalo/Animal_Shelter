import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
    private final Queue<Dog> dogs = new LinkedList<>();
    private final Queue<Cat> cats = new LinkedList<>();
    private int order = 0;

    public void inQue(Animal a) {
        a.setOrder(order++);
        if (a instanceof Dog) {
            dogs.add((Dog) a);
        } else if (a instanceof Cat) {
            cats.add((Cat) a);
        } else {
            throw new IllegalArgumentException("Only dogs and cats are allowed.");
        }
    }

    public Animal UnQueAny() {
        if (dogs.isEmpty()) return unQueCat();
        if (cats.isEmpty()) return unQueDog();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        return dog.older(cat) ? unQueDog() : unQueCat();
    }

    public Dog unQueDog() {
        return dogs.poll();
    }

    public Cat unQueCat() {
        return cats.poll();
    }
}
