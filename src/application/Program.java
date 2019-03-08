package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Product> list = new ArrayList<>();

		System.out.print("Entre com o número de produtos: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Produto #" + i + " dados:");
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char typeProduct = sc.next().charAt(0);
			sc.nextLine();

			System.out.print("Nome:");
			String name = sc.nextLine();
			System.out.print("Preço: ");
			double price = sc.nextDouble();

			if (typeProduct == 'i') {
				System.out.print("Taxa de Alfândega: ");
				double customsFee = sc.nextDouble();

				Product product = new ImportedProduct(name, price, customsFee);
				list.add(product);
			} else if (typeProduct == 'u') {
				System.out.print("Data de manutenção: (DD/MM/YYYY) ");
				Date manufactureDate = sdf.parse(sc.next());

				Product product = new UsedProduct(name, price, manufactureDate);
				list.add(product);
			} else {
				Product product = new Product(name, price);
				list.add(product);
			}

		}
		
		System.out.println();
		System.out.println("Tags de Preço: ");

		for (Product product : list) {
			System.out.println(product.priceTag());
		}

		sc.close();
	}

}
