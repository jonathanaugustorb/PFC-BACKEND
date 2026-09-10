package forcamente.api.dto;

import forcamente.api.entity.enums.GrupoMuscularEnum;

public record VolumeGrupoMuscularDTO(
        GrupoMuscularEnum grupoMuscular,
        String descricao,
        Double volumeKg
) {
}
