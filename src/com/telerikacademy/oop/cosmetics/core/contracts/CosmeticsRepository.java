package com.telerikacademy.oop.cosmetics.core.contracts;

import com.telerikacademy.oop.cosmetics.models.CreamImpl;
import com.telerikacademy.oop.cosmetics.models.ShampooImpl;
import com.telerikacademy.oop.cosmetics.models.ToothpasteImpl;
import com.telerikacademy.oop.cosmetics.models.contracts.Category;
import com.telerikacademy.oop.cosmetics.models.contracts.Product;
import com.telerikacademy.oop.cosmetics.models.contracts.ShoppingCart;
import com.telerikacademy.oop.cosmetics.models.enums.GenderType;
import com.telerikacademy.oop.cosmetics.models.enums.ScentType;
import com.telerikacademy.oop.cosmetics.models.enums.UsageType;

import java.util.List;

public interface CosmeticsRepository {

    ShoppingCart getShoppingCart();

    List<Category> getCategories();

    List<Product> getProducts();

    Product findProductByName(String productName);

    Category findCategoryByName(String categoryName);

    Category createCategory(String categoryToAdd);

    ShampooImpl createShampoo(String name, String brandName, double price, GenderType genderType,
                              int millilitres, UsageType usageType);

    ToothpasteImpl createToothpaste(String name, String brandName, double price, GenderType genderType, List<String> ingredients);

    CreamImpl createCream(String name, String brandName, double price, GenderType genderType, ScentType scentType);

    boolean categoryExist(String categoryName);

    boolean productExist(String productName);

    void removeProductFromCart(Product product);

    void addProductToShoppingCart(Product product);

}
