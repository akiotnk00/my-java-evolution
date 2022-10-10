package main;

import java.util.Scanner;

public class MathTeste {

	public static void testeMinMax(Scanner scan) {
		Integer numero1 = 5;
		Integer numero2 = 10;

		Integer op = 1;

		while (op != 0) {

			System.out.println("Selecione uma opção:");
			System.out.println("1 - Min");
			System.out.println("2 - Max");
			System.out.println("0 - voltar.");
			op = scan.nextInt();

			switch (op) {
			case 0:
				break;
			case 1:
				System.out.println("O menor é: "+Math.min(numero1, numero2));
				break;
			case 2:
				System.out.println("O maior é: "+Math.max(numero1, numero2));
				break;
			default:
				System.out.println("Digite uma opção válida!" + "\n");
				break;
			}
			System.out.println("/n");
		}

	}

	public static void testePapelTesouraPedra(Scanner scan) {
		Integer opcao = 5;
		Double numeroSorteado;
		while (opcao != 0) {
			System.out.println("Digite uma opção");
			System.out.println("1 - Papel");
			System.out.println("2 - Tesoura");
			System.out.println("3 - Pedra");
			System.out.println("0 - Sair");
			opcao = scan.nextInt();

			numeroSorteado = Math.random() * 100;
			System.out.println(numeroSorteado);

			switch (opcao) {
			case 0:
				System.out.println("Saiu");
				break;
			case 1:
				if (numeroSorteado > 0.0 & numeroSorteado < 33.0) {
					System.out.println("Os 2 escolheram papel.");
				}
				if (numeroSorteado > 33.0 & numeroSorteado < 66.0) {
					System.out.println("Você perdeu!");
				}
				if (numeroSorteado > 66.0 & numeroSorteado < 100.0) {
					System.out.println("Você Ganhou!");
				}
				break;
			case 2:
				if (numeroSorteado > 0.0 & numeroSorteado < 33.0) {
					System.out.println("Você ganhou!.");
				}
				if (numeroSorteado > 33.0 & numeroSorteado < 66.0) {
					System.out.println("Os 2 escolheram tesoura.");
				}
				if (numeroSorteado > 66.0 & numeroSorteado < 100.0) {
					System.out.println("Você perdeu!");
				}
				break;
			case 3:
				if (numeroSorteado > 0.0 & numeroSorteado < 33.0) {
					System.out.println("Você perdeu!.");
				}
				if (numeroSorteado > 33.0 & numeroSorteado < 66.0) {
					System.out.println("Você ganhou!");
				}
				if (numeroSorteado > 66.0 & numeroSorteado < 100.0) {
					System.out.println("Os 2 escolheram pedra!");
				}
				break;
			default:
				System.out.println("Opcao invalida" + "\n");
				break;
			}
		}

	}

	public static void testeSqrt(Scanner scan) {
		Double numero1 = 0.0;

		Integer op = 1;

		while (op != 0) {

			System.out.println("Selecione uma opção:");
			System.out.println("1 - Raiz Quadrada");
			System.out.println("0 - voltar.");
			op = scan.nextInt();

			switch (op) {
			case 0:
				break;
			case 1:
				System.out.println("Digite um numero:");
				numero1 = scan.nextDouble();
				System.out.println("Resultado: " + Math.sqrt(numero1));
				break;

			default:
				System.out.println("Digite uma opção válida!" + "\n");
				break;
			}
		}

	}

	public static void testeRandom(Scanner scan) {

		Integer op = 1;

		while (op != 0) {

			System.out.println("Selecione uma opção:");
			System.out.println("1 - 1 random (de 1 a 100)");
			System.out.println("2 - 10 random (de 1 a 1000)");
			System.out.println("0 - voltar.");
			op = scan.nextInt();

			switch (op) {
			case 0:
				break;
			case 1:
				System.out.println(Math.random() * 100);
				break;
			case 2:
				int i = 0;
				while (i < 10) {
					System.out.println(Math.random() * 1000);
					i++;
				}
				break;
			default:
				System.out.println("Digite uma opção válida!" + "\n");
				break;
			}
		}

	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Testes da classe Objects
		Integer op = 1;
		while (op != 0) {
			System.out.println("Selecione uma opção para teste:");
			System.out.println("1 - min e max");
			System.out.println("2 - sqrt - raiz quadrada");
			System.out.println("3 - random");
			System.out.println("4 - Jogo Papel Tesoura Pedra");
			System.out.println("5 - Ver o valor de PI");
			System.out.println("6 - Ver o valor de E");
			System.out.println("0 - Para sair.");

			op = scan.nextInt();

			switch (op) {
			case 0:
				System.exit(0);
				break;
			case 1:
				testeMinMax(scan);
				break;
			case 2:
				testeSqrt(scan);
				break;
			case 3:
				testeRandom(scan);
				break;
			case 4:
				testePapelTesouraPedra(scan);
				break;
			case 5:
				System.out.println("O valor de PI é: " + Math.PI + "\n");
				break;
			case 6:
				System.out.println("O valor de E é: " + Math.E + "\n");
				break;
			default:

				System.out.println("Digite uma opção válida!" + "\n");
			}

		}
	}
}
