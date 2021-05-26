package Repository;

import domain.data.Product;

public class Repository {
    private Product[] items = new Product[0];

    public void removeById(int id) {
        if (findById(id) == null) {
            System.out.println("not found");
            return;
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : items) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        items = tmp;
    }

    public Product findById(int id) {
        for (Product product : items) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }
}

