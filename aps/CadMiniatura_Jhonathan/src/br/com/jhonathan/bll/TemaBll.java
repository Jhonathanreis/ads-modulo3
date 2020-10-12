/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 10/10/2020 20:51:27 
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
package br.com.jhonathan.bll;

import br.com.jhonathan.dal.TemaDal;
import br.com.jhonathan.model.Tema;
import static br.com.jhonathan.bll.ValidacoesBll.*;
import java.util.ArrayList;

/**
 *
 * @author JHONATHAN
 */

public class TemaBll {
    
    private TemaDal temaDal;
    
    public TemaBll() throws Exception{
        temaDal = new TemaDal();
    }
    
    public void Adicionar(Tema tema) throws Exception {
        try {
            validarNome(tema.getTem_nome());
            temaDal.addTema(tema);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe um tema com este nome!";
            }
            throw new Exception(mensagem);
        }      
    }
    
    public void Alterar(Tema tema) throws Exception {
        try {
            temaDal.updateTema(tema);
            validarNome(tema.getTem_nome());
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe um tema com este nome!";
            }
            throw new Exception(mensagem);
        }      
    }
    
    public void Remover(Tema tema) throws Exception {
        try {
            temaDal.deleteTema(tema.getTem_iden());

        } catch (Exception e) {       
            throw new Exception(e.getMessage());
        }      
    }
    
    public ArrayList<Tema> getConsulta() throws Exception {
        try {
            return temaDal.getAllTemas();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    
    public Tema getConsultaPorId(int tem_iden) throws Exception{
        try {
            return temaDal.getTemaById(tem_iden);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Tema getTemaNome(String nome) throws Exception {
        try {
            return temaDal.getTemaNome(nome);
        } catch (Exception e) {
            throw e;
        }
    }
}
