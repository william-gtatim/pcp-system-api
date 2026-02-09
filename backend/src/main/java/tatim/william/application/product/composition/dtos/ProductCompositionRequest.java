package tatim.william.application.product.composition.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductCompositionRequest(
        @NotNull(message = "O id da matéria-prima é obrigatória")
        Long rawMaterialId,
        @NotNull(message = "A quantidade de matéria-prima é obrigatória")
        @Positive(message = "A quantidade de matéria-prima deve ser um valor positivo")
        float quantityRequired
) {
}
