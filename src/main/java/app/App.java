package app;

import ctrl.Controller;

import java.io.IOException;
import java.util.Scanner;

public class App {

    /**
     * Main view
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Controller ctrl = new Controller();
        int opcao;
        System.out.println("============== LEDSCode ================\n");
        System.out.println("Menu:");
        opcao = menu();

        do {
            switch (opcao) {
                case 1:
                    ctrl.staticProject();
                    break;

                case 0:
                    finalizarApp();
                    break;
            }
            opcao = menu();
        }while (opcao != 0);
    }

    /**
     * Menu da aplicacao
     * @return
     */
    public static int menu(){
        Scanner leitor = new Scanner(System.in);
        int opcao;

        opcoesMenu();
        System.out.print("Digite: ");
        opcao = leitor.nextInt();

        return opcao;
    }

    /**
     * Metodo que mostra as opcoes do menu
     */
    public static void opcoesMenu() {

        System.out.println("Para criar projeto estático, digite 1.");
        System.out.println("Para sair, digite 0.");
    }

    /**
     * Metodo para finalizar view
     */
    public static void finalizarApp() {
        System.out.println("App finalizado!!!");
    }
}
