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
public class Medio extends Cafe {

    public Medio() {
        descricao = "200 ML";
    }

    @Override
    public double preco() {
        return 5.00;
    }
}
