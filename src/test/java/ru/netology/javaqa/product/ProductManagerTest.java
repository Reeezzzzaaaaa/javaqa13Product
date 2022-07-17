package ru.netology.javaqa.product;
import ru.netology.javaqa.domain.Product;
import ru.netology.javaqa.domain.Book;
import ru.netology.javaqa.domain.Smartphone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);


    Product book1 = new Book(1,"Портрет Дориана Грея",259,"Оскар Уайльд", 320,1_890);
    Product book2 = new Book(2,"Сильмариллион",2_461,"Джон Рональд Руэл Толкин", 432,2_015);
    Product book3 = new Book(3,"Старнная история доктора Джекила и мистера Хайда",258,"Робер Луис Стивенсон",416,2_016);
    Product smartphone1 = new Smartphone(4,"S22",89_999,"Samsung","China");
    Product smartphone2 = new Smartphone(5,"13 Pro Max",119_999,"Apple","China");
    Product smartphone3 = new Smartphone(6,"Redmi 9C",11_499,"Xiaomi","China");
    Product smartphone4 = new Smartphone(7,"A22s",19_999,"Samsung","China");

    @BeforeEach
    public void setup() {
        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
    }

    @Test
    public void addTest() {

        manager.add(smartphone4);

        Product[] expected = {book1, book2, book3, smartphone1, smartphone2, smartphone3, smartphone4};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void searchByTextTest() {

        Product[] expected = new Product[]{book2};
        Product[] actual = manager.searchBy("Сильмариллион");

        Assertions.assertArrayEquals(expected, actual);
    }
}
