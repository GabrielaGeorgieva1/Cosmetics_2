package com.telerikacademy.oop.cosmetics.models.contracts;

import com.telerikacademy.oop.cosmetics.models.enums.ScentType;

public interface Cream extends Product{
    ScentType getScentType();
}
