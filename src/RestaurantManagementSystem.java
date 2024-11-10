import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantManagementSystem {

    // MenuItem class
    static class MenuItem {
        private String name;
        private double price;

        public MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " - $" + price;
        }
    }

    // Order class
    static class Order {
        private ArrayList<MenuItem> items;

        public Order() {
            items = new ArrayList<>();
        }

        public void addItem(MenuItem item) {
            items.add(item);
        }

        public double calculateTotal() {
            double total = 0;
            for (MenuItem item : items) {
                total += item.getPrice();
            }
            return total;
        }

        @Override
        public String toString() {
            StringBuilder orderDetails = new StringBuilder("Order Details:\n");
            for (MenuItem item : items) {
                orderDetails.append(item.toString()).append("\n");
            }
            orderDetails.append("Total: $").append(calculateTotal());
            return orderDetails.toString();
        }
    }

    // Restaurant class
    static class Restaurant {
        private String name;
        private ArrayList<MenuItem> menu;

        public Restaurant(String name) {
            this.name = name;
            this.menu = new ArrayList<>();
        }

        public void addMenuItem(MenuItem item) {
            menu.add(item);
        }

        public ArrayList<MenuItem> getMenu() {
            return menu;
        }

        public String getName() {
            return name;
        }
    }

    // Main method
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("The Great Eatery");
        restaurant.addMenuItem(new MenuItem("Burger", 5.99));
        restaurant.addMenuItem(new MenuItem("Pizza", 7.99));
        restaurant.addMenuItem(new MenuItem("Salad", 4.99));

        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        System.out.println("Welcome to " + restaurant.getName());
        System.out.println("Menu:");
        for (MenuItem item : restaurant.getMenu()) {
            System.out.println(item);
        }

        String choice;
        do {
            System.out.print("Enter menu item name to order (or 'done' to finish): ");
            choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("done")) {
                boolean found = false;
                for (MenuItem item : restaurant.getMenu()) {
                    if (item.getName().equalsIgnoreCase(choice)) {
                        order.addItem(item);
                        System.out.println(item.getName() + " added to your order.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Item not found. Please try again.");
                }
            }
        } while (!choice.equalsIgnoreCase("done"));

        System.out.println(order);
        scanner.close();
    }
}