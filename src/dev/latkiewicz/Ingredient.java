package dev.latkiewicz;

import java.math.BigDecimal;

record Ingredient(
     IngredientType type,
     BigDecimal price,
     int calories
) {}

enum IngredientType {
    BREAD, MEAT, SAUCE, VEGETABLE, CHEESE
}
