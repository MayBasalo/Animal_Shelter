public abstract class Animal {
    private final String name;
    private int order;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean older(Animal other) {
        return this.order < other.getOrder();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + name + ")";
    }
}

