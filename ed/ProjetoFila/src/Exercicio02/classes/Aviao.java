package Exercicio02.classes;

/**
 *
 * @author JHONATHAN
 */
public class Aviao {

    private String nome;
    private int idAviao;
    private String companhia;
    private String capacidade;

    public Aviao() {

    }

    public Aviao(String nome, int idAviao, String companhia, String capacidade) {
        this.nome = nome;
        this.idAviao = idAviao;
        this.companhia = companhia;
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdAviao() {
        return idAviao;
    }

    public void setIdAviao(int idAviao) {
        this.idAviao = idAviao;
    }

    public String getCompanhiaAeria() {
        return companhia;
    }

    public void setCompanhiaAeria(String string) {
        this.companhia = string;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public java.lang.String toString() {
        return "Aviao{"
                + "nome:" + nome
                + " idAviao:" + idAviao
                + " companhiaAeria:" + companhia.toString()
                + " capacidade:" + capacidade;
    }
}
