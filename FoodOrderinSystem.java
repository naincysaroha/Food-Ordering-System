package Module_1;

class Customer {
    private int cust_id;
    private String cust_name;
    private String mobile;

    public Customer(int cust_id, String cust_name, String mobile) {
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.mobile = mobile;
    }

    public int getcustinfo() {
        return this.cust_id;
    }

    public void setcustid(int id) {
        this.cust_id = id;
    }

    public void displayinfo() {
        System.out.println("Customer ID : " + cust_id);
        System.out.println("Customer Name : " + cust_name);
        System.out.println("Mobile : " + mobile);
    }
}

class fooditem {
    private int itemid;
    private String foodname;
    private double price;

    public fooditem(int itemid, String foodname, double price) {
        this.itemid = itemid;
        this.foodname = foodname;
        this.price = price;
    }

    public double getprice() {
        return this.price;
    }

    public String getitemname() {
        return this.foodname;
    }

    public void displayitem() {
        System.out.println("Item ID : " + itemid);
        System.out.println("Food Name : " + foodname);
        System.out.println("Price : " + price);
    }
}

abstract class discount {
    public abstract double calculatediscount(double billamount);
}

class regularcustomer extends discount {
    public double calculatediscount(double billamount) {
        return billamount * 0.05; // 5% discount
    }
}

class order {
    private int orderid;
    private Customer customer;
    private fooditem[] items;
    private int itemcount;

    public order(int orderid, Customer customer) {
        this.orderid = orderid;
        this.customer = customer;
        this.itemcount = 0;
        this.items = new fooditem[5];
    }

    public void additem(fooditem item) {
        if (itemcount < 5) {
            items[itemcount] = item;
            itemcount++;
        } else {
            System.out.println("Orders are full");
        }
    }

    public double calculatebill() {
        double sum = 0;

        for (int i = 0; i < itemcount; i++) {
            sum += items[i].getprice();
        }

        return sum;
    }

    public void displayorder(discount d) {

        System.out.println("\n========== ORDER DETAILS ==========");
        System.out.println("Order ID : " + orderid);

        System.out.println("\nCustomer Details:");
        customer.displayinfo();

        System.out.println("\nFood Items:");

        for (int i = 0; i < itemcount; i++) {
            items[i].displayitem();
            System.out.println();
        }

        double bill = calculatebill();
        double discountAmount = d.calculatediscount(bill);
        double finalBill = bill - discountAmount;

        System.out.println("Bill Amount : " + bill);
        System.out.println("Discount : " + discountAmount);
        System.out.println("Amount To Pay : " + finalBill);
    }
}

public class FoodOrderinSystem {

    public static void main(String[] args) {

        Customer c1 = new Customer(10, "Ayush", "9368520860");

        fooditem f1 = new fooditem(1, "Burger", 50);
        fooditem f2 = new fooditem(2, "Aloo Paratha", 40);
        fooditem f3 = new fooditem(3, "Vada Pao", 30);

        order o1 = new order(101, c1);

        o1.additem(f1);
        o1.additem(f2);
        o1.additem(f3);

        discount d = new regularcustomer();

        o1.displayorder(d);
    }
}
