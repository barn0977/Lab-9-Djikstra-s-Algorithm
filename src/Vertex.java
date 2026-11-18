import java.util.ArrayList;

public class Vertex {
    private String name;
    private ArrayList<Edge> edges;


    public Vertex(String n) {
        this.name = n;
        this.edges = new ArrayList<>();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }
}
