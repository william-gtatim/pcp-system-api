package tatim.william.application.planning;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


@QuarkusTest
class ProductionPlanningServiceTest {
    @Inject
    ProductionPlanningService planningService;

    @Test
    void shouldPlanProduction() {
        var result = planningService.plan();

        assertEquals(2, result.size());

        var first = result.get(0);
        var second = result.get(1);

        assertEquals("PAO", first.code());
        assertEquals(10, first.quantity());
        assertEquals(new BigDecimal("500.00"), first.totalRevenue());

        assertEquals("PIZZA", second.code());
        assertEquals(4, second.quantity());
        assertEquals(new BigDecimal("400.00"), second.totalRevenue());
    }

}