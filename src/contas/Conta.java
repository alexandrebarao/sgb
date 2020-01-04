/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contas;

import java.util.ArrayList;
import userinterfaces.ContaUI;

/**
 *
 * @author Administrator
 */
public abstract class Conta {
    private static int numero = 0;
    private double saldo;
    
    private ArrayList listaMovimentos;
    
    public Conta() {
        ++numero;
        
        listaMovimentos = new ArrayList();
        
    }
    
    public boolean transferir(Conta c, double valor) {
        c.setSaldo(getSaldo()+valor);
        setSaldo(getSaldo()-valor);
        return true;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
     public void menu() {
        ContaUI c = new ContaUI(this);
        c.menuMovimentosConta();
    }
}
