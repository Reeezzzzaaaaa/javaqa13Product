package ru.netology.javaqa.product;
import ru.netology.javaqa.domain.Product;
import ru.netology.javaqa.domain.Book;
import ru.netology.javaqa.domain.Smartphone;

public class ProductRepository {

    private Product[] products = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products,0, tmp, 0, products.length);
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public Product[] findAll() {
        Product[] tmp = new Product[products.length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        products = tmp;
        return products;
    }

    public Product[] getProducts() {
        return products;
    }
}
