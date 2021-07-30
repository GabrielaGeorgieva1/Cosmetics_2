package com.telerikacademy.oop.cosmetics.models.contracts;

import com.telerikacademy.oop.cosmetics.models.enums.UsageType;

public interface Shampoo extends Product{

    int getMillilitres();

    UsageType getUsageType();

}
