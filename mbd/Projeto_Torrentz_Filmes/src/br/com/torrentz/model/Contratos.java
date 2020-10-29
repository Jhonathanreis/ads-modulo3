/*
 *  --------------------------------------------------------------------------------------------------->
 *  Licensa    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 27/10/2020 22:48:36 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : mbd - Modelagem de banco de dados
 *  Aluno      : Jhonathan dos reis
 *  Projeto    : PROJETO CAMADAS
 *  Exercício  : Cadastro de miniaturas
 *  ----------------------------------------------------------------------------------------------------
 *  Proposito do arquivo Realizar a criação de contratos
 *  ---------------------------------------------------------------------------------------------------| 
 */
package br.com.torrentz.model;

import java.sql.Date;

/**
 *
 * @author JHONATHAN
 */

public class Contratos {

    //---ATRIBUTOS---//
    private int con_iden = 0;
    private char con_status;
    private Date con_inicio = null;
    private Date con_fim = null;
    private Usuarios con_usu_iden = null;
    private Planos con_pla_iden = null;

    //---CONSTRUTOR PADRÃO---//
    public Contratos() {

    }
    
    //---CONSTRUTOR PASSANDO PARAMETRO---//
    public Contratos(int con_iden, char con_status, Date con_inicio, Date con_fim) {
        this.con_iden = con_iden;
        this.con_status = con_status;
        this.con_fim = con_fim;
    }
    
    //---GETERS E SETTERS---//
    public int getCon_iden() {
        return con_iden;
    }

    public void setCon_iden(int con_iden) {
        this.con_iden = con_iden;
    }

    public char getCon_status() {
        return con_status;
    }

    public void setCon_status(char con_status) {
        this.con_status = con_status;
    }

    public Date getCon_inicio() {
        return con_inicio;
    }

    public void setCon_inicio(Date con_inicio) {
        this.con_inicio = con_inicio;
    }

    public Date getCon_fim() {
        return con_fim;
    }

    public void setCon_fim(Date con_fim) {
        this.con_fim = con_fim;
    }

    public Usuarios getCon_usu_iden() {
        return con_usu_iden;
    }

    public void setCon_usu_iden(Usuarios con_usu_iden) {
        this.con_usu_iden = con_usu_iden;
    }

    public Planos getCon_pla_iden() {
        return con_pla_iden;
    }

    public void setCon_pla_iden(Planos con_pla_iden) {
        this.con_pla_iden = con_pla_iden;
    }  
}
