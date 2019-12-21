/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterfaces;

import clientes.ClienteVip;
import java.util.Scanner;
/**
 *
 * @author Administrator
 */
public class ClienteVipUI  {
    
    ClienteVip clienteVip;
    
   
    public ClienteVipUI(ClienteVip c) {
        clienteVip = c;
    }
    
    public void menu() {
        System.out.println("\n\nDados para novo cliente VIP\n");
        
        
        System.out.println("\nNome? ");
        Scanner input = new Scanner(System.in);
        clienteVip.setNome(input.nextLine());
        
        // Identificar gestor de conta
        // dar acesso ao sistema de gerir gestores...
        
    }
}