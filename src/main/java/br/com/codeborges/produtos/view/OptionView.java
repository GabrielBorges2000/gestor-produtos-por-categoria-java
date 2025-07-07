package main.java.br.com.codeborges.produtos.view;

import javax.swing.JOptionPane;
import main.java.br.com.codeborges.produtos.model.Option;

public class OptionView {

    public static Option select() {
        Option ret = (Option) JOptionPane.showInputDialog(
                null,
                "Selecione uma opção",
                "Menu de opções",
                JOptionPane.QUESTION_MESSAGE,
                null,
                Option.values(),
                Option.CREATE_PRODUCT
        );

        return ret != null ? ret : Option.EXIT;
    }
}
