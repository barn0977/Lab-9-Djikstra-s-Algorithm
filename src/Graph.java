import java.util.*;

public abstract class Graph {

    protected ArrayList<Vertex> vertices;

    public abstract Vertex addVertex(String n);

    public abstract void addEdge(String from, String to, double weight);

    public abstract void printGraph();

    public abstract boolean isVertex(String name);

    public abstract Vertex nameVertex(String name);

    public ArrayList<Vertex> getVertices() {return vertices;}

    public void Dijkstra(Vertex source) {
        HashMap<Vertex, Double> distance = new HashMap<>();
        HashMap<Vertex, Vertex> previous = new HashMap<>();

        PriorityQueue<Vertex> queue = new PriorityQueue<>(
                Comparator.comparingDouble(n -> distance.get(n)));

        for (Vertex vertex: vertices) {
            distance.put(vertex, Double.POSITIVE_INFINITY);
            previous.put(vertex, null);
        }
        distance.put(source, 0.0);
        queue.addAll(vertices);
        //This is the actually Dijstras Algorithm by dijA
        while (!queue.isEmpty()) {
            Vertex dijA = queue.poll();

            if (Double.isInfinite(distance.get(dijA))){
                break;
            }
            for (Edge edge : dijA.getEdges()) {
                Vertex vertex;

                if (edge.getFrom() == dijA) {
                    vertex = edge.getTo();
                } else if (edge.getTo() == dijA) {
                    vertex = edge.getFrom();
                }else {
                    continue;
                }
                //Stops from doing the same letter
                if (!queue.contains(dijA)) {
                    continue;
                }
                double alg = distance.get(dijA) + edge.getWeight();

                if (alg < distance.get(vertex)) {
                    queue.remove(vertex);
                    distance.put(vertex, alg);
                    previous.put(vertex, dijA);

                    queue.add(vertex);
                }
            }
        }
        for (Vertex ver: vertices) {
            if (Double.isInfinite(distance.get(ver))) {
                System.out.println(ver.getName() + " Cannot Be Retrieved ");
                continue;
            }
            LinkedList<Vertex> path = new LinkedList<>();

            Vertex current = ver;

            while (current != null) {
                path.addFirst(current);
                current = previous.get(current);
            }
            for (int i = 0; i < path.size(); i++) {
                System.out.println(path.get(i).getName());

                if (i < path.size() - 1) {
                    System.out.println(" -> ");
                }
            }
            System.out.printf(" distance: %.1f%n", distance.get(ver));
        }
    }
}
