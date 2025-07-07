package main.java.br.com.codeborges.produtos.repository;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import main.java.br.com.codeborges.produtos.model.Category;

public class CategoryCollectionRepository {

    private static final List<Category> categories;

    static {
        categories = new ArrayList<>();

        Category eleronicsCategory = new Category("Eletrônics");
        Category phonesCategory = new Category("Phones");
        Category bookCategory = new Category("Books");

        create(eleronicsCategory);
        create(phonesCategory);
        create(bookCategory);
    }

    public List<Category> findAll() {
        return categories;
    }

    public static Category findById(long id) {
        return categories.stream()
                .filter(category -> category.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static List<Category> findByName(String name) {
        return categories.stream()
                .filter(category -> category.getName().equalsIgnoreCase(name))
                .toList();
    }

    public static Category create(Category category) {
        if (categories.contains(category)) {
            var hasCategory = "Já existe uma categoria com o nome " + category.getName();
            JOptionPane.showMessageDialog(null, hasCategory, null, 0);

            return null;
        }

        category.setId(categories.size() + 1);
        categories.add(category);

        return category;
    }
}
