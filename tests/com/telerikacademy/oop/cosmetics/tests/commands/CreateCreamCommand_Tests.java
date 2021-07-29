package com.telerikacademy.oop.cosmetics.tests.commands;

public class CreateCreamCommand_Tests {

  /*  Command command;
    CosmeticsRepository cosmeticsRepository;

    @BeforeEach
    public void beforeEach() {
        cosmeticsRepository = new CosmeticsRepositoryImpl();
        command = new CreateCreamCommand(cosmeticsRepository);
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
                ScentType.LAVENDER.toString());
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
                ScentType.LAVENDER.toString());
        //Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(parameters));
    }

    @Test
    public void should_throwException_when_scentInvalid() {
        //Arrange
        List<String> parameters = List.of(VALID_NAME,
                VALID_BRAND_NAME,
                String.valueOf(POSITIVE_DOUBLE),
                GenderType.MEN.toString(),
                "invalid-scent");
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
                ScentType.LAVENDER.toString());

        //Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(parameters));
    }

    @Test
    public void should_return_InstanceOfTypeProduct() {
        // Arrange, Act
        List<String> parameters = List.of(VALID_NAME,
                VALID_BRAND_NAME,
                String.valueOf(POSITIVE_DOUBLE),
                GenderType.MEN.toString(),
                ScentType.LAVENDER.toString());
        command.execute(parameters);

        // Assert
        Assertions.assertTrue(cosmeticsRepository.getProducts().get(0) instanceof Product);
    }

    @Test
    public void should_add_toList() {
        // Arrange
        List<String> parameters = List.of(VALID_NAME,
                VALID_BRAND_NAME,
                String.valueOf(POSITIVE_DOUBLE),
                GenderType.MEN.toString(),
                ScentType.LAVENDER.toString());

        //Act, Assert
        Assertions.assertAll(
                () -> Assertions.assertDoesNotThrow(() -> command.execute(parameters)),
                () -> Assertions.assertEquals(1, cosmeticsRepository.getProducts().size())
        );
    }
*/
}
