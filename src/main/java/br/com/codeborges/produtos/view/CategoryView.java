package main.java.br.com.codeborges.produtos.view;

import javax.swing.JOptionPane;
import main.java.br.com.codeborges.produtos.model.Category;
import main.java.br.com.codeborges.produtos.repository.CategoryCollectionRepository;

public class CategoryView {

    private static final CategoryCollectionRepository repository = new CategoryCollectionRepository();

    public static Category select(Category category) {
        Category ret = (Category) JOptionPane.showInputDialog(
                null,
                "Selecione uma categoria",
                "Menu de categorias",
                JOptionPane.QUESTION_MESSAGE,
                null,
                repository.findAll().toArray(),
                category == null ? null : category
        );

        return ret != null ? ret : null;
    }

    public void success() {
        JOptionPane.showMessageDialog(
                null,
                "Categoria criada com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void success(Category category) {
        JOptionPane.showMessageDialog(
                null,
                "Categoria " + category.getName() + " criada com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static Category form(Category category) {
        String name = JOptionPane.showInputDialog(
                null,
                "Digite o nome da categoria:",
                category == null ? "" : category.getName());

        return new Category(name);
    }
}
