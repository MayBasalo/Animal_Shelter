from collections import deque

class Animal:
    def __init__(self, name, animal_type, order):
        self.name = name
        self.type = animal_type  # "dog" or "cat"
        self.order = order       # Arrival time (used for FIFO)

    def __repr__(self):
        return f"{self.type.capitalize()}({self.name})"


class AnimalShelter:
    def __init__(self):
        self.dogs = deque()
        self.cats = deque()
        self.order = 0  # Global counter to track arrival order

    def enqueue(self, name, animal_type):
        animal = Animal(name, animal_type, self.order)
        self.order += 1

        if animal_type.lower() == "dog":
            self.dogs.append(animal)
        elif animal_type.lower() == "cat":
            self.cats.append(animal)
        else:
            raise ValueError("Only dogs and cats are allowed.")

    def dequeueAny(self):
        if not self.dogs and not self.cats:
            return None
        if not self.dogs:
            return self.dequeueCat()
        if not self.cats:
            return self.dequeueDog()

        # Compare arrival times
        if self.dogs[0].order < self.cats[0].order:
            return self.dequeueDog()
        else:
            return self.dequeueCat()

    def dequeueDog(self):
        return self.dogs.popleft() if self.dogs else None

    def dequeueCat(self):
        return self.cats.popleft() if self.cats else None


# Test code to run when file is executed
if __name__ == "__main__":
    shelter = AnimalShelter()
    shelter.enqueue("Buddy", "dog")
    shelter.enqueue("Whiskers", "cat")
    shelter.enqueue("Rex", "dog")
    shelter.enqueue("Mittens", "cat")

    print("Dequeue Any:", shelter.dequeueAny())   # Should print Dog(Buddy)
    print("Dequeue Cat:", shelter.dequeueCat())   # Should print Cat(Whiskers)
    print("Dequeue Dog:", shelter.dequeueDog())   # Should print Dog(Rex)
    print("Dequeue Any:", shelter.dequeueAny())   # Should print Cat(Mittens)
    print("Dequeue Any:", shelter.dequeueAny())   # Should print None

