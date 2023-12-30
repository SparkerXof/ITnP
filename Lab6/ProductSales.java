import java.util.Map;
import java.util.TreeMap;

public class ProductSales {
    private TreeMap<String, Integer> salesList = new TreeMap<String, Integer>();

    public void newProduct(String product) {
        newProduct(product, 0);
    }

    public void newProduct(String product, int sales) {
        if (salesList.containsKey(product)) {
            addSales(product, sales);
        } else {
            salesList.put(product, sales);
        }
    }

    public void addSales(String product, int sales) {
        salesList.replace(product, salesList.get(product) + sales);
    }

    public void removeProduct(String product) {
        salesList.remove(product);
    }

    public String[][] getSalesList() {
        String[][] list = new String[salesList.size()][2];
        int i = 0;
        for (Map.Entry<String, Integer> sale : salesList.entrySet()) {
            list[i][0] = sale.getKey();
            list[i][1] = sale.getValue().toString();
            i++;
        }
        return list;
    }

    public Map.Entry<String, Integer> getPopularProduct() {
        Map.Entry<String, Integer> popularProduct = null;
        for (Map.Entry<String, Integer> product : salesList.entrySet()) {
            if (popularProduct == null || product.getValue() > popularProduct.getValue()) {
                popularProduct = Map.entry(product.getKey(), product.getValue());
            }
        }
        return popularProduct;
    }

    public int getTotalSales() {
        int totalSales = 0;
        for (Map.Entry<String, Integer> product : salesList.entrySet()) {
            totalSales += product.getValue();
        }
        return totalSales;
    }
}
