/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 10/10/2020 19:58:02 
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

public class Foto {
    
    //---ATRIBUTOS---//
    private int fot_iden = 0;
    private String fot_caminho = "";
    private String fot_descricao = "";
    private int fot_min_iden = 0;
   

    //---CONSTRUTOR PADRÃO---//
    public Foto() {

    }

    //---CONSTRUTOR PASSANDO PARAMETRO---//
    public Foto(int fot_iden, String fot_caminho, String fot_descricao, int fot_min_iden) {
        this.fot_iden = fot_iden;
        this.fot_caminho = fot_caminho;
        this.fot_descricao = fot_descricao;
        this.fot_min_iden = fot_min_iden;
    }
    
    //---GETERS E SETTERS---//
    public int getFot_iden() {
        return fot_iden;
    }

    public void setFot_iden(int fot_iden) {
        this.fot_iden = fot_iden;
    }

    public String getFot_caminho() {
        return fot_caminho;
    }

    public void setFot_caminho(String fot_caminho) {
        this.fot_caminho = fot_caminho;
    }

    public String getFot_descricao() {
        return fot_descricao;
    }

    public void setFot_descricao(String fot_descricao) {
        this.fot_descricao = fot_descricao;
    }   

    public int getFot_min_iden() {
        return fot_min_iden;
    }

    public void setFot_min_iden(int fot_min_iden) {
        this.fot_min_iden = fot_min_iden;
    }
}
