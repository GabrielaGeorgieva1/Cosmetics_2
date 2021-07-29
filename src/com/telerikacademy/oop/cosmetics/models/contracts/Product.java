package com.telerikacademy.oop.cosmetics.models.contracts;

import com.telerikacademy.oop.cosmetics.models.enums.GenderType;

public interface Product {

    String getName();

    String getBrandName();

    double getPrice();

    GenderType getGenderType();

    String print();

}
