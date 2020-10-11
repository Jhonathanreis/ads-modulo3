/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 10/10/2020 18:40:07 
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
public class Tema {
    
    //---ATRIBUTOS---//
    private int tem_iden = 0;
    private String tem_nome = "";

    //---CONSTRUTOR PADRÃO---//
    public Tema() {

    }

    //---CONSTRUTOR PASSANDO PARAMETRO---//
    public Tema(int tem_iden, String tem_nome) {
        this.tem_iden = tem_iden;
        this.tem_nome = tem_nome;
    }
    
    //---GETERS E SETTERS---//
    public int getTem_iden() {
        return tem_iden;
    }

    public void setTem_iden(int tem_iden) {
        this.tem_iden = tem_iden;
    }

    public String getTem_nome() {
        return tem_nome;
    }

    public void setTem_nome(String tem_nome) {
        this.tem_nome = tem_nome;
    }
}
