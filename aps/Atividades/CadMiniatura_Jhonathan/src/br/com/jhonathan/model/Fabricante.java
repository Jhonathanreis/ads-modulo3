/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 10/10/2020 18:43:27 
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

package br.com.jhonathan.model;

/**
 *
 * @author JHONATHAN
 */
public class Fabricante {
    
    //---ATRIBUTOS---//
    private int fab_iden = 0;
    private String fab_nome = "";

    //---CONSTRUTOR PADRÃO---//
    public Fabricante() {

    }

    //---CONSTRUTOR PASSANDO PARAMETRO---//
    public Fabricante(int fab_iden, String fab_nome) {
        this.fab_iden = fab_iden;
        this.fab_nome = fab_nome;
    }
    
    //---GETERS E SETTERS---//
    public int getFab_iden() {
        return fab_iden;
    }

    public void setFab_iden(int fab_iden) {
        this.fab_iden = fab_iden;
    }

    public String getFab_nome() {
        return fab_nome;
    }

    public void setFab_nome(String fab_nome) {
        this.fab_nome = fab_nome;
    }
}
