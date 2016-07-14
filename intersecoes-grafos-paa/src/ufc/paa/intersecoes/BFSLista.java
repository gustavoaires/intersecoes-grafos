package ufc.paa.intersecoes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author gustavo aires matos
 * @author eduardo lopes silva
 * Todos os comentarios de explicacao desta classe se aplicam para a classe BFSMatriz
 * A unica diferenca é que em BFSMatriz usa matriz no lugar da lista de adjacencia
 */
public class BFSLista {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		/**
		 * @variable m representa a quantidade de arestas
		 * @variable n representa a quantidade de vertices
		 * @variable v representa o primeiro vertice lido na linha
		 * @variable w representa o segundo vertice lido na linha
		 * @variable p representa o peso da aresta
		 * @variable grafo representa as relacoes (arestas) entre os vertices e os vertices
		 */
		int m = 0, n = 0, v = 0, w = 0, p = 0;
		n = e.nextInt();
		m = e.nextInt();
	
		// Inicializando o grafo
		List<List<Integer>> grafo = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			grafo.add(new ArrayList<>());
		
		/**
		 * O grafo é repesentado de forma bidirecional
		 * Sempre que p for 2, v é adicionado na lista de w e w é adicionado na lista de v
		 * Caso p = 1, a aresta é adicionada de v para w
		 */
		for (int i = 1; i <= m; i++) {
			// primeiro vertice
			v = e.nextInt();
			// segundo vertice
			w = e.nextInt();
			// o peso (1 ou 2) decide se há duas arestas ou uma entre v e w
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

	/**
	 * @param grafo representa as relacoes (arestas) entre os vertices e os vertices
	 * @return 1 se de algum vertice inicial tem caminho para todos os outros vertices, 0 cc
	 */
	public static int temCaminho(List<List<Integer>> grafo) {
		// O loop repete até não existir caminho partindo de um vertice i
		for (int i = 1; i < grafo.size(); i++)
			if (bfs(grafo, i) == false)
				return 0;
		return 1;
	}
	
	/**
	 * @param grafo representa as relacoes (arestas) entre os vertices e os vertices
	 * @param s representa o vertice inicial
	 * @return false se algum vertice nao esta preto e true cc
	 */
	public static boolean bfs(List<List<Integer>> grafo, int s) {
		/**
		 * @variable fila guarda os proximos vertices a serem visitados
		 * @variable cor vetor com o estado do vertice (1=nao visitado, 2=visitado e vizinhos nao, 3=visitado e vizinhos tambem)
		 */
		Queue<Integer> fila = new LinkedList<>();
		Cor[] cor = new Cor[grafo.size()];
		// Inicializando o vetor de cores
		for(int i = 1; i < grafo.size(); i++)
			cor[i] = Cor.BRANCO;
		cor[s] = Cor.CINZA;
		fila.add(s);
		/**
		 *  O loop repete até que a fila esteja vazia
		 *  Deve-se remover o primeiro da fila, pois eh o primeiro que deve ser visitado (comeca do vertice s)
		 *  Para todos os adjacentes do vertice removido da fila, deve-se adiciona-los a fila caso nao visitados
		 *  Depois de verificar todos os adjacentes marca-se o vertice removido da fila como visitado e com seus vizinhos checados (PRETO) 
		 */
		while (!fila.isEmpty()) {
			int u = fila.poll();
			for (int w : grafo.get(u)) {
				if (cor[w] == Cor.BRANCO) {
					cor[w] = Cor.CINZA;
					fila.add(w);
				}
			}
			cor[u] = Cor.PRETO;
		}
		
		/**
		 * Necessario verificar se todos os vertices estao pretos
		 * @return true se todos preto, false se algum nao preto
		 */
		for (int i = 1; i < grafo.size(); i++)
			if(cor[i] != Cor.PRETO)
				return false;
		return true;
	}
	
}
