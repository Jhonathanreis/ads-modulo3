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
public class Leite extends Adicionais {
    
    private Cafe tamanho;
    
    public Leite(Cafe tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String getDescricao() {
        return tamanho.getDescricao() + " Leite";
    }

    @Override
    public double preco() {
        return 0.5 + tamanho.preco();
    }
}