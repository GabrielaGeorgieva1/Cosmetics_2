package com.telerikacademy.oop.cosmetics.tests.utils;

import com.telerikacademy.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.telerikacademy.oop.cosmetics.models.ShampooImpl;
import com.telerikacademy.oop.cosmetics.models.contracts.Category;
import com.telerikacademy.oop.cosmetics.models.contracts.Shampoo;
import com.telerikacademy.oop.cosmetics.models.enums.GenderType;
import com.telerikacademy.oop.cosmetics.models.enums.UsageType;

import java.util.Arrays;
import java.util.List;

import static com.telerikacademy.oop.cosmetics.tests.utils.TestData.POSITIVE_DOUBLE;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestData.Shampoo.VALID_BRAND_NAME;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestData.Shampoo.VALID_NAME;

public class TestUtilities {

    public static Shampoo initializeTestProduct(CosmeticsRepository repository) {
        Shampoo product = initializeTestShampoo();
        repository.createShampoo(product.getName(),
                product.getBrandName(),
                product.getPrice(),
                product.getGenderType(),
                product.getMillilitres(),
                product.getUsageType());
        return product;
    }

    public static Category initializeTestCategory(CosmeticsRepository repository) {
        return repository.createCategory(TestData.Category.VALID_NAME);
    }

    public static Shampoo initializeTestShampoo() {
        return new ShampooImpl(VALID_NAME, VALID_BRAND_NAME, POSITIVE_DOUBLE, GenderType.MEN, 10, UsageType.EVERY_DAY);
    }

    /**
     * Returns a new List with size equal to wantedSize.
     * Useful when you do not care what the contents of the List are,
     * for example when testing if a list of a command throws exception
     * when it's parameters list's size is less/more than expected.
     *
     * @param wantedSize the size of the List to be returned.
     * @return a new List with size equal to wantedSize
     */
    public static List<String> initializeListWithSize(int wantedSize) {
        return Arrays.asList(new String[wantedSize]);
    }

    /**
     * Returns a new String with size equal to wantedSize.
     * Useful when you do not care what the contents of a String are,
     * for example when testing if a String of given size
     * would cause an exception being thrown.
     *
     * @param wantedSize the size of the String to be returned.
     * @return a new String with size equal to wantedSize
     */
    public static String initializeStringWithSize(int wantedSize) {
        return "x".repeat(wantedSize);
    }

}
