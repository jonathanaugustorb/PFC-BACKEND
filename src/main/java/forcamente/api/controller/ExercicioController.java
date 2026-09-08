package forcamente.api.controller;

import forcamente.api.dto.ExercicioRequestDTO;
import forcamente.api.dto.ExercicioResponseDTO;
import forcamente.api.entity.GrupoMuscularEnum;
import forcamente.api.service.IExercicioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercicios")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
@RequiredArgsConstructor
public class ExercicioController {

    private final IExercicioService exercicioService;

    @PostMapping
    public ResponseEntity<ExercicioResponseDTO> criarExercicio(
            @Valid @RequestBody ExercicioRequestDTO exercicioRequestDTO) {

        var exercicioResponseDTO = exercicioService.criarExercicio(exercicioRequestDTO);

        var location = URI.create("/api/exercicios/" + exercicioResponseDTO.id());
        return ResponseEntity.created(location).body(exercicioResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ExercicioResponseDTO>> listarExercicios(
            @RequestParam(name = "grupoMuscular", required = false) GrupoMuscularEnum grupoMuscular) {

        var exercicios = (grupoMuscular == null)
                ? exercicioService.listarExercicios()
                : exercicioService.listarPorGrupoMuscular(grupoMuscular);

        return ResponseEntity.ok(exercicios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioResponseDTO> buscarPorId(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(exercicioService.buscarPorId(id));
    }
}
