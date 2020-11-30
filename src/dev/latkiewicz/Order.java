package dev.latkiewicz;

import java.math.BigDecimal;
import java.util.Optional;

import static java.math.BigDecimal.ZERO;

public class Order {
    private Burger burger;
    private Fries fries;

    public void createBurger(BurgerOrder burgerOrder) {
        var price = burgerOrder.ingredients()
                .stream()
                .map(Ingredient::price)
                .reduce(ZERO, BigDecimal::add)
                .add(burgerOrder.baseBurgerPrice());
        var calories = burgerOrder.ingredients()
                .stream()
                .mapToInt(Ingredient::calories)
                .sum() + burgerOrder.baseBurgerCalories();

        this.burger = new Burger(burgerOrder.name(), burgerOrder.ingredients(), price, calories);
    }

    public void createFries(FriesOrder friesOrder) {
        this.fries = new Fries(friesOrder.price(), friesOrder.calories());
    }

    public BigDecimal getPrice() {
        var burgerPrice = Optional.ofNullable(burger).map(Burger::price).orElse(ZERO);
        var friesPrice = Optional.ofNullable(fries).map(Fries::price).orElse(ZERO);
        return burgerPrice.add(friesPrice);
    }

    public int getCalories() {
        var burgerCalories = Optional.ofNullable(burger).map(Burger::calories).orElse(0);
        var friesCalories = Optional.ofNullable(fries).map(Fries::calories).orElse(0);
        return burgerCalories + friesCalories;
    }

    @Override
    public String toString() {
        return "Order{" +
                "burger=" + burger +
                ", fries=" + fries +
                ", total calories=" + getCalories() +
                ", total price=" + getPrice() +
                '}';
    }
}
