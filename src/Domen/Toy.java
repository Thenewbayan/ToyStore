package Domen;


public class Toy {
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
}