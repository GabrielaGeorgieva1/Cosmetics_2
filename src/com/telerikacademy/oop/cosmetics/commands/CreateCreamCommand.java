package com.telerikacademy.oop.cosmetics.commands;

import com.telerikacademy.oop.cosmetics.core.contracts.Command;
import com.telerikacademy.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.telerikacademy.oop.cosmetics.models.enums.GenderType;
import com.telerikacademy.oop.cosmetics.models.enums.ScentType;
import com.telerikacademy.oop.cosmetics.models.enums.UsageType;
import com.telerikacademy.oop.cosmetics.utils.ParsingHelpers;
import com.telerikacademy.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateCreamCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;
    private static final String Cream_ALREADY_EXISTS = "Cream with name %s already exists!";
    private static final String Cream_CREATED = "Cream with name %s was created!";

    private final CosmeticsRepository cosmeticsRepository;

    public CreateCreamCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String name = parameters.get(0);
        String brandName = parameters.get(1);
        double price = ParsingHelpers.tryParseDouble(parameters.get(2), ParsingHelpers.INVALID_PRICE);
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        ScentType scentType = ParsingHelpers.tryParseScent(parameters.get(4));
        return creamName(name, brandName, price, genderType, scentType);
    }

    private String creamName(String name, String brandName, double price, GenderType genderType,
                               ScentType scentType) {
        if (cosmeticsRepository.productExist(name)) {
            throw new IllegalArgumentException(String.format(Cream_ALREADY_EXISTS,name));
        }

        cosmeticsRepository.createCream(name, brandName, price, genderType, scentType);

        return String.format(Cream_CREATED,name);
    }
}
