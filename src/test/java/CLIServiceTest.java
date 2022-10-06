import domain.Order;
import domain.drinkable.Drink;
import domain.eatable.Lunch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.CLIService;
import services.OrderInitializationService;
import utils.PriceCalculator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

public class CLIServiceTest {

    private Order order;

    @Before
    public void setup() {
        this.order = initializeOrder();
    }

    @Test
    public void run() throws Exception {
//        tried but cannot test cli
        CLIService cliService = new CLIService(new OrderInitializationService().createOrderMenu());

        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("y\n0\n1\nn\ny\n0\n1\ny\ny\nn\n".getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        PrintStream stdout = System.out;
        System.setOut(ps);

//        cliService.run();

        System.setIn(stdin);
        System.setOut(stdout);
    }


    @Test
    public void calculatorTest() {
        BigDecimal price = new PriceCalculator().calculateOrderPrice(order);
        Assert.assertEquals(BigDecimal.valueOf(5501.0), price);
    }

    private Order initializeOrder() {
        Order order = new OrderInitializationService().createOrderMenu();
        for (Lunch lunch : order.getLunches()) {
            lunch.setAmount(1);
        }
        for (Drink drink : order.getDrinks()) {
            drink.setAmount(1);
            drink.getIceCube().setOrdered(true);
            drink.getLemon().setOrdered(true);
        }
        return order;
    }
}
