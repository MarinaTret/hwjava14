package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "Колбаса", 500);
    Product product2 = new Product(2, "Сыр", 400);
    Product product3 = new Product(3, "Оливки", 300);

    @Test
    public void successDel() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(3);

        Product[] expected = {product1, product2};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    @Test
    public void NotFound() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(12);
        });
    }
}
