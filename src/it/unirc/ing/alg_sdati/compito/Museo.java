package it.unirc.ing.alg_sdati.compito;

import java.util.LinkedList;




import java.util.ListIterator;

import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.shortestpath.DijkstraDistance;
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

	public void m1(Sala s1, Sala s2, int c)
	{
		Corridoio corr = new Corridoio(1,c);

		if(!g.containsEdge(corr))
			g.addEdge(corr, s1, s2);
	}


	public LinkedList<Sala> m2(int k, int l, int v)
	{
		LinkedList<Sala> saleList = new LinkedList<Sala>();
		LinkedList<Sala> saleList2 = new LinkedList<Sala>();


		for(Sala s: g.getVertices())
			if(s.isAudioGuida()&&s.numOperePrestito(v)<=k&&s.numDonneLingue()>l)
				saleList.add(s);

		for(Sala s: g.getVertices())
		{
			int c=0;
			for(Sala sAd:saleList)
			{

				UnweightedShortestPath<Sala,Corridoio> sup = new UnweightedShortestPath<Sala,Corridoio>(g);
				if(sup.getDistance(s, sAd)!=null&&!s.equals(sAd))
					c++;
			}
			if(c>=3)
				saleList2.add(s);
		}
		return saleList;
	}

	public LinkedList<Opera> m3 (LinkedList<Sala> salaList, int m)
	{
		LinkedList<Opera> opList = new LinkedList<Opera>();

		boolean found = false;
		for(Sala sal1: g.getVertices())
		{
			for(Sala sal2: salaList)
			{
				if(sal1.equals(sal2))
					found=true;
			}
			if(!found)
			{
				for(Opera op: sal1.getOpList())
				{
					if(!op.isPrestito()&&op.getEtaStimata()>=m)
						opList.add(op);
				}
			}
		}
		return opList;

	}

	public int sicurezza (Sala s1, Sala s2, LinkedList<Sala> L, int k)
	{
		for(Sala sala: L)
			g.removeVertex(sala);

		LinkedList<Sala> salaList = new LinkedList<Sala>();
		ListIterator<Sala> iterator = salaList.listIterator();

		while(iterator.hasNext())
		{
			Sala sala= iterator.next();
			for(Dipendente d: sala.getDipList())
				if(d.getNumAnniServizio()<5&&d.getQualifica().equals("sorveglianza"))
					g.removeVertex(sala);
		}

		LinkedList<Corridoio> corrList = new LinkedList<Corridoio>();
		ListIterator<Corridoio> iterator2 = corrList.listIterator();

		while(iterator2.hasNext())
		{
			Corridoio c = iterator2.next();
			if(c.getCapacita()<k)
				g.removeEdge(c);
		}


		Transformer<Corridoio, Integer> wtTransformer = new Transformer<Corridoio, Integer>() {
			public Integer transform(Corridoio link) {
				return link.getCapacita();
			}
		};
		
		PrimMinimumSpanningTree<Sala, Corridoio> mst = 
				new PrimMinimumSpanningTree<Sala, Corridoio>( UndirectedSparseGraph.<Sala, Corridoio>getFactory() );
		DijkstraDistance<Sala, Corridoio> dd= new DijkstraDistance<Sala, Corridoio>(g,wtTransformer);
		Number dist = dd.getDistance(s1, s2);
		return dist.intValue();
	}

}
