package assignment3;

import java.util.*;

public class MyUndirectedGraph implements A3Graph {

	List<Integer> graph = new LinkedList<Integer>();
	int vertexCount;
	int edgesCount = 0;
	List<Integer> edges[];
	List<List<Integer>> aList;
	List<List<Integer>> cc;

	public MyUndirectedGraph(int vertices) {
		vertexCount = vertices;
		edges = new LinkedList[vertices];
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

	@Override
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

	@Override
	public void addEdge(int sourceVertex, int targetVertex) {
		edges[sourceVertex].add(targetVertex);
		edges[targetVertex].add(sourceVertex);
		aList.get(sourceVertex).add(targetVertex);
		aList.get(targetVertex).add(sourceVertex);
	}

	@Override
	public boolean isConnected() {
		for (int i = 0; i < vertexCount; i++) {
			if (!edges[i].isEmpty()) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isAcyclic() {

		Boolean visited[] = new Boolean[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			visited[i] = false;
		}
		for (int temp = 0; temp < vertexCount; temp++) {
			if (visited[temp] == false) {
				if (hasCycle(temp, visited, -1)) {
					return false;
				}
			}
		}
		return true;
	}

	public Boolean hasCycle(int vertex, Boolean v[], int top) {
		v[vertex] = true;
		Integer temp;

		Iterator<Integer> it = edges[vertex].iterator();
		while (it.hasNext()) {
			temp = it.next();

			if (v[temp] == false) {
				if (hasCycle(temp, v, vertex)) {
					return true;
				}
			} else if (temp != top) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<List<Integer>> connectedComponents() {
		for (int i = 0; i < vertexCount; i+=2) {
			int status = 0;
			for (int j = status; j < vertexCount; j++) {
				if (!edges[j].isEmpty()) {
					cc.get(i).add(graph.get(j));
				}
				else if() {
					
				}
				else {
					cc.get(i+1).add(graph.get(j));
					status = j;
					break;
				}
			}
		}
		return null;
	}

	@Override
	public boolean hasEulerPath() {
		// TODO Auto-generated method stub
		return A3Graph.super.hasEulerPath();
	}

	@Override
	public List<Integer> eulerPath() {
		// TODO Auto-generated method stub
		return A3Graph.super.eulerPath();
	}

}
