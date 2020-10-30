package Exercicio02.main;

import Exercicio02.classes.Aviao;
import Exercicio02.main.fila.FilaAviao;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JHONATHAN
 */

public class main {

    public static void main(String[] args) {
        int idaviao = 0;
        Scanner ler = new Scanner(System.in);
        FilaAviao filaAviao = new FilaAviao();
        Aviao aviao = null;
        String opcao;
        do {
            menu();
            opcao = validaentrada();

            switch (opcao) {

                case "1":
                    System.out.println();
                    System.out.println("QUANTIDADE DE AVIOES NA ESPERA: " + filaAviao.size());
                    System.out.println();
                    break;
                case "2":
                    System.out.println();
                    filaAviao.dequeue();
                    System.out.println(filaAviao.peek() + "\n ACABOU DE DECOLAR!");
                    System.out.println();
                    break;
                case "3":
                    System.out.println();
                    System.out.println("DIGITE O NOME DO AVIAO:");
                    System.out.print("> ");
                    String nome = validaAlfa();
                    System.out.println("DIGITE A COMPANHIA DO AVIAO:");
                    System.out.print("> ");
                    String companhia = validaAlfa();
                    System.out.println("DIGITE A CAPACIDADE DO AVIAO:");
                    System.out.print("> ");
                    String capacidade = validaNumber();
                    aviao = new Aviao(nome, idaviao++, companhia, capacidade);
                    filaAviao.enqueue(aviao);
                    System.out.println("AVIAO:\n " + aviao.toString() + "\n FOI ADICIONADO");
                    System.out.println();
                    break;
                case "4":
                    List<Aviao> lista = filaAviao.mostrar();
                    if (lista == null) {
                        System.out.println("NÃO EXISTEM AVIOES NA"
                                + "FILA DE ESPERA!");
                    } else {
                        for (Aviao obj : lista) {
                            System.out.println(obj.toString());

                        }

                    }
                    System.out.println();
                    break;
                case "5":
                    System.out.println("O AVIAO : " + filaAviao.peek()
                            + "\n É O PROXIMA DA FILA!");
                    break;
                case "6":
                    System.out.println("XAUUUUUU!");
                    System.exit(0);
                    break;
            }

        } while (opcao != "6");

    }

    private static void menu() {
        System.out.println("SELECIONE A OPÇAO\n");
        System.out.println("1 - NUMERO DE AVIOES NA ESPERA DA DECOLAGEM");
        System.out.println("2 - Autorizar a decolagem do primeiro avião da fila".toUpperCase());
        System.out.println("3 - Adicionar um avião à fila de espera".toUpperCase());
        System.out.println("4 - Listar todos os aviões na fila de espera".toUpperCase());
        System.out.println("5 - Listar as características do primeiro avião da fila".toUpperCase());
        System.out.println("6 - SAIR");
    }

    private static boolean campoNumerico(String campo) {
        return campo.matches("[0-9]+");
    }

    private static boolean campoAlfabetico(String campo) {

        return campo.toLowerCase().matches("[a-z]+");
    }

    private static boolean campoentrada(String campo) {
        return campo.matches("[1-6]+");
    }

    private static String validaentrada() {
        Scanner ler = new Scanner(System.in);
        String campo;
        campo = ler.nextLine();
        while (campoentrada(campo) == false) {
            System.out.println("OPÇAO INVALIDA");
            campo = ler.nextLine();

        }
        return campo;
    }

    private static String validaNumber() {
        Scanner ler = new Scanner(System.in);
        String campo;
        campo = ler.nextLine();
        while (campoNumerico(campo) == false) {
            System.out.println("OPÇAO INVALIDA");
            campo = ler.nextLine();

        }
        return campo;
    }

    private static String validaAlfa() {
        Scanner ler = new Scanner(System.in);
        String campo;
        campo = ler.nextLine();
        while (campoAlfabetico(campo) == false) {
            System.out.println("OPÇAO INVALIDA");
            campo = ler.nextLine();

        }
        return campo;
    }

}
