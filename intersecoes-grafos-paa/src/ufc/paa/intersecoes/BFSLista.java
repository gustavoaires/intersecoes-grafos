package ufc.paa.intersecoes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFSLista {
	
public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		int m = 0, n = 0, v = 0, w = 0, p = 0;
		n = e.nextInt();
		m = e.nextInt();
	
		List<List<Integer>> grafo = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			grafo.add(new ArrayList<>());
		for (int i = 1; i <= m; i++) {
			v = e.nextInt();
			w = e.nextInt();
			p = e.nextInt();
			// caso p seja 1, somente essa linha sera executada (tem uma aresta de v para w)
			grafo.get(v).add(w);
			// se a entrada de p for 2, havera aresta de ida e volta (o if contempla isso)
			if (p == 2)
				grafo.get(w).add(v);
		}
		
		System.out.println(temCaminho(grafo));
		e.close();
		
	}

	public static int temCaminho(List<List<Integer>> grafo){
		
		for(int i = 1; i<grafo.size(); i++){
			if(bfs(grafo, i) == false){
				return 0;
			}
		}
		return 1;
	}
	
	public static boolean bfs(List<List<Integer>> grafo, int s){
		Queue<Integer> fila = new LinkedList<>();
		
		int[] cor = new int[grafo.size()];
		for(int i = 1; i<grafo.size(); i++){
			cor[i] =1;
		}
		cor[s] = 2;
		fila.add(s);
		
		while(!fila.isEmpty()){
			int u = fila.poll();
			for(int w : grafo.get(u)){
				if(cor[w]==1){
					cor[w]=2;
					fila.add(w);
				}
			}
			cor[u] = 3;
		}
		
		for(int i = 1; i<grafo.size(); i++){
			if(cor[i] != 3)
				return false;
		}
		return true;
	}
	
}
