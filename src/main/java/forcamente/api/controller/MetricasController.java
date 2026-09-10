package forcamente.api.controller;

import forcamente.api.dto.VolumeTreinoRequestDTO;
import forcamente.api.dto.VolumeTreinoResponseDTO;
import forcamente.api.service.IMetricasService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/metricas")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
@RequiredArgsConstructor
public class MetricasController {

    private final IMetricasService metricasService;

    @PostMapping("/volume-treino")
    public ResponseEntity<VolumeTreinoResponseDTO> calcularVolumeTreino(
            @Valid @RequestBody VolumeTreinoRequestDTO volumeTreinoRequestDTO) {
        return
                ResponseEntity.ok(metricasService.calcularVolumeTreino(volumeTreinoRequestDTO));
    }
}

