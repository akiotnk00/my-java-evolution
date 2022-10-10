package main;

public class DinamicaException {

	public static int resultadoEntreDois(Integer numero1, Integer numero2) throws Exception {

		// Se o primeiro parametro for menor que 0
		if (numero1 < 0) {
			
			// Se o segundo for maior que 10.
			if (numero2 > 10) {
				throw new Exception(
						"O primeiro parametro não pode ser menor que 0 e o segundo parametro não pode ser maior que 10.");
			} else {
				throw new Exception("O primeiro parametro não pode ser menor que 0.");
			}
			
			// Primeiro maior ou igual a 0 e o segundo for maior que 10.
		} else if (numero2 > 10) {
			throw new Exception("O segundo parametro não pode ser maior que 10.");
		} else {
			return Math.max(numero1, numero2) - Math.min(numero1, numero2);
		}
	}

	public static void main(String[] args) {

		// Teste com o primeiro menor que 0.
		try {
			resultadoEntreDois(-1, 5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Teste com o segundo maior que 10.
		try {
			resultadoEntreDois(3, 15);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Teste com o primeiro menor que 0 e o segundo maior que 10.
		try {
			resultadoEntreDois(-4, 12);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Teste com o segundo numero maior que o primeiro.
		try {
			System.out.println(resultadoEntreDois(2, 8));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Teste com o primeiro numero maior que o segundo.
		try {
			System.out.println(resultadoEntreDois(5, 3));
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
