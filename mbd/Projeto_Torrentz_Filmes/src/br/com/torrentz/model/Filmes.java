/*
 *  --------------------------------------------------------------------------------------------------->
 *  Licensa    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 27/10/2020 22:49:35 
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

/**
 *
 * @author JHONATHAN
 */

public class Filmes {
    
    //---ATRIBUTOS---//
    private int fil_iden = 0;
    private String fil_sinopse = "";
    private String fil_titulo = "";
    private int fil_ano = 0;
    private Categorias fil_cat_iden = null;
    
    
    //---CONSTRUTOR PADRÃO---//
    public Filmes() {
        
    }
    
    //---CONSTRUTOR PASSANDO PARAMETRO---//
    public Filmes(int fil_iden, String fil_sinopse, String fil_titulo, int fil_ano) {
        this.fil_iden = fil_iden;
        this.fil_sinopse = fil_sinopse;
        this.fil_titulo = fil_titulo;
        this.fil_ano = fil_ano;
    }
    
    //---GETERS E SETTERS---//
    public int getFil_iden() {
        return fil_iden;
    }

    public void setFil_iden(int fil_iden) {
        this.fil_iden = fil_iden;
    }

    public String getFil_sinopse() {
        return fil_sinopse;
    }

    public void setFil_sinopse(String fil_sinopse) {
        this.fil_sinopse = fil_sinopse;
    }

    public String getFil_titulo() {
        return fil_titulo;
    }

    public void setFil_titulo(String fil_titulo) {
        this.fil_titulo = fil_titulo;
    }

    public int getFil_ano() {
        return fil_ano;
    }

    public void setFil_ano(int fil_ano) {
        this.fil_ano = fil_ano;
    }

    public Categorias getFil_cat_iden() {
        return fil_cat_iden;
    }

    public void setFil_cat_iden(Categorias fil_cat_iden) {
        this.fil_cat_iden = fil_cat_iden;
    }   
}
