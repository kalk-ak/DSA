/*
public class AdjacencyMapGraph<V, E> implements Graph<V, E>{
    private class InnerVertex<V> implements Vertex<V> {
        private V element;
        private Position<Vertex<V>> pos;
        private Map<Vertex<V>, Edge<E>> outgoing, incoming;

        */
/** Constructs a new inner vertex instance storing the given element
         * @param elem the element to be stored
         * @param isDirected boolean - condition on wheather the graph is directed or not
         * @returns true if the vertex was added sucessfull or false otherwise
         *//*

        public InnerVertex(V elem, boolean isDirected) {
            element = elem;
            outgoing = new ProbeHashMap<>();
            if (isDirected)
                incoming = new ProbeHashMap<>();
            else
                incoming = outgoing;
        }

        // setters and getters
        */
/**
         * @return the element associated with the vertex
         *//*

        @Override
        public V getElement() {
            return element;
        }
        public void setPosition(Position<Vertex<V>> p) {
            pos = p;
        }
        public void setElement(V element) { this.element = element; }

        */
/** Returns reference to the underlying map of outgoing edges *//*

        public Map<Vertex<V>, Edge<E>> getOutgoing() { return outgoing; }

        */
/** Returns reference to the underlying map of outgoing edges *//*

        public Map<Vertex<V>, Edge<E>> getIncoming() { return incoming; }

        public Position<Vertex<V>> getPos() { return pos; }
    } // --------- end of inner vertex class

    private class InnerEdge<E> implements Edge<E> {
        private E element;
        private Position<Edge<E>> pos;
        private Vertex<V>[] endpoints; // the endpoints of each vertex is stored in an array of size 2

        */
/** constructs innerEdge instance from u to v storing the given element *//*

        public InnerEdge(Vertex<V> u, Vertex<V> v, E elem) {
            element = elem;
            endpoints = (Vertex<V>[]) new Vertex[] {u, v};

        }

        @Override
        public E getElement() {
            return element;
        }

        public Vertex<V>[] getEndpoints() { return endpoints; }

        */
/** Stores the position of this edge within the graph's vertex list *//*

        public void setPosition(Position<Edge<E>> p) { pos = p; }

        */
/** @return the position of this edge within the graph's vertex list *//*

        public Position<Edge<E>> getPosition() { return pos; }

    } // ------------ end of innerEdge class

    private boolean isDirected;
    private PositionalList<Vertex<V>> vertices = new LinkedPositionalList<>();
    private PositionalList<Edge<E>> edges = new LinkedPositionalList<>();

    */
/** Constructs an empty graph (either directed or undirected) *//*

    public AdjacencyMapGraph(boolean isDirected) { this.isDirected = isDirected; }

    */
/** returns the number of vertices of the graph *//*

    public int numVertices() {
        return vertices.size();
    }
    */
/** returns the vertices of the graph as an iterable collection *//*

    public Iterable<Vertex<V>> vertices() { return vertices; }

    public int numEdges() {
        return edges.size();
    }

    */
/**
     * Returns an iterable of all the edges of the graph
     *//*

    @Override
    public Iterable<Edge<E>> edges() {
        return edges;
    }

    */
/**
     * Returns the edge from vertex u to vertex v, if one exists;
     * else returns null. For an undirected graph there is no difference between getEdge(u, x) and getEdge(x, u)
     *//*

    @Override
    public Edge<E> getEdge(Vertex<V> v, Vertex<V> u) {
        InnerVertex<V> origin = validate(v);
        return origin.getOutgoing().get(u);
    }

    */
/**
     * Returns an array containing the two endPoint vertices of edge e.
     * if the graph is directed the first vertex is the origin and the second is
     * the destination
     *
     * @param e
     *//*

    @Override
    public Vertex<V>[] endVertices(Edge<E> e) {
        InnerEdge<E> edge = validate(e);
        return edge.getEndpoints();
    }

    */
/**
     * For edge e incident to vertex v, returns the other vertex of
     * the edge; an error occurs if e is not incident to v
     *
     * @param v
     * @param e
     *//*

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        InnerEdge<E> edge = validate(e);
        Vertex<V>[] endpoints = edge.getEndpoints();

        if (v == endpoints[0])
            return endpoints[1];
        else if (V == endpoints[1])
            return endpoints[0];
        else
            throw new IllegalStateException("edge isn't incident to vertex or more than 2 endpoints (something definitely is wrong")

    }

    */
/**
     * Returns an iteration of all outgoing edges from vertex v
     *
     * @param v
     *//*

    @Override
    public Iterable<Edge<E>> outGoingEdges(Vertex<V> v) {
        InnerVertex<V> vertex = validate(v);
        return vertex.getOutgoing().values();
    }

    */
/**
     * Returns an iteration of all incoming edges to vertex v.
     * for an undirected graph this returns the same collection as outgoing Edges
     *
     * @param v
     *//*

    @Override
    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) {
        InnerVertex<V> vertex = validate(v);
        return vertex.getIncoming().values();
    }
    // utility method for validating vertexes
    private InnerVertex<V> validate(Vertex<V> vert) {
        if (vert == null)
            throw new IllegalArgumentException("Vertex can not be null type");

        InnerVertex<V> vertex = new InnerVertex<>(vert.getElement(), isDirected);
        return vertex;
    }
    private InnerEdge<E> validate(Edge<E> e) {
        if (e == null)
            throw new IllegalArgumentException("Edge can't be null");

        InnerEdge<E> edge;
        if (e instanceof AdjacencyMapGraph<V, E>.InnerEdge<E>) {
            edge = (InnerEdge<E>) e;
        } else
            throw new IllegalArgumentException("Unsupported type of edge passed as a parameter")
        return edge;
    }
    // --------- end of validation utilities
    */
/**
     * Creates and returns a new vertex storing element x
     *
     * @param x
     *//*

    @Override
    public Vertex<V> insertVertex(V x) {
        return new InnerVertex<>(x, isDirected);
    }

    */
/**
     * Creates and returns a new Edge from vertex u to vertx v,
     * storing element x; an error occurs if there already exists an edge from
     * u to v
     *
     * @param u
     * @param v
     * @param x
     *//*

    @Override
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E x) {
        return new InnerEdge<>(u, v, x);
    }

    */
/**
     * Removes vertex v and all its incident edges from the graph
     *
     * @param v
     *//*

    @Override
    public void removeVertex(Vertex<V> v) {
        vertices

    */
/**
     * Removes edge e from the graph
     *
     * @param e
     *//*

    @Override
    public void removeEdge(Edge<E> e) {

    }


}

*/
