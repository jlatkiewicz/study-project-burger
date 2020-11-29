package dev.latkiewicz;

import java.math.BigDecimal;
import java.util.List;

record Burger(
     String name,
     List<Ingredient> ingredients,
     BigDecimal price,
     int calories
) {
}
