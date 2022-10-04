package testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack {

	public static void iniciaJogo(Scanner scan) {
		int opcao;
		List<Integer> jogador = new ArrayList<Integer>();
		List<Integer> mesa = new ArrayList<Integer>();

		// Inicio da partida
		jogador.add((int) (Math.random() * 13));
		jogador.add((int) (Math.random() * 13));

		mesa.add((int) (Math.random() * 13));
		mesa.add((int) (Math.random() * 13));

		// Mostra as cartas
		System.out.print("Cartas do Jogador: ");
		for (Integer carta : jogador) {
			switch(carta) {
			case 0:
				System.out.print("[" + "A" + "]");
				break;
			case 11:
				System.out.print("[" + "J" + "]");
				break;
			case 12:
				System.out.print("[" + "Q" + "]");
				break;
			case 13:
				System.out.print("[" + "K" + "]");
				break;
			
			default:
				System.out.print("[" + carta + "]");
			break;
			}
		}
		System.out.println("");
		System.out.print("Cartas da Mesa: ");
		for (Integer cartamesa : mesa) {
			switch(cartamesa) {
			case 0:
				System.out.print("[" + "A" + "]");
				break;
			case 11:
				System.out.print("[" + "J" + "]");
				break;
			case 12:
				System.out.print("[" + "Q" + "]");
				break;
			case 13:
				System.out.print("[" + "K" + "]");
				break;
			default:
				System.out.print("[" + cartamesa + "]");
			break;
		}
		}
		System.out.println("");
		
	}

	// Classe Main
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int opcao;

		System.out.println("Bem-vindo(a) ao BlackJack");
		System.out.println("1 - Começar partida");
		System.out.println("0 - Sair");

		opcao = scan.nextInt();

		if (opcao == 1) {
			iniciaJogo(scan);
		}

	}

}
