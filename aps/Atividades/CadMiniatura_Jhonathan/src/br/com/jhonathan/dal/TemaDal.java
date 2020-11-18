/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 10/10/2020 20:31:09 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : APS - Arquitetura e Projeto de Software
 *  Aluno      : Jhonathan dos reis
 *  Projeto    : PROJETO CAMADAS
 *  Exercício  : Cadastro de miniaturas
 *  ---------------------------------------------------------------------------------------------------
 *  Propósito do arquivo.
 *  ---------------------------------------------------------------------------------------------------| 
 */
package br.com.jhonathan.dal;

import br.com.jhonathan.model.Tema;
import br.com.jhonathan.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author JHONATHAN
 */

public class TemaDal {

    private Connection conexao;

    public TemaDal() throws Exception{
        conexao = Conexao.getConexao();
    }

    public void addTema(Tema tema) throws Exception{

        String sql = "INSERT INTO temas(tem_nome) VALUES (?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, tema.getTem_nome());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public void deleteTema(int tem_iden) throws SQLException {

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM temas WHERE tem_iden=?");

            preparedStatement.setInt(1, tem_iden);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public void updateTema(Tema tema) throws SQLException {

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE temas SET tem_nome=? WHERE tem_iden = ?");
            preparedStatement.setString(1, tema.getTem_nome());
            preparedStatement.setInt(2, tema.getTem_iden());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw e;
        }
    }

    public ArrayList<Tema> getAllTemas() throws SQLException {

        ArrayList<Tema> temas = new ArrayList<Tema>();

        String sql = "SELECT * FROM temas";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Tema tema = new Tema();
                tema.setTem_iden(rs.getInt("tem_iden"));
                tema.setTem_nome(rs.getString("tem_nome"));
                temas.add(tema);
            }
        } catch (SQLException e) {
            throw e;
        }
        return temas;
    }

    public Tema getTemaById(int tem_iden) throws Exception {
        Tema tema = new Tema();

        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("SELECT * FROM temas WHERE tem_iden=?");
            preparedStatement.setInt(1, tem_iden);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                tema.setTem_iden(rs.getInt("tem_iden"));
                tema.setTem_nome(rs.getString("tem_nome"));
            } else {
                throw new Exception("Nenhum tema com o id " + tem_iden);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return tema;
    }
    
    public Tema getTemaNome(String nome) throws Exception {
        Tema tema = new Tema();

        String sql = "SELECT * FROM temas WHERE tem_nome=?";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                tema.setTem_iden(rs.getInt("tem_iden"));
                tema.setTem_nome(rs.getString("tem_nome"));
            }
        } catch (Exception e) {
            throw e;
        }
        return tema;
    }
}
