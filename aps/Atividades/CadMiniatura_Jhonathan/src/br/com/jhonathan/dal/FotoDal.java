/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 12/10/2020 12:39:45 
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

import br.com.jhonathan.model.Foto;
import br.com.jhonathan.model.Miniatura;
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
public class FotoDal {

    private Connection conexao;

    public FotoDal() throws Exception {
        conexao = Conexao.getConexao();
    }

    public void addFoto(Foto foto) throws Exception {
        String sql = "INSERT INTO fotos(fot_caminho, fot_descricao, fot_min_iden) VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, foto.getFot_caminho());
            preparedStatement.setString(2, foto.getFot_descricao());
            preparedStatement.setInt(3, foto.getMiniatura().getMin_iden());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteFoto(int fot_iden) throws SQLException {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM fotos WHERE fot_iden=?");
            preparedStatement.setInt(1, fot_iden);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void updateFoto(Foto foto) throws SQLException {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE fotos SET fot_caminho=?, fot_descricao=?, fot_min_iden=? WHERE fot_iden = ?");
            preparedStatement.setString(1, foto.getFot_caminho());
            preparedStatement.setString(2, foto.getFot_descricao());
            preparedStatement.setInt(3, foto.getMiniatura().getMin_iden());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public ArrayList<Foto> getAllFotos() throws SQLException, Exception {
        ArrayList<Foto> fotos = new ArrayList<Foto>();

        String sql = "select * from fotos";
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Foto foto = new Foto();
                foto.setFot_iden(rs.getInt("fot_iden"));
                foto.setFot_caminho(rs.getString("fot_caminho"));
                foto.setFot_descricao(rs.getString("fot_descricao"));
                int fot_min_iden = rs.getInt("fot_min_iden");
                MiniaturaDal mdal = new MiniaturaDal();
                Miniatura objetoMiniatura = mdal.getMiniaturaById(fot_min_iden);
                foto.setMiniatura(objetoMiniatura);
                fotos.add(foto);
            }
        } catch (SQLException e) {
            throw e;
        }
        return fotos;
    }

    public Foto getFotoById(int fot_iden) throws Exception {
        Foto foto = new Foto();

        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from fotos where fot_iden=?");
            preparedStatement.setInt(1, fot_iden);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                foto.setFot_iden(rs.getInt("fot_iden"));
                foto.setFot_caminho(rs.getString("fot_caminho"));
                foto.setFot_descricao(rs.getString("fot_descricao"));
                int fot_min_iden = rs.getInt("fot_min_iden");
                MiniaturaDal mdal = new MiniaturaDal();
                Miniatura objetoMiniatura = mdal.getMiniaturaById(fot_min_iden);
                foto.setMiniatura(objetoMiniatura);
            } else {
                throw new Exception("Nenhuma miniatura com o id ");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return foto;
    }

    /**
     * Consulta todas as fotos de uma miniatura
     * @param fot_min_iden id da miniatura
     * @return ArrayList
     * @throws Exception 
     */
    public ArrayList<Foto> getFotos(int fot_min_iden) throws Exception {
        
        
        ArrayList<Foto> fotos = new ArrayList<Foto>();

        try {

            String sql = "select * from fotos WHERE fot_min_iden = ?";
            PreparedStatement preparedStatement = conexao.
                    prepareStatement(sql);
            preparedStatement.setInt(1, fot_min_iden);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Foto foto = new Foto();
                foto.setFot_iden(rs.getInt("fot_iden"));
                foto.setFot_caminho(rs.getString("fot_caminho"));
                foto.setFot_descricao(rs.getString("fot_descricao"));
                MiniaturaDal mdal = new MiniaturaDal();
                Miniatura objetoMiniatura = mdal.getMiniaturaById(fot_min_iden);
                foto.setMiniatura(objetoMiniatura);
                fotos.add(foto);
            }
        } catch (SQLException e) {
            throw e;
        }
        return fotos;
    }
}
