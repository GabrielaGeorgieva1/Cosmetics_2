package com.telerikacademy.oop.cosmetics.commands;

import com.telerikacademy.oop.cosmetics.core.contracts.Command;
import com.telerikacademy.oop.cosmetics.core.contracts.CosmeticsRepository;
import com.telerikacademy.oop.cosmetics.models.contracts.Toothpaste;
import com.telerikacademy.oop.cosmetics.models.enums.GenderType;
import com.telerikacademy.oop.cosmetics.models.enums.UsageType;
import com.telerikacademy.oop.cosmetics.utils.ParsingHelpers;
import com.telerikacademy.oop.cosmetics.utils.ValidationHelpers;

import java.util.Arrays;
import java.util.List;

public class CreateToothpasteCommand implements Command {

    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 5;
    private static final String Toothpaste_ALREADY_EXISTS = "Toothpaste with name %s already exists!";
    private static final String Toothpaste_CREATED = "Toothpaste with name %s was created!";

    private final CosmeticsRepository cosmeticsRepository;

    public CreateToothpasteCommand(CosmeticsRepository cosmeticsRepository) {
        this.cosmeticsRepository = cosmeticsRepository;
    }

    @Override
    public String execute(List<String> parameters) {
        ValidationHelpers.validateArgumentsCount(parameters, EXPECTED_NUMBER_OF_ARGUMENTS);
        String name = parameters.get(0);
        String brandName = parameters.get(1);
        double price = ParsingHelpers.tryParseDouble(parameters.get(2), ParsingHelpers.INVALID_PRICE);
        GenderType genderType = ParsingHelpers.tryParseGender(parameters.get(3));
        List<String> ingredients = Arrays.asList(parameters.get(4).split(","));
        return toothpasteName(name, brandName, price, genderType,ingredients);
    }
    private String toothpasteName(String name, String brandName, double price, GenderType genderType,List<String> ingredients) {
        if (cosmeticsRepository.productExist(name)) {
            throw new IllegalArgumentException(String.format(Toothpaste_ALREADY_EXISTS,name));
        }

        cosmeticsRepository.createToothpaste(name, brandName, price, genderType,ingredients);

        return String.format(Toothpaste_CREATED,name);
    }

}