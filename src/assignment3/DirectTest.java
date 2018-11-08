package assignment3;

import java.util.Arrays;
import java.util.List;

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
		
		MySocialNetwork msn = new MySocialNetwork(15);
		/*Note, the vertexes and edges of this graph are from the example in exercise 3, however each
		 * number is decreased by one so 4 in here means 5 on the example. */
		msn.addVertex(0);
		msn.addVertex(1);
		msn.addVertex(2);
		msn.addVertex(3);
		msn.addVertex(4);
		msn.addVertex(5);
		msn.addVertex(6);
		msn.addVertex(7);
		msn.addVertex(8);
		msn.addVertex(9);
		msn.addVertex(10);
		msn.addVertex(11);
		msn.addVertex(12);
		msn.addVertex(13);
		msn.addVertex(14);
		msn.addEdge(0, 1);
		msn.addEdge(0, 2);
		msn.addEdge(1, 2);
		msn.addEdge(2, 3);
		msn.addEdge(0, 3);
		msn.addEdge(1, 3);
		msn.addEdge(2, 12);
		msn.addEdge(2, 5);
		msn.addEdge(5, 13);
		msn.addEdge(5, 4);
		msn.addEdge(3, 4);
		msn.addEdge(1, 4);
		msn.addEdge(0, 4);
		msn.addEdge(4, 14);
		msn.addEdge(4, 11);
		msn.addEdge(4, 8);
		msn.addEdge(4, 7);
		msn.addEdge(4, 6);
		msn.addEdge(6, 10);
		msn.addEdge(6, 9);
		msn.addEdge(7, 9);
		msn.addEdge(8, 9);
		System.out.println(msn.numberOfPeopleAtFriendshipDistance(4, 2));
		System.out.println("Furthest from " + 4  + " = " + msn.furthestDistanceInFriendshipRelationships(4));
		List<Integer> possibleFriends = msn.possibleFriends(4);
		System.out.print("Possible friends of " + 4 + ": ");
		for(int i = 0; i < possibleFriends.size(); i++) {
			System.out.print(possibleFriends.get(i));
			System.out.print(" ");
		}

	}

}
