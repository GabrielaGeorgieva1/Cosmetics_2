package com.telerikacademy.oop.cosmetics.commands;

import com.telerikacademy.oop.cosmetics.core.contracts.Command;
import com.telerikacademy.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.telerikacademy.oop.cosmetics.models.contracts.Shampoo;
import com.telerikacademy.oop.cosmetics.models.enums.GenderType;
import com.telerikacademy.oop.cosmetics.models.enums.UsageType;
import com.telerikacademy.oop.cosmetics.utils.ParsingHelpers;
import com.telerikacademy.oop.cosmetics.utils.ValidationHelpers;

import java.util.List;

public class CreateShampooCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 6;
    private static final String Shampoo_ALREADY_EXISTS = "Shampoo with name %s already exists!";
    private static final String Shampoo_CREATED = "Shampoo with name %s was created!";

    private final CosmeticsRepository cosmeticsRepository;

    public CreateShampooCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String name = parameters.get(0);
        String brandName = parameters.get(1);
        double price = ParsingHelpers.tryParseDouble(parameters.get(2), ParsingHelpers.INVALID_PRICE);
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        int millilitres = ParsingHelpers.tryParseInt(parameters.get(4), ParsingHelpers.INVALID_MILLILITRES);
        UsageType usageType = ParsingHelpers.tryParseUsageType(parameters.get(5));
        return shampooName(name, brandName, price, genderType, millilitres, usageType);
    }

    private String shampooName(String name, String brandName, double price, GenderType genderType,
                               int millilitres, UsageType usageType) {
        if (cosmeticsRepository.productExist(name)) {
            throw new IllegalArgumentException(String.format(Shampoo_ALREADY_EXISTS,name));
        }

        cosmeticsRepository.createShampoo(name, brandName, price, genderType, millilitres, usageType);

        return String.format(Shampoo_CREATED,name);
    }

}
