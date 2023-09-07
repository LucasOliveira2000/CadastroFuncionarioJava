package SoftLJunior.cadastro.domain.funcionario;

public record DadosAlteracaoFuncionario(Long id,
                                        String nome,
                                        Integer idade,
                                        String nascimento,
                                        String funcao,
                                        String modelo,
                                        String contrato) {
}
