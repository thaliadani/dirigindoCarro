import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();
        Carro carro = new Carro();

        int opcao;

        do {
            menu.exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    carro.ligar();
                    break;
                case 2:
                    carro.desligar();
                    break;
                case 3:
                    carro.acelerar();
                    break;
                case 4:
                    carro.diminuirVelocidade();
                    break;
                case 5:
                    carro.verificarVelocidade();
                    break;
                case 6:
                    carro.trocarMarcha();
                    break;
                case 7:
                    carro.virarDireita();
                    break;
                case 8:
                    carro.virarEsquerda();
                    break;
                case 9:
                    System.out.println("Obrigado por usar nosso sistema!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println();
        }while (opcao != 9);

        scanner.close();
    }
}
