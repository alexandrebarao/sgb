/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contas;

/**
 *
 * @author Administrator
 */
public class ContaOrdem extends Conta {
    
    public void depositar(double valor) {
        setSaldo(getSaldo()+valor);
    }
    
    public boolean levantar(double valor) {
        boolean conseguiuLevantar = false;
        
        if ( getSaldo() >= valor ) {
             setSaldo(getSaldo()-valor);
             conseguiuLevantar = true;
        }
        return conseguiuLevantar;
    }
}
