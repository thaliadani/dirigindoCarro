import java.util.Scanner;

public class Carro {
    Scanner scanner = new Scanner(System.in);


    private boolean ligado;
    private int velocidade;
    private int marcha; // 0 a 6
    private String direcao; // "frente", "esquerda", "direita"

    public Carro() {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0; // ponto morto
        this.direcao = "frente";
    }

    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("Carro ligado.");
        } else {
            System.out.println("Carro já está ligado.");
        }
    }

    public void desligar() {
        if (!ligado) {
            System.out.println("Carro já está desligado.");
            return;
        }
        if (marcha == 0 && velocidade == 0) {
            ligado = false;
            System.out.println("Carro desligado.");
        } else {
            System.out.println("Não é possível desligar o carro. Coloque em ponto morto e pare o carro (velocidade 0).");
        }
    }

    public void acelerar() {
        if (!ligado) {
            System.out.println("Carro desligado. Não pode acelerar.");
            return;
        }
        if (marcha == 0) {
            System.out.println("Carro em ponto morto. Não pode acelerar.");
            return;
        }
        int novaVelocidade = velocidade + 1;
        if (novaVelocidade > 120) {
            System.out.println("Velocidade máxima atingida (120 km/h).");
            return;
        }
        if (velocidadeValidaParaMarcha(novaVelocidade, marcha)) {
            System.out.println("Velocidade " + novaVelocidade + " km/h não permitida na marcha " + marcha + ".");
            return;
        }
        velocidade = novaVelocidade;
        System.out.println("Acelerou para " + velocidade + " km/h.");
    }

    public void diminuirVelocidade() {
        if (!ligado) {
            System.out.println("Carro desligado. Não pode diminuir velocidade.");
            return;
        }
        if (velocidade == 0) {
            System.out.println("Carro já está parado.");
            return;
        }
        int novaVelocidade = velocidade - 1;
        if (velocidadeValidaParaMarcha(novaVelocidade, marcha)) {
            System.out.println("Velocidade " + novaVelocidade + " km/h não permitida na marcha " + marcha + ".");
            return;
        }
        velocidade = novaVelocidade;
        System.out.println("Velocidade diminuída para " + velocidade + " km/h.");
    }

    public void virarEsquerda() {
        if (!ligado) {
            System.out.println("Carro desligado. Não pode virar.");
            return;
        }
        if (velocidade < 1 || velocidade > 40) {
            System.out.println("Para virar, a velocidade deve estar entre 1 km/h e 40 km/h.");
            return;
        }
        direcao = "esquerda";
        System.out.println("Virando para a esquerda.");
    }

    public void virarDireita() {
        if (!ligado) {
            System.out.println("Carro desligado. Não pode virar.");
            return;
        }
        if (velocidade < 1 || velocidade > 40) {
            System.out.println("Para virar, a velocidade deve estar entre 1 km/h e 40 km/h.");
            return;
        }
        direcao = "direita";
        System.out.println("Virando para a direita.");
    }

    public void verificarVelocidade() {
        System.out.println("Velocidade atual: " + velocidade + " km/h.");
    }

    public void trocarMarcha() {
        System.out.println("Escolha a nova marcha (0 a 6): ");
        int novaMarcha = scanner.nextInt();

        if (!ligado) {
            System.out.println("Carro desligado. Não pode trocar marcha.");
            return;
        }
        if (novaMarcha < 0 || novaMarcha > 6) {
            System.out.println("Marcha inválida. Escolha entre 0 e 6.");
            return;
        }
        if (Math.abs(novaMarcha - marcha) != 1) {
            System.out.println("Não é permitido pular marchas. Marcha atual: " + marcha + ".");
            return;
        }
        if (velocidadeValidaParaMarcha(velocidade, novaMarcha)) {
            System.out.println("Velocidade atual " + velocidade + " km/h não é permitida na marcha " + novaMarcha + ".");
            return;
        }
        marcha = novaMarcha;
        System.out.println("Marcha trocada para " + marcha + ".");
    }

    private boolean velocidadeValidaParaMarcha(int velocidade, int marcha) {
        return !switch (marcha) {
            case 0 -> // ponto morto
                    velocidade == 0;
            case 1 -> velocidade >= 0 && velocidade <= 21;
            case 2 -> velocidade >= 21 && velocidade <= 41;
            case 3 -> velocidade >= 41 && velocidade <= 61;
            case 4 -> velocidade >= 61 && velocidade <= 81;
            case 5 -> velocidade >= 81 && velocidade <= 101;
            case 6 -> velocidade >= 101 && velocidade <= 121;
            default -> false;
        };
    }

}
