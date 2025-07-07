package main.java.br.com.codeborges.produtos.model;

public enum Option {
    CREATE_CATEGORY(1, "CRIAR CATEGORIA"),
    CREATE_PRODUCT(2, "CRIAR PRODUTO"),
    UPDATE_PRODUCT(3, "ALTERAR PRODUTO"),
    FIND_PRODUCT_BY_ID(4, "BUSCAR PRODUTO POR ID"),
    FIND_PRODUCT_BY_CATEGORY(5, "BUSCAR PRODUTO POR CATEGORIA"),
    EXIT(6, "SAIR DO SISTEMA");

    private int id;
    private String name;

    Option(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Option setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public Option setId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
