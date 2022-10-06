package services;

import domain.Order;
import domain.drinkable.Drink;
import domain.eatable.Lunch;
import enums.Cuisines;
import lombok.extern.slf4j.Slf4j;
import utils.PriceCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class CLIService implements AutoCloseable {
    private final Scanner sc = new Scanner(System.in);

    private final Order orderMenu;

    private final Order order = new Order();
    private final List<Lunch> lunchList = new ArrayList<>();
    private final List<Drink> drinkList = new ArrayList<>();

    public CLIService(Order orderMenu) {
        this.orderMenu = orderMenu;
    }

    public void run() throws Exception {
        log.info("Hello, welcome to Food ordering system!");
        log.info("Do you want to see our food menu?");
        log.info("Press y/n");
        if (sc.nextLine().equalsIgnoreCase("y")) {
            wantsOrder();
        } else {
            log.info("Good bye!");
        }
    }

    private void wantsOrder() throws Exception {
        Cuisines[] cuisines = Cuisines.values();
        log.info("We have different " + cuisines.length + " cuisines");
        log.info("Which one do you want to choose? (Enter index of cuisine below)");
        for (int i = 0; i < cuisines.length; i++) {
            log.info(i + ". " + cuisines[i]);
        }
        String cuisine = sc.nextLine();
        if (cuisine.equalsIgnoreCase("0")) {
            orderLunch(Cuisines.POLISH);
        } else if (cuisine.equalsIgnoreCase("1")) {
            orderLunch(Cuisines.MEXICAN);
        } else if (cuisine.equalsIgnoreCase("2")) {
            orderLunch(Cuisines.ITALIAN);
        } else {
            log.error("Does not exist, try again!");
            wantsOrder();
        }
    }

    private void orderLunch(Cuisines cuisine) throws Exception {
        for (Lunch lunch : orderMenu.getLunches()) {
            if (lunch.getCuisineName().equals(cuisine)) {
                log.info("You choose " + cuisine + " cuisine.");
                log.info("It has " + lunch.getMainCourseName() + " as a main course. Dessert " + lunch.getDessertName() + ". Price is " + lunch.getPrice());
                log.info("How many amounts you want to order this lunch?");
                lunch.setAmount(Integer.parseInt(sc.nextLine()));
                lunchList.add(lunch);
            }
        }
        log.info("Do you want to order one more lunch? (y/n)");
        if (sc.nextLine().equalsIgnoreCase("y")) {
            wantsOrder();
        } else {
            log.info("Do you want to order drinks? (y/n)");
            if (sc.nextLine().equalsIgnoreCase("y")) {
                orderDrinks();
            } else {
                close();
            }
        }
    }

    private void orderDrinks() {
        log.info("Well, we have different drinks. You will see bar menu below");
        log.info("We have there drinks. Choose by index please!");
        for (int i = 0; i < orderMenu.getDrinks().size(); i++) {
            log.info(i + ". " + orderMenu.getDrinks().get(i).getName() + ". Price is " + orderMenu.getDrinks().get(i).getDrinkPrice());
        }
        String drinkIndex = sc.nextLine();
        if (Integer.parseInt(drinkIndex) >= orderMenu.getDrinks().size() && Integer.parseInt(drinkIndex) < 0) {
            log.error("Try again");
            orderDrinks();
        }

        Drink drink = orderMenu.getDrinks().get(Integer.parseInt(drinkIndex));

        log.info("How many amounts you want to order this lunch?");
        drink.setAmount(Integer.parseInt(sc.nextLine()));

        log.info("Do you want to add ice-cube to your drink? (y/n)" + " Price for ice-cube is " + drink.getIceCube().getPrice());
        if (sc.nextLine().equalsIgnoreCase("y")) {
            drink.getIceCube().setOrdered(true);
        }

        log.info("Do you want to add lemon to your drink? (y/n)" + " Price for lemon is " + drink.getLemon().getPrice());
        if (sc.nextLine().equalsIgnoreCase("y")) {
            drink.getLemon().setOrdered(true);
        }
        drinkList.add(drink);

        log.info("Do you want to order one more drink? (y/n)");
        if (sc.nextLine().equalsIgnoreCase("y")) {
            orderDrinks();
        } else {
            close();
        }
    }
    @Override
    public void close() {
        order.setLunches(lunchList);
        order.setDrinks(drinkList);
        order.setOrderPrice(new PriceCalculator().calculateOrderPrice(order));

        log.info("Congrats, you have already ordered.");
        log.info("Let's summarize your order");

        log.info("Your order is " + order);
        log.info("Your overall price is " + order.getOrderPrice());
    }
}
