package com.telerikacademy.oop.cosmetics.tests.models;

import com.telerikacademy.oop.cosmetics.models.ShampooImpl;
import com.telerikacademy.oop.cosmetics.models.enums.GenderType;
import com.telerikacademy.oop.cosmetics.models.enums.UsageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.telerikacademy.oop.cosmetics.models.ShampooImpl.*;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestData.POSITIVE_DOUBLE;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestData.POSITIVE_INT;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestData.Shampoo.VALID_BRAND_NAME;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestData.Shampoo.VALID_NAME;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestUtilities.initializeStringWithSize;

public class ShampooImpl_Tests {

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {NAME_MIN_LENGTH - 1, NAME_MAX_LENGTH + 1})
    public void should_throwException_when_nameLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ShampooImpl(
                        initializeStringWithSize(testLength),
                        VALID_BRAND_NAME,
                        POSITIVE_DOUBLE,
                        GenderType.MEN,
                        POSITIVE_INT,
                        UsageType.EVERY_DAY));
    }

    @ParameterizedTest(name = "with length {0}")
    @ValueSource(ints = {BRAND_NAME_MIN_LENGTH - 1, BRAND_NAME_MAX_LENGTH + 1})
    public void should_throwException_when_brandNameLengthOutOfBounds(int testLength) {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ShampooImpl(
                        VALID_NAME,
                        initializeStringWithSize(testLength),
                        POSITIVE_DOUBLE,
                        GenderType.MEN,
                        POSITIVE_INT,
                        UsageType.EVERY_DAY));

    }

    @Test
    public void should_throwException_when_PriceIsNegative() {
        // Arrange, Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new ShampooImpl(
                        VALID_NAME,
                        VALID_BRAND_NAME,
                        -1,
                        GenderType.MEN,
                        POSITIVE_INT,
                        UsageType.EVERY_DAY));
    }

    @Test
    public void should_create_Shampoo_when_ValidValuesArePassed() {
        // Arrange, Act, Assert
        Assertions.assertDoesNotThrow(() -> new ShampooImpl(
                VALID_NAME,
                VALID_BRAND_NAME,
                POSITIVE_DOUBLE,
                GenderType.MEN,
                POSITIVE_INT,
                UsageType.EVERY_DAY));
    }

}
