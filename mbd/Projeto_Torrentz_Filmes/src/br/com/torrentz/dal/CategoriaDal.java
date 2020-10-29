/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 29/10/2020 00:23:53 
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

import br.com.torrentz.model.Categorias;
import java.sql.Connection;
import java.sql.SQLException;
import br.com.torrentz.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JHONATHAN
 */
public class CategoriaDal {

    private Connection conexao;

    public CategoriaDal() throws Exception {
        conexao = Conexao.getConexao();
    }

    public void addCategoria(Categorias categoria) throws SQLException {

        String sql = "INSERT INTO categorias(cat_nome) VALUES(?)";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, categoria.getCat_nome());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir uma categoria", "Menssagem", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteCategoria(int cat_iden) throws SQLException {

        String sql = "DELETE FROM categorias WHERE cat_iden =?";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, cat_iden);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar a categoria", "Menssagem", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateCategoria(Categorias categoria) throws SQLException {
        
        String sql = "UPDATE categorias SET cat_nome=? WHERE cat_iden=?";
        
        try {           
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, categoria.getCat_nome());
            preparedStatement.setInt(2, categoria.getCat_iden());
            preparedStatement.executeUpdate();           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar a categoria", "Menssagem", JOptionPane.ERROR_MESSAGE);
        }     
    }
    
    public ArrayList<Categorias> getAllCategorias() throws SQLException {
        ArrayList<Categorias> lista = new ArrayList<Categorias>();
        String sql = "SELECT * FROM categorias";      
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
                Categorias categorias = new Categorias();
                categorias.setCat_nome(rs.getString("cat_nome"));
                categorias.setCat_iden(rs.getInt("cat_iden"));
                lista.add(categorias);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
    
    public Categorias getCategoriasById(int cat_iden) throws Exception {
        Categorias categoria = new Categorias();
        
        String sql = "SELECT * FROM categorias WHERE cat_iden=?";
        
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                categoria.setCat_iden(rs.getInt("cat_iden"));
                categoria.setCat_nome(rs.getString("cat_nome"));
            } else {
                throw new Exception("Nenhuma categoria com o id " + cat_iden);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return categoria;
    }   
}