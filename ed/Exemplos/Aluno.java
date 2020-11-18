
public class Aluno {
    private int matricula;
    private String nome;
    private double nota;//8 bytes
    private Aluno proximo;
    private Aluno anterior;
    //construtor
    public Aluno(int matricula, String nome, double nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }
    //construtor
    public Aluno() {
        nota=3.2;
        
    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, matricula: %d e nota: %.1f", nome,matricula,nota);
    }
    
    
    
}
