package forcamente.api.service.impl;

import forcamente.api.dto.UsuarioRequestDTO;
import forcamente.api.dto.UsuarioResponseDTO;
import forcamente.api.entity.UsuarioEntity;
import forcamente.api.mapper.UsuarioMapper;
import forcamente.api.repository.IUsuarioRepository;
import forcamente.api.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    @Transactional
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        log.info("criarUsuario: {}", usuarioRequestDTO.email());

        if (usuarioRepository.existsByEmail(usuarioRequestDTO.email())) {
            throw new IllegalArgumentException(
                    "Ja existe um usuario cadastrado com o e-mail: " + usuarioRequestDTO.email());
        }
        if (usuarioRepository.existsByCpf(usuarioRequestDTO.cpf())) {
            throw new IllegalArgumentException("Ja existe um usuario cadastrado com este CPF");
        }

        UsuarioEntity usuarioEntity = usuarioMapper.toEntity(usuarioRequestDTO);

        usuarioEntity.setSenhaHash(passwordEncoder.encode(usuarioRequestDTO.senha()));

        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuarioEntity);

        return usuarioMapper.toDTO(usuarioSalvo);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(UUID usuarioId) {
        log.info("buscarPorId: {}", usuarioId);

        UsuarioEntity usuarioEntity = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Usuario nao encontrado: " + usuarioId));

        return usuarioMapper.toDTO(usuarioEntity);
    }
}
