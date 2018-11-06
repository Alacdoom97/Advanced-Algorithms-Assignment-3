package assignment3;

import java.util.*;
import java.util.LinkedList;
import java.util.List;

public class MyDirectedGraph implements A3Graph {

    List<Integer> graph = new LinkedList<Integer>();
    int vertexCount;
    int edgesCount = 0;
    List<Integer> edges[];
    List<List<Integer>> aList;
    List<List<Integer>> cc;

    public MyDirectedGraph(int vertices)
    {
        vertexCount = vertices;
        edges = new LinkedList[vertices];
        cc = new LinkedList();
        aList = new ArrayList<>(vertices);
        int temp = 0;
        while(temp < vertices)
        {
            edges[temp] = new LinkedList();
            cc.add(new LinkedList<Integer>());
            aList.add(new LinkedList<>());
            temp++;
        } 
    }

    @Override
    public void addVertex(int vertex)
    {
    	if (graph.size() == 0) {
    		graph.add(vertex);
    	}
        else if (graph.size() == vertexCount)
        {
            System.err.println("Max amount of vertices reached!");
        }
        else if (graph.get(vertex-1) > vertex && (graph.get(vertex -1)+1) < vertex)
        {
            System.err.println("The list must be sequential!");
        }
        else
        {
            graph.add(vertex);
        }
    }

    @Override
    public void addEdge(int sourceVertex, int targetVertex)
    {
        edges[sourceVertex].add(targetVertex);
        aList.get(sourceVertex).add(targetVertex);
    }

    @Override
    public boolean isConnected() {

        Boolean visited[] = new Boolean[vertexCount];
        for (int i = 0; i < vertexCount; i++)
        {
            visited[i] = false;
        }
        visitCheck(0, visited);
        for (int i = 0; i < vertexCount; i++)
        {
            if (visited[i] == false)
            {
                return false;
            }
        }
        MyDirectedGraph mdg = reverse();  // Reverses the edges order
        for (int i = 0; i < vertexCount; i++)
        {
            visited[i] = false;
        }
        mdg.visitCheck(0, visited);
        for (int i = 0; i < vertexCount; i++)
        {
            if (visited[i] == false)
            {
                return false;
            }
        }
        return true;
    }

    private MyDirectedGraph reverse()
    {
        MyDirectedGraph mdg = new MyDirectedGraph(vertexCount);
        for (int v = 0; v < vertexCount; v++)
        {
            Iterator<Integer> i = edges[v].listIterator();
            while (i.hasNext())
                mdg.edges[i.next()].add(v);
        }
        return mdg;
    }

    private void visitCheck(int vertex, Boolean visited[])
    {
        visited[vertex] = true;
        int n;
        Iterator<Integer> it = edges[vertex].iterator();
        while (it.hasNext())
        {
            n = it.next();
            if (!visited[n])
            {
                visitCheck(n, visited);
            }
        }
    }

    @Override
    public boolean isAcyclic()
    {
        boolean[] visited = new boolean[vertexCount]; 
        boolean[] recStack = new boolean[vertexCount]; 
           
        for (int i = 0; i < vertexCount; i++) {
            if (hasCycle(i, visited, recStack)) {
                return false; 
            }
        }
        return true; 
    }

    private boolean hasCycle(int i, boolean[] visited, boolean[] recursion)
    {
        if (recursion[i]) {
            return true; 
        }
  
        if (visited[i]) {
            return false;
        }
              
        visited[i] = true; 
  
        recursion[i] = true; 
        List<Integer> children = aList.get(i); 
          
        for (Integer c: children) {
            if (hasCycle(c, visited, recursion)) {
                return true; 
            }
        }
                  
        recursion[i] = false; 
  
        return false; 
    }

    private void organize(int vertex, Boolean visited[], Stack s)
    {
        visited[vertex] = true;
        Iterator<Integer> i = edges[vertex].iterator();
        while(i.hasNext())
        {
            int j = i.next();
            if(visited[j] == false)
            {
                organize(j, visited, s);
            }
        }
        s.push(new Integer(vertex));
    }

    @Override
    public List<List<Integer>> connectedComponents()
    {
        Stack s = new Stack();
        Boolean[] visited = new Boolean[vertexCount];
        for(int i = 0; i < vertexCount; i++)
        {
            visited[i] = false;
        }
        for(int j = 0; j < vertexCount; j++)
        {
            if(visited[j] == false)
            {
                organize(j, visited, s);
            }
        }
        MyDirectedGraph mdg = reverse();
        for(int i = 0; i < vertexCount; i++)
        {
            visited[i] = false;
        }
        int level = 0;
        while(!s.empty())
        {
            int temp = (int) s.pop();
            if(visited[temp] == false)
            {
                mdg.visitCheck(temp, visited);
                cc.get(level).add(temp);
            }
        }
        return cc;
    }
}
