package ufc.paa.intersecoes;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		int m = 0, n = 0, v = 0, w = 0, p = 0;
		n = e.nextInt();
		m = e.nextInt();
		//os labels dos vertices comecam de 1
		int grafo[][] =  new int[n+1][n+1];

		for (int i = 1; i <= m; i++) {
			v = e.nextInt();
			w = e.nextInt();
			p = e.nextInt();
			//caso p seja 1, somente essa linha sera executada (tem uma aresta de v para w)
			grafo[v][w] = 1;
			//se a entrada de p for 2, havera aresta de ida e volta (o if contempla isso)
			if (p == 2)
				grafo[w][v] = 1;
		}
		System.out.println(/*nome do metodo mapeamento intersecoes*/);
		e.close();
	}
}
