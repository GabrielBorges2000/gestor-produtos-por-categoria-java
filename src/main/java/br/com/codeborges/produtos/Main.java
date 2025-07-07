package main.java.br.com.codeborges.produtos;

import java.util.List;
import javax.swing.JOptionPane;
import main.java.br.com.codeborges.produtos.model.Category;
import main.java.br.com.codeborges.produtos.model.Option;
import main.java.br.com.codeborges.produtos.model.Product;
import main.java.br.com.codeborges.produtos.repository.CategoryCollectionRepository;
import main.java.br.com.codeborges.produtos.repository.ProductCollectionRepository;
import main.java.br.com.codeborges.produtos.view.CategoryView;
import main.java.br.com.codeborges.produtos.view.OptionView;
import main.java.br.com.codeborges.produtos.view.ProductView;

public class Main {

    public static void main(String[] args) {
        Option option;

        do {
            option = OptionView.select();

            switch (option) {
                case CREATE_CATEGORY ->
                    createCategory();
                case CREATE_PRODUCT ->
                    createProduct();
                case UPDATE_PRODUCT ->
                    updateProduct();
                case FIND_PRODUCT_BY_ID ->
                    findProductById();
                case FIND_PRODUCT_BY_CATEGORY ->
                    findProductByCategory();
                case EXIT ->
                    exit();
                default ->
                    exit();
            }

        } while (option != Option.EXIT);
    }

    private static void createCategory() {
        CategoryView view = new CategoryView();
        Category category = CategoryView.form(new Category());
        CategoryCollectionRepository.create(category);
        view.success(category);
    }

    private static void createProduct() {
        Product product = ProductView.form(new Product());
        ProductCollectionRepository.create(product);
        ProductView.success(product);
    }

    private static void updateProduct() {
        Product product = ProductView.select(null);
        ProductView.update(product);
    }

    private static void findProductById() {
        Product productSelected = ProductView.select(null);
        Product product = ProductCollectionRepository.findById(productSelected.getId());

        if (product == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "Produto não encontrado: " + productSelected.getName()
            );
        } else {
            ProductView.showProduct(product);
        }
    }

    private static void findProductByCategory() {
        Category category = CategoryView.select(null);
        List<Product> products = ProductCollectionRepository.findByCategory(category);

        if (products.isEmpty()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Nenhum produto encontrado para a categoria: " + category.getName()
            );
        } else {
            products.forEach(ProductView::showProduct);
            products.forEach(System.out::println);
        }
    }

    private static void exit() {
        System.exit(0);
    }
}
