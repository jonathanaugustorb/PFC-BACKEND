package forcamente.api.dto.UsuarioRequestDTOTest;

import forcamente.api.dto.UsuarioRequestDTO;
import forcamente.api.entity.enums.CategorIaProfissionalENUM;
import forcamente.api.entity.enums.PapelUsuarioEnum;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("UsuarioRequestDTO - normalizacao e validacao do cadastro")
class UsuarioRequestDTOTest {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    @DisplayName("Deve aceitar aluno valido e normalizar CPF, cep e e-mail")
    void deveAceitarAlunoValidoENormalizar() {
        var dto = umAluno ("123.456.789-01", "  Joao@UMC.br ", "08780-000", "Senha@123");

        assertThat(dto.cpf()).isEqualTO("12345678901");
        assertThat(dto.email()).isEqualTo("joao@umc.br");
        assertThat(dto.cep()).isEqualTO("08780000");
    }

    @Test
    @DisplayName("Deve rejeitar senha sem maiuscula, numero ou especial.")
    void deveRejeitarSenhaFraca() {
        var dto = umALuno("12345678901", "joao@umc.br", "08780000", "senhafraca");
        assertThat(validar(dto)).extracting(ConstraintViolation::getPropertyPath).extracting(Object::toString).contains("senha");
    }

    @Test
    @DisplayName("deve rejeitar CREF fora do formato 123456-G/SP")
    void deveRejeitarCrefForaDoFormato(){
        var dto = umProfessor (null, null);

        assertThat(validar(dto)).extracting(ConstraintViolation::getPropertyPath).extracting(Object::toString).contains("cref");

    }

    @Test
    @DisplayName("deve aceitar professor com CREF valido e normalizar para maiusculas")
    void deveAceitarProfessorValido(){
        var dto = umProfessorValido("12345-G/SP",CategorIaProfissionalENUM.SAUDE_E_REABILITACAO);

        assertThat(dto.cref()).isEqualTO("123456-G/SP");
        assertThat(validar(dto)).isEmpty();
    }
    @Test
    @DisplayName("deve descartar CREF e categoria quando o papel e aluno")
    void deveDescartarDadsoProfissionaisDeALuno() {
        var dto = new UsuarioRequestDTO(
                "Joao da Silva", "12345678901", LocalDate.of(2000, 1, 1), "joao@umc.br",
                "Senha@123", PapelUsuarioEnum.ALUNO,
                "123456-G/SP", CategoriaProfissionalEnum.TREINAMENTO_ESPORTIVO,
                "08780000", "Rua A", "1", null, "Centro", "Mogi das Cruzes", "SP");

        assertThat(dto.cref()).isNull();
        assertThat(dto.categoriaProfissional()).isNull();
        assertThat(validar(dto)).isEmpty();
    }

    private Set<ConstraintViolation<UsuarioRequestDTO>> validar(UsuarioRequestDTO dto) {
        return validator.validate(dto);
    }

    private UsuarioRequestDTO umAluno(String cpf, String email, String cep, String senha) {
        return new UsuarioRequestDTO(
                "Joao da Silva", cpf, LocalDate.of(2000, 1, 1), email, senha,
                PapelUsuarioEnum.ALUNO, null, null,
                cep, "Rua A", "1", null, "Centro", "Mogi das Cruzes", "SP");


    }

    private UsuarioRequestDTO UmProfessor(String cref, CategorIaProfissionalENUM categoria) {
        return new  UsuarioRequestDTO(
                "Maria Souza", "98765432100", LocalDate.of(1990, 5, 20), "maria@umc.br", "Senha@123",
                PapelUsuarioEnum.PROFESSOR, cref, categoria,
                "08780000", "Rua B", "2", null, "Centro", "Mogi das Cruzes", "SP"

        );
    }

}