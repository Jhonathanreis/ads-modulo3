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

import br.com.jhonathan.model.Fabricante;
import br.com.jhonathan.model.Miniatura;
import br.com.jhonathan.model.Tema;
import br.com.jhonathan.model.TipoMiniatura;
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

    public void addMiniatura(Miniatura miniatura) throws Exception {
        String sql = "INSERT INTO miniaturas(min_modelo, "
                    + "min_ano, min_observacoes, min_edicao, min_escala, min_valor, min_fab_iden, min_tmi_iden, min_tem_iden) VALUES (?,?,?,?,?,?,?,?,?)";
        try {  
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);    
            preparedStatement.setString(1, miniatura.getMin_modelo());
            preparedStatement.setInt(2, miniatura.getMin_ano());
            preparedStatement.setString(3, miniatura.getMin_observacoes());
            preparedStatement.setString(4, miniatura.getMin_edicao());
            preparedStatement.setString(5, miniatura.getMin_escala());
            preparedStatement.setInt(6, miniatura.getMin_valor());      
            preparedStatement.setInt(7, miniatura.getFabricante().getFab_iden());      
            preparedStatement.setInt(8, miniatura.getTipoDeMiniatura().getTmi_iden());      
            preparedStatement.setInt(9, miniatura.getTema().getTem_iden());      
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteMiniatura(int min_iden) throws SQLException {
        try {
            PreparedStatement preparedStatement = conexao.prepareStatement("DELETE FROM miniaturas WHERE min_iden=?");
            preparedStatement.setInt(1, min_iden);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void updateMiniatura(Miniatura miniatura) throws SQLException {
        PreparedStatement preparedStatement = conexao.prepareStatement("UPDATE miniaturas SET min_iden=?, min_modelo=?,"
                    + " min_ano=?, min_obervacoes=?, min_edicao=?, min_escala=?, min_valor=? min_fab_iden=?, min_tmi_iden=?, min_tem_iden=? WHERE min_iden=?");
        try {
            preparedStatement.setString(1, miniatura.getMin_modelo());
            preparedStatement.setInt(2, miniatura.getMin_ano());
            preparedStatement.setString(3, miniatura.getMin_observacoes());
            preparedStatement.setString(4, miniatura.getMin_edicao());
            preparedStatement.setString(5, miniatura.getMin_escala());
            preparedStatement.setInt(6, miniatura.getMin_valor());
            preparedStatement.setInt(7, miniatura.getFabricante().getFab_iden());      
            preparedStatement.setInt(8, miniatura.getTipoDeMiniatura().getTmi_iden());      
            preparedStatement.setInt(9, miniatura.getTema().getTem_iden());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    public ArrayList<Miniatura> getAllMiniaturas() throws SQLException, Exception {
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
                miniatura.setMin_observacoes(rs.getString("min_observacoes"));
                miniatura.setMin_edicao(rs.getString("min_edicao"));
                miniatura.setMin_escala(rs.getString("min_escala"));
                miniatura.setMin_valor(rs.getInt("min_valor"));
                
                //Utilizando chave estrangeira!!! Estudar para aplicação no netbeans
                int min_fab_iden = rs.getInt("min_fab_iden");
                int min_tmi_iden = rs.getInt("min_tmi_iden");
                int min_tem_iden = rs.getInt("min_tem_iden");
                FabricanteDal fdal = new FabricanteDal();
                TipoMiniaturaDal tipoDal = new TipoMiniaturaDal();
                TemaDal tdal = new TemaDal();
                Fabricante objetoFabricante = fdal.getFabricanteById(min_fab_iden);
                TipoMiniatura objetoTipoMiniatura = tipoDal.getTipoMiniaturaById(min_tmi_iden);
                Tema objetoTema  = tdal.getTemaById(min_tem_iden);              
                miniatura.setFabricante(objetoFabricante);
                miniatura.setTipoDeMiniatura(objetoTipoMiniatura);
                miniatura.setTema(objetoTema);
                miniaturas.add(miniatura);
            }
        } catch (SQLException e) {
            throw e;
        }
        return miniaturas;
    }

    public Miniatura getMiniaturaById(int min_iden) throws Exception {

        Miniatura miniatura = new Miniatura();

        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from miniaturas where min_iden=?");
            preparedStatement.setInt(1, min_iden);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()) {
                miniatura.setMin_iden(rs.getInt("min_iden"));
                miniatura.setMin_modelo(rs.getString("min_modelo"));
                miniatura.setMin_ano(rs.getInt("min_ano"));
                miniatura.setMin_observacoes(rs.getString("min_observacoes"));
                miniatura.setMin_edicao(rs.getString("min_edicao"));
                miniatura.setMin_escala(rs.getString("min_escala"));
                miniatura.setMin_valor(rs.getInt("min_valor"));
                int min_fab_iden = rs.getInt("min_fab_iden");
                int min_tmi_iden = rs.getInt("min_tmi_iden");
                int min_tem_iden = rs.getInt("min_tem_iden");
                FabricanteDal fdal = new FabricanteDal();
                TipoMiniaturaDal tipoDal = new TipoMiniaturaDal();
                TemaDal tdal = new TemaDal();
                Fabricante objetoFabricante = fdal.getFabricanteById(min_fab_iden);
                TipoMiniatura objetoTipoMiniatura = tipoDal.getTipoMiniaturaById(min_tmi_iden);
                Tema objetoTema  = tdal.getTemaById(min_tem_iden);              
                miniatura.setFabricante(objetoFabricante);
                miniatura.setTipoDeMiniatura(objetoTipoMiniatura);
                miniatura.setTema(objetoTema);
                
            } else {
                throw new Exception("Nenhuma miniatura com o id ");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return miniatura;
    }
}
