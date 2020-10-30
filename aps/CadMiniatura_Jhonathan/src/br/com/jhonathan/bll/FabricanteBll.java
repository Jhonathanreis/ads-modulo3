/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 11/10/2020 18:52:55 
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

import br.com.jhonathan.dal.FabricanteDal;
import br.com.jhonathan.model.Fabricante;
import static br.com.jhonathan.bll.ValidacoesBll.*;
import java.util.ArrayList;

/**
 *
 * @author JHONATHANN
 */
public class FabricanteBll {

    private FabricanteDal fabricanteDal;

    public FabricanteBll() throws Exception {
        fabricanteDal = new FabricanteDal();
    }

    public void Adicionar(Fabricante fabricante) throws Exception {
        try {
            validarNome(fabricante.getFab_nome());
            fabricanteDal.addFabricante(fabricante);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe um fabricante com este nome!";
            }
            throw new Exception(mensagem);
        }
    }

    public void Alterar(Fabricante fabricante) throws Exception {
        try {
            validarNome(fabricante.getFab_nome());
            fabricanteDal.updateFabricante(fabricante);
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("duplicate")) {
                mensagem = "Ja existe um fabricante com este nome";
            }
            throw new Exception(mensagem);
        }
    }

    public void Remover(Fabricante fabricante) throws Exception {
        try {
            validarNome(fabricante.getFab_nome());
            fabricanteDal.deleteFabricante(fabricante.getFab_iden());
        } catch (Exception e) {
            String mensagem = e.getMessage();
            if (mensagem.contains("update")) {
                mensagem = "Existe umupdatea miniatura com está fabricante cadastrada!";
            }
            throw new Exception(mensagem);
        }
    }

    public ArrayList<Fabricante> getConsulta() throws Exception {
        try {
            return fabricanteDal.getAllFabricantes();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public Fabricante getConsultaPorId(int fab_iden) throws Exception {
        try {
            return fabricanteDal.getFabricanteById(fab_iden);

        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    public Fabricante getFabricanteNome(String nome) throws Exception {
        try {
            return fabricanteDal.getFabricanteNome(nome);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
