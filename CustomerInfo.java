import java.util.Scanner;

class CustomerInfo {
    private int customerID;
    private String customername;

    public void input(Scanner sc) {
        System.out.print("Enter The ID Of The Customer: ");
        customerID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter The Name Of The Customer: ");
        customername = sc.nextLine();
    }

    public void output() {
        System.out.println("CustomerID Is: " + customerID);
        System.out.println("Customer Name Is: " + customername);
    }
}
