/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contas;

import userinterfaces.ContaInvestimentoUI;
import userinterfaces.ContaOrdemUI;
import userinterfaces.ContaPoupancaUI;

/**
 *
 * @author Administrator
 */
public class ContaPoupanca extends Conta {
    private double juro;
    
    public ContaPoupanca() {
        juro = 1.05;
    }
    
      public void menu() {
        ContaPoupancaUI c = new ContaPoupancaUI(this);
        c.menuMovimentosConta();
    }
    
}
