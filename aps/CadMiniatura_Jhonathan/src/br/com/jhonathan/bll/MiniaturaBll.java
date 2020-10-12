/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 11/10/2020 23:19:01 
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

import static br.com.jhonathan.bll.ValidacoesBll.validarNome;
import br.com.jhonathan.dal.MiniaturaDal;
import br.com.jhonathan.model.Miniatura;
import java.util.ArrayList;

/**
 *
 * @author JHONATHAN
 */
public class MiniaturaBll {
    
    private MiniaturaDal miniaturaDal;
    
    public MiniaturaBll() throws Exception {
        miniaturaDal = new MiniaturaDal();
    }
    
    public void Adicionar(Miniatura miniatura) throws Exception {
        try {
            validarNome(miniatura.getMin_modelo());
            miniaturaDal.addMiniatura(miniatura);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe uma miniatura com este nome!";
            }
            throw new Exception(mensagem);
        }
    }
    
    public void Alterar(Miniatura miniatura) throws Exception {
        try {
            validarNome(miniatura.getMin_modelo());
            miniaturaDal.updateMiniatura(miniatura);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe uma miniatura com este nome";
            }
            throw new Exception(mensagem);
        }
    }
    
    public void Remover(Miniatura miniatura) throws Exception {
        try {
            validarNome(miniatura.getMin_modelo());
            miniaturaDal.deleteMiniatura(miniatura.getMin_iden());
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("update")) {
                mensagem = "Existe uma miniatura cadastrada!";
            }
            throw new Exception(mensagem);
        }
    }
    
    public ArrayList<Miniatura> getConsulta() throws Exception {
        try {
            return miniaturaDal.getAllMiniaturas();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    
    public Miniatura getConsultaPorId(int min_iden) throws Exception {
        try {
            return miniaturaDal.getMiniaturaById(min_iden);
            
        } catch (Exception e) {
            throw new Exception(e.getMessage());
            
        }
    }
}
