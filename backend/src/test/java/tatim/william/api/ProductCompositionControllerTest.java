package tatim.william.api;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


@QuarkusTest
class ProductCompositionControllerTest {
    Long productId;
    Long rawMaterialId;

    @BeforeEach
    void setup() {

        productId =
                given()
                        .contentType(ContentType.JSON)
                        .body("""
                    {
                        "name": "Produto Teste",
                        "price": 10.0
                    }
                """)
                        .when()
                        .post("/products")
                        .then()
                        .statusCode(201)
                        .extract()
                        .jsonPath()
                        .getLong("id");

        rawMaterialId =
                given()
                        .contentType(ContentType.JSON)
                        .body("""
                    {
                        "name": "Matéria Prima Teste",
                        "stockQuantity": 100
                    }
                """)
                        .when()
                        .post("/raw-materials")
                        .then()
                        .statusCode(201)
                        .extract()
                        .jsonPath()
                        .getLong("id");
    }

    @Test
    void shouldCreateProductComposition() {

        given()
                .contentType(ContentType.JSON)
                .body("""
                {
                    "rawMaterialId": %d,
                    "quantityRequired": 2.5
                }
            """.formatted(rawMaterialId))
                .when()
                .post("/products/{productId}/composition", productId)
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("rawMaterialId", equalTo(rawMaterialId.intValue()))
                .body("quantityRequired", equalTo(2.5f));
    }



}