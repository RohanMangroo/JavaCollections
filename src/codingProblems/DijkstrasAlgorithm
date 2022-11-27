class Program {
  public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
    Dijkstra graph = new Dijkstra(start, edges);
    return graph.distances;
  }
}

class Dijkstra {
  int[][][] edges;
  HashSet<Integer> set;
  int[] distances;

  Dijkstra(int start, int[][][] edges){
    this.edges = edges;
    this.set = new HashSet<Integer>();
    this.distances = createDistances(start, edges);

    this.findShortestPath();
    
  }

  private int[] createDistances(int start, int[][][] edges){
    int[] array = new int[edges.length];
    Arrays.fill(array, Integer.MAX_VALUE);
    array[start] = 0;
    return array;
  }

  private void findShortestPath(){
    while(this.set.size() != this.distances.length){
      int currNode = this.findNextNode(); 
      if(this.distances[currNode] == Integer.MAX_VALUE) break;
      
      int[][] outboundEdges = this.edges[currNode];

      for(int[] edge: outboundEdges){
        int node = edge[0];
        int weight = edge[1];
        this.distances[node] = Math.min(this.distances[currNode] + weight, this.distances[node]);
      }
      this.set.add((Integer) currNode);
    }

    for(int i = 0; i < this.distances.length; i++){ if(this.distances[i] == Integer.MAX_VALUE) this.distances[i] = -1;}
  }

  private int findNextNode(){
    int currMin = Integer.MAX_VALUE;
    int idx = 0;
    
    for(int i = 0; i < this.distances.length; i++){
      if(this.set.contains((Integer) i)) continue;
      if(this.distances[i] <= currMin){
        currMin = this.distances[i];
        idx = i;
      }
    }
    return idx;
  }


  
}
