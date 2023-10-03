import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReceivePoint deliveryService = new ReceivePoint(10);

        while (true) {
            System.out.println("\nDelivery Service Menu:");
            System.out.println("1. Create Shipment");
            System.out.println("2. Add Item to Shipment");
            System.out.println("3. View Shipments");
            System.out.println("4. Cancel Shipment");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter delivery method (Truck/Train/Bus/Bicycle): ");
                    String deliveryMethod = scanner.nextLine();
                    System.out.print("Enter destination address: ");
                    String destination = scanner.nextLine();

                    // Вибір місця відправлення
                    System.out.println("Select departure point:");
                    System.out.println("1. Lviv");
                    System.out.println("2. Kyiv");
                    System.out.println("3. Poltava");
                    System.out.println("4. Kharkiv");
                    System.out.println("5. Lytsk");
                    int departureChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    DeparturePoint departurePoint;
                    switch (departureChoice) {
                        case 1:
                            departurePoint = new DeparturePoint("Lviv");
                            break;
                        case 2:
                            departurePoint = new DeparturePoint("Kyiv");
                            break;
                        case 3:
                            departurePoint = new DeparturePoint("Poltava");
                            break;
                        case 4:
                            departurePoint = new DeparturePoint("Kharkiv");
                            break;
                        case 5:
                            departurePoint = new DeparturePoint("Lytsk");
                            break;
                        default:
                            System.out.println("Invalid departure point choice.");
                            continue;
                    }

                    if (deliveryService.createShipment(deliveryMethod, destination, departurePoint)) {
                        System.out.println("Shipment created successfully.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the index of the shipment to add an item to: ");
                    int shipmentIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Перевірка коректності індексу
                    if (shipmentIndex >= 1 && shipmentIndex <= deliveryService.getShipmentCount()) {
                        System.out.print("Enter item name: ");
                        String itemName = scanner.nextLine();
                        System.out.print("Enter item weight (in kg): ");
                        double itemWeight = scanner.nextDouble();
                        System.out.print("Enter item size (in cm): ");
                        double itemSize = scanner.nextDouble();
                        Item item = new Item(itemName, itemWeight, itemSize);

                        // Додавання товару до відправлення
                        if (deliveryService.addItemToShipment(shipmentIndex, item)) {
                            System.out.println("Item added to shipment " + shipmentIndex + ".");
                        } else {
                            System.out.println("Item could not be added to shipment. Check weight and size limits.");
                        }
                    } else {
                        System.out.println("Invalid shipment index.");
                    }
                    break;
                case 3:
                    deliveryService.viewShipments();
                    break;
                case 4:
                    System.out.print("Enter the index of the shipment to cancel: ");
                    int index = scanner.nextInt();
                    deliveryService.cancelShipment(index);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
