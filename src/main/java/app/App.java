package app;

import ctrl.Controller;

import java.io.IOException;
import java.util.Scanner;

public class App {

    /**
     * Main app
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        Controller ctrl = new Controller();
        int opcao = 0;
        System.out.println("============== LEDSCode ================\n");
        System.out.println("Menu:");
        menu();

        switch (opcao){
            case 1:
                ctrl.staticProject();
                break;

            case 0:
                finalizarApp();
                break;
        }
    }

    /**
     * Menu da aplicacao
     * @return
     */
    public static int menu(){
        Scanner leitor = new Scanner(System.in);
        int opcao;
        do{
            opcoesMenu();
            System.out.print("Digite: ");
            opcao = leitor.nextInt();

        }while(opcao != 0);

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
     * Metodo para finalizar app
     */
    private static void finalizarApp() {
        System.out.println("App finalizado!!!");
    }
}
