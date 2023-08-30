package Domen;


public class Toy {
    private static int nextId = 1;
    private String name;
    private int id;
    private int probability;
    private int quantity;

    public Toy(String name, int id, int probability, int quantity) {
        this.name = name;
        this.id = id;
        this.probability = probability;
        this.quantity = quantity;
    }

    public Toy(String name, int probability, int quantity) {
        this.name = name;
        this.probability = probability;
        this.quantity = quantity;
        this.id = nextId++; // присваивание id и увеличение счетчика
    }

    public static void setNextId(int id) {
        nextId = id;
    }

    public static int getNextId() {
        return nextId;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getProbability() {
        return probability;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Toy [name=" + name + ", id=" + id + ", probability=" + probability + ", quantity=" + quantity + "]";
    }
}