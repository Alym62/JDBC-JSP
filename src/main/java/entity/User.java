package entity;

public class User {

    private Integer cod_registro;
    private String nome;
    private String profissao;
    private Integer idade;

    public User(){
        super();
    }

    public User(Integer cod_registro, String nome, String profissao, Integer idade){
        super();
        this.cod_registro = cod_registro;
        this.nome = nome;
        this.profissao = profissao;
        this.idade = idade;
    }

    public Integer getCod_registro() {
        return cod_registro;
    }

    public void setCod_registro(Integer cod_registro) {
        this.cod_registro = cod_registro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
