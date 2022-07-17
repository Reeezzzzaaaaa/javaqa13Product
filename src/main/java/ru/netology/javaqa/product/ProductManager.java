package ru.netology.javaqa.product;
import ru.netology.javaqa.domain.Product;

public class ProductManager {

    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        int copyToIndex = 0;
        Product[] tmp = new Product[repo.findAll().length];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        result = new Product[copyToIndex];
        System.arraycopy(tmp,0, result,0, copyToIndex);

        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
