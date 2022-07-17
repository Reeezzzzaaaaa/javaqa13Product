package ru.netology.javaqa.product;
import ru.netology.javaqa.domain.Product;
import ru.netology.javaqa.exeptions.NotFoundException;

public class ProductRepository {

    private Product[] products = new Product[0];

    public Product[] getProducts() {
        return products;
    }

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        System.arraycopy(products,0, tmp, 0, products.length);
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product findById(int id) {
        Product[] tmp = new Product[1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() == id) {
                tmp[copyToIndex] = product;
                return product;
            }

        }
        return null;
    }

    public void removeById(int id) {

        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
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
}
