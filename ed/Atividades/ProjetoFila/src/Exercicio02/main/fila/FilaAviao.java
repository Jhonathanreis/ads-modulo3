package Exercicio02.main.fila;

import Exercicio02.classes.Aviao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JHONATHAN
 */

public class FilaAviao {

    int tamanho;
    int inicio;
    int fim;
    int quantidadeDeElementos;
    private Aviao[] array;

    public FilaAviao() {
        this(4
        );
    }

    public FilaAviao(int tamanho) {
        if (tamanho <= 0) {
            throw new RuntimeException("Tamanho tem que ser > 0");
        }

        this.tamanho = tamanho;
        this.array = new Aviao[tamanho];
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

    public boolean filaCheia() {
        return quantidadeDeElementos == tamanho;//true
    }

    public void enqueue(Aviao elemento) {
        if (filaCheia()) {
            throw new RuntimeException("Fila cheia");
        }
        array[fim] = elemento;
        fim = (fim + 1) % tamanho;
        quantidadeDeElementos++;
    }

    public void dequeue() {
        if (empty()) {
            throw new RuntimeException("Fila Vazia");
        }

        inicio = (inicio + 1) % tamanho;
        quantidadeDeElementos--;
    }

    public Aviao peek() {
        if (empty()) {
            throw new RuntimeException("fila vazia");
        }

        return array[inicio];
    }

    public void destroy() {
        inicio = 0;
        fim = 0;
        tamanho = 0;
    }

    public List<Aviao> mostrar() {
        List<Aviao> elementos = new ArrayList<Aviao>();
        for (int i = 0; i < quantidadeDeElementos; i++) {
            elementos.add(array[i]);
        }
        return elementos;

    }
}
