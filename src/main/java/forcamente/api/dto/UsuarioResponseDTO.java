package forcamente.api.dto;

import forcamente.api.entity.PapelUsuarioEnum;

import java.time.LocalDateTime;
import java.util.UUID;

public record UsuarioResponseDTO(
        UUID id,
        String nomeCompleto,
        String cpf,
        String email,
        PapelUsuarioEnum papel,
        String cidade,
        String estado,
        boolean ativo,
        LocalDateTime criadoEm
) {
}
