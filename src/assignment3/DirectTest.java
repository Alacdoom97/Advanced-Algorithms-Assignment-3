package assignment3;

public class DirectTest {

	public static void main(String[] args) {
		/*MyDirectedGraph mdg = new MyDirectedGraph(3);
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
		}*/
		
		MySocialNetwork msn = new MySocialNetwork(9);
		msn.addVertex(0);
		msn.addVertex(1);
		msn.addVertex(2);
		msn.addVertex(3);
		msn.addVertex(4);
		msn.addVertex(5);
		msn.addVertex(6);
		msn.addVertex(7);
		msn.addVertex(8);
		msn.addEdge(0, 1);
		msn.addEdge(1, 2);
		msn.addEdge(2, 4);
		msn.addEdge(3, 4);
		msn.addEdge(0, 4);
		msn.addEdge(4, 5);
		msn.addEdge(5, 6);
		msn.addEdge(6, 7);
		msn.addEdge(3, 7);
		msn.addEdge(3, 8);
		msn.numberOfPeopleAtFriendshipDistance(4, 1);

	}

}
