public class Shipment {
    private Item[] items;
    private String deliveryMethod;
    private String destination;
    private DeparturePoint departurePoint;

    public Shipment(int capacity, String deliveryMethod, String destination, DeparturePoint departurePoint) {
        this.items = new Item[capacity];
        this.deliveryMethod = deliveryMethod;
        this.destination = destination;
        this.departurePoint = departurePoint;
    }

    public boolean addItem(Item item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = item;
                return true;
            }
        }
        return false;
    }

    public void cancelShipment() {
        items = new Item[items.length];
    }

    public boolean canDeliver() {
        // Implement delivery restrictions based on deliveryMethod
        // For example, check weight and size limits for the chosen delivery method
        return true; // Replace with actual logic
    }

    public String getDestination() {
        return destination;
    }

    public void deliver() {
        if (canDeliver()) {
            System.out.println("Delivery successful from: " + departurePoint.getCity() + " to: " + destination);
            items = new Item[items.length];
        } else {
            System.out.println("Delivery failed. Invalid delivery method or exceeded limits.");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Shipment from: " + departurePoint.getCity() + " to: " + destination + " (" + deliveryMethod + ")\n");
        for (Item item : items) {
            if (item != null) {
                result.append("- ").append(item.toString()).append("\n");
            }
        }
        return result.toString();
    }
}
