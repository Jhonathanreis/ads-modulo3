/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author JHONATHAN
 */

public class Aviao {
    
    //---ATRIBUTOS---//
    private static Aviao INSTANCE;
    private ArrayList<Integer> idDoAcento;
    private ArrayList<String> status;
    private ArrayList<String> passageiro;
    private ArrayList<Date> checkIn;
    

    //---CONSTRUTOR PADRÃO---//
    public Aviao() {
        this.idDoAcento = new ArrayList<>();
        this.status = new ArrayList<>();
        this.passageiro = new ArrayList<>();
        this.checkIn = new ArrayList<>();
        for (int i = 1; i <= 14; i++) {
            idDoAcento.add(i);
            status.add("DISPONIVEL");
            passageiro.add("");
            checkIn.add(null);
        }
    }

    //---INSTANCIA SINGLETON---//
    public static Aviao getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Aviao();
        }
        return INSTANCE;
    }
    
    //---GETERS E SETTERS---//
    public ArrayList<Integer> getIdDoAcento() {
        return idDoAcento;
    }

    public void setIdDoAcento(ArrayList<Integer> idDoAcento) {
        this.idDoAcento = idDoAcento;
    }

    public ArrayList<String> getStatus() {
        return status;
    }

    public void setStatus(int i, String novoStatus) {
        status.set(i, novoStatus);
    }

    public ArrayList<String> getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(int i, String novoNomePassageiro) {
        passageiro.set(i, novoNomePassageiro);
    }

    public ArrayList<Date> getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(int i, Date novoCheckIn) {
        checkIn.set(i, novoCheckIn);
    }
    //---ToSTRING---//
    public String toString(int i) {
        return idDoAcento.get(i) + ";" + status.get(i) + ";" + passageiro.get(i) + ";" + checkIn.get(i);
    }
}
