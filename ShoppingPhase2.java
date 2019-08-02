import java.util.*;
class Product {
    String name;
    int price;
    int quantity;
    String type ;
    Date date;
    Product(String n, int p, int q,String t) {
        name = n;
        price = p;
        quantity = q;
        type = t;
        date = new Date();
    }
    public void setQuantity(int n) {
        if( n*-1 > this.quantity )
            System.out.println("Exceeded existing quantity\n-----------x---------x---------");
        else
            quantity += n;
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

    public void modQuantity(Product p,int n){
        p.setQuantity(n);
    }
    public void subTotal() {
        int sum = 0;
        double temp = 0;
        Product item;
        for (int i = 0; i < cart.size(); i++) {
            item = cart.get(i);
            if(item.type == "or")
                temp = item.price * item.quantity + (item.price *0.05);
            if(item.type == "s")
                temp = item.price * item.quantity + (item.price *0.05);
            if(item.type == "ot")
                temp = item.price * item.quantity + (item.price *0.10);
            if(item.type == "lux")
                temp = item.price * item.quantity + (item.price *0.15);




            System.out.println();
            System.out.println(item.name);
            System.out.print("Quantity : " + Integer.toString(item.quantity) + " Price is " + Integer.toString(item.price) + " Cost = " + Double.toString(temp));
            System.out.println();
            sum += temp;
        }

        double total = sum;
        System.out.println("\nTotal With Tax = ");
        System.out.print(total);
        System.out.println();
        System.out.println("Price after rounding of is :");
        System.out.print((int) total);
        System.out.println();

    }
    public void retu (Date ret,Product p){
        System.out.println("Return Date ");
        System.out.print(ret);
        System.out.println("\nDate of Purchase ");
        System.out.print(p.date);

        System.out.println("\nFood can be returned within 1 day of date of purchase.\n" +
                "Apperel can be returned within 31 days of date of purchase with tag intact.");


    }
}
public class ShoppingPhase2 {
    public static void main(String[] args) { //Writing my code here
        Product p1 = new Product("Biscuit", 10, 1,"or");
        Product p2 = new Product("Chips", 25, 2,"or");
        Product p3 = new Product("T-Shirt", 25, 1,"s");
        Product p4 = new Product("Decor", 35, 2,"ot");
        Product p5 = new Product("Watch", 10, 1,"lux");

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(p1);
        cart.addItem(p2);
        cart.addItem(p3);
        cart.addItem(p4);
        cart.addItem(p5);
        cart.subTotal();
        cart.removeItem(p5);
        cart.modQuantity(p1,4);
        cart.subTotal();
        Date retur = new Date(1019,9,4);
        cart.retu(retur,p1);

    }
}