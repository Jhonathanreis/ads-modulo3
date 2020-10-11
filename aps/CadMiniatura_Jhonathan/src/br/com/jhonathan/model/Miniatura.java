/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 10/10/2020 19:23:13 
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

import java.util.ArrayList;

/**
 *
 * @author JHONATHAN
 */
public class Miniatura {

    //---ATRIBUTOS---//
    private int min_iden = 0;
    private String min_modelo = "";
    private int min_ano = 0;
    private String min_observacoes = "";
    private String min_edicao = "";
    private String min_escala = "";
    private int min_valor = 0;
    private Fabricante fabricante = null;
    private TipoMiniatura tipoDeMiniatura = null;
    private Tema tema = null;
    private ArrayList<Foto> fotos = new ArrayList<>();
    
    

    //---CONSTRUTOR PADRÃO---//
    public Miniatura() {

    }

    //---CONSTRUTOR PASSANDO PARAMETRO---//
    public Miniatura(int min_iden, String min_modelo,
            int min_ano, String min_observacoes, String min_edicao, String min_escala, int min_valor) {
        this.min_iden = min_iden;
        this.min_modelo = min_modelo;
        this.min_ano = min_ano;
        this.min_observacoes = min_observacoes;
        this.min_edicao = min_edicao;
        this.min_escala = min_escala;
        this.min_valor = min_valor;
    }

    //---GETERS E SETTERS---//
    public int getMin_iden() {
        return min_iden;
    }

    public void setMin_iden(int min_iden) {
        this.min_iden = min_iden;
    }

    public String getMin_modelo() {
        return min_modelo;
    }

    public void setMin_modelo(String min_modelo) {
        this.min_modelo = min_modelo;
    }

    public int getMin_ano() {
        return min_ano;
    }

    public void setMin_ano(int min_ano) {
        this.min_ano = min_ano;
    }

    public String getMin_observacoes() {
        return min_observacoes;
    }

    public void setMin_observacoes(String min_observacoes) {
        this.min_observacoes = min_observacoes;
    }

    public String getMin_edicao() {
        return min_edicao;
    }

    public void setMin_edicao(String min_edicao) {
        this.min_edicao = min_edicao;
    }

    public String getMin_escala() {
        return min_escala;
    }

    public void setMin_escala(String min_escala) {
        this.min_escala = min_escala;
    }

    public int getMin_valor() {
        return min_valor;
    }

    public void setMin_valor(int min_valor) {
        this.min_valor = min_valor;
    }
}
