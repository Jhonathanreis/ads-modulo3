/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 11/10/2020 18:08:21 
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

import br.com.jhonathan.model.Fabricante;
import java.sql.PreparedStatement;

import br.com.jhonathan.util.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author JHONATHAN
 */
public class FabricanteDal {

    private Connection conexao;

    public FabricanteDal() throws Exception {
        conexao = Conexao.getConexao();
    }

    public void addFabricante(Fabricante fabricante) throws Exception {
        String sql = "INSERT INTO fabricantes(fab_nome) VALUES(?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, fabricante.getFab_nome());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteFabricante(int fab_iden) throws SQLException {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM fabricantes WHERE fab_iden=?");
            preparedStatement.setInt(1, fab_iden);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void updateFabricante(Fabricante fabricante) throws SQLException {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE fabricantes SET fab_nome=? WHERE fab_iden = ?");
            preparedStatement.setString(1, fabricante.getFab_nome());
            preparedStatement.setInt(2, fabricante.getFab_iden());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public ArrayList<Fabricante> getAllFabricantes() throws SQLException {
        ArrayList<Fabricante> lista = new ArrayList<Fabricante>();
        String sql = "SELECT * FROM fabricantes";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Fabricante fabricante = new Fabricante();
                fabricante.setFab_iden(rs.getInt("fab_iden"));
                fabricante.setFab_nome(rs.getString("fab_nome"));
                lista.add(fabricante);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }

    public Fabricante getFabricanteById(int fab_iden) throws Exception {
        Fabricante fabricante = new Fabricante();
        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("SELECT * FROM fabricantes WHERE fab_iden=?");
            preparedStatement.setInt(1, fab_iden);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                fabricante.setFab_iden(rs.getInt("fab_iden"));
                fabricante.setFab_nome(rs.getString("fab_nome"));
            } else {
                throw new Exception("Nenhum fabricante com o id " + fab_iden);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return fabricante;
    }

    public Fabricante getFabricanteNome(String nome) throws Exception {
        Fabricante fab = new Fabricante();

        String sql = "SELECT * FROM fabricantes WHERE fab_nome=?";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                fab.setFab_iden(rs.getInt("fab_iden"));
                fab.setFab_nome(rs.getString("fab_nome"));
            }
        } catch (Exception e) {
            throw e;
        }
        return fab;
    }
}
