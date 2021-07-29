package com.telerikacademy.oop.cosmetics.tests.core;

import com.telerikacademy.oop.cosmetics.core.CosmeticsRepositoryImpl;
import com.telerikacademy.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.telerikacademy.oop.cosmetics.models.contracts.Category;
import com.telerikacademy.oop.cosmetics.models.contracts.Product;
import com.telerikacademy.oop.cosmetics.models.enums.GenderType;
import com.telerikacademy.oop.cosmetics.models.enums.UsageType;
import com.telerikacademy.oop.cosmetics.tests.utils.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.telerikacademy.oop.cosmetics.tests.utils.TestUtilities.*;
import static org.junit.jupiter.api.Assertions.*;

public class CosmeticsRepositoryImpl_Tests {

    CosmeticsRepository cosmeticsRepository;

    @BeforeEach
    public void beforeEach() {
        cosmeticsRepository = new CosmeticsRepositoryImpl();
    }

    @Test
    public void findProductByName_should_throwException_when_productDoesntExist() {
        //Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> cosmeticsRepository.findProductByName("test-name"));
    }

    @Test
    public void findProductByName_should_returnProduct_when_productExists() {
        //Arrange
        Product product = initializeTestProduct(cosmeticsRepository);

        //Act, Assert
        assertAll(
                () -> assertDoesNotThrow(() -> cosmeticsRepository.findProductByName(product.getName())),
                () -> Assertions.assertNotNull(cosmeticsRepository.findProductByName(product.getName()))
        );
    }

    @Test
    public void findCategoryByName_should_throwException_when_categoryDoesntExist() {
        //Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> cosmeticsRepository.findCategoryByName("test-name"));
    }

    @Test
    public void findCategoryByName_should_returnProduct_when_categoryExists() {
        //Arrange
        Category category = initializeTestCategory(cosmeticsRepository);

        //Act, Assert
        assertAll(
                () -> assertDoesNotThrow(() -> cosmeticsRepository.findCategoryByName(category.getName())),
                () -> Assertions.assertNotNull(cosmeticsRepository.findCategoryByName(category.getName()))
        );
    }

    @Test
    public void createShampoo_should_addShampooToList() {
        //Arrange, Act, Assert
        assertAll(
                () -> assertDoesNotThrow(() -> cosmeticsRepository.createShampoo(TestData.Shampoo.VALID_NAME,
                        TestData.Shampoo.VALID_BRAND_NAME,
                        TestData.POSITIVE_DOUBLE,
                        GenderType.MEN,
                        TestData.POSITIVE_INT,
                        UsageType.EVERY_DAY)),
                () -> assertEquals(1, cosmeticsRepository.getProducts().size())
        );
    }

    @Test
    public void createToothpaste_should_addToothpasteToList() {
        //Arrange, Act, Assert
        assertAll(
                () -> assertDoesNotThrow(() -> cosmeticsRepository.createToothpaste(TestData.Shampoo.VALID_NAME,
                        TestData.Shampoo.VALID_BRAND_NAME,
                        TestData.POSITIVE_DOUBLE,
                        GenderType.MEN,
                        initializeListWithSize(2))),
                () -> assertEquals(1, cosmeticsRepository.getProducts().size())
        );
    }

//    @Test
//    public void createCream_should_addCreamToList(){
//        //Arrange, Act, Assert
//        assertAll(
//                () -> assertDoesNotThrow(() -> cosmeticsRepository.createCream(TestData.Shampoo.VALID_NAME,
//                        TestData.Shampoo.VALID_BRAND_NAME,
//                        TestData.POSITIVE_DOUBLE,
//                        GenderType.MEN,
//                        ScentType.LAVENDER)),
//                () -> assertEquals(1,cosmeticsRepository.getProducts().size())
//        );
//    }
//
//    @Test
//    public void createCategory_should_addCategoryToList(){
//        //Arrange, Act, Assert
//        assertAll(
//                () -> assertDoesNotThrow(() -> cosmeticsRepository.createCategory(TestData.Category.VALID_NAME)),
//                () -> assertEquals(1,cosmeticsRepository.getCategories().size())
//        );
//    }

}
