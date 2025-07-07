package main.java.br.com.codeborges.produtos.view;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import main.java.br.com.codeborges.produtos.model.Category;
import main.java.br.com.codeborges.produtos.model.Product;
import main.java.br.com.codeborges.produtos.repository.ProductCollectionRepository;

public class ProductView {

    private static final ProductCollectionRepository repository = new ProductCollectionRepository();

    public static Product select(Product product) {
        Product ret = (Product) JOptionPane.showInputDialog(
                null,
                "Selecione uma produto",
                "Menu de produtos",
                JOptionPane.QUESTION_MESSAGE,
                null,
                repository.findAll().toArray(),
                product == null ? 1 : product
        );

        return ret != null ? ret : null;
    }

    public static Product form(Product product) {
        Category category = null;
        String name = "";
        String description = "";
        double price = 0;

        do {
            category = CategoryView.select(product.getCategory());
        } while (category == null);

        do {
            name = JOptionPane.showInputDialog("Digite o nome do produto:", product.getName());
        } while (name.equals(""));

        do {
            description = JOptionPane.showInputDialog("Digite a descrição do produto:", product.getDescription());
        } while (description.equals(""));

        do {
            String priceInput = JOptionPane.showInputDialog("Digite o preço do produto (ex: 99.99):", product.getPrice());

            try {
                price = Double.parseDouble(priceInput);
            } catch (NumberFormatException e) {
                price = 0;
            }
        } while (price <= 0);

        product.setCategory(category)
                .setName(name)
                .setDescription(description)
                .setCreatedAt(LocalDateTime.now())
                .setPrice(BigDecimal.valueOf(price));

        return product;
    }

    public static void success() {
        JOptionPane.showMessageDialog(
                null,
                "Produto salvo com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void success(Product product) {
        JOptionPane.showMessageDialog(
                null,
                "Produto " + product.getName() + " salvo com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void showProduct(Product product) {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(product.getId()).append(System.lineSeparator())
                .append("Nome: ").append(product.getName()).append(System.lineSeparator())
                .append("Descrição: ").append(product.getDescription()).append(System.lineSeparator())
                .append(String.format("Preço: R$ %,.2f", product.getPrice() != null ? product.getPrice() : BigDecimal.ZERO))
                .append(System.lineSeparator())
                .append("Categoria: " + product.getCategory() != null ? product.getCategory().getName() : "Sem Categoria");

        JOptionPane.showMessageDialog(
                null,
                sb.toString(),
                "Detalhes do Produto",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static void update(Product product) {
        Product newProduct = form(product);
        success(newProduct);
        showProduct(newProduct);
    }
}
