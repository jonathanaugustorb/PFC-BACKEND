package forcamente.api.entity;

import lombok.Getter;

@Getter
public enum GrupoMuscularEnum {

    PEITO("Peito"),
    COSTAS("Costas"),
    OMBRO("Ombro"),
    BICEPS("Biceps"),
    TRICEPS("Triceps"),
    PERNA("Perna"),
    GLUTEO("Gluteo"),
    ABDOMEN("Abdomen");

    private final String descricao;

    GrupoMuscularEnum(String descricao) {
        this.descricao = descricao;
    }
}
