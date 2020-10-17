/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import classes.Funcionario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
//import java.util.Iterator;

/**
 *
 * @author eugeniojulio
 */
public class FuncionarioPersistencia {

    //Atributos
    private String nomeDoArquivo;

    //Metodos
    public FuncionarioPersistencia(String nome) {
        nomeDoArquivo = nome;
    }

    public ArrayList<Funcionario> listagemDeAlunosNome() throws Exception {
        try {
            ArrayList<Funcionario> array = new ArrayList<Funcionario>();
            FileReader fr = new FileReader(nomeDoArquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha = "";
            int pos = 0;
            while ((linha = br.readLine()) != null) {
                Funcionario aux = new Funcionario(linha);
                array.add(aux);
                pos++;
            }
            br.close();
            //algoritmo de Ordenação
            for (int i = 0; i < array.size(); i++) {
                for (int j = i; j < array.size(); j++) {
                    if (array.get(i).getNome().compareToIgnoreCase(array.get(j).getNome()) >= 0) {
                        Funcionario temp = array.get(j);
                        array.set(j, array.get(i));
                        array.set(i, temp);
                    }
                }
            }
            return array;
        } catch (Exception erro) {
            throw erro;
        }
    }
}
