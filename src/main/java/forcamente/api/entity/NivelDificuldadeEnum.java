package forcamente.api.entity;

import lombok.Getter;

@Getter
public enum NivelDificuldadeEnum {

    INICIANTE("Iniciante"),
    INTERMEDIARIO("Intermediario"),
    AVANCADO("Avancado");

    private final String descricao;

    NivelDificuldadeEnum(String descricao) {
        this.descricao = descricao;
    }
}
