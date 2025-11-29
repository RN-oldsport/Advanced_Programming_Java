package BigRestaurantPublic;


import java.util.ArrayList;

abstract class Person {

    private String name;
    private String phoneNumber;

    public Person(String name, String phone) {
        this.name = name;
        this.phoneNumber = phone;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public abstract String getInfo();

}


class Customer extends Person {

    private static int counter = 1;
    private String customerId;
    private int loyaltyPoints = 0;

    public Customer(String name, String phone) {
        super(name, phone);
        this.customerId = "C" + String.format("%03d", counter++);
    }

    public String getCustomerId(){
        return customerId;
    }

    public int getLoyaltyPoints(){
        return loyaltyPoints;
    }

    public void addLoyaltyPoints(double payment) {
        if (payment > 1000000) {loyaltyPoints += 2;}
        else if (payment > 500000) {loyaltyPoints += 1;}
    }

    public double getDiscount() {
        if (loyaltyPoints > 5) {return 0.1;}
        if (loyaltyPoints > 3) {return 0.05;}
        return 0;
    }

    @Override
    public String getInfo() {
        return String.format("ID: %s, Name: %s, Phone: %s, Loyalty Points: %d", this.customerId, super.getName(), super.getPhoneNumber(), this.loyaltyPoints);
    }
}


class Employee extends Person {

    private static int counter = 1;
    private String employeeId;
    private int hoursWorked;
    private String position;
    private double baseSalary;

    public Employee(String name, String phone, double baseSalary, String position, int hoursWorked) {
        super(name, phone);
        this.employeeId = "E" + String.format("%03d", counter++);
        this.hoursWorked = hoursWorked;
        this.position = position;
        this.baseSalary = baseSalary;
    }

    public void addHoursWorked() {
        this.hoursWorked += 1;
    }

    public double calculateSalary() {
        if (hoursWorked <= 160) {
            return baseSalary;
        }

        double overtimeSalary = (hoursWorked - 160) * 1.5 * baseSalary / 160;
        return baseSalary + overtimeSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getInfo() {
        return String.format("ID : %s, Name : %s, Phone : %s, Position : %s, HoursWorked: %s", this.employeeId, super.getName(), super.getPhoneNumber(), this.position,  this.hoursWorked);
    }
}


abstract class MenuItem {

    enum Category {
        FOOD,
        BEVERAGE
    }

    private int itemId;
    private String name;
    private double price;
    private Category category;

    public MenuItem (int itemId, String name, double price,  Category category) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public abstract String getDetails ();
    // getter setter
}


class Food extends MenuItem {

    enum SpiceLevel {
        MILD,
        MEDIUM,
        SPICY,
    }

    private SpiceLevel spiceLevel;
    private int preparationTime;

    public Food(int itemId, String name, double price, SpiceLevel spiceLevel, int preparationTime) {
        super(itemId, name, price, Category.FOOD);
        this.spiceLevel = spiceLevel;
        this.preparationTime = preparationTime;
    }

    @Override
    public String getDetails() {
        return String.format("ID: %d, Name: %s, Price: %2f, Category: %s, Spice: %s, Preparation Time: %dmin", super.getItemId(), super.getName(), super.getPrice(), super.getCategory(), spiceLevel, preparationTime);
    }
}


class Beverage extends MenuItem {

    enum Temper {
        HOT,
        COLD
    }

    enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    Size size;
    Temper temperature;

    public Beverage(int itemId, String name, double price, Size size, Temper temperature) {
        super(itemId, name, price, Category.BEVERAGE);
        this.size = size;
        this.temperature = temperature;
    }

    public Temper getTemperature() {
        return temperature;
    }

    @Override
    public String getDetails() {
        return String.format("ID: %d, Name: %s, Price: %2f, Category: %s, Size: %s, Temperature: %s", super.getItemId(), super.getName(), super.getPrice(), super.getCategory(), size, temperature);
    }
}


class Order {

    private static int counter = 1;
    private int orderId;
    private Customer customer;
    private ArrayList<MenuItem> items;
    private double totalAmount;

    public Order(Customer customer) {
        this.orderId = counter++;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addOrderItem(MenuItem item) {
        this.items.add(item);
        this.calculateTotal();
    }

    public void calculateTotal() {
        totalAmount = 0.0;
        for (MenuItem item : items) {
            totalAmount += item.getPrice();
        }

        customer.addLoyaltyPoints(totalAmount);

        if (customer.getDiscount() != 0) {
            double off = customer.getDiscount() * totalAmount;
            totalAmount -= off;
        }
    }

    public void getOrderSummary() {

        StringBuilder itemsList = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            itemsList.append(items.get(i).getName());
            if (i < items.size() - 1) {
                itemsList.append(" - ");
            }
        }
        
        System.out.printf("OrderI ID: %d, Customer: %s, Total Amount: %2f\nItems: %s", orderId, customer, totalAmount, itemsList.toString());
    }
}


public class BigRestaurant {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Sarah", "0998xxx1256", 25000000, "chef", 185));
        employees.add(new Employee("Magenta", "0922xxx7864",  18000000,"waitress", 170));
        employees.add(new Employee("Oliver", "0933xxx4534",  20000000,"accountant", 190));

        Customer customer1 = new Customer("Anastasia Bell", "0912xxx2323");
        Customer customer2 = new Customer("Adriana Casey", "0918xxx4566");
        Customer customer3 = new Customer("Quentin Dickson", "0911xxx3433");
        Customer customer4 = new Customer("Diana Wolfe", "013xxx4322");
        Customer customer5 = new Customer("Zachery Lynch", "013xxx3411");

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        Food kebab = new Food(1, "kebab", 760000, Food.SpiceLevel.MEDIUM, 30);
        Beverage cocktail = new Beverage(1, "cocktail", 372000, Beverage.Size.LARGE, Beverage.Temper.COLD);
        Beverage mocktail = new Beverage(2, "mocktail", 348000, Beverage.Size.LARGE, Beverage.Temper.COLD);
        Food pizza = new Food(2, "pizza", 550000, Food.SpiceLevel.SPICY, 30);
        Beverage water = new Beverage(3, "water", 60000,  Beverage.Size.LARGE, Beverage.Temper.COLD);
        Food salad = new Food(3, "salad", 1980000, Food.SpiceLevel.MILD, 15);

        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(kebab);
        menuItems.add(cocktail);
        menuItems.add(mocktail);
        menuItems.add(pizza);
        menuItems.add(water);
        menuItems.add(salad);


        Order order1 = new Order(customers.get(0));
        order1.addOrderItem(kebab);
        order1.addOrderItem(mocktail);
        order1.addOrderItem(water);

        Order order2 = new Order(customers.get(1));
        order2.addOrderItem(pizza);
        order2.addOrderItem(salad);
        order2.addOrderItem(water);

        Order order3 = new Order(customers.get(2));
        order3.addOrderItem(pizza);
        order3.addOrderItem(cocktail);
        order3.addOrderItem(salad);

        Order  order4 = new Order(customers.get(3));
        order4.addOrderItem(kebab);
        order4.addOrderItem(cocktail);
        order4.addOrderItem(salad);

        Order order5 = new Order(customers.get(4));
        order5.addOrderItem(pizza);
        order5.addOrderItem(kebab);
        order5.addOrderItem(salad);

        // Everyone's salary calculation
        for (Employee employee : employees) {
            System.out.println(employee.getName() + "'s Salary: " + employee.calculateSalary() + " (" + employee.getPosition() + ")");
        }

        // Finding the most loyal customer.
        int maxLP = 0;
        String theirName = "";
        for (Customer customer : customers) {
            if (customer.getLoyaltyPoints() > maxLP) {
                maxLP = customer.getLoyaltyPoints();
                theirName = customer.getName();
            }
        }
        System.out.println("\n" + theirName + " with loyalty points " + maxLP + ", is the most loyal customer ever.");

        // summery of customers, employees and menu items.
        System.out.println("\nOur Beloved Customers:");
        for  (Customer customer : customers) {
            System.out.println(customer.getName() + " with loyalty points " + customer.getLoyaltyPoints());
        }

        System.out.println("\nOur Dear Hard-Working Staff:");
        for (Employee employee : employees) {
            System.out.println(employee.getPosition() + " " + employee.getName());
        }

        System.out.println("\nOur Delicious Menu Items Marvel:");
        for (MenuItem item : menuItems) {
            System.out.println(item.getName() + " " + item.getCategory());
        }

    }
}
