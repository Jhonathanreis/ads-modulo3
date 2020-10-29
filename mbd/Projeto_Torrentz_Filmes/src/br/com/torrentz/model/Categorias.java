/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licen�a    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 27/10/2020  
 *  Institui��o: FACULDADE SENAI FATESG
 *  Curso      : An�lise e Desenvolvimento de sistemas - M�dulo 3 - 2020/2
 *  Disciplina : mbd - Modelagem de banco de dados
 *  Aluno      : Jhonathan dos reis
 *  Projeto    : PROJETO CAMADAS
 *  Exerc�cio  : Cadastro de miniaturas
 *  ---------------------------------------------------------------------------------------------------
 *  Prop�sito do arquivo
 *  ---------------------------------------------------------------------------------------------------| 
 */
package br.com.torrentz.model;

/**
 *
 * @author JHONATHAN
 */

public class Categorias {
    
    //---ATRIBUTOS---//
    private int cat_iden = 0;
    private String cat_nome = "";
    
    //---CONSTRUTOR PADRÃO---//
    public Categorias() {
        
    }
    
    //---CONSTRUTOR PASSANDO PARAMETRO---//
    public Categorias(int cat_iden, String cat_nome) {
        this.cat_iden = cat_iden;
        this.cat_nome = cat_nome;
    }
    
    //---GETERS E SETTERS---//
    public int getCat_iden() {
        return cat_iden;
    }

    public void setCat_iden(int cat_iden) {
        this.cat_iden = cat_iden;
    }

    public String getCat_nome() {
        return cat_nome;
    }

    public void setCat_nome(String cat_nome) {
        this.cat_nome = cat_nome;
    }   
}
