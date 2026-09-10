package forcamente.api.dto;

import java.util.List;

public record VolumeTreinoResponseDTO(

        Double volumeTotalKg,
        List<VolumeGrupoMuscularDTO> volumePorGrupoMuscular,
        Integer totalSeries,
        Integer totalRepeticoes,
        Integer intensidadeMediaKgPorRep

) {
}
