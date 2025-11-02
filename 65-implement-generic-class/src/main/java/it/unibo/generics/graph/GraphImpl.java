package it.unibo.generics.graph;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.StrategyExploration;

import java.util.*;

/*Implementazione Generica Grafo*/
public class GraphImpl<N> implements Graph<N> {

    /*Mappa di adiacenza: nodo -> set di nodi collegati*/
    private final Map<N, Set<N>> adjacencyMap;

    /*Strategia di esplorazione*/
    private StrategyExploration<N> strategy;


    public GraphImpl() {
        this.adjacencyMap = new HashMap<>();
    }


    @Override
    public void setStrategy(StrategyExploration<N> strategy) {
        this.strategy = strategy;
    }


    @Override
    public void addNode(N node) {
        if (node != null && !adjacencyMap.containsKey(node)) {
            adjacencyMap.put(node, new HashSet<>());
        }
    }


    @Override
    public void addEdge(N source, N target) {
        
        if (source == null || target == null) {
            return;
        }
        
        addNode(source);
        addNode(target);

        adjacencyMap.get(source).add(target);
    }

    /*Restituisce l'insieme dei nodi*/
    @Override
    public Set<N> nodeSet() {
        return new HashSet<>(adjacencyMap.keySet());
    }

    /*Restituisce i nodi collegati*/
    @Override
    public Set<N> linkedNodes(N node) {
        
        Set<N> neighbors = adjacencyMap.get(node);
        return neighbors != null ? new HashSet<>(neighbors) : new HashSet<>();
    }

    /*Restituisce un percorso dal nodo source al nodo target*/
    @Override
    public List<N> getPath(N source, N target) {
        
        if (strategy == null) {
            throw new IllegalStateException("No exploration strategy set");
        }
        
        return strategy.computePath(this, source, target);
    }
}