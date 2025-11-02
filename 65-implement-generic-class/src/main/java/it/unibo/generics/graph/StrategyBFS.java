package it.unibo.generics.graph;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.StrategyExploration;

import java.util.*;

public class StrategyBFS<N> implements StrategyExploration<N> {

    @Override
    public List<N> computePath(Graph<N> graph, N source, N target) {
        
        if (source == null || target == null) { 
            return Collections.emptyList();
        }

        Map<N, N> parentMap = new HashMap<>();
        Queue<N> queue = new LinkedList<>();
        Set<N> visited = new HashSet<>();

        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            
            N current = queue.poll();

            if (current.equals(target)) {
                break;
            }

            for (N neighbor : graph.linkedNodes(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        if (!visited.contains(target)) {
            return Collections.emptyList();
        }

        /*Ricostruzione Percorso*/
        List<N> path = new LinkedList<>();
        
        for (N at = target; at != null; at = parentMap.get(at)) {
            path.add(0, at);
        }
        return path;
    }
}
