package forcamente.api.dto;

import forcamente.api.entity.enums.GrupoMuscularEnum;
import forcamente.api.entity.enums.NivelDificuldadeEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public record ExercicioResponseDTO(
        UUID id,
        String nome,
        GrupoMuscularEnum grupoMuscular,
        NivelDificuldadeEnum nivel,
        String descricaoExecucao,
        String errosComuns,
        String aquecimentoRecomendado,
        String equipamento,
        String gifUrl,
        LocalDateTime criadoEm
) {
}
