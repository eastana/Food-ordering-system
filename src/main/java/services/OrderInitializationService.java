package services;

import domain.Order;
import domain.common.OrderCommons;
import domain.drinkable.Drink;
import domain.eatable.Lunch;
import enums.Cuisines;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class OrderInitializationService {
    public Order createOrderMenu() {
        Lunch italian = new Lunch(
                Cuisines.ITALIAN,
                "Pasta",
                "Ice-cream",
                BigDecimal.valueOf(1990.00),
                0
        );
        Lunch mexican = new Lunch(
                Cuisines.MEXICAN,
                "Taco",
                "Cheesecake",
                BigDecimal.valueOf(1590.00),
                0
        );
        Lunch polish = new Lunch(
                Cuisines.POLISH,
                "Pierogi",
                "Truffles",
                BigDecimal.valueOf(1890.00),
                0
        );

        List<Lunch> lunchList = new ArrayList<>() {
            {
                add(italian);
                add(mexican);
                add(polish);
            }
        };

        Drink cola = new Drink(
                "Cola",
                BigDecimal.TEN,
                0,
                new OrderCommons(false, BigDecimal.ONE),
                new OrderCommons(false, BigDecimal.ONE)
        );
        Drink fanta = new Drink(
                "Fanta",
                BigDecimal.TEN,
                0,
                new OrderCommons(false, BigDecimal.ONE),
                new OrderCommons(false, BigDecimal.ONE)
        );
        Drink water = new Drink(
                "Water",
                BigDecimal.valueOf(5),
                0,
                new OrderCommons(false, BigDecimal.ONE),
                new OrderCommons(false, BigDecimal.ONE)
        );

        List<Drink> drinkList = new ArrayList<>() {
            {
                add(cola);
                add(fanta);
                add(water);
            }
        };
        return new Order(lunchList, drinkList);
    }
}
