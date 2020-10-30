/*
 *  -------------------------------------------------------------------------------------------------->
 *  Licença    : MIT - Copyright 2019 Jhonathan dos reis (jhonlinux) <jhonathan.rosa@maximatech.com.br>
 *  Criado em  : 11/10/2020 19:19:43 
 *  Instituição: FACULDADE SENAI FATESG
 *  Curso      : Análise e Desenvolvimento de sistemas - Módulo 3 - 2020/2
 *  Disciplina : APS - Arquitetura e Projeto de Software
 *  Aluno      : Jhonathan dos reis
 *  Projeto    : PROJETO CAMADAS
 *  Exercício  : Torrentz_filmes
 *  ---------------------------------------------------------------------------------------------------
 *  Propósito do arquivo.
 *  ---------------------------------------------------------------------------------------------------| 
 *
 *  Fonte: https://github.com/Viniciusalopes/ads20192-modulo3/blob/master/pp/PpSingletonDecoratorTemplateColaborador/src/br/com/vinicius/generic/bll/BllGeneric.java
 *
 */
package br.com.torrentz.bll;

/**
 *
 * @author JHONATHAN
 */
public class ValidacoesBll {

    protected static String charsVogaisAcentuadas = "àâãáéêíòôõóúÀÂÂÁÉÊÍÒÔÕÓÚ";
    protected static String charsLetras = "qwertyuiopasdfghjklçzxcvbnmQWERTYUIOPASDFGHJKLÇZXCVBNM " + charsVogaisAcentuadas;
    protected static String charsNumeros = "0123456789";

    public static void validarTextoTamanho(String texto) throws Exception {
        texto = texto.trim();
        if (texto.length() == 0) {
            throw new Exception("Informe o nome!");
        }

        if (texto.length() < 2) {
            throw new Exception("O nome deve ter pelo menos duas letras!");
        }
    }

    public static void validarCampoTamanho(String texto, String nomeDoCampoTexto) throws Exception {
        try {
            validarNome(texto);
        } catch (Exception e) {
            throw new Exception(e.getMessage().replace("nome", nomeDoCampoTexto));
        }
    }

    public static void validarCampo(String texto, String nomeDoCampoTexto) throws Exception {
        try {
            validarNome(texto);
        } catch (Exception e) {
            throw new Exception(e.getMessage().replace("nome", nomeDoCampoTexto));
        }
    }

    /**
     * Valida nome.
     *
     * @param nome Texto com nome válido, com pelo menos duas letras.
     * @throws Exception
     */
    public static void validarNome(String nome) throws Exception {
        validarTextoTamanho(nome);

        for (char c : nome.toCharArray()) {
            if (!charsLetras.contains(c + "")) {
                throw new Exception("O nome deve ter apenas letras e espaços!");
            }
        }
    }
}
