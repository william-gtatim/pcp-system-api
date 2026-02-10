package tatim.william.api;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class ProductionPlanningControllerTest {
    @Test
    void shouldReturnProductionPlanningList() {

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/production-planing")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("", is(notNullValue()))
                .body("", is(instanceOf(java.util.List.class)));
    }
}