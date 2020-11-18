/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cafe;

/**
 *
 * @author JHONATHAN
 */

public abstract class Cafe {
    
    String descricao = "Café";
    
    public String getDescricao() {
        return descricao;
    }
    
    public abstract double preco(); 
}
