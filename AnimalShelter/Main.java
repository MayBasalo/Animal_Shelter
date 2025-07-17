public class Main {
    public static void main(String[] args) {
        AnimalShelter s = new AnimalShelter();
        s.inQue(new Dog("Muffin"));
        s.inQue(new Dog("Ursala"));
        s.inQue(new Cat("Scruggz"));
        s.inQue(new Cat("Tulgey"));
        s.inQue(new Dog("Bertha"));
        s.inQue(new Cat("Marcie"));
        s.inQue(new Dog("Finkle"));
        s.inQue(new Cat("Bingus"));

        System.out.printf("\nAny animal: %s", s.UnQueAny().getName());
        System.out.printf("\nCat only: %s", s.unQueCat().getName());
        System.out.printf("\nDog only: %s", s.unQueDog().getName());
    }
}
