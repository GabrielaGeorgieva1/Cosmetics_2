package com.telerikacademy.oop.cosmetics.tests.commands;

import com.telerikacademy.oop.cosmetics.commands.CreateCategoryCommand;
import com.telerikacademy.oop.cosmetics.core.CosmeticsRepositoryImpl;
import com.telerikacademy.oop.cosmetics.core.contracts.Command;
import com.telerikacademy.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.telerikacademy.oop.cosmetics.models.contracts.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.telerikacademy.oop.cosmetics.commands.CreateCategoryCommand.EXPECTED_NUMBER_OF_ARGUMENTS;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestData.Category.VALID_NAME;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestUtilities.initializeListWithSize;
import static com.telerikacademy.oop.cosmetics.tests.utils.TestUtilities.initializeTestCategory;

public class CreateCategoryCommand_Tests {

    Command command;
    CosmeticsRepository cosmeticsRepository;

    @BeforeEach
    public void beforeEach() {
        cosmeticsRepository = new CosmeticsRepositoryImpl();
        command = new CreateCategoryCommand(cosmeticsRepository);
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
    public void should_throwException_when_nameExist() {
        // Arrange, Act
        Category category = initializeTestCategory(cosmeticsRepository);
        List<String> parameters = List.of(category.getName());

        // Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(parameters));
    }

    @Test
    public void should_addToList_when_argumentsAreValid() {
        // Arrange, Act
        List<String> parameters = List.of(VALID_NAME);

        // Assert
        Assertions.assertAll(
                () -> Assertions.assertDoesNotThrow(() -> command.execute(parameters)),
                () -> Assertions.assertEquals(1, cosmeticsRepository.getCategories().size())
        );
    }

}
