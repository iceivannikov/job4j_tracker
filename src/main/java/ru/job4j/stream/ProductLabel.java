package ru.job4j.stream;

import java.util.List;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(product -> {
                    int difference = product.getStandard() - product.getActual();
                    return difference <= 3 && difference >= 0;
                })
                .map(product -> new Label(product.getName(), product.getPrice() / 2))
                .map(Label::toString)
                .toList();
    }
}
