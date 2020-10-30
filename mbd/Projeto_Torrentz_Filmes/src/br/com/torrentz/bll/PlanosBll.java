/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 29/10/2020 23:39:20 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : mbd - Modelagem de banco de dados
 *  Aluno      : Jhonathan dos reis
 *  Projeto    : PROJETO CAMADAS
 *  Exercício  : Cadastro de miniaturas
 *  ---------------------------------------------------------------------------------------------------
 *  Propósito do arquivo (Pregu;á náo deicha preencher).
 *  ---------------------------------------------------------------------------------------------------| 
 */


package br.com.torrentz.bll;

import static br.com.torrentz.bll.ValidacoesBll.*;
import br.com.torrentz.dal.PlanosDal;
import br.com.torrentz.model.Planos;
import java.util.ArrayList;

/**
 *
 * @author JHONATHAN
 */
public class PlanosBll {
    
    //TESTE

    private PlanosDal planosdal;
    
    public PlanosBll() throws Exception {
        planosdal = new PlanosDal();
    }
    
    public void Adicionar(Planos planos) throws Exception {
        
        try {
            validarNome(planos.getPla_nome());           
            planosdal.addPlanos(planos);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Já existe um plano com este nome!";
            }
            throw new Exception(mensagem);
        }
    }
    
    public void Alterar(Planos planos) throws Exception {
        
        try {
            validarNome(planos.getPla_nome());
            planosdal.updateCategoria(planos);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Já existe um plano com este nome!";
            }
            throw new Exception(mensagem);
        }
    }
    
    public void Remover(Planos planos) throws Exception {
        
        try {
            planosdal.deletePlanos(planos.getPla_iden());
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("update")) {
                mensagem = "precisa tratar";
            }
            throw new Exception(mensagem);
        }
    }
    
    public ArrayList<Planos> getConsulta() throws Exception {
        
        try {
            
            return planosdal.getAllPlanos();
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("empty")) {
                mensagem = "Não existe nenhum dado nesta consulta!";
            }
            throw new Exception(mensagem);
        }
    }
    
    public Planos getConsultaPorId(int pla_iden) throws Exception {
         try {
            return planosdal.getPlanosById(pla_iden);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("empty")) {
                mensagem = "Não existe nenhum plano cadastrado com este id!";
            }
            throw new Exception(mensagem);
        }
    }
}
