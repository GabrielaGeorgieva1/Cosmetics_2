package com.telerikacademy.oop.cosmetics.models;


import com.telerikacademy.oop.cosmetics.models.contracts.Toothpaste;
import com.telerikacademy.oop.cosmetics.models.enums.GenderType;

import java.util.ArrayList;
import java.util.List;

public class ToothpasteImpl extends Cosmetic implements Toothpaste{

     private List<String> ingredients = new ArrayList<String>();

    public ToothpasteImpl(String name, String brand, double price, GenderType genderType,List<String> ingredients) {
        super(name, brand, price, genderType);
        this.ingredients = ingredients;

    }

    @Override
    public List<String> getIngredients() {
        return ingredients;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToothpasteImpl toothpaste = (ToothpasteImpl) o;
        return getName().equals(toothpaste.getName()) &&
                getBrandName().equals(toothpaste.getBrandName()) &&
                getPrice() == toothpaste.getPrice() &&
                this.getGenderType().equals(toothpaste.getGenderType()) &&
                getIngredients().equals(toothpaste.getIngredients());
    }
    @Override
    public String print() {
        return String.format("%s, #Ingredients: %s",super.print(),ingredients);
    }
}
