/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 12/10/2020 13:17:29 
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

import br.com.jhonathan.dal.FotoDal;
import br.com.jhonathan.model.Foto;
import java.util.ArrayList;

/**
 *
 * @author JHONATHAN
 */
public class FotoBll {

    private FotoDal fotoDal;

    public FotoBll() throws Exception {
        fotoDal = new FotoDal();
    }

    public void Adicionar(Foto foto) throws Exception {
        try {
            fotoDal.addFoto(foto);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe uma miniatura com este nome!";
            }
            throw new Exception(mensagem);
        }
    }

    public void Alterar(Foto foto) throws Exception {
        try {
            fotoDal.updateFoto(foto);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe uma miniatura com este nome";
            }
            throw new Exception(mensagem);
        }
    }

    public void Remover(Foto foto) throws Exception {
        try {
            fotoDal.deleteFoto(foto.getFot_iden());
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("update")) {
                mensagem = "Existe uma miniatura cadastrada!";
            }
            throw new Exception(mensagem);
        }
    }

    public ArrayList<Foto> getConsulta() throws Exception {
        try {
            return fotoDal.getAllFotos();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Foto getConsultaPorId(int fot_iden) throws Exception {
        try {
            return fotoDal.getFotoById(fot_iden);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public ArrayList<Foto> getFotos(int fot_min_iden) throws Exception {
        return fotoDal.getFotos(fot_min_iden);
    }
}
