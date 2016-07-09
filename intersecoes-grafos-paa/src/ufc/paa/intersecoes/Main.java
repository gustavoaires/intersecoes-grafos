package ufc.paa.intersecoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		int m = 0, n = 0, v = 0, w = 0, p = 0;
		n = e.nextInt();
		m = e.nextInt();
		//os labels dos vertices comecam de 1
		ArrayList<ArrayList<Integer>> grafo = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i <= n; i++)
			grafo.get(i).add(null);

		for (int i = 1; i <= m; i++) {
			v = e.nextInt();
			w = e.nextInt();
			p = e.nextInt();
			//caso p seja 1, somente essa linha sera executada (tem uma aresta de v para w)
			if (grafo.get(v) != null) {
				grafo.get(v).add(w);
			} else {
				ArrayList<Integer> a = new ArrayList<Integer>();
				a.add(w);
				grafo.add(v,a);
			}
			//se a entrada de p for 2, havera aresta de ida e volta (o if contempla isso)
			if (p == 2) {
				if (grafo.get(w) != null) {
					grafo.get(w).add(v);
				} else {
					ArrayList<Integer> a = new ArrayList<Integer>();
					a.add(v);
					grafo.add(w,a);
				}
			}
		}
		System.out.println(/*nome do metodo mapeamento intersecoes*/);
		e.close();
	}
}
