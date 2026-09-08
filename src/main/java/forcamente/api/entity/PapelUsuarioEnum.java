package forcamente.api.entity;

import lombok.Getter;

@Getter
public enum PapelUsuarioEnum {

    ALUNO("Aluno"),
    PROFESSOR("Professor"),
    ADMINISTRADOR("Administrador");

    private final String descricao;

    PapelUsuarioEnum(String descricao) {
        this.descricao = descricao;
    }
}
