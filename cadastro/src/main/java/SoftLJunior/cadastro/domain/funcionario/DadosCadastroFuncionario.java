package SoftLJunior.cadastro.domain.funcionario;

import java.util.Date;

public record DadosCadastroFuncionario(String nome,
                                       Integer idade,
                                       String nascimento,
                                       String funcao,
                                       String modelo,
                                       String contrato) {
}
