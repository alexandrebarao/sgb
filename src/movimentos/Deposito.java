/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movimentos;

/**
 *
 * @author Administrator
 */
public class Deposito extends Movimento {
    
     public String informacao() {
        return new String("Movimento depósito - " + getValor() + " " + getTimeStamp());
    }
}
