package assignment3;

import java.util.LinkedList;
import java.util.List;

public class MyDirectedGraph implements A3Graph {

	List<Integer> gList = new LinkedList<Integer>();
	int nrOfVert = 0;

	@Override
    public void addVertex(int vertex) {
		if (nrOfVert == 0) {
    	gList.add(vertex);
    	nrOfVert++;
		}
		else if(gList.get(nrOfVert - 1) > vertex) {
			System.err.println("");
		}
		else {
			gList.add(e)
		}

    }

	@Override
	public void addEdge(int sourceVertex, int targetVertex) {
		if (nrOfVert <= 1) {
			System.err.println("Error! There aren't enough vertices for there to be an edge");
		}

	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAcyclic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<List<Integer>> connectedComponents() {
		// TODO Auto-generated method stub
		return null;
	}

}
