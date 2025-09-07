import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter Client Data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth Date (DD/MM/YYYY): ");
        String birthDateStr = sc.nextLine();
        Date birthDate = sdf.parse(birthDateStr);

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order Data:");
        System.out.print("Status: ");
        String statusStr = sc.nextLine();

        Order order = new Order();
        order.setClient(client);
        order.setStatus(OrderStatus.valueOf(statusStr.toUpperCase()));

        System.out.print("How many items to this order? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product Name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product Price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            OrderItem item = new OrderItem(productName, quantity, productPrice);
            order.addItem(item);
        }

        System.out.println("\nORDER SUMMARY:");
        System.out.println(order);

        sc.close();
    }
}