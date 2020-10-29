/*
 *  --------------------------------------------------------------------------------------------------->
 *  Licensa    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 27/10/2020 22:49:49 
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

public class Usuarios {
    
    //---ATRIBUTOS---//
    private int usu_iden = 0;
    private String usu_nome = "";
    private String usu_cpf = "";
    private String usu_email = "";
    private String usu_senha = "";
    private Cupons usu_cup_iden = null;
    
    //---CONSTRUTOR PADRÃO---//

    public Usuarios() {
        
    }
    
    //---CONSTRUTOR PASSANDO PARAMETRO---//
    public Usuarios(int usu_iden, String usu_nome, String usu_cpf, String usu_email, String usu_senha) {
        this.usu_iden = usu_iden;
        this.usu_nome = usu_nome;
        this.usu_cpf = usu_cpf;
        this.usu_email = usu_email;
        this.usu_senha = usu_senha;
    }
    
    //---GETERS E SETTERS---//
    public int getUsu_iden() {
        return usu_iden;
    }

    public void setUsu_iden(int usu_iden) {
        this.usu_iden = usu_iden;
    }

    public String getUsu_nome() {
        return usu_nome;
    }

    public void setUsu_nome(String usu_nome) {
        this.usu_nome = usu_nome;
    }

    public String getUsu_cpf() {
        return usu_cpf;
    }

    public void setUsu_cpf(String usu_cpf) {
        this.usu_cpf = usu_cpf;
    }

    public String getUsu_email() {
        return usu_email;
    }

    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    public String getUsu_senha() {
        return usu_senha;
    }

    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }

    public Cupons getUsu_cup_iden() {
        return usu_cup_iden;
    }

    public void setUsu_cup_iden(Cupons usu_cup_iden) {
        this.usu_cup_iden = usu_cup_iden;
    } 
}
