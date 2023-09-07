package SoftLJunior.cadastro.domain.funcionario;


import jakarta.persistence.*;

@Entity
@Table(name = "funcionarios")

public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    private String nascimento;
    private String funcao;
    private String modelo;
    private String contrato;


    public Funcionario(DadosCadastroFuncionario dados){
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.nascimento = dados.nascimento();
        this.funcao = dados.funcao();
        this.modelo = dados.modelo();
        this.contrato = dados.contrato();

    }

    public Funcionario(){}

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", nascimento='" + nascimento + '\'' +
                ", funcao='" + funcao + '\'' +
                ", modelo='" + modelo + '\'' +
                ", contrato='" + contrato + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getModelo() {
        return modelo;
    }

    public String getContrato() {
        return contrato;
    }


    public void atualizaDados(DadosAlteracaoFuncionario dados) {
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.nascimento = dados.nascimento();
        this.funcao = dados.funcao();
        this.modelo = dados.modelo();
        this.contrato = dados.contrato();
    }
}
