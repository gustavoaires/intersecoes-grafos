package ufc.paa.intersecoes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Algoritmo {
	
public static void main(String[] args) {
		
		List<List<Integer>> grafo = new ArrayList<>();
		grafo.add(new ArrayList<>());
		grafo.add(new ArrayList<>());
		grafo.add(new ArrayList<>());
		grafo.add(new ArrayList<>());
		grafo.add(new ArrayList<>());
		
		grafo.get(1).add(2);
		grafo.get(1).add(3);
		grafo.get(1).add(4);
		grafo.get(4).add(2);
		grafo.get(3).add(1);
		grafo.get(3).add(4);
		grafo.get(4).add(1);
		
		System.out.println(temCaminho(grafo));
		
		List<List<Integer>> grafo2 = new ArrayList<>();
		grafo2.add(new ArrayList<>());
		grafo2.add(new ArrayList<>());
		grafo2.add(new ArrayList<>());
		grafo2.add(new ArrayList<>());
		grafo2.add(new ArrayList<>());
		
		grafo2.get(1).add(2);
		grafo2.get(1).add(3);
		grafo2.get(1).add(4);
		grafo2.get(2).add(4);
		grafo2.get(3).add(1);
		grafo2.get(3).add(4);
		grafo2.get(4).add(1);
		
		System.out.println(temCaminho(grafo2));
		
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
