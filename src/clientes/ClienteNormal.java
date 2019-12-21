/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import java.util.ArrayList;
import userinterfaces.ClienteNormalUI;

/**
 *
 * @author Administrator
 */
public class ClienteNormal {
    private String nome;
    // String email;
    
    private static int gerador=0;
    private int numero; 
    
    ArrayList listaCartoes;

    public ArrayList getListaCartoes() {
        return listaCartoes;
    }
    
    public ClienteNormal() {
        ++gerador;
        numero = gerador;
        setNome("Sem nome atribuido"); 
        
        listaCartoes = new ArrayList();
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public  int getNumero() {
        return numero;
    }
    
    public void menu() {
        ClienteNormalUI ui = new ClienteNormalUI(this);
        ui.menu();
    }
    
}
