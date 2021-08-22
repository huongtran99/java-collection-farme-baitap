package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    addProducts(scanner, productManager);
                    break;
                }
                case 2: {
                    showProducts(productManager);
                    break;
                }
                case 3: {
                    updateProducts(scanner, productManager);
                    break;
                }
                case 4: {
                    removeProduct(scanner, productManager);
                    break;
                }
                case 5: {
                    searchProduct(scanner, productManager);
                    break;
                }
                case 6: {
                    sortProducts(productManager);
                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }
            }
        } while (choice >= 0 && choice < 7);
    }

    public static void showProducts(ProductManager productManager) {
        System.out.println("Danh sách sản phẩm là: ");
        productManager.showProduct();
    }

    public static void sortProducts(ProductManager productManager) {
        productManager.sortProduct();
        productManager.showProduct();
    }

    public static void searchProduct(Scanner scanner, ProductManager productManager) {
        System.out.print("Nhap ten can tim kiem: ");
        String name = scanner.nextLine();
        int index = productManager.findProductByName(name);
        if (index != -1) {
            System.out.println("San pham ma ban muon tim la");
            System.out.println(productManager.getProducts().get(index).toString());
        } else {
            System.out.println("Khong tim thay san pham trong danh sach");
        }
    }

    public static void removeProduct(Scanner scanner, ProductManager productManager) {
        System.out.print("Nhap id muon xoa: ");
        String id = scanner.nextLine();
        int index = productManager.findProductById(id);
        if (index != -1) {
            productManager.deleteProduct(id);
        } else {
            System.out.println("Không tồn tại id này");
        }
    }

    public static void updateProducts(Scanner scanner, ProductManager productManager) {
        System.out.println("Chỉnh sửa thông tin sản phẩm");
        System.out.print("Nhập id sản phẩm cần sửa: ");
        String id = scanner.nextLine();
        int index = productManager.findProductById(id);
        if (index != -1) {
            Product product = inputProduct(scanner);
            productManager.updateProduct(id, product);
        } else {
            System.out.println("Không tồn tại id này");
        }
    }

    public static void addProducts(Scanner scanner, ProductManager productManager) {
        Product product = inputProduct(scanner);
        productManager.addProduct(product);
    }

    private static Product inputProduct(Scanner scanner) {
        System.out.println("--Thêm sản phẩm--");
        System.out.println("Nhập id: ");
        String id = scanner.nextLine();
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá: ");
        String price = scanner.nextLine();
        Product product = new Product(id, name, price);
        return product;
    }

    private static void menu() {
        System.out.println("MENU");
        System.out.println("1. Thêm sản phẩm");
        System.out.println("2. Hiển thị danh sách");
        System.out.println("3. Sửa sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Tim kiem theo ten");
        System.out.println("0. Thoát");
    }
}
