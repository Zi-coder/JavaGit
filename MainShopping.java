import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
class Product {
    String name;
    int price;
    int quantity;
    Product(String n, int p, int q) {
        name = n;
        price = p;
        quantity = q;
    }
    public void setQuantity(int n) {
        quantity = n;
    }
}
class ShoppingCart {
    List < Product > cart = new ArrayList < Product > ();
    public void addItem(Product p) {
        cart.add(p);
    }
    public void removeItem(Product p) {
        cart.remove(p);
    }
    public void modifyQuantity(Product p, int n) {
        p.setQuantity(n);
    }
    public void subTotal() {
        int sum = 0, temp = 0;
        Product item;
        for (int i = 0; i < cart.size(); i++) {
            item = cart.get(i);

            temp = item.price * item.quantity;
            System.out.println();
            System.out.println(item.name);
            System.out.print("Quantity : " + Integer.toString(item.quantity) + " Price is " + Integer.toString(item.price) + " Cost = " + Integer.toString(temp));
            System.out.println();
            sum += temp;
        }
        double total = sum + sum * 0.18;
        System.out.println("\nTotal With Tax = ");
        System.out.print(total);
        System.out.println();
        System.out.println("Price after rounding of is :");
        System.out.print((int) total);
        System.out.println();

    }
}
public class MainShopping {
    public static void main(String[] args) { //Writing my code here
        Product p1 = new Product("Biscuit", 10, 1);
        Product p2 = new Product("Chips", 25, 2);
        Product p3 = new Product("Kurkure", 25, 1);
        Product p4 = new Product("Coke", 35, 2);
        Product p5 = new Product("Popcorn", 10, 1);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(p1);
        cart.addItem(p2);
        cart.addItem(p3);
        cart.addItem(p4);
        cart.addItem(p5);
        cart.subTotal();
        cart.removeItem(p5);
        cart.modifyQuantity(p1, 5);
        cart.subTotal();

    }
}