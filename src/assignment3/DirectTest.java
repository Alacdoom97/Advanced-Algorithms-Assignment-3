package assignment3;

public class DirectTest {

	public static void main(String[] args) {
		MyDirectedGraph mdg = new MyDirectedGraph(3);
		mdg.addVertex(0);
		mdg.addVertex(1);
		mdg.addVertex(2);
		mdg.addEdge(0, 1);
		mdg.addEdge(1, 2);
		mdg.addEdge(2, 0);
		if (mdg.isAcyclic() == true) {
			System.out.println("Graph is ACYCLIC");

		} else {
			System.out.println("Graph does contain cycle");
		}
		
		MyDirectedGraph mdg2 = new MyDirectedGraph(3);
		mdg2.addVertex(0);
		mdg2.addVertex(1);
		mdg2.addVertex(2);
		mdg2.addEdge(0, 1);
		mdg2.addEdge(0, 2);
		if (mdg2.isAcyclic() == true) {
			System.out.println("Graph 2 is ACYCLIC");

		} else {
			System.out.println("Graph 2 does contain cycle");
		}

	}

}
