import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            System.out.println("Product #" + (i+1) + " data:");
            System.out.print("Common, used or imported: ");
            char priceTag = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if (priceTag == 'i' || priceTag == 'I') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                Product product = new ImportedProduct(name, price, customsFee);
                list.add(product);
            } else if (priceTag == 'c' || priceTag == 'c') {
                Product product = new Product(name, price);
                list.add(product);
            } else if (priceTag == 'u' || priceTag == 'U') {
                System.out.print("Manufacture date (dd/MM/yyy): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Product product = new UsedProduct(name, price, date);
                list.add(product);
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");
        for (Product product : list) {
            System.out.println(product.priceTag());
        }
    }
}