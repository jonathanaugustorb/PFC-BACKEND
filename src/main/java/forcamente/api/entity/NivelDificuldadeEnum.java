package forcamente.api.entity;

import lombok.Getter;

@Getter
public enum NivelDificuldadeEnum {

    INICIANTE("Iniciante"),
    INTERMEDIARIO("Intermediário"),
    AVANCADO("Avançado");

    private final String descricao;

    NivelDificuldadeEnum(String descricao) {
        this.descricao = descricao;
    }
}
