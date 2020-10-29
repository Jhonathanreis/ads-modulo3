/*
 *  --------------------------------------------------------------------------------------------------->
 *  Licensa    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 27/10/2020 22:49:28 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : mbd - Modelagem de banco de dados
 *  Aluno      : Jhonathan dos reis
 *  Projeto    : PROJETO CAMADAS
 *  Exercício  : Cadastro de miniaturas
 *  ----------------------------------------------------------------------------------------------------
 *  Propósito do arquivo (Pregu;á náo deicha preencher).
 *  ---------------------------------------------------------------------------------------------------| 
 */
package br.com.torrentz.model;

import java.sql.Date;

/**
 *
 * @author JHONATHAN
 */
public class Cupons {
    
    //---ATRIBUTOS---//
    private int cup_iden = 0;
    private int cup_porcentagem = 0;
    private Date cup_data_geracao;
    
    //---CONSTRUTOR PADRÃO---//
    public Cupons() {
        
    }
    
    //---CONSTRUTOR PASSANDO PARAMETRO---//
    public Cupons(int cup_iden, int cup_porcentagem, Date cup_data_geracao) {
        this.cup_iden = cup_iden;
        this.cup_porcentagem = cup_porcentagem;
        this.cup_data_geracao = cup_data_geracao;
    }
    
    //---GETERS E SETTERS---//
    public int getCup_iden() {
        return cup_iden;
    }

    public void setCup_iden(int cup_iden) {
        this.cup_iden = cup_iden;
    }

    public int getCup_porcentagem() {
        return cup_porcentagem;
    }

    public void setCup_porcentagem(int cup_porcentagem) {
        this.cup_porcentagem = cup_porcentagem;
    }

    public Date getCup_data_geracao() {
        return cup_data_geracao;
    }

    public void setCup_data_geracao(Date cup_data_geracao) {
        this.cup_data_geracao = cup_data_geracao;
    }    
}
