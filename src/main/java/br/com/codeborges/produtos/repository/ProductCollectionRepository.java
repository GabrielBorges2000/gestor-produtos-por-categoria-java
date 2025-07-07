package main.java.br.com.codeborges.produtos.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import main.java.br.com.codeborges.produtos.model.Category;
import main.java.br.com.codeborges.produtos.model.Product;

public class ProductCollectionRepository {

    private static final List<Product> products;

    static {
        products = new ArrayList<>();

        Product product = new Product(
                "Notebook",
                "Notebook Dell Inspiron 15",
                BigDecimal.valueOf(12000),
                LocalDateTime.now(),
                new Category("Eletrônics")
        );

        create(product);
    }

    public List<Product> findAll() {
        return products;
    }

    public static Product create(Product product) {
        if (products.contains(product)) {
            var hasCategory = "Já existe um produto com o nome: " + product.getName();
            JOptionPane.showMessageDialog(null, hasCategory, null, 0);

            return null;
        }

        product.setId(products.size() + 1l);
        products.add(product);

        return product;
    }

    public static List<Product> findByCategory(Category category) {
        System.out.println("Buscando produtos na categoria: " + category.getName());

        List<Product> productsList = products.stream()
                .filter(product -> product.getCategory().equals(category))
                .toList();

        System.out.println("Encontrados " + productsList.size() + " produtos na categoria: " + category.getName());

        return productsList;
    }

    public static Product findById(long id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
