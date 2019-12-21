/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterfaces;

import java.util.Scanner;

import banco.Banco;
import clientes.*;
import cartoes.*;

/**
 *
 * @author Administrator
 */
public class BancoUI {

    Banco meuBanco;

    public BancoUI(Banco b) {
        meuBanco = b;
    }

    public void menu() {

        boolean termina = false;
        do {
            System.out.println("\n\n");
            System.out.println("Menu do Banco");
            System.out.println("1 - Criar um cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Opções do cliente");
            System.out.println("4 - Selecionar um cartão");
            System.out.println("5 - Avançar um período");
            System.out.println("6 - Sair");
            System.out.println("\nPor favor, selecione uma opção: ");

            Scanner input = new Scanner(System.in);
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    criarUmCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    if (meuBanco.getClienteAtivo() == null) {
                        if (pedirCliente()) {
                            opcoesDoCliente();
                        }
                    } else {
                        opcoesDoCliente();
                    }
                    break;
                case 6:
                    termina = true;
                    break;
                default:
                    System.out.println("\nOpção incorreta...");
            }

        } while (!termina);
    }

    private void criarUmCliente() {
        boolean termina = false;
        do {
            System.out.println("\n\n");
            System.out.println("Criar um cliente");
            System.out.println("1 - Cliente normal");
            System.out.println("2 - Cliente VIP");
            System.out.println("3 - Voltar para o menu anterior");
            System.out.println("\nPor favor, selecione uma opção: ");

            Scanner input = new Scanner(System.in);
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    criarClienteNormal();
                    break;
                case 2:
                    criarClienteVip();
                    break;
                case 3:
                    termina = true;
                    break;
                default:
                    System.out.println("\nOpção incorreta...");
            }

        } while (!termina);
    }

    private void criarClienteNormal() {
        ClienteNormal c = new ClienteNormal();
        meuBanco.getListaClientes().add(c);
        c.menu();
    }

    private void criarClienteVip() {
        ClienteVip c = new ClienteVip();
        meuBanco.getListaClientes().add(c);
        c.menu();
    }

    private void listarClientes() {
        System.out.println("\n\nListagem de clientes");
        for (int i = 0; i < meuBanco.getListaClientes().size(); i++) {
            ClienteNormal c = (ClienteNormal) meuBanco.getListaClientes().get(i);
            System.out.println("");
            if (meuBanco.getClienteAtivo() != null) {
                if (c.getNumero() == meuBanco.getClienteAtivo().getNumero()) {
                    System.out.print("--> ");
                } else {
                    System.out.print("    ");
                }
            }
            System.out.print("#" + c.getNumero() + " " + c.getNome()); // polimorfismo, clientes VIP são listados

        }
    }

    public boolean pedirCliente() {
        boolean estado = false;

        System.out.println("\n\nIndique qual o numero de cliente");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        ClienteNormal clienteAtivo = meuBanco.procuraCliente(n);

        if (clienteAtivo != null) {
            meuBanco.setClienteAtivo(clienteAtivo);
            estado = true;
        }

        return estado;

    }

    public void editarDadosCliente() {
        if (meuBanco.getClienteAtivo() != null) {
            meuBanco.getClienteAtivo().menu();
        }
    }

    public void desativarCliente() {
        meuBanco.setClienteAtivo(null);
    }

    public void criarCartaoDebito() {
        if (meuBanco.getClienteAtivo() != null) {
            CartaoDebito c = new CartaoDebito();
            meuBanco.getClienteAtivo().getListaCartoes().add(c);
            c.menu();
        } else {

            System.out.println("Sem cliente ativo...");
        }
    }

    public void criarCartaoCredito() {
        if (meuBanco.getClienteAtivo() != null) {
            CartaoCredito c = new CartaoCredito();
            meuBanco.getClienteAtivo().getListaCartoes().add(c);
            c.menu();
        } else {

            System.out.println("Sem cliente ativo...");
        }
    }

    public void criarCartao() {

        // escolher tipo de cartão 
        boolean termina = false;

        do {
            System.out.println("\n\n");
            System.out.println("Criar cartao");
            System.out.println("1 - Cartao de Debito");
            System.out.println("2 - Cartao de Credito");
            System.out.println("3 - Voltar para o menu anterior");
            System.out.println("\nPor favor, selecione uma opção: ");

            Scanner input = new Scanner(System.in);
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    criarCartaoDebito();
                    break;
                case 2:
                    criarCartaoCredito();
                    break;

                case 3:
                    termina = true;
                    break;
                default:
                    System.out.println("\nOpção incorreta...");
            }

        } while (!termina);

    }

    public void listarCartoes() {
        if (meuBanco.getClienteAtivo() != null) {
            for (int i = 0; i < meuBanco.getClienteAtivo().getListaCartoes().size(); i++) {
                CartaoDebito c = (CartaoDebito) meuBanco.getClienteAtivo().getListaCartoes().get(i);
                System.out.println("Cartao #" + c.getNumero());
                if (c instanceof CartaoCredito) {
                    CartaoCredito cc = (CartaoCredito) c;
                    System.out.print(" Plafond: " + cc.getPlafond());
                }
            }
        }
    }

    public void opcoesDoCliente() {
        boolean termina = false;

        do {
            System.out.println("\n\n");
            System.out.println("Opcoes do cliente");
            System.out.println("1 - Desativar cliente");
            System.out.println("2 - Editar os dados do cliente");
            System.out.println("3 - Criar cartao");
            System.out.println("4 - Listar cartoes");
            System.out.println("5 - Alterar dados do cartao");
            System.out.println("6 - Desativar cartao");
            System.out.println("7 - Criar conta");
            System.out.println("8 - Voltar para o menu anterior");
            System.out.println("\nPor favor, selecione uma opção: ");

            Scanner input = new Scanner(System.in);
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    desativarCliente();
                    break;
                case 2:
                    editarDadosCliente();
                    break;
                case 3:
                    criarCartao();
                    break;
                case 4:
                    listarCartoes();
                    break;
                case 8:
                    termina = true;
                    break;
                default:
                    System.out.println("\nOpção incorreta...");
            }

        } while (!termina);
    }
}
