package com.codegym;

import java.util.ArrayList;

public class ProductManager {

    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(String id, Product product) {
        int index = findProductById(id);
        products.set(index, product);
    }

    public void deleteProduct(String id) {
        int index = findProductById(id);
        products.remove(index);
    }

    public void sortProduct() {
        products.sort(Product::compareTo);
    }

    public void showProduct() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public int findProductByName(String name) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (name.equals(products.get(i).getName())) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int findProductById(String id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (id.equals(products.get(i).getId())) {
                index = i;
                break;
            }
        }
        return index;
    }
}
