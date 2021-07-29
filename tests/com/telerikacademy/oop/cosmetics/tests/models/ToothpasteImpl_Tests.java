package com.telerikacademy.oop.cosmetics.tests.models;

import com.telerikacademy.oop.cosmetics.models.ToothpasteImpl;
import com.telerikacademy.oop.cosmetics.models.enums.GenderType;
import com.telerikacademy.oop.cosmetics.tests.utils.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.telerikacademy.oop.cosmetics.tests.utils.TestUtilities.initializeListWithSize;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestUtilities.initializeStringWithSize;

public class ToothpasteImpl_Tests {

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {ToothpasteImpl.NAME_MIN_LENGTH - 1, ToothpasteImpl.NAME_MAX_LENGTH + 1})
    public void should_throwException_when_nameLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ToothpasteImpl(
                        initializeStringWithSize(testLength),
                        TestData.Toothpaste.VALID_BRAND_NAME,
                        TestData.POSITIVE_DOUBLE,
                        GenderType.MEN,
                        initializeListWithSize(TestData.POSITIVE_INT))
        );
    }

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {ToothpasteImpl.BRAND_NAME_MIN_LENGTH - 1, ToothpasteImpl.BRAND_NAME_MAX_LENGTH + 1})
    public void should_throwException_when_brandNameLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ToothpasteImpl(
                        TestData.Toothpaste.VALID_NAME,
                        initializeStringWithSize(testLength),
                        TestData.POSITIVE_DOUBLE,
                        GenderType.MEN,
                        initializeListWithSize(TestData.POSITIVE_INT))
        );

    }

    @Test
    public void should_throwException_when_PriceIsNegative() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ToothpasteImpl(
                        TestData.Toothpaste.VALID_NAME,
                        TestData.Toothpaste.VALID_BRAND_NAME,
                        -1,
                        GenderType.MEN,
                        initializeListWithSize(TestData.POSITIVE_INT))
        );
    }

    @Test
    public void should_create_Shampoo_when_ValidValuesArePassed() {
        // Arrange, Act, Assert
        Assertions.assertDoesNotThrow(
                () -> new ToothpasteImpl(
                        TestData.Toothpaste.VALID_NAME,
                        TestData.Toothpaste.VALID_BRAND_NAME,
                        TestData.POSITIVE_DOUBLE,
                        GenderType.MEN,
                        initializeListWithSize(TestData.POSITIVE_INT))
        );
    }

}
