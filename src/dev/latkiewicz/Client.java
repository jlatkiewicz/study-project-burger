package dev.latkiewicz;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class Client {

    public Order createOrder(Optional<BurgerOrder> burgerOrder, Optional<FriesOrder> friesOrder) {
        var order = new Order();
        burgerOrder.ifPresent(order::createBurger);
        friesOrder.ifPresent(order::createFries);
        return order;
    }

    public void printOrder(Order order) {
        System.out.println(order.toString());
    }
}

record BurgerOrder(List<Ingredient> ingredients, String name, BigDecimal baseBurgerPrice, int baseBurgerCalories){}
record FriesOrder(BigDecimal price, int calories){}