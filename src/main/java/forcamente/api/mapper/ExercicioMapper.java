package forcamente.api.mapper;

import forcamente.api.dto.ExercicioRequestDTO;
import forcamente.api.dto.ExercicioResponseDTO;
import forcamente.api.entity.ExercicioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExercicioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "criadoEm", expression = "java(java.time.LocalDateTime.now())")
    ExercicioEntity toEntity(ExercicioRequestDTO exercicioRequestDTO);

    ExercicioResponseDTO toDTO(ExercicioEntity exercicioEntity);
}
