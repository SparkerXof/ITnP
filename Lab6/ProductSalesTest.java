import java.util.Arrays;

public class ProductSalesTest {
    public static void main(String[] args) {
        ProductSales list = new ProductSales();

        list.newProduct("Apple", 5);
        list.newProduct("Sandwich");
        list.addSales("Sandwich", 3);
        System.out.println(Arrays.deepToString(list.getSalesList()));
        list.newProduct("Milk", 10);
        System.out.println(list.getTotalSales());
        list.removeProduct("Apple");
        System.out.println(list.getTotalSales());
        System.out.println(list.getPopularProduct());
    }
}
