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

public class Customer extends CustomerInfo {

    public void decide(Scanner sc) {
        System.out.println("1. To Know The Product Description");
        System.out.println("2. To Know The Product Uses");
        System.out.print("Enter The Number Of Decision You Wish To Execute: ");
        int decision = sc.nextInt();

        switch (decision) {
            case 1:
                System.out.println("1. Fire Extinguisher");
                System.out.println("2. Smoke Detectors");
                System.out.println("3. Fire Sprinklers");
               System.out.print("Enter The Number Of Choice Of Product You Wish To Know: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> System.out.println("Description: A device for extinguishing fires.");
                    case 2 -> System.out.println("Description: A device to detect smoke and trigger alarms.");
                    case 3 -> System.out.println("Description: A device that automatically puts out fires.");
                    default -> System.out.println("Invalid Product Choice!");
                }
                break;

            case 2:
                System.out.println("Product Uses:");
                System.out.println("1. Fire Extinguisher: Used to put out small fires.");
                System.out.println("2. Smoke Detectors: Used to detect smoke and alert occupants.");
                System.out.println("3. Fire Sprinklers: Used to automatically spray water when fire is detected.");
                break;

            default:
                System.out.println("Invalid Decision!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer customer = new Customer();
        customer.input(sc);
        customer.output();
        customer.decide(sc); 
        sc.close();
    }
}
