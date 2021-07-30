package com.telerikacademy.oop.cosmetics.models;

import com.telerikacademy.oop.cosmetics.core.CosmeticsRepositoryImpl;
import com.telerikacademy.oop.cosmetics.models.contracts.Product;
import com.telerikacademy.oop.cosmetics.models.enums.GenderType;
import com.telerikacademy.oop.cosmetics.utils.ValidationHelpers;

public class Cosmetic implements Product {

    public static final int NAME_MIN_LENGTH = 3;
    public static final int NAME_MAX_LENGTH = 10;
    public static final int BRAND_NAME_MIN_LENGTH = 2;
    public static final int BRAND_NAME_MAX_LENGTH = 10;
    public static final int NAME_MiN_LENGTH_Cream = 3;
    public static final int NAME_MAX_LENGTH_Cream= 3;
    public static final int BRAND_NAME_MiN_LENGTH_Cream = 15;
    public static final int BRAND_NAME_MAX_LENGTH_Cream = 15;

    protected String name;
    protected String brand;
    private final double price;
    private final GenderType genderType;

    public Cosmetic(String name, String brand, double price, GenderType genderType) {
        setName(name);
        setBrand(brand);
        if(price < 0){
            throw new IllegalArgumentException("The price cannot be negative");
        }
        this.price = price;
        this.genderType = genderType;
    }

    public void setName(String name) {
        ValidationHelpers.validateStringLength(name,NAME_MIN_LENGTH,NAME_MAX_LENGTH,String.format("The name cannot  length should be between %s and %s symbols",NAME_MIN_LENGTH,NAME_MAX_LENGTH));
        this.name = name;
    }

    public void setBrand(String brand) {
        ValidationHelpers.validateStringLength(brand, NAME_MIN_LENGTH, NAME_MAX_LENGTH, String.format(" The brand cannot  length should be between %s and %s symbols", NAME_MIN_LENGTH, NAME_MAX_LENGTH));
        this.brand = brand;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBrandName() {
        return brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public GenderType getGenderType() {
        return genderType;
    }

    @Override
    public String print() {
        return String.format("%s %s%n#Price: %.2s%n#Gender: %s%n",getName(),getBrandName(),getPrice(),getGenderType());
    }
}
