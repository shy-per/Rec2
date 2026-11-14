import java.util.Scanner;

public class Vestibular {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[][] inscritos = new long[10][3];
        int total = 0;
        int[] cursos = new int[5];
        int somaIdades = 0;

        while (total < 10) {
            System.out.print("Digite o CPF: ");
            long cpf = sc.nextLong();

            boolean existe = false;
            for (int i = 0; i < total; i++) {
                if (inscritos[i][0] == cpf) {
                    existe = true;
                    break;
                }
            }

            if (existe) {
                System.out.println("CPF ja cadastrado registro nao inserido");
            } else {
                System.out.print("Digite a idade: ");
                int idade = sc.nextInt();

                int curso;
                do {
                    System.out.print("Digite o curso (1-ADS 2-GECOM 3-Eventos 4-RH): ");
                    curso = sc.nextInt();
                    if (curso < 1 || curso > 4) {
                        System.out.println("Curso invalido");
                    }
                } while (curso < 1 || curso > 4);

                inscritos[total][0] = cpf;
                inscritos[total][1] = idade;
                inscritos[total][2] = curso;

                cursos[curso]++;
                somaIdades += idade;
                total++;
            }
        }

        System.out.println();
        System.out.println("Inscritos em ADS: " + cursos[1]);
        System.out.println("Inscritos em GECOM: " + cursos[2]);
        System.out.println("Inscritos em Eventos: " + cursos[3]);
        System.out.println("Inscritos em RH: " + cursos[4]);
        System.out.println("Media de idade dos inscritos: " + (double) somaIdades / total);
    }
}
