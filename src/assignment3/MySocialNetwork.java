package assignment3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MySocialNetwork extends MyUndirectedGraph implements A3SocialNetwork {
	
	List<Integer> graph = new LinkedList<Integer>();
	int vertexCount;
	int edgesCount = 0;
	List<Integer> edges[];
	List<Integer> cloneEuler[];
	List<Integer> eulerPath;
	List<List<Integer>> aList;
	List<List<Integer>> cc;
	
	public MySocialNetwork(int vertices) {
		super(vertices);
		vertexCount = vertices;
		edges = new LinkedList[vertices];
		eulerPath = new LinkedList();
		cc = new LinkedList();
		aList = new ArrayList<>(vertices);
		int temp = 0;
		while (temp < vertices) {
			edges[temp] = new LinkedList();
			cc.add(new LinkedList<Integer>());
			aList.add(new LinkedList<>());
			temp++;
		}
	}
	public void addVertex(int vertex) {
		if (graph.size() == 0) {
			graph.add(vertex);
		} else if (graph.size() == vertexCount) {
			System.err.println("Max amount of vertices reached!");
		} else if (graph.get(vertex - 1) > vertex && (graph.get(vertex - 1) + 1) < vertex) {
			System.err.println("The list must be sequential!");
		} else {
			graph.add(vertex);
		}

	}
	
	public void addEdge(int sourceVertex, int targetVertex) {
		edges[sourceVertex].add(targetVertex);
		edges[targetVertex].add(sourceVertex);
		aList.get(sourceVertex).add(targetVertex);
		aList.get(targetVertex).add(sourceVertex);
	}

	@Override
    public int numberOfPeopleAtFriendshipDistance(int vertexIndex, int distance) {
	int friendsAtDistance = 0;
	if(distance == 0) {
		return vertexIndex;
	}
	else if(edges[vertexIndex].size() == 0) {
		System.err.println("This friend has no friends! :(");
	}
	else if (distance > 0){
		for (int i = 0; i < distance; i++) {
				System.out.println(edges[vertexIndex]);
		}
	 }
	return 0;
	}
	

    @Override
    public int furthestDistanceInFriendshipRelationships(int vertexIndex) {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public List<Integer> possibleFriends(int vertexIndex) {
	
	return null;
    }

}
