package dev.latkiewicz;

import java.math.BigDecimal;
import java.util.Optional;

public class Order {
    private Burger burger;
    private Fries fries;

    public void createBurger(BurgerOrder burgerOrder) {
        var price = burgerOrder.ingredients()
                .stream()
                .map(Ingredient::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
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

    public Optional<Burger> getBurger() {
        return Optional.ofNullable(burger);
    }

    public Optional<Fries> getFries() {
        return Optional.ofNullable(fries);
    }

    @Override
    public String toString() {
        return "Order{" +
                "burger=" + burger +
                ", fries=" + fries +
                '}';
    }
}
