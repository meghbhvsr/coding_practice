import java.util.HashSet;

public class Graph<E, T> {
    public static class GraphNode<E, T> extends Node<E> {
        HashSet<GraphEdge<E , T>> neighbours;
        GraphNode(E val) {
            super(val);
            neighbours = new HashSet<>();
        }
        public HashSet<GraphEdge<E , T>> neighbours() {
            return neighbours;
        }
        public void addEdge(GraphNode<E, T> n, T val) {
            neighbours.add(new GraphEdge<>(n, val));
        }
    }

    public static class GraphEdge<E, T> {
        private GraphNode<E, T> node;
        private T val;
        GraphEdge(GraphNode<E, T> node, T val) {
            this.node = node;
            this.val = val;
        }
        GraphEdge(GraphNode<E, T> node) {
            this(node, null);
        }
        public GraphNode<E, T> getNeighbour() {
            return node;
        }
        public T getVal() {
            return val;
        }
        boolean hasVal() { return val != null; }
    }

    private HashSet<GraphNode<E, T>> nodes;

    public Graph() { nodes = new HashSet<>(); }

    public boolean hasNode(GraphNode node) {
        return nodes.contains(node);
    }

    public GraphNode<E, T> addNode(E val) {
        GraphNode<E, T> node = new GraphNode<>(val);
        nodes.add(node);
        return node;
    }

    public void addEdge(GraphNode<E, T> n1, GraphNode<E, T> n2, T val) {
        if (hasNode(n1) && hasNode(n2)) {
            n1.addEdge(n2, val);
        } else {
            System.out.println("Add node to graph first");
        }
    }

    public void dfs(GraphNode<E, T> node) {
        dfs(node, new HashSet<>());
        System.out.println();
    }

    private void dfs(GraphNode<E, T> node, HashSet<GraphNode<E, T>> visited) {
        if (visited.contains(node)) { return; }

        visited.add(node);
        System.out.print(node + ",");

        for (GraphEdge<E, T> edge : node.neighbours()) {
            dfs(edge.getNeighbour(), visited);
        }
    }
}
