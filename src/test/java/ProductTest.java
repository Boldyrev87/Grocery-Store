import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    @Test
    public void test() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(44, "chocolate", 96);
        Product product2 = new Product(87, "vodka", 450);
        repo.add(product1);
        repo.add(product2);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(94);
        });
    }

    @Test
    public void test_2() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(96, "cigarettes", 150);
        Product product2 = new Product(156, "beer", 78);

        repo.add(product1);
        repo.add(product2);

        repo.remove(96);
        Product[] actual = repo.findAll();
        Product[] expected = {product2};
        Assertions.assertArrayEquals(actual, expected);
    }
}

