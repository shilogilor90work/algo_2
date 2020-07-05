// Java program to print connected components in
// an undirected graph
import java.util.LinkedList;
import java.util.Queue;
class Graph {
    // A user define class to represent a graph.
    // A graph is an array of adjacency lists.
    // Size of array will be V (number of vertices
    // in graph)
    int V;
    LinkedList<Integer>[] adjListArray;
    int connected_size;
    // constructor
    Graph(int V) {
        this.V = V;
        // define the size of array as
        // number of vertices
        adjListArray = new LinkedList[V];

        // Create a new list for each vertex
        // such that adjacent nodes can be stored

        for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList<Integer>();
        }
    }

    // Adds an edge to an undirected graph
    void addEdge( int src, int dest) {
        // Add an edge from src to dest.
        adjListArray[src].add(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        adjListArray[dest].add(src);
    }

    void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        connected_size++;
        // Recur for all the vertices
        // adjacent to this vertex
        for (int x : adjListArray[v]) {
            if(!visited[x]) DFSUtil(x,visited);
        }

    }
    void connectedComponents() {
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        for(int v = 0; v < V; ++v) {
          connected_size = 0;
            if(!visited[v]) {
                // go through all reachable vertices
                // from v
                DFSUtil(v,visited);
                System.out.println(connected_size);
            }
        }
    }


}
class connected_components
{
  // Driver program to test above
  public static void main(String[] args){
      // Create a graph given in the above diagram
      Graph g = new Graph(8); // 8 vertices numbered from 0 to 7

      g.addEdge(1, 2);
      g.addEdge(1, 3);
      g.addEdge(1, 4);
      g.addEdge(2, 3);
      g.addEdge(3, 4);
      g.addEdge(5, 6);
      g.addEdge(5, 7);
      g.addEdge(6, 7);


      System.out.println("Following are connected components");
      g.connectedComponents();

  }
}
