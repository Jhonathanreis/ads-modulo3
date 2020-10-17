/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

/**
 *
 * @author JHONATHAN
 */
public class Funcionario {
    
    //---ATRIBUTOS---//
    private String matricula;
    private String nome;

    //---CONSTRUTOR PADRÃO---//
    public Funcionario(String matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
    }

    public Funcionario(String str){
        String[] vetor = str.split(";");
        this.matricula = vetor[0];
        this.nome = vetor[1];
    }
    
    //---GETERS E SETTERS---//

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }   
}
