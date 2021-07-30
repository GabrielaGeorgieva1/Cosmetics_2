package com.telerikacademy.oop.cosmetics.tests.utils;

import com.telerikacademy.oop.cosmetics.models.CategoryImpl;
import com.telerikacademy.oop.cosmetics.models.CreamImpl;
import com.telerikacademy.oop.cosmetics.models.ShampooImpl;
import com.telerikacademy.oop.cosmetics.models.ToothpasteImpl;

import static com.telerikacademy.oop.cosmetics.tests.utils.TestUtilities.initializeStringWithSize;

public class TestData {

    public static final double POSITIVE_DOUBLE = 10.75;
    public static final int POSITIVE_INT = 5;

    public static class Toothpaste {

        public static final String VALID_NAME = initializeStringWithSize(ToothpasteImpl.NAME_MIN_LENGTH + 1);
        public static final String VALID_BRAND_NAME = initializeStringWithSize(ToothpasteImpl.BRAND_NAME_MIN_LENGTH + 1);
        public static final String VALID_INGREDIENTS = "test1,test2,test3";

    }

    public static class Shampoo {

        public static final String VALID_NAME = initializeStringWithSize(ShampooImpl.NAME_MIN_LENGTH + 1);
        public static final String VALID_BRAND_NAME = initializeStringWithSize(ShampooImpl.BRAND_NAME_MIN_LENGTH + 1);

    }
    public static class Cream {

      public static final String VALID_NAME = initializeStringWithSize(CreamImpl.NAME_MIN_LENGTH + 1);
      public static final String VALID_BRAND_NAME = initializeStringWithSize(CreamImpl.BRAND_NAME_MIN_LENGTH + 1);
   }

    public static class Category {

        public static final String VALID_NAME = initializeStringWithSize(CategoryImpl.NAME_MIN_LENGTH + 1);

    }

}
