package Testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blackjack {

	static List<Integer> jogador;
	static List<Integer> mesa;

	// Metodo que limpa e preenche novamente um baralho (Lista de Integer).
	public static List<Integer> resetaBaralho(List<Integer> baralho) {

		// Limpa o conteudo da lista.
		baralho.clear();

		Integer i = 1;

		// Preenche o baralho de 1 a 13.
		while (i <= 13) {
			baralho.add(i);
			i++;
		}

		return baralho;
	}

	public static List<Integer> escolheCartaJogador(List<Integer> baralho) {

		Integer posicao;

		// Escolhe uma posição no baralho de acordo com o tamanho do baralho;
		posicao = (int) (Math.random() * baralho.size());

		// O jogador recebe a carta.
		jogador.add(baralho.get(posicao));

		// A carta é removida do baralho.
		baralho.remove(posicao);

		// Retorna o baralho para ele ser atualizado.
		return baralho;
	}

	public static List<Integer> escolheCartaMesa(List<Integer> baralho) {

		Integer posicao;

		// Escolhe uma posição no baralho de acordo com o tamanho do baralho;
		posicao = (int) (Math.random() * baralho.size());

		// O jogador recebe a carta.
		mesa.add(baralho.get(posicao));

		// A carta é removida do baralho.
		baralho.remove(posicao);

		// Retorna o baralho para ele ser atualizado.
		return baralho;
	}

	// Quando a opcao iniciar um jogo é escolhida.
	public static void iniciaJogo(Scanner scan) {

		// Inicia as listas de baralhos.
		List<Integer> ouro = new ArrayList<Integer>();
		List<Integer> espada = new ArrayList<Integer>();
		List<Integer> copa = new ArrayList<Integer>();
		List<Integer> paus = new ArrayList<Integer>();

		// Inicia jogadores.
		jogador = new ArrayList<Integer>();
		mesa = new ArrayList<Integer>();

		// Inicia baralhos.
		ouro = resetaBaralho(ouro);
		espada = resetaBaralho(espada);
		copa = resetaBaralho(copa);
		paus = resetaBaralho(paus);

		// Sorteia as 2 cartas iniciais do jogador.
		int contador = 0;
		while (contador < 2) {
			// Sorteia de 0 a 3 para saber qual o naipe.
			switch ((int) (Math.random() * 3)) {
			// Ouro
			case 0:
				ouro = escolheCartaJogador(ouro);
				break;
			// Espada
			case 1:
				espada = escolheCartaJogador(espada);
				break;
			// Copa
			case 2:
				copa = escolheCartaJogador(copa);
				break;
			// Paus
			default:
				paus = escolheCartaJogador(paus);
				break;
			}
			contador++;
		}

		// Reseta o contador;
		contador = 0;

		// Sorteia as 2 cartas inicias da mesa.
		while (contador < 2) {
			// Sorteia de 0 a 3 para saber qual o naipe.
			switch ((int) (Math.random() * 3)) {
			// Ouro
			case 0:
				ouro = escolheCartaMesa(ouro);
				break;
			// Espada
			case 1:
				espada = escolheCartaMesa(espada);
				break;
			// Copa
			case 2:
				copa = escolheCartaMesa(copa);
				break;
			// Paus
			default:
				paus = escolheCartaMesa(paus);
				break;
			}
			contador++;
		}
		// Inicio da partida.

		exibeJogadores();

		int opcao;

		System.out.println("-> Escolha uma opção");
		System.out.println("1 - Pegar outra carta");
		System.out.println("0 - Parar");

		
		opcao = 5;
		
		while (opcao != 0 && calculaCartas(jogador) <= 21) {
			opcao = scan.nextInt();
			
			switch (opcao) {
			case 0:
				while (calculaCartas(mesa) < calculaCartas(jogador) && calculaCartas(jogador) < 21) {
					switch ((int) (Math.random() * 3)) {
					// Ouro
					case 0:
						ouro = escolheCartaMesa(ouro);
						break;
					// Espada
					case 1:
						espada = escolheCartaMesa(espada);
						break;
					// Copa
					case 2:
						copa = escolheCartaMesa(copa);
						break;
					// Paus
					default:
						paus = escolheCartaMesa(paus);
						break;
					}
					exibeJogadores();
				}
				break;
			case 1:
				switch ((int) (Math.random() * 3)) {
				// Ouro
				case 0:
					ouro = escolheCartaJogador(ouro);
					break;
				// Espada
				case 1:
					espada = escolheCartaJogador(espada);
					break;
				// Copa
				case 2:
					copa = escolheCartaJogador(copa);
					break;
				// Paus
				default:
					paus = escolheCartaJogador(paus);
					break;
				}
				exibeJogadores();			
				break;
			default:
				break;
			}
		}
		if(calculaCartas(jogador)<=21) {
		while (calculaCartas(mesa) < calculaCartas(jogador) && calculaCartas(jogador) < 21) {
			switch ((int) (Math.random() * 3)) {
			// Ouro
			case 0:
				ouro = escolheCartaMesa(ouro);
				break;
			// Espada
			case 1:
				espada = escolheCartaMesa(espada);
				break;
			// Copa
			case 2:
				copa = escolheCartaMesa(copa);
				break;
			// Paus
			default:
				paus = escolheCartaMesa(paus);
				break;
			}
			exibeJogadores();
		}
		if(calculaCartas(mesa)>calculaCartas(jogador) && calculaCartas(mesa)<=21) {
			System.out.println("Você perdeu!");
		}
		else
		{
			System.out.println("Você ganhou!");
		}
		}
		else
		{
			System.out.println("Você perdeu!");
		}
	}

	public static void exibeJogadores() {
		System.out.print("Cartas do Jogador: ");
		exibeCartasJogador(jogador);

		System.out.print("Cartas da Mesa: ");
		exibeCartasJogador(mesa);
	}

	public static void exibeCartasJogador(List<Integer> cartasjogador) {
		for (Integer carta : cartasjogador) {
			switch (carta) {
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
		System.out.print(" # Total: " + calculaCartas(cartasjogador));
		System.out.println("");
	}

	public static double calculaCartas(List<Integer> cartasjogador) {

		Integer soma = cartasjogador.stream().mapToInt(i -> i.intValue() > 10 ? 10 : i.intValue()).sum();

		return soma;
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
