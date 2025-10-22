import java.util.Iterator;

public interface Graph<V, E> {
    /** Returns teh number of vertices of the graph */
    public int numVertices();

    /** Returns an iterable of all the vertices of the graph */
    Iterable<Vertex<V>> vertices();

    /** Returns teh number of edges of the graph */
     int numEdges();

     /** Returns an iterable of all the edges of the graph */
     Iterable<Edge<E>> edges();

    /** Returns the edge from vertex u to verex v, if one exists;
     * else returns null. For an undirected graph there is no difference between getEdge(u, x) and getEdge(x, u)
     */
    Edge<E> getEdge(Vertex<V> v, Vertex<V> u);

    /** Returns an array containing the two endPoint vertices of edge e.
     * if the graph is directed the first vertex is the origin and the second is
     * the destination
     */
    Vertex<V>[] endVertices(Edge<E> e);

    /** For edge e incident to vertex v, returns the other vertex of
     * the edge; an error occurs if e is not incident to v
     */
    Vertex<V> opposite(Vertex<V> v, Edge<E> e);

    /**
     * Returns an iteration of all outgoing edges from vertex v
     */
    Iterable<Edge<E>> outGoingEdges(Vertex<V> v);

    /**
     * Returns an iteration of all incoming edges to vertex v.
     * for an undirected graph this returns the same collection as outgoing Edges
     */
    Iterable<Edge<E>> incomingEdges(Vertex<V> v);

    /**
     * Creates and returns a new vertex storing element x
     */
    Vertex<V> insertVertex(V elem);

    /**
     * Creates and returns a new Edge from vertex u to vertx v,
     * storing element x; an error occurs if there already exists an edge from
     * u to v
     */
    Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E elem);

    /**
     * Removes vertex v and all its incident edges from the graph
     */
    void removeVertex(Vertex<V> v);

    /** Removes edge e from the graph */
    void removeEdge(Edge<E> e);
}
