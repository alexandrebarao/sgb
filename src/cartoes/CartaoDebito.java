/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartoes;

import userinterfaces.CartaoDebitoUI;

/**
 *
 * @author Administrator
 */
public class CartaoDebito {
    
      private int numero;
      private static int gerador = 100;

    public int getNumero() {
        return numero;
    }
    
      public CartaoDebito() {
          ++gerador;
          numero = gerador;
      }
      public void menu() {
        CartaoDebitoUI ui = new CartaoDebitoUI(this);
        ui.menu();
    }

}
