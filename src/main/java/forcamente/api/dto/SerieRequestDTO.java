package forcamente.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.UUID;

public record SerieRequestDTO(

        @NotNull(message = "Informe o exercício")
        UUID exercicioId,

        @NotNull(message = "Informe a quantidade de séries")
        @Positive(message = "A quantidade de series deve ser maior que zero")
        Integer series,

        @NotNull(message = "Informe a quantidade de repetições")
        @Positive(message = "A quantidade de repetições deve ser maior que zero")
        Integer repeticoes,

        @NotNull(message = "Informe a carga")
        @PositiveOrZero(message = "A carga não pode ser negativa")
        Double cargaKg

) {
}
