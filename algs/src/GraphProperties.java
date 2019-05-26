
import edu.princeton.cs.algs4.*;

public class GraphProperties
{
	private int[] eccentricity;
	private int diameter;
	private int radius;
	private int center;
	
	GraphProperties(Graph G) {
		int V = G.V();
		eccentricity = new int[V];
		int[] distTo = new int[V];
		
		for (int c = 0; c < V; c++) {
			for (int i = 0; i < V; i++) distTo[i] = -1;
			Queue<Integer> queue = new Queue<Integer>();
			queue.enqueue(c);
			distTo[c] = 0;
			while (!queue.isEmpty()) {
				int v = queue.dequeue();				
				for (int w : G.adj(v))
					if (distTo[w] == -1) {
						queue.enqueue(w);
						distTo[w] = distTo[v] + 1;
					}
				if (queue.isEmpty()) eccentricity[c] = distTo[v];
			}
			
		}
		diameter = eccentricity[0];
		radius = eccentricity[0];
		center = 0;
		for (int c = 1; c < V; c++) {
			if (diameter < eccentricity[c]) diameter = eccentricity[c];
			if (radius > eccentricity[c]) {
				radius = eccentricity[c];
				center = c;
			}
		}
	}
	
	int eccentricity(int v) { return eccentricity[v]; }
	
	int diameter() { return diameter; }
	
	int radius() { return radius; }
	
	int center() { return center; }

}
