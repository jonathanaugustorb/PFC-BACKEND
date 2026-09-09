package forcamente.api.dto;

import forcamente.api.entity.enums.GrupoMuscularEnum;
import forcamente.api.entity.enums.NivelDificuldadeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ExercicioRequestDTO(

        @NotBlank(message = "O nome do exercicio e obrigatorio")
        @Size(max = 120, message = "O nome deve ter no maximo 120 caracteres")
        String nome,

        @NotNull(message = "O grupo muscular e obrigatorio")
        GrupoMuscularEnum grupoMuscular,

        @NotNull(message = "O nivel de dificuldade e obrigatorio")
        NivelDificuldadeEnum nivel,

        @NotBlank(message = "A descricao da execucao e obrigatoria")
        String descricaoExecucao,

        String errosComuns,

        String aquecimentoRecomendado,

        String equipamento,

        String gifUrl
) {
}
