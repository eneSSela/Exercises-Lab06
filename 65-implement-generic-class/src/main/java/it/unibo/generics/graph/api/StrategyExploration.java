package it.unibo.generics.graph.api;

import java.util.List;

/*Interfaccia per le strategie di esplorazione*/
public interface StrategyExploration<N> {

    /*Calcola un percorso dal nodo source al nodo target*/
    List<N> computePath(Graph<N> graph, N source, N target);
}
