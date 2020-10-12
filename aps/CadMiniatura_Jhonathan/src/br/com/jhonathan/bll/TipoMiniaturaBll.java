/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 11/10/2020 22:22:52 
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

import br.com.jhonathan.dal.TipoMiniaturaDal;
import br.com.jhonathan.model.TipoMiniatura;
import static br.com.jhonathan.bll.ValidacoesBll.*;
import java.util.ArrayList;

/**
 *
 * @author JHONATHAN
 */
public class TipoMiniaturaBll {

    private TipoMiniaturaDal miniaturaDal;

    public TipoMiniaturaBll() throws Exception {
        miniaturaDal = new TipoMiniaturaDal();
    }

    public void Adicionar(TipoMiniatura miniatura) throws Exception {
        try {
            validarNome(miniatura.getTmi_tipo());
            miniaturaDal.addTipoMiniatura(miniatura);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe uma miniatura com este tipo!";
            }
            throw new Exception(mensagem);
        }
    }

    public void Alterar(TipoMiniatura miniatura) throws Exception {
        try {
            validarNome(miniatura.getTmi_tipo());
            miniaturaDal.updateTipoMiniatura(miniatura);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe uma miniatura com este tipo";
            }
            throw new Exception(mensagem);
        }
    }

    public void Remover(TipoMiniatura miniatura) throws Exception {
        try {
            validarNome(miniatura.getTmi_tipo());
            miniaturaDal.deleteTipoMiniatura(miniatura);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("update")) {
                mensagem = "Existe um fabricante com esta miniatura cadastrada!";
            }
            throw new Exception(mensagem);
        }
    }

    public ArrayList<TipoMiniatura> getConsulta() throws Exception {
        try {
            return miniaturaDal.getAllTipoMiniaturas();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public TipoMiniatura getConsultaPorId(int tmi_iden) throws Exception {
        try {
            return miniaturaDal.getTipoMiniaturaById(tmi_iden);

        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    public TipoMiniatura getTipoMiniaturaNome(String nome) throws Exception {
        try {
            return miniaturaDal.getTipoMiniaturaNome(nome);
        } catch (Exception e) {
            throw e;
        }
    }
}
