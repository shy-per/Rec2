import java.util.Scanner;

public class Campeonato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] tabela = new int[10][4];

        for (int i = 0; i < 10; i++) {
            System.out.println("Time " + (i + 1));
            System.out.print("Vitorias: ");
            int vitorias = sc.nextInt();
            System.out.print("Empates: ");
            int empates = sc.nextInt();
            System.out.print("Derrotas: ");
            int derrotas = sc.nextInt();

            tabela[i][0] = vitorias * 3;
            tabela[i][1] = empates * 1;
            tabela[i][2] = derrotas * 0;
            tabela[i][3] = tabela[i][0] + tabela[i][1] + tabela[i][2];
        }

        int[] ordem = new int[10];
        for (int i = 0; i < 10; i++) {
            ordem[i] = i;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 10; j++) {
                if (tabela[ordem[j]][3] > tabela[ordem[i]][3]) {
                    int aux = ordem[i];
                    ordem[i] = ordem[j];
                    ordem[j] = aux;
                }
            }
        }

        System.out.println();
        System.out.println("Tabela do campeonato");
        System.out.println("Time\tVitorias\tEmpates\tDerrotas\tPontos");
        for (int i = 0; i < 10; i++) {
            System.out.println((i + 1) + "\t" + tabela[i][0] + "\t\t" + tabela[i][1] + "\t" + tabela[i][2] + "\t\t" + tabela[i][3]);
        }

        System.out.println();
        System.out.println("Tres primeiros colocados");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + "o lugar: Time " + (ordem[i] + 1) + " com " + tabela[ordem[i]][3] + " pontos");
        }
    }
}
