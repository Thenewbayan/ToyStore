

public class Toy {
    public String name;
    public int id;
    public int chance;
    public int quantity;
    
    public Toy(String name, int id, int chance, int quantity) {
        this.name = name;
        this.id = id;
        this.chance = chance;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getChance() {
        return chance;
    }
    public void setChance(int chance) {
        this.chance = chance;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
}
