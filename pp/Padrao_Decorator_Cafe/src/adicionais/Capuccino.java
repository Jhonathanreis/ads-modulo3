/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adicionais;

import cafe.Cafe;

/**
 *
 * @author JHONATHAN
 */

public class Capuccino extends Adicionais {
    
    private Cafe tamanho;
    
    public Capuccino(Cafe tamanho) {
        this.tamanho = tamanho;
    }
    
    @Override
    public String getDescricao() {
         return tamanho.getDescricao() + " | Capuccino";
    }

    @Override
    public double preco() {
        return 1.0 + tamanho.preco();
    } 
}
