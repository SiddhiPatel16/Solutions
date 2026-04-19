import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        
        boolean[] visited = new boolean[n];

       
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while(!stack.isEmpty()){
            int node = stack.pop();

            if(node == destination)
                return true;

            if(!visited[node]){
                visited[node] = true;

                for(int neighbor : graph.get(node)){
                    stack.push(neighbor);
                }
            }
        }

        return false;
    }
}