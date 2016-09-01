package com.coverxiaoeye.cyberdojo._11storagerobot;

enum Color {
    RED, GREEN, YELLOW
};

public class Product {
    private String name;
    private Color color;
    private int weight;

    public Product(String name, Color color, int weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        if (weight != product.weight) return false;
        if (!name.equals(product.name)) return false;
        return color == product.color;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + weight;
        return result;
    }
}
