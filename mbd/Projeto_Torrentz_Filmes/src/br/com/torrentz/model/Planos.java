/*
 *  --------------------------------------------------------------------------------------------------->
 *  Licensa    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 27/10/2020 22:49:41 
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
public class Planos {
   
    //---ATRIBUTOS---//
    private int pla_iden = 0;
    private int pla_acesso_simultaneo = 0;
    private String pla_nome = "";
    private float pla_preco = 0;
    
    //---CONSTRUTOR PADRÃO---//
    public Planos() {
        
    }
    
    //---CONSTRUTOR PASSANDO PARAMETRO---//
    public Planos(int pla_iden, int pla_acesso_simultaneo, String pla_nome, float pla_preco) {
        this.pla_iden = pla_iden;
        this.pla_acesso_simultaneo = pla_acesso_simultaneo;
        this.pla_nome = pla_nome;
        this.pla_preco = pla_preco;
    }
    
    //---GETERS E SETTERS---//
    public int getPla_iden() {
        return pla_iden;
    }

    public void setPla_iden(int pla_iden) {
        this.pla_iden = pla_iden;
    }

    public int getPla_acesso_simultaneo() {
        return pla_acesso_simultaneo;
    }

    public void setPla_acesso_simultaneo(int pla_acesso_simultaneo) {
        this.pla_acesso_simultaneo = pla_acesso_simultaneo;
    }

    public String getPla_nome() {
        return pla_nome;
    }

    public void setPla_nome(String pla_nome) {
        this.pla_nome = pla_nome;
    }

    public float getPla_preco() {
        return pla_preco;
    }

    public void setPla_preco(float pla_preco) {
        this.pla_preco = pla_preco;
    }
}
