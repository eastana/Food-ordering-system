package domain.eatable;

import enums.Cuisines;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
public class Lunch {
    private Cuisines cuisineName;
    private String mainCourseName;
    private String dessertName;

    private BigDecimal price;
    private int amount;

    @Override
    public String toString() {
        return "Lunch{" +
                "cuisineName=" + cuisineName +
                ", mainCourseName='" + mainCourseName + '\'' +
                ", dessertName='" + dessertName + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}
