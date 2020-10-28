/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 10/10/2020 17:50:31 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : APS - Arquitetura e Projeto de Software
 *  Aluno      : Jhonathan dos reis
 *  Projeto    : PROJETO CAMADAS
 *  Exercício  : Cadastro de miniaturas
 *  ---------------------------------------------------------------------------------------------------
 *  Realiza a conexão com o banco de dados.
 *  ---------------------------------------------------------------------------------------------------| 
 */
package br.com.torrentz.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author JHONATHAN Conexão com o banco
 */
public class Conexao {

    private static Connection conexao = null;

    public static Connection getConexao() throws Exception{
        try {
            String driver = "org.postgresql.Driver";
            String url = "jdbc:postgresql://debian:5432/torrentz_filmes";
            String user = "postgres";
            String password = "1234";

            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
        } catch(Exception e) {
            throw e;
        }
        return conexao;
    }
}
