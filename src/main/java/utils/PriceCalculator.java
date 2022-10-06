package utils;

import domain.Order;
import domain.drinkable.Drink;
import domain.eatable.Lunch;

import java.math.BigDecimal;

public final class PriceCalculator {
    public BigDecimal calculateOrderPrice(Order order) {
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (Lunch lunch : order.getLunches()) {
            totalPrice = totalPrice.add(lunch.getPrice().multiply(BigDecimal.valueOf(lunch.getAmount())));
        }
        for (Drink drink : order.getDrinks()) {
            totalPrice = totalPrice.add(drink.getDrinkPrice().multiply(BigDecimal.valueOf(drink.getAmount())));
            if (drink.getIceCube().isOrdered()) {
                totalPrice = totalPrice.add(drink.getIceCube().getPrice());
            }
            if (drink.getLemon().isOrdered()) {
                totalPrice = totalPrice.add(drink.getLemon().getPrice());
            }
        }
        return totalPrice;
    }
}
