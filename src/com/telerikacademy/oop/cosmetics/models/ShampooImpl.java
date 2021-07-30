package com.telerikacademy.oop.cosmetics.models;


import com.telerikacademy.oop.cosmetics.models.contracts.Shampoo;
import com.telerikacademy.oop.cosmetics.models.enums.GenderType;
import com.telerikacademy.oop.cosmetics.models.enums.UsageType;

public class ShampooImpl extends Cosmetic implements Shampoo {

    private int milliliters;
    private final UsageType usageType;


    public ShampooImpl(String name, String brand, double price, GenderType genderType, int milliliters,
                       UsageType usageType) {
        super(name, brand, price, genderType);
        setMilliliters(milliliters);
        this.usageType = usageType;
    }

    public void setMilliliters(int milliliters) {
        if(milliliters < 0) {
            throw new IllegalArgumentException("The milliliters cannot be negative");
        }
        this.milliliters = milliliters;
    }

    @Override
    public int getMillilitres() {
        return milliliters;
    }

    @Override
    public UsageType getUsageType() {
        return usageType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShampooImpl shampoo = (ShampooImpl) o;
        return getName().equals(shampoo.getName()) &&
                getBrandName().equals(shampoo.getBrandName()) &&
                getPrice() == shampoo.getPrice() &&
                getGenderType().equals(shampoo.getGenderType()) &&
                getMillilitres() == shampoo.getMillilitres() &&
                getUsageType().equals(shampoo.getUsageType());
    }
    @Override
    public String print() {
        return String.format("%s#Milliliters: %s%n#Usage: %s",super.print(),getMillilitres(),getUsageType());

    }
}
