package Exercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JHONATHAN
 */
public class FilaConsutorio {

    int tamanho;
    int inicio;
    int fim;
    int quantidadeDeElementos;
    private Paciente[] array;

    public FilaConsutorio() {
        this(4
        );
    }

    public FilaConsutorio(int tamanho) {
        if (tamanho <= 0) {
            throw new RuntimeException("Tamanho tem que ser > 0");
        }

        this.tamanho = tamanho;
        this.array = new Paciente[tamanho];
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

    public void enqueue(Paciente elemento) {
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

    public Paciente peek() {
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

    public List<Paciente> mostrar() {
        List<Paciente> elementos = new ArrayList<Paciente>();
        for (int i = 0; i < quantidadeDeElementos; i++) {
            elementos.add(array[i]);
        }
        return elementos;

    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Paciente paciente = null;
        Paciente paciente1 = new Paciente("Watlas", "000.000.000.00", "9999-9999", "Watlas@hot.com");
        FilaConsutorio filaConsutorio = new FilaConsutorio();
        filaConsutorio.enqueue(paciente1);
        String opcao;

        do {
            Menu();
            opcao = ler.nextLine();
            while (campoNumerico(opcao) == false) {
                System.out.println("Digite somente numero, analfabeto!");
                opcao = ler.nextLine();
            }
            switch (opcao) {
                case "1":
                    if (filaConsutorio.filaCheia()) {
                        System.out.println("FILA CHEIA");
                        break;
                    }

                    System.out.println("PREENCHA OS DADOS");

                    System.out.println("Nome: ");
                    String nome = ler.nextLine();
                    while (campoAlfabetico(nome) == false) {
                        System.out.println("Digite somente letras:");
                        nome = ler.nextLine();
                    }
                    System.out.println("CPF");
                    String cpf = ler.nextLine();
                    while (campoNumerico(cpf) == false) {
                        System.out.println("Digite somente numero, analfabeto!");
                        cpf = ler.nextLine();
                    }
                    System.out.println("TELEFONE:");
                    String telefone = ler.nextLine();
                    while (campoNumerico(telefone) == false) {
                        System.out.println("Digite somente numero, analfabeto!");
                        telefone = ler.nextLine();
                    }
                    System.out.println("EMAIL:");
                    String email = ler.nextLine();
                    paciente = new Paciente(nome, cpf, telefone, email);

                    filaConsutorio.enqueue(paciente);
                    break;
                case "2":
                    saltar();
                    System.out.println("Paciente: " + filaConsutorio.peek().toString() + "\n vai ser atendido agora!".toUpperCase());
                    filaConsutorio.dequeue();
                    break;
                case "3":
                    saltar();
                    System.out.println("PROXIMO PACIENTE");
                    System.out.println(filaConsutorio.peek().toString());
                    break;
                case "4":
                    saltar();
                    if (filaConsutorio.empty() == true) {
                        System.out.println("A FILA ESTA CHEIA");
                    } else {
                        System.out.println("A FILA AINDA NAO ESTA CHEIA");
                    }
                    break;
                case "5":
                    saltar();
                    System.out.println("QUANTIDADE DE PESSOAS NA FILA:"
                            + filaConsutorio.size());
                    break;
                case "6":
                    saltar();
                    List<Paciente> lista = filaConsutorio.mostrar();
                    if (lista.size() == 0) {
                        System.out.println("A fila esta vazia".toUpperCase());
                    } else {
                        System.out.println("Dados dos pacientes".toUpperCase());
                        for (Paciente aux : lista) {

                            System.out.println(aux.toString());
                        }
                    }
            }

        } while (opcao != "0");

    }

    public static void Menu() {
        System.out.println(
                " SELECIONE A OPÇÃO:");
        System.out.println("1 - Inserir Paciente".toUpperCase());
        System.out.println("2 - Chamar Paciente".toUpperCase());
        System.out.println("3 - Verificar Proximo paciente".toUpperCase());
        System.out.println("4 - verificar se a fila esta cheia/vazia".toUpperCase());
        System.out.println("5 - verificar quantidade de paciente na fila".toUpperCase());
        System.out.println("(opçao extre) 6 - mostrar todos da fila".toUpperCase());
        System.out.println("7 SAIR");

    }

    private static boolean campoNumerico(String campo) {
        return campo.matches("[0-9]+");
    }

    private static boolean campoAlfabetico(String campo) {
        return campo.toLowerCase().matches("[a-z]+");
    }

    private static void saltar() {
        System.out.println("\n");
    }

}
