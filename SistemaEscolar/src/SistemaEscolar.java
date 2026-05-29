import java.util.Scanner;
import java.util.Locale;

public class SistemaEscolar {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        final int MAXIMO_ALUNOS_CADASTRADO = 5;
        String alunosCadastrados[] = new String[MAXIMO_ALUNOS_CADASTRADO]; // Vetor alunos cadastrado

        String[] disciplinas = {"Português", "Matemática", "Ciência", "História", "Física"};

        double notas[][] = new double[5][5]; // Matriz para notas

        int opcao;

        do {
            System.out.println();
            System.out.println("====================");
            System.out.println("1 - Cadastro de alunos");
            System.out.println("2 - Lançar notas");
            System.out.println("3 - Ver boletim");
            System.out.println("4 - Ver aprovados");
            System.out.println("5 - Ver reprovados");
            System.out.println("0 - Sair");
            System.out.println("====================");
            System.out.print("Digite uma opção: ");
            opcao = sc.nextInt();

            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("==================");
                    System.out.println("Cadastro de alunos");
                    System.out.println("==================");

                    System.out.print("Quantos alunos deseja cadastrar? ");
                    int quantidadeAlunos = sc.nextInt();

                    sc.nextLine(); // Limpar buffer

                    for (int contador = 0; contador < quantidadeAlunos; contador++) {

                        System.out.print("Digite somente o primeiro nome do " + (contador +1) + "º aluno: ");

                        String nomeAluno = sc.nextLine();

                        if (nomeAluno.contains(" ")) {

                            System.out.println();

                            System.out.println("Digite somente o primeiro nome do aluno, sem espaços. Tente novamente.");

                            contador--; // Decrementar o contador para repetir a iteração

                            continue;
                        }

                        alunosCadastrados[contador] = nomeAluno;
                    }

                    break;
                case 2:
                    System.out.println("===================");
                    System.out.println("Lançamento de notas");
                    System.out.println("===================");

                    for (int  contador = 0; contador < alunosCadastrados.length; contador++) {

                        if (alunosCadastrados[contador] != null) {

                            System.out.println("ID" + "[" + contador + "] -" + " " + alunosCadastrados[contador]);

                        }
                    }

                    System.out.println();
                    System.out.print("Selecione o ID do aluno que deseja lançar a nota: ");
                    int idAluno = sc.nextInt();

                    for(int contador = 0; contador < alunosCadastrados.length; contador++){

                        if (idAluno == contador && alunosCadastrados[contador] != null) {

                            System.out.print("Digite a nota da disciplina [Português]: ");
                            notas[contador][0] = sc.nextDouble();
                            System.out.print("Digite a nota da disciplina [Matemática]: ");
                            notas[contador][1] = sc.nextDouble();
                            System.out.print("Digite a nota da disciplina [Ciência]: ");
                            notas[contador][2] = sc.nextDouble();
                            System.out.print("Digite a nota da disciplina [História]: ");
                            notas[contador][3] = sc.nextDouble();
                            System.out.print("Digite a nota da disciplina [Física]: ");
                            notas[contador][4] = sc.nextDouble();

                            break;

                        }
                    }


                    break;
                case 3:
                    System.out.println("===================");
                    System.out.println("Verificar boletim");
                    System.out.println("===================");

                    // Imprimir o cabeçalho
                    System.out.printf("%-15s", "Aluno");

                    for(int contadorDisciplinas = 0; contadorDisciplinas < disciplinas.length; contadorDisciplinas++){
                        System.out.printf("%-15s", disciplinas[contadorDisciplinas]);
                    }

                    System.out.println(); // Pular linha

                    // Imprimir os alunos + notas
                    for(int contadorAlunosCadastrado = 0; contadorAlunosCadastrado < alunosCadastrados.length; contadorAlunosCadastrado++){

                       // Ignorar posições vazias
                       if (alunosCadastrados[contadorAlunosCadastrado] == null) {
                           continue;
                       }

                       // Nome do aluno
                       System.out.printf("%-15s", alunosCadastrados[contadorAlunosCadastrado]);

                       // Notas do aluno
                       for(int contadorDisciplinas = 0; contadorDisciplinas < disciplinas.length; contadorDisciplinas++){
                            System.out.printf("%-15.1f", notas[contadorAlunosCadastrado][contadorDisciplinas]);
                       }

                        System.out.println(); // Pular linha
                    }
                    break;
                case 4:
                    System.out.println("===================");
                    System.out.println("Alunos aprovados");
                    System.out.println("===================");

                    for(int contadorAlunosCadastrado = 0; contadorAlunosCadastrado < alunosCadastrados.length; contadorAlunosCadastrado++){

                        if (alunosCadastrados[contadorAlunosCadastrado] == null) {
                            continue;
                        }

                        double somaNotas = 0;

                        for(int contadorDisciplinas = 0; contadorDisciplinas < disciplinas.length; contadorDisciplinas++){
                            somaNotas += notas[contadorAlunosCadastrado][contadorDisciplinas];
                        }

                        double media = somaNotas / disciplinas.length;

                        if (media >= 6.0) {
                            System.out.println(alunosCadastrados[contadorAlunosCadastrado] + " - Média: " + String.format("%.1f", media));

                        }
                    }

                    break;
                case 5:
                    System.out.println("===================");
                    System.out.println("Alunos reprovados");
                    System.out.println("===================");

                    for(int contadorAlunosCadastrado = 0; contadorAlunosCadastrado < alunosCadastrados.length; contadorAlunosCadastrado++){

                        if (alunosCadastrados[contadorAlunosCadastrado] == null) {
                            continue;
                        }

                        double somaNotas = 0;

                        for(int contadorDisciplinas = 0; contadorDisciplinas < disciplinas.length; contadorDisciplinas++){
                            somaNotas += notas[contadorAlunosCadastrado][contadorDisciplinas];
                        }

                        double media = somaNotas / disciplinas.length;

                        if (media < 6.0) {
                            System.out.println(alunosCadastrados[contadorAlunosCadastrado] + " - Média: " + String.format("%.1f", media));

                        }
                    }

                    break;
                case 0:
                    System.out.println();
                    System.out.println("Saindo do sistema...");

                    break;
                default:
                    System.out.println();
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }while (opcao != 0);

        sc.close();
    }
}