package ufc.paa.intersecoes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSMatriz {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		int m = 0, n = 0, v = 0, w = 0, p = 0;
		n = e.nextInt();
		m = e.nextInt();
		// os labels dos vertices comecam de 1
		int grafo[][] = new int[n + 1][n + 1];
		
		for (int i = 1; i <= m; i++) {
			v = e.nextInt();
			w = e.nextInt();
			p = e.nextInt();
			// caso p seja 1, somente essa linha sera executada (tem uma aresta de v para w)
			grafo[v][w] = 1;
			// se a entrada de p for 2, havera aresta de ida e volta (o if contempla isso)
			if (p == 2)
				grafo[w][v] = 1;
		}
		
		int temCaminhoParaTodo = 1;
		for (int i = 1; i <= n; i++) {
			temCaminhoParaTodo = bfs(n, grafo, i);
			if (temCaminhoParaTodo == 0)
				break;
		}
		System.out.println(temCaminhoParaTodo);
		e.close();
	}
	
	public enum Cor {
		BRANCO, CINZA, PRETO;
	}

	public static int bfs(int n, int grafo[][], int s) {
		Queue<Integer> fila = new LinkedList<>();
		Cor cor[] = new Cor[n + 1];
		for (int i = 0; i <= n; i++)
			cor[i] = Cor.BRANCO;
		cor[s] = Cor.CINZA;
		fila.add(s);
		int v;

		while (!fila.isEmpty()) {
			v = fila.remove();
			for (int w = 1; w <= n; w++) {
				if (grafo[v][w] == 1) {
					if (cor[w].equals(Cor.BRANCO)) {
						cor[w] = Cor.CINZA;
						fila.add(w);
					}
				}
			}
			cor[v] = Cor.PRETO;
		}

		for (int i = 1; i <= n; i++)
			if (!cor[i].equals(Cor.PRETO))
				return 0;
		return 1;
	}
}
