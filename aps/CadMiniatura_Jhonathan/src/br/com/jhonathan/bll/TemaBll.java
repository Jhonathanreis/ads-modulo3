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
import java.util.ArrayList;

/**
 *
 * @author JHONATHAN
 */

public class TemaBll {
    
    private TemaDal temaDal;
    
    public TemaBll() {
        temaDal = new TemaDal();
    }
    
    public void Adicionar(Tema tema) throws Exception {
        temaDal.addTema(tema);
    }
    
    public void Alterar(Tema tema) throws Exception {
        temaDal.updateTema(tema);
    }
    
    public void Remover(Tema tema) throws Exception {
        temaDal.deleteTema(tema.getTem_iden());
    }
    
    public ArrayList<Tema> getConsulta() {
        return temaDal.getAllTemas();
    }
    
    public Tema getConsultaPorId(int tem_iden) throws Exception {
        return temaDal.getTemaById(tem_iden);
    }
}
