/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 10/10/2020 18:42:40 
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
public class TipoMiniatura {
    
    //---ATRIBUTOS---//
    private int tmi_iden = 0;
    private String tmi_tipo = "";

    //---CONSTRUTOR PADRÃO---//
    public TipoMiniatura() {

    }

    //---CONSTRUTOR PASSANDO PARAMETRO---//
    public TipoMiniatura(int tmi_iden, String tmi_tipo) {
        this.tmi_iden = tmi_iden;
        this.tmi_tipo = tmi_tipo;
    }
    
    //---GETERS E SETTERS---//
    public int getTmi_iden() {
        return tmi_iden;
    }

    public void setTmi_iden(int tmi_iden) {
        this.tmi_iden = tmi_iden;
    }

    public String getTmi_tipo() {
        return tmi_tipo;
    }

    public void setTmi_tipo(String tmi_tipo) {
        this.tmi_tipo = tmi_tipo;
    }
}
