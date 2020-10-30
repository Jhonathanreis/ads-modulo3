package Exercicio03.classses;

/**
 *
 * @author JHONATHAN
 */

public class Pilha {

    private int tamanho;
    private String[] Array;
    private int topo = -1;

    public Pilha() {

    }

    public Pilha(int tamanho) {
        if (tamanho <= 0) {
            throw new RuntimeException("tamanho nao pode ser menor que 10");
        }

        this.tamanho = tamanho;
        Array = new String[tamanho];
    }

    public void inserir(String elemento) {
        if (estaCheia()) {
            throw new RuntimeException("esta cheio");
        }

        Array[topo + 1] = elemento;
        topo++;
    }

    public void retirar() {
        if (estaVazia()) {
            throw new RuntimeException("esta vazio");
        }

        topo--;
    }

    public boolean estaVazia() {
        return topo == -1;

    }

    public boolean estaCheia() {
        return topo == (tamanho - 1);

    }

    public int quantidadeDeElementos() {
        return topo+1;

    }
    public String consultar(){

        return Array[topo];
    }
    public void esvaziarPilha(){
        topo =-1;
    }






}
