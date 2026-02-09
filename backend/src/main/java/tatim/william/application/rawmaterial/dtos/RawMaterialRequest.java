package tatim.william.application.rawmaterial.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
public record RawMaterialRequest(
        @NotBlank(message = "O nome é obrigatório")
        String name,
        @NotNull(message = "A quantidade em estoque é obrigatória")
        @Positive(message = "A quantidade em estoque não pode ser negativa")
        Long stockQuantity
) {
}
