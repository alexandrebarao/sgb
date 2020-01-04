/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterfaces;

import contas.Conta;

/**
 *
 * @author Administrator
 */
public class ContaUI {
    
    Conta conta; 
    
    public ContaUI(Conta c) {
        conta = c;
    }
    
    public void menuMovimentosConta() {
        // reedfinir nas sub classes e criar o menu específico
    }
}
