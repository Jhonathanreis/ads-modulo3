/*
 *  --------------------------------------------------------------------------------------------------->
 *  Licensa    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 27/10/2020 22:49:59 
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

import java.sql.Date;

/**
 *
 * @author JHONATHAN
 */
public class Visualizados {
    
    //---ATRIBUTOS---//
    private int vis_iden = 0;
    private boolean vis_completo = false;
    private Date vis_data_geracao;
    private Usuarios vis_usu_iden = null;
    private Filmes vis_fil_iden = null;
    
    //---CONSTRUTOR PADRÃO---//
    public Visualizados() {
        
    }
    
    //---CONSTRUTOR PASSANDO PARAMETRO---//
    public Visualizados(int vis_iden, boolean vis_completo, Date vis_data_geracao) {
        this.vis_iden = vis_iden;
        this.vis_completo =vis_completo;
        this.vis_data_geracao =  vis_data_geracao;
    }
    
    //---GETERS E SETTERS---//
    public int getVis_iden() {
        return vis_iden;
    }

    public void setVis_iden(int vis_iden) {
        this.vis_iden = vis_iden;
    }

    public boolean isVis_completo() {
        return vis_completo;
    }

    public void setVis_completo(boolean vis_completo) {
        this.vis_completo = vis_completo;
    }

    public Date getVis_data_geracao() {
        return vis_data_geracao;
    }

    public void setVis_data_geracao(Date vis_data_geracao) {
        this.vis_data_geracao = vis_data_geracao;
    }

    public Usuarios getVis_usu_iden() {
        return vis_usu_iden;
    }

    public void setVis_usu_iden(Usuarios vis_usu_iden) {
        this.vis_usu_iden = vis_usu_iden;
    }

    public Filmes getVis_fil_iden() {
        return vis_fil_iden;
    }

    public void setVis_fil_iden(Filmes vis_fil_iden) {
        this.vis_fil_iden = vis_fil_iden;
    }
}
