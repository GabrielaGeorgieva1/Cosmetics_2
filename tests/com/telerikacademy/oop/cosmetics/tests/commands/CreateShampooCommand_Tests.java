package com.telerikacademy.oop.cosmetics.tests.commands;

import com.telerikacademy.oop.cosmetics.commands.CreateShampooCommand;
import com.telerikacademy.oop.cosmetics.core.CosmeticsRepositoryImpl;
import com.telerikacademy.oop.cosmetics.core.contracts.Command;
import com.telerikacademy.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.telerikacademy.oop.cosmetics.models.contracts.Product;
import com.telerikacademy.oop.cosmetics.models.enums.GenderType;
import com.telerikacademy.oop.cosmetics.models.enums.UsageType;
import com.telerikacademy.oop.cosmetics.tests.utils.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.telerikacademy.oop.cosmetics.commands.CreateShampooCommand.EXPECTED_NUMBER_OF_ARGUMENTS;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestData.POSITIVE_DOUBLE;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestData.Shampoo.VALID_BRAND_NAME;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestData.Shampoo.VALID_NAME;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestUtilities.initializeListWithSize;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestUtilities.initializeTestProduct;

public class CreateShampooCommand_Tests {

    Command command;
    CosmeticsRepository cosmeticsRepository;

    @BeforeEach
    public void beforeEach() {
        cosmeticsRepository = new CosmeticsRepositoryImpl();
        command = new CreateShampooCommand(cosmeticsRepository);
    }

    @ParameterizedTest(name = "with {0} arguments")
    @ValueSource(ints = {EXPECTED_NUMBER_OF_ARGUMENTS - 1, EXPECTED_NUMBER_OF_ARGUMENTS + 1})
    public void should_throwException_when_argumentsCountDifferentThanExpected(int testCount) {
        // Arrange, Act
        List<String> parameters = initializeListWithSize(testCount);

        // Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(parameters));
    }

    @Test
    public void should_throwException_when_priceInvalid() {
        //Arrange
        List<String> parameters = List.of(VALID_NAME,
                VALID_BRAND_NAME,
                "invalid-price",
                GenderType.MEN.toString(),
                String.valueOf(TestData.POSITIVE_INT),
                UsageType.EVERY_DAY.toString());
        //Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(parameters));
    }

    @Test
    public void should_throwException_when_genderInvalid() {
        //Arrange
        List<String> parameters = List.of(VALID_NAME,
                VALID_BRAND_NAME,
                String.valueOf(POSITIVE_DOUBLE),
                "invalid-gender",
                String.valueOf(TestData.POSITIVE_INT),
                UsageType.EVERY_DAY.toString());
        //Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(parameters));
    }

    @Test
    public void should_throwException_when_usageTypeInvalid() {
        //Arrange
        List<String> parameters = List.of(VALID_NAME,
                VALID_BRAND_NAME,
                String.valueOf(POSITIVE_DOUBLE),
                GenderType.MEN.toString(),
                String.valueOf(TestData.POSITIVE_INT),
                "invalid-usage-type");
        //Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(parameters));
    }

    @Test
    public void should_throwException_when_millilitersInvalid() {
        //Arrange
        List<String> parameters = List.of(VALID_NAME,
                VALID_BRAND_NAME,
                String.valueOf(POSITIVE_DOUBLE),
                GenderType.MEN.toString(),
                "invalid-mls",
                UsageType.EVERY_DAY.toString());
        //Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(parameters));
    }

    @Test
    public void should_throwException_when_nameExists() {
        //Arrange
        Product testProduct = initializeTestProduct(cosmeticsRepository);

        List<String> parameters = List.of(testProduct.getName(),
                VALID_BRAND_NAME,
                String.valueOf(POSITIVE_DOUBLE),
                GenderType.MEN.toString(),
                String.valueOf(TestData.POSITIVE_INT),
                UsageType.MEDICAL.toString());

        //Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(parameters));
    }

    @Test
    public void should_return_instanceOfTypeProduct() {
        // Arrange, Act
        List<String> parameters = List.of(VALID_NAME,
                VALID_BRAND_NAME,
                String.valueOf(POSITIVE_DOUBLE),
                GenderType.MEN.toString(),
                String.valueOf(TestData.POSITIVE_INT),
                UsageType.MEDICAL.toString());

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertDoesNotThrow(() -> command.execute(parameters)),
                () -> Assertions.assertTrue(cosmeticsRepository.getProducts().get(0) instanceof Product)
        );
    }

    @Test
    public void should_addToList_when_argumentsAreValid() {
        // Arrange
        List<String> parameters = List.of(VALID_NAME,
                VALID_BRAND_NAME,
                String.valueOf(POSITIVE_DOUBLE),
                GenderType.MEN.toString(),
                String.valueOf(TestData.POSITIVE_INT),
                UsageType.MEDICAL.toString());

        //Act, Assert
        Assertions.assertAll(
                () -> Assertions.assertDoesNotThrow(() -> command.execute(parameters)),
                () -> Assertions.assertEquals(1, cosmeticsRepository.getProducts().size())
        );
    }

}
