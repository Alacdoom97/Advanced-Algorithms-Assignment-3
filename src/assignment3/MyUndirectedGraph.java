package assignment3;

import java.util.*;

public class MyUndirectedGraph implements A3Graph {

	List<Integer> graph = new LinkedList<Integer>();
	int vertexCount;
	int edgesCount = 0;
	List<Integer> edges[];
	List<Integer> cloneEuler[];
	List<Integer> eulerPath;
	List<List<Integer>> aList;
	List<List<Integer>> cc;

	public MyUndirectedGraph(int vertices) {
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
		Boolean visited[] = new Boolean[vertexCount];
		int i = 0;
		while (i < vertexCount) {
			visited[i] = false;
		}

		for (i = 0; i < vertexCount; i++) {
			if (edges[i].size() != 0) {
				break;
			}
		}

		if (i == vertexCount) {
			return true;
		}

		visitCheck(i, visited);
		for (i = 0; i < vertexCount; i++) {
			if (visited[i] == false && edges[i].size() > 0) {
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
		int level = 0;

		Boolean visited[] = new Boolean[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			visited[i] = false;
		}

		for (int i = 0; i < vertexCount; i++) {
			if (visited[i] == false) {
				visitCheckLevel(i, visited, level);
				level++;
			}
		}
		return null;
	}

	private void visitCheckLevel(int vertex, Boolean visited[], int level) {
		visited[vertex] = true;
		int n;
		Iterator<Integer> it = edges[vertex].iterator();
		while (it.hasNext()) {
			n = it.next();
			if (!visited[n]) {
				cc.get(level).add(n);
				visitCheckLevel(n, visited, level);
			}
		}
	}

	private void visitCheck(int vertex, Boolean visited[]) {
		visited[vertex] = true;
		int n;
		Iterator<Integer> it = edges[vertex].iterator();
		while (it.hasNext()) {
			n = it.next();
			if (!visited[n]) {
				visitCheck(n, visited);
			}
		}
	}

	@Override
	public boolean hasEulerPath() {
		if (isConnected() == false) {
			return false;
		}
		int oddCount = 0;
		for (int i = 0; i < vertexCount; i++) {
			if (edges[i].size() % 2 != 0) {
				oddCount++;
			}
		}

		if (oddCount > 2) {
			return false;
		} else if (oddCount == 2) {
			return false;
		}

		return true;
	}

	@Override
	public List<Integer> eulerPath() {
		cloneEuler = edges.clone();

		Integer u = 0;
		for (int i = 0; i < vertexCount; i++) {
			if (cloneEuler[i].size() % 2 == 1) {
				u = i;
				break;
			}
		}

		
		addEulerVertex(u);
		return eulerPath;
	}

	private void addEulerVertex(Integer vertex) {
		
		for (int i = 0; i < cloneEuler[vertex].size(); i++) {
			Integer edge = cloneEuler[vertex].get(i);
			if (nextEdge(vertex, edge)) {
				eulerPath.add(vertex);
				removeEdge(vertex, edge);
				addEulerVertex(edge);
			}
		}
	}
	
	private void removeEdge(int source, int target) {
		cloneEuler[source].remove(target); 
        cloneEuler[source].remove(target); 
	}
	
	private boolean nextEdge(int source, int target) {
		if (cloneEuler[source].size() == 1) {
			return true;
		}
		
		boolean[] visited = new boolean[vertexCount]; 
        int count1 = search(source, visited);  
        removeEdge(source, target); 
        visited = new boolean[vertexCount]; 
        int count2 = search(source, visited);  
        addEdgeBack(source, target);
        if (count1 > count2) {
        	return false;
        }
		return false; 
	}
	
	private int search(int vertex, boolean visited[]) {
		visited[vertex] = true; 
        int count = 1; 
        for (int adj : cloneEuler[vertex]) 
        { 
            if (!visited[adj]) 
            { 
                count = count + search(adj, visited); 
            } 
        } 
        return count; 
	}
	
	private void addEdgeBack(int source, int target) {
		cloneEuler[source].add(target);
		cloneEuler[target].add(source);
	}
}
