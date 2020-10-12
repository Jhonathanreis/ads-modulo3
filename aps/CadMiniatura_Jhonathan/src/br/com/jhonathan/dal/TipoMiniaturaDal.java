/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 11/10/2020 21:48:16 
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

import br.com.jhonathan.model.TipoMiniatura;
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
public class TipoMiniaturaDal {
    
    private Connection conexao;
    
    public TipoMiniaturaDal() throws Exception {
        conexao = Conexao.getConexao();
    }
    
    public void addTipoMiniatura(TipoMiniatura tipoMiniatura) throws Exception {
        String sql = "INSERT INTO tipo_miniaturas(tmi_tipo) VALUES(?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, tipoMiniatura.getTmi_tipo());            
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }
    
    public void deleteTipoMiniatura(TipoMiniatura tipoMiniatura) throws SQLException {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM tipo_miniaturas WHERE tmi_iden=?");
            preparedStatement.setInt(1, tipoMiniatura.getTmi_iden());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public void updateTipoMiniatura(TipoMiniatura tipoMiniatura) throws SQLException {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE tipo_miniaturas SET tmi_tipo=? WHERE tmi_iden = ?");
            preparedStatement.setString(1, tipoMiniatura.getTmi_tipo());
            preparedStatement.setInt(2, tipoMiniatura.getTmi_iden());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public ArrayList<TipoMiniatura> getAllTipoMiniaturas() throws SQLException {
        ArrayList<TipoMiniatura> lista = new ArrayList<TipoMiniatura>();
        String sql = "SELECT * FROM tipo_miniaturas";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                TipoMiniatura miniatura = new TipoMiniatura();
                miniatura.setTmi_iden(rs.getInt("tmi_iden"));
                miniatura.setTmi_tipo(rs.getString("tmi_tipo"));
                lista.add(miniatura);
            }
        } catch (SQLException e) {
            throw e;
        }
        return lista;
    }
    
    public TipoMiniatura getTipoMiniaturaById(int tmi_iden) throws Exception {
        TipoMiniatura miniatura = new TipoMiniatura();
        try {  
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("SELECT * FROM tipo_miniatura WHERE tmi_iden=?");
            preparedStatement.setInt(1, tmi_iden);
            ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
                miniatura.setTmi_iden(rs.getInt("tmi_iden"));
                miniatura.setTmi_tipo(rs.getString("tmi_tipo"));
            } else {
                throw new Exception("Nenhum tipo de miniatura com o id ");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return miniatura;
    }
    
    public TipoMiniatura getTipoMiniaturaNome(String nome) throws Exception {
        TipoMiniatura tipo = new TipoMiniatura();

        String sql = "SELECT * FROM tipo_miniaturas WHERE tmi_tipo=?";

        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                tipo.setTmi_iden(rs.getInt("tmi_iden"));
                tipo.setTmi_tipo(rs.getString("tmi_tipo"));
            }
        } catch (Exception e) {
            throw e;
        }
        return tipo;
    }
}
