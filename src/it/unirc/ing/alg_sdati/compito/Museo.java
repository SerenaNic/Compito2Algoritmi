package it.unirc.ing.alg_sdati.compito;

import java.util.LinkedList;
import java.util.ListIterator;
import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.Transformer;
import edu.uci.ics.jung.algorithms.shortestpath.PrimMinimumSpanningTree;
import edu.uci.ics.jung.algorithms.shortestpath.UnweightedShortestPath;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedGraph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;

public class Museo {

	private UndirectedGraph<Sala,Corridoio> g;

	public Museo() {
		g = new UndirectedSparseGraph<Sala,Corridoio>();
	}

	public void m1(Sala s1, Sala s2, int c){
		if(!g.findEdge(s1,s2)){
			Corridoio corr = new Corridoio(s1.getNomeSala()+"-"+s2.getNomeSala(),c);
			g.addEdge(corr, s1, s2);
		}
	}


	public LinkedList<Sala> m2(int k, int l, int v){
		LinkedList<Sala> res = new LinkedList<Sala>();
		UnweightedShortestPath<Sala,Corridoio> sup = new UnweightedShortestPath<Sala,Corridoio>(g);

		for(Sala s1: g.getVertices()){
			int c=0;
			for(Sala s2: g.getVertices()){
				if(s2.isAudioGuida()&&s2.numOperePrestito(v)<=k&&s2.numDonneLingue()>l)
					if(sup.getDistance(s1, s2)!=null&&!s1.equals(s2))
						c++;	
			}
			if(c>=3)
				res.add(s1);
		}
		return res;
	}

	public LinkedList<Corridoio> m3(LinkedList<Sala> salaList, int k){
		UndirectedGraph<Sala,Corridoio> g1 = g.clone();
		for(Sala sala: salaList)
			g1.removeVertex(sala);

		Transformer<Corridoio, Integer> wtTransformer = new Transformer<Corridoio, Integer>() {
			public Integer transform(Corridoio link) {
				return link.getCapacita();
			}
		};
		
		PrimMinimumSpanningTree<Sala, Corridoio> pmst = 
				new PrimMinimumSpanningTree<Sala, Corridoio>( UndirectedSparseGraph.<Sala, Corridoio>getFactory(),wtTransformer );
		Graph<Sala,Corridoio> mst = pmst.transform(g1);
		res.addAll(mst.getEdges());
		return res;
	}

}
