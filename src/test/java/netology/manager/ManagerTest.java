
package netology.manager;


import org.junit.jupiter.api.Test;
import domain.data.Book;
import domain.data.Product;
import domain.data.Smartphone;
import Repository.Repository;
import domain.Manager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class ManagerTest {
    private final Repository repository = new Repository();
    private final Manager manager = new Manager(repository);
    private final Smartphone smart1 = new Smartphone(4, "ios1", 32, "Bill");
    private final Smartphone smart2 = new Smartphone(5, "ios2", 35, "Steve");
    private final Book book1 = new Book(1, "one", 150, "Author A");
    private final Book book2 = new Book(2, "two ", 200, "Author B");
    private final Book book3 = new Book(3, "three", 250, "Author B");


    @Test
    public void shouldAddProduct() {
        manager.add(book1);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldAddAllProducts() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1, book2, smart1, smart2};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchProduct() {
        manager.add(book1);
        manager.add(book2);

        Product[] actual = manager.searchBy("Author B");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchBookByAuthor() {
        manager.add(book1);
        manager.add(book2);

        Product[] actual = manager.searchBy("Author A");
        Product[] expected = new Product[]{book1};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchSmartByManufacturer() {
        manager.add(smart1);
        manager.add(smart2);

        Product[] actual = manager.searchBy("Bill");
        Product[] expected = new Product[]{smart1};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldSearchSmartByName() {
        manager.add(smart1);
        manager.add(smart2);

        Product[] actual = manager.searchBy("ios2");
        Product[] expected = new Product[]{smart2};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldNotFoundProduct() {
        manager.add(smart1);
        manager.add(smart2);
        manager.add(book1);
        manager.add(book2);

        Product[] actual = manager.searchBy("Android");
        Product[] expected = new Product[0];
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindTwoBookByOneAuthor() {
        manager.add(book2);
        manager.add(book1);
        manager.add(book3);

        Product[] actual = manager.searchBy("Author B");
        Product[] expected = new Product[]{book2, book3};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemoveById() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smart1);
        manager.add(smart2);
        manager.removeById(2);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1, smart1, smart2,};
        assertArrayEquals(actual, expected);
    }
}