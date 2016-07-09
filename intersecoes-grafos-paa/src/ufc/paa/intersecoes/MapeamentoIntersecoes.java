package ufc.paa.intersecoes;

import java.util.LinkedList;
import java.util.Queue;

public class MapeamentoIntersecoes {

	public enum Cor {
		BRANCO, CINZA, PRETO;
	}

	public static int BFS(int n, int grafo[][], int s) {
		Queue<Integer> q = new LinkedList<>();
		Cor cor[] = new Cor[n + 1];
		for (int i = 0; i <= n; i++)
			cor[i] = Cor.BRANCO;
		cor[s] = Cor.CINZA;
		q.add(s);
		int v;

		while (!q.isEmpty()) {
			v = q.remove();
			for (int w = 1; w <= n; w++) {
				if (grafo[v][w] == 1) {
					if (cor[w].equals(Cor.BRANCO)) {
						cor[w] = Cor.CINZA;
						q.add(w);
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
