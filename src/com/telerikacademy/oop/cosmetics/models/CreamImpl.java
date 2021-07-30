package com.telerikacademy.oop.cosmetics.models;

import com.telerikacademy.oop.cosmetics.models.contracts.Cream;
import com.telerikacademy.oop.cosmetics.models.enums.GenderType;
import com.telerikacademy.oop.cosmetics.models.enums.ScentType;
import com.telerikacademy.oop.cosmetics.utils.ValidationHelpers;

public class CreamImpl extends Cosmetic implements Cream {
    private final ScentType scentType;

    public CreamImpl(String name, String brand, double price, GenderType genderType,ScentType scentType) {
        super(name, brand, price, genderType);
        this.scentType = scentType;
    }

    @Override
    public void setName(String name) {
        ValidationHelpers.validateStringLength(name,NAME_MiN_LENGTH_Cream,NAME_MAX_LENGTH_Cream,String.format("The name cannot  length should be between %s and %s symbols",
                NAME_MiN_LENGTH_Cream,NAME_MAX_LENGTH_Cream));
       super.name = name;
    }
    @Override
    public void setBrand(String brand){
        ValidationHelpers.validateStringLength(brand,BRAND_NAME_MIN_LENGTH,BRAND_NAME_MAX_LENGTH,String.format("The name cannot  length should be between %s and %s symbols",
                BRAND_NAME_MiN_LENGTH_Cream,BRAND_NAME_MAX_LENGTH));
        super.brand = brand;
    }

    @Override
    public ScentType getScentType() {
        return scentType;
    }
    @Override
    public String print() {
        return String.format("%s %s",super.print(),getScentType());
    }
}


