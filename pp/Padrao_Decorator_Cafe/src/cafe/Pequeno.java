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
public class Pequeno extends Cafe {

    public Pequeno() {
        descricao = "100 ML";
    }

    @Override
    public double preco() {
        return 3.00;
    }
}
