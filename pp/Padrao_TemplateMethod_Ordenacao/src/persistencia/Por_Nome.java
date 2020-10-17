/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

import classes.Aluno;

/**
 *
 * @author JHONATHAN
 */
public class Por_Nome extends AlunoPersistenciaTemplateMethod {

    public Por_Nome(String str) {
        super(str);
    }

    @Override
    public boolean ePrimeiro(Aluno aluno1, Aluno aluno2) {
        return aluno1.getNomeSa().compareToIgnoreCase(aluno2.getNomeSa()) <= 0;
    }
}
