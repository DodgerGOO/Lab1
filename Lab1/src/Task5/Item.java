public class Item {
    private String name;
    private double weight;
    private double size;

    public Item(String name, double weight, double size) {
        this.name = name;
        this.weight = weight;
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return name + " (Weight: " + weight + "kg, Size: " + size + "cm)";
    }
}
