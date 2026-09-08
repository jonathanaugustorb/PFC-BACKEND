package forcamente.api.mapper;

import forcamente.api.dto.UsuarioRequestDTO;
import forcamente.api.dto.UsuarioResponseDTO;
import forcamente.api.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)

    @Mapping(target = "senhaHash", ignore = true)

    @Mapping(target = "ativo", constant = "true")
    @Mapping(target = "criadoEm", expression = "java(java.time.LocalDateTime.now())")
    UsuarioEntity toEntity(UsuarioRequestDTO usuarioRequestDTO);

    UsuarioResponseDTO toDTO(UsuarioEntity usuarioEntity);
}
