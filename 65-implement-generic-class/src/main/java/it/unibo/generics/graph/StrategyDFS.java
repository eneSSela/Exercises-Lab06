package it.unibo.generics.graph;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.StrategyExploration;

import java.util.*;

public class StrategyDFS<N> implements StrategyExploration<N> {

    @Override
    public List<N> computePath(Graph<N> graph, N source, N target) {
        
        if (source == null || target == null) {
            return Collections.emptyList();
        }
        
        List<N> path = new ArrayList<>();
        Set<N> visited = new HashSet<>();
        
        if (dfs(graph, source, target, path, visited)) {
            return path;
        }
        
        return Collections.emptyList();
    }

    
    /*Metodo Ricorsivo DFS*/
    private boolean dfs(Graph<N> graph, N current, N target, List<N> path, Set<N> visited) {
        
        visited.add(current);
        path.add(current);

        if (current.equals(target)) {
            return true;
        }
        
        for (N neighbor : graph.linkedNodes(current)) {
            if (!visited.contains(neighbor)) {
                if (dfs(graph, neighbor, target, path, visited)) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }
}