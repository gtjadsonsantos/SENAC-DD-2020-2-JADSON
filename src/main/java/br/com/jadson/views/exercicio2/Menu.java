package br.com.jadson.views.exercicio2;

import java.util.Scanner;

public class Menu {
    private static final int MENU_VACINA = 1;
    private static final int MENU_PESSOA = 2;

    public void exibirMenu() {
        int option = this.exibirOpcoes();

        if (option == MENU_VACINA) {
            new MenuVacina().exibirMenu();
        }

        if (option == MENU_PESSOA) {
            new MenuPessoa().exibirMenu();
        }
    }

    public int exibirOpcoes() {
        Scanner teclado = new Scanner(System.in);

        System.out.print("BEM VINDO\n\n");
        System.out.println("Options:");
        System.out.println(MENU_VACINA + " - MENU VACINA");
        System.out.println(MENU_PESSOA + " - MENU PESSOA");
        System.out.print("Digite a opção: ");

        teclado.close();

        return teclado.nextInt();
    }
}