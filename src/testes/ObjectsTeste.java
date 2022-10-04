package testes;

import java.util.Objects;
import java.util.Scanner;

public class ObjectsTeste {

	public static void testeHashCode(Scanner scan) {
		Carro carro1 = new Carro();
		Carro carro2 = new Carro();

		Integer op = 1;

		while (op != 0) {

			System.out.println("Selecione uma opção:");
			System.out.println("1 - Teste HashCode");
			System.out.println("0 - voltar.");
			op = scan.nextInt();

			switch (op) {
			case 0:
				break;
			case 1:
				System.out.println(Objects.hashCode(carro1));
				System.out.println(Objects.hashCode(carro2));
				
				break;
			default:
				System.out.println("Digite uma opção válida!");
				break;
			}
		}

	}
	
	public static void testeEquals(Scanner scan) {
		Carro carro1 = new Carro();
		Carro carro2 = new Carro();

		Integer op = 1;

		while (op != 0) {

			System.out.println("Selecione uma opção:");
			System.out.println("1 - Objetos iguais");
			System.out.println("2 - Objetos não iguais");
			System.out.println("0 - voltar.");
			op = scan.nextInt();

			switch (op) {
			case 0:
				break;
			case 1:
				if (Objects.equals(carro1, carro1)) {
					System.out.println("São iguais");
				} else {
					System.out.println("Não são iguais");
				}
				break;
			case 2:
				if (Objects.equals(carro1, carro2)) {
					System.out.println("São iguais");
				} else {
					System.out.println("Não são iguais");
				}
				break;
			default:
				System.out.println("Digite uma opção válida!");
				break;
			}
		}

	}

	public static void testeIsNull(Scanner scan) {
		Carro carro1 = new Carro();
		Carro carro2 = null;

		Integer op = 1;

		while (op != 0) {

			System.out.println("Selecione uma opção:");
			System.out.println("1 - Objeto nulo");
			System.out.println("2 - Objetos não nulo");
			System.out.println("0 - voltar.");
			op = scan.nextInt();

			switch (op) {
			case 0:
				break;
			case 1:
				if (Objects.isNull(carro1)) {
					System.out.println("Objeto nulo");
				} else {
					System.out.println("Objeto não nulo");
				}
				break;
			case 2:
				if (Objects.isNull(carro2)) {
					System.out.println("Objeto nulo");
				} else {
					System.out.println("Objeto não nulo");
				}
				break;
			default:
				System.out.println("Digite uma opção válida!");
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
			System.out.println("1 - equals");
			System.out.println("2 - isNull");
			System.out.println("3 - hashCode");
			System.out.println("0 - Para sair.");

			op = scan.nextInt();

			switch (op) {
			case 0:
				System.exit(0);
				break;
			case 1:
				testeEquals(scan);
				break;
			case 2:
				testeIsNull(scan);
				break;
			case 3:
				testeHashCode(scan);
				break;
			default:
				System.out.println("Digite uma opção válida!");
			}

		}
	}
}
