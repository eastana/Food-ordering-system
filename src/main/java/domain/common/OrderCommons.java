package domain.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
public final class OrderCommons {

    private boolean isOrdered;
    private BigDecimal price;

    @Override
    public String toString() {
        return "OrderCommons{" +
                "isOrdered=" + isOrdered +
                ", price=" + price +
                '}';
    }
}
