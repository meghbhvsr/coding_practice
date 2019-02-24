import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        //ArrayList<Integer> arr = Stream.of(12, 3, 6, 9, 0, -1, 20 ,11).collect(Collectors.toCollection(ArrayList::new));
        //QuickSort.sort(arr);
        //arr.stream().map(i -> i + ",").forEach(System.out::print);

//        Graph<Integer, Integer> g = new Graph<>();
//        Graph.GraphNode<Integer, Integer> n6 = g.addNode(6);
//        Graph.GraphNode<Integer, Integer> n5 =  g.addNode(5);
//        Graph.GraphNode<Integer, Integer> n2 = g.addNode(2);
//        Graph.GraphNode<Integer, Integer> n3 = g.addNode(3);
//        Graph.GraphNode<Integer, Integer> n10 = g.addNode(10);
//
//        n6.addEdge(n5, 0);
//        n5.addEdge(n3, 0);
//        n5.addEdge(n2, 0);
//        n3.addEdge(n6, 0);
//        n2.addEdge(n10, 0);
//        n10.addEdge(n3, 0);
//
//        g.dfs(n5);
//        g.dfs(n10);
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(4);
        ll.add(-2);
        ll.add(1);
        ll.add(-5);
        //System.out.println(ll.toString());

    }
}
