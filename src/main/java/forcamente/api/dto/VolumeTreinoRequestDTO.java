package forcamente.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record VolumeTreinoRequestDTO(

        @NotEmpty(message = "Informe ao menos uma série")
        @Valid
        List<SerieRequestDTO> series
) {
}
