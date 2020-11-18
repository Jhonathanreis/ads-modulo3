package Exercicio03.classses;

/**
 *
 * @author JHONATHAN
 */
public class Fila {

    int tamanho;
    int inicio;
    int fim;
    int quantidadeDeElementos;
    String[] array;

    public Fila(int tamanho) {
        if (tamanho <= 0) {
            throw new RuntimeException("Tamanho tem que ser > 0");
        }

        this.tamanho = tamanho;
        this.array = new String[tamanho];
        inicio = 0;
        fim = 0;
        quantidadeDeElementos = 0;

    }

    public boolean empty() {

        return quantidadeDeElementos == 0;
    }

    public int size() {
        return quantidadeDeElementos;
    }

    public void enqueue(String elemento) {
        if (quantidadeDeElementos == tamanho) {
            throw new RuntimeException("Fila cheia");
        }
        this.array[this.fim] = elemento;
        this.fim = (this.fim + 1) % this.tamanho;
        ++this.quantidadeDeElementos;

    }

    public void dequeue() {
        if (empty()) {
            throw new RuntimeException("Fila Vazia");
        }

        inicio = (inicio + 1) % tamanho;
        quantidadeDeElementos--;
    }

    public String peek() {
        if (!empty()) {
            return array[inicio];
        }
        throw new RuntimeException("fila vazia");
    }

    public void destroy() {
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public String mostrar() {
        String elementos = "";
        for (int i = 0; i < quantidadeDeElementos; i++) {
            elementos += array[i] + "";
        }
        return elementos;

    }

    public void furaFila(String elemento) {
        //inicio é o primeiro da fila (primeiro a entrar - primeiro a sair)
        this.inicio--;
        if (this.inicio < 0) {
            this.inicio = this.array.length - 1;
        }

        array[this.inicio] = elemento;
        fim = (fim + 1) % tamanho;
        ++quantidadeDeElementos;

    }

}
