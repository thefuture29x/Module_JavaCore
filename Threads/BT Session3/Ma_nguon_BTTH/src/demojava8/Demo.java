package demojava8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
	static List<Product> listProduct = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Demo proRun = new Demo();
		do {
			System.out.println("*******************MENU*********************");
			System.out.println("1. Nhap thong tin san pham");
			System.out.println("2. Tinh loi nhuan cua san pham");
			System.out.println("3. Hien thi thong tin san pham");
			System.out.println("4. Tim kiem san pham theo ten san pham");
			System.out.println("5. Sap xep theo thuat toan noi bot - thue tang dan");
			System.out.println("6. Sap xep theo Collections - gia nhap giam dan");
			System.out.println("7. Thoat");
			System.out.print("Su lua chon cua ban: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1:
				proRun.inputListData(sc);
				break;
			case 2:
				proRun.calListProfit();
				break;
			case 3:
				proRun.displayListData();
				break;
			case 4:
				proRun.seachProductByName(sc);
				break;
			case 5:
				proRun.sortProductByTax();
				break;
			case 6:
				proRun.sortProductByImportPrice();
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Xin vui long chon tu 1-7");
			}
		} while (true);
	}

	public void inputListData(Scanner sc) {
		// Nhap thong tin n san pham
		System.out.println("Nhap vao so san pham can nhap du lieu: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			// Khoi tao mot doi tuong san pham moi de nhap du lieu
			Product pro = new Product();
			pro.inputData();
			// add vao listProduct
			listProduct.add(pro);
		}
	}

	public void calListProfit() {
		// Tinh loi nhuan cho cac san pham dang quan ly
		for (Product pro : listProduct) {
			pro.calProfit();
		}
	}

	public void displayListData() {
		// Hien thi thong tin cac san pham
		for (Product pro : listProduct) {
			pro.displayData();
		}
	}

	public void seachProductByName(Scanner sc) {
		System.out.println("Nhap vao ten san pham can tim kiem: ");
		String searchName = sc.nextLine();
		Optional<Product> item = Optional.of(listProduct.stream()
				.filter(listProduct -> searchName.equals(listProduct.getProductName())).findAny().orElse(null));
		item.get().displayData();

	}

	public void sortProductByTax() {
		List<Product> list = listProduct.stream().sorted(Comparator.comparingDouble(Product::getTax))
				.collect(Collectors.toList());

		listProduct.clear();
		listProduct.addAll(list);
		System.out.println("Da sap xep xong san pham theo thue tang dan");
	}

	public void sortProductByImportPrice() {
		List<Product> list = listProduct.stream().sorted(Comparator.comparingDouble(Product::getTax).reversed())
				.collect(Collectors.toList());

		listProduct.clear();
		listProduct.addAll(list);
		System.out.println("Da sap xep xong san pham theo thue tang dan");
	}

}
