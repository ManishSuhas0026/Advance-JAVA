import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Comparator;

public class AmazonCRMSystem {
    public static void main(String[] args) {
        // ArrayList Implementation
        ArrayList<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Zoro"));
        customerList.add(new Customer("Sanji"));
        for (Customer customer : customerList) {
            System.out.println("Customer: " + customer.getName());
        }

        // HashMap Implementation
        HashMap<String, Product> productCatalog = new HashMap<>();
        productCatalog.put("001", new Product("Laptop"));
        productCatalog.put("002", new Product("Smartphone"));
        Product laptop = productCatalog.get("001");
        if (laptop != null) {
            System.out.println("Product: " + laptop.getName());
        }

        // HashSet Implementation
        HashSet<Product> uniqueProducts = new HashSet<>();
        uniqueProducts.add(new Product("Laptop"));
        uniqueProducts.add(new Product("Smartphone"));
        uniqueProducts.add(new Product("Laptop")); // Duplicate, won't be added
        for (Product product : uniqueProducts) {
            System.out.println("Product: " + product.getName());
        }

        // TreeSet Implementation
        TreeSet<Customer> sortedCustomerSet = new TreeSet<>(new CustomerComparator());
        sortedCustomerSet.add(new Customer("Zoro"));
        sortedCustomerSet.add(new Customer("Sanji"));
        for (Customer customer : sortedCustomerSet) {
            System.out.println("Customer: " + customer.getName());
        }
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class CustomerComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        return c1.getName().compareTo(c2.getName());
    }
}
