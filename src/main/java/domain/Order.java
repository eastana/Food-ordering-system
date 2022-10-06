package domain;

import domain.drinkable.Drink;
import domain.eatable.Lunch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class Order {
    private List<Lunch> lunches;
    private List<Drink> drinks;

    private BigDecimal orderPrice;

    public Order(List<Lunch> lunches, List<Drink> drinks) {
        this.lunches = lunches;
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "Order{" +
                "lunches=" + lunches +
                ", drinks=" + drinks +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
