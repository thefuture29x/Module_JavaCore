package demojava8;

import java.util.Scanner;

public class Product implements IPoduct {
	private String productId;
    private String productName;
    private double importPrice;
    private double exportPrice;
    private double tax;
    private double profit;

    public Product() {
    }

    public Product(String productId, String productName, double importPrice, double exportPrice, double tax, double profit) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.tax = tax;
        this.profit = profit;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
	@Override
    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao ma san pham: ");
        this.productId = sc.nextLine();
        System.out.println("Nhap vao ten san pham: ");
        this.productName = sc.nextLine();
        System.out.println("Nhap vao ma nhap cua san pham: ");
        this.importPrice = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap vao ma xuat cua san pham: ");
        this.exportPrice = Double.parseDouble(sc.nextLine());
        System.out.println("Nhap vao thue cua san pham: ");
        this.tax = Double.parseDouble(sc.nextLine());
    }
	@Override
    public void displayData() {
        System.out.println("Ma SP: " + this.productId);
        System.out.println("Ten SP: " + this.productName);
        System.out.println("Gia nhap: " + this.importPrice);
        System.out.println("Gia xuat: " + this.exportPrice);
        System.out.println("Thue: " + this.tax);
        System.out.println("Loi nhuan: " + this.profit);
    }

    public void calProfit() {
        this.profit = this.exportPrice - this.importPrice - this.tax;
    }

}
