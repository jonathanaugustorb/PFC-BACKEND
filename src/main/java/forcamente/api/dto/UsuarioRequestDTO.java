package forcamente.api.dto;

import forcamente.api.entity.enums.PapelUsuarioEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO(

        @NotBlank(message = "O nome completo e obrigatorio")
        String nomeCompleto,

        @NotBlank(message = "O CPF e obrigatorio")
        @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 digitos, apenas numeros")
        String cpf,

        @NotBlank(message = "O e-mail e obrigatorio")
        @Email(message = "E-mail em formato invalido")
        String email,

        @NotBlank(message = "A senha e obrigatoria")
        @Size(min = 8, message = "A senha deve ter no minimo 8 caracteres")
        String senha,

        @NotNull(message = "O papel do usuario e obrigatorio")
        PapelUsuarioEnum papel,

        @Pattern(regexp = "\\d{8}", message = "O CEP deve conter 8 digitos, apenas numeros")
        String cep,

        String logradouro,

        String numero,

        String complemento,

        String bairro,

        String cidade,

        @Size(max = 2, message = "O estado deve ser a sigla com 2 letras")
        String estado
) {
}
