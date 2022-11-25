class Program {

  public boolean cycleInGraph(int[][] edges) {
    Graph graph = new Graph();
    graph.loopEdges(edges);
    return graph.hasCycle;
  }
}

class Graph {
  HashSet<Integer> currPath;
  boolean hasCycle;

  Graph(){
    this.currPath = new HashSet<Integer>();
    this.hasCycle = false;
  }


  public void loopEdges(int[][] edges){
    for(int i = 0; i < edges.length; i++){findCycle(edges, i);}
  }
  
  public void findCycle(int[][] edges, int currNode){
    if(this.hasCycle) return;
    if(this.currPath.contains((Integer) currNode)){this.hasCycle = true; return;}
    
    int[] currNodeEdges = edges[currNode];
    this.currPath.add((Integer) currNode);

    for(int node: currNodeEdges){findCycle(edges, node);}

    this.currPath.remove((Integer) currNode);
  }
}
