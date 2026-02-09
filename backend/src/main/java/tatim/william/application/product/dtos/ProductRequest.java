package tatim.william.application.product.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank(message = "O nome é obrigatório")
        String name,

        @Positive(message = "O preço não pode ser negativo")
        @NotNull(message = "O preço é obrigatório")
        BigDecimal price
){
}
