/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 11/10/2020 12:50:59 
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

import br.com.jhonathan.model.Miniatura;
import br.com.jhonathan.util.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author JHONATHAN
 */
public class MiniaturaDal {

    private Connection conexao;

    public MiniaturaDal() throws Exception{
        conexao = Conexao.getConexao();
    }

    public void addMiniatura(Miniatura miniatura) {

    }

    public void deleteMiniatura(int min_iden) {

    }

    public void updateMiniatura(Miniatura miniatura) {

    }

    public ArrayList<Miniatura> getAllMiniaturas() {
        ArrayList<Miniatura> miniaturas = new ArrayList<Miniatura>();

        String sql = "select * from miniaturas";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Miniatura miniatura = new Miniatura();
                
                miniatura.setMin_iden(rs.getInt("min_iden"));
                miniatura.setMin_modelo(rs.getString("min_modelo"));
                miniatura.setMin_ano(rs.getInt("min_ano"));
                miniatura.setMin_observacoes(rs.getString("min_observações"));
                miniatura.setMin_edicao(rs.getString("min_edicao"));
                miniatura.setMin_escala(rs.getString("min_escala"));
                miniatura.setMin_valor(rs.getInt("min_valor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return miniaturas;
    }

    public Miniatura getMiniaturaById(int min_iden) throws Exception {

        Miniatura miniatura = new Miniatura();

        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from miniatura where min_iden=?");
            preparedStatement.setInt(1, min_iden);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                miniatura.setMin_iden(rs.getInt("min_iden"));
                miniatura.setMin_modelo(rs.getString("min_modelo"));
                miniatura.setMin_ano(rs.getInt("min_ano"));
                miniatura.setMin_observacoes(rs.getString("min_observações"));
                miniatura.setMin_edicao(rs.getString("min_edicao"));
                miniatura.setMin_escala(rs.getString("min_escala"));
                miniatura.setMin_valor(rs.getInt("min_valor"));
            } else {
                throw new Exception("Nenhuma miniatura com o id " + min_iden);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage() + "dal - ");
        }
        return miniatura;
    }
}
