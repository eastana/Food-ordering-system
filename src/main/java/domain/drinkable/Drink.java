package domain.drinkable;

import domain.common.OrderCommons;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Drink {
    private String name;
    private BigDecimal drinkPrice;
    private int amount;

    private OrderCommons iceCube;
    private OrderCommons lemon;


    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", drinkPrice=" + drinkPrice +
                ", amount=" + amount +
                ", iceCube=" + iceCube +
                ", lemon=" + lemon +
                '}';
    }
}
