/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 29/10/2020 23:02:20 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : mbd - Modelagem de banco de dados
 *  Aluno      : Jhonathan dos reis
 *  Projeto    : PROJETO CAMADAS
 *  Exercício  : Cadastro de miniaturas
 *  ---------------------------------------------------------------------------------------------------
 *  Propósito do arquivo (Pregu;á náo deicha preencher).
 *  ---------------------------------------------------------------------------------------------------| 
 */
package br.com.torrentz.dal;

import br.com.torrentz.model.Planos;
import java.sql.Connection;
import br.com.torrentz.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author JHONATHAN
 */
public class PlanosDal {

    private Connection conexao;

    public PlanosDal() throws Exception {
        conexao = Conexao.getConexao();
    }

    public void addPlanos(Planos planos) throws Exception {

        String sql = "INSERT INTO planos(pla_acesso_simultaneo, pla_nome, pla_preco) VALUES(?,?,?)";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, planos.getPla_acesso_simultaneo());
            preparedStatement.setString(2, planos.getPla_nome());
            preparedStatement.setFloat(3, planos.getPla_preco());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public void deletePlanos(int pla_iden) throws Exception {

        String sql = "DELETE FROM planos WHERE cat_iden =?";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, pla_iden);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateCategoria(Planos planos) throws Exception {

        String sql = "UPDATE planos SET pla_acesso_simultaneo=?, pla_nome=?, pla_preco=? WHERE pla_iden=?";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, planos.getPla_acesso_simultaneo());
            preparedStatement.setString(2, planos.getPla_nome());
            preparedStatement.setFloat(3, planos.getPla_preco());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Planos> getAllPlanos() throws Exception {

        ArrayList<Planos> lista = new ArrayList<Planos>();
        String sql = "SELECT * FROM planos";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Planos planos = new Planos();                
                planos.setPla_iden(rs.getInt("pla_iden"));
                planos.setPla_acesso_simultaneo(rs.getInt("pla_acesso_simultaneo"));
                planos.setPla_nome(rs.getString("pla_nome"));
                planos.setPla_preco(rs.getFloat("pla_preco"));
                lista.add(planos);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public Planos getPlanosById(int pla_iden) throws Exception {

        Planos planos = new Planos();

        String sql = "SELECT * FROM planos WHERE pla_iden=?";

        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                planos.setPla_acesso_simultaneo(rs.getInt("pla_acesso_simultaneo"));
                planos.setPla_nome(rs.getString("pla_nome"));
                planos.setPla_preco(rs.getFloat("pla_preco"));

            } else {
                throw new Exception("Nenhuma categoria com o id ");
            }
        } catch (Exception e) {
            throw e;
        }
        return planos;
    }
}
