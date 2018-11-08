package assignment3;

import java.util.ArrayList;
import java.util.Arrays;
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
	int[] level;

	public MySocialNetwork(int vertices) {
		super(vertices);
		vertexCount = vertices;
		edges = new LinkedList[vertices];
		eulerPath = new LinkedList();
		cc = new LinkedList();
		aList = new ArrayList<>(vertices);
		level = new int[vertexCount];
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
		DFS(vertexIndex);
		for (int i = 0; i < level.length; i++) {
			if (level[i] == distance) {
				friendsAtDistance++;
			}
		}
		return friendsAtDistance;
	}

	private void DFS(int me) {
		boolean[] visited = new boolean[vertexCount];
		boolean[] recStack = new boolean[vertexCount];
		level = new int[vertexCount];
		int depth = 0;

		hasCycle(me, visited, recStack, depth, level);

	}

	private void hasCycle(int i, boolean[] visited, boolean[] recursion, int depth, int[] level) {
		if (recursion[i]) {
			return;
		}

		if (visited[i]) {
			if (level[i] > depth) {
			} else {
				return;
			}
		}

		visited[i] = true;
		level[i] = depth;

		recursion[i] = true;
		List<Integer> children = aList.get(i);

		for (Integer c : children) {
			hasCycle(c, visited, recursion, depth + 1, level);
		}

		recursion[i] = false;

		return;
	}

	@Override
	public int furthestDistanceInFriendshipRelationships(int vertexIndex) {
		int furthest = 0;
		DFS(vertexIndex);
		for (int i = 0; i < level.length; i++) {
			if (level[i] > furthest) {
				furthest = level[i];
			}
		}
		return furthest;
	}

	@Override
	public List<Integer> possibleFriends(int vertexIndex) {
		return DFSPossible(vertexIndex);
	}

	private List<Integer> DFSPossible(int me) {
		boolean[] visited = new boolean[vertexCount];
		boolean[] recStack = new boolean[vertexCount];
		int[] sameFriends;
		level = new int[vertexCount];
		int depth = 0;

		hasCycle(me, visited, recStack, depth, level);
		List<Integer> l2Friends = new ArrayList<Integer>();
		for (int i = 0; i < level.length; i++) {
			if (level[i] == 2) {
				l2Friends.add(i);
			}

		}
		for (int i = 0; i < l2Friends.size(); i++) {
			if (aList.get(l2Friends.get(i)).size() < 3) {
				l2Friends.remove(i);
			}
		}
		sameFriends = new int[l2Friends.size()];
		for (int i = 0; i < l2Friends.size(); i++) {
			List<Integer> children = edges[l2Friends.get(i)];
			for (Integer c : children) {
				if (edges[me].contains(c)) {
					System.out.println(edges[me].contains(c));
					sameFriends[i]++;
				}
			}
			System.out.println(Arrays.toString(sameFriends));
			for(int j = 0; j < sameFriends.length; j++) {
				if(sameFriends[j] < 3) {
					l2Friends.remove(i);
				}
			}
		}
		return l2Friends;
	}

}
