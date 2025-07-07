package main.java.br.com.codeborges.produtos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Product {

    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime createdAt;
    private Category category;

    public Product() {
    }

    public Product(
            Long id,
            String name,
            String description,
            BigDecimal price,
            LocalDateTime createdAt,
            Category category
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
        this.category = category;
    }

    public Product(
            String name,
            String description,
            BigDecimal price,
            LocalDateTime createdAt,
            Category category
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public Product setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Product setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Product setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product produto = (Product) obj;
        return name.equals(produto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }
}
