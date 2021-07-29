package com.telerikacademy.oop.cosmetics;

import com.telerikacademy.oop.cosmetics.core.CosmeticsEngineImpl;

public class Startup {

    public static void main(String[] args) {
        CosmeticsEngineImpl engine = new CosmeticsEngineImpl();
        engine.start();
    }

}
