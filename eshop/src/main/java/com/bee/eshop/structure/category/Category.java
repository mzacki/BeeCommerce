package com.bee.eshop.structure.category;

import com.bee.eshop.structure.product.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class Category {

    private final List<Item> items;
    private List<Category> subcategoryList = new ArrayList<>();
    private final String name;

    public Category(String name, List<Item> items, List<Category> subcategoryList) {
        this.items = items;
        this.subcategoryList = subcategoryList;
        this.name = name;
    }

    public Category(String name, List<Item> items) {
        this.items = items;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public List<Category> getSubcategoryList() {
        return new ArrayList<>(subcategoryList);
    }

    public List<Item> seeAllProducts() {
        return subcategoryList.stream()
                .map(Category::getItems)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

}
