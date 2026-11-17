import java.io.BufferedReader;
import java.io.FileReader;

public class GraphReader {

    public boolean readGraph(String filename, AdjList adjL, AdjMatrix adjM) {

        String startVertex = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] StringArray = line.split(" ");

                if (StringArray.length != 3) {
                    System.out.println("Error Reading The Files Lines At: " + line);
                }
                String from = StringArray[0].trim();
                String to = StringArray[1].trim();
                double weight = Double.parseDouble(StringArray[2].trim());

                if (startVertex == null) {
                    startVertex = from;
                }

                adjL.addEdge(from, to, weight);
                adjM.addEdge(from, to, weight);
            }

        } catch (Exception e) {
            System.out.print("Error Occurred While Reading The File");
            return false;
        }
        if (startVertex == null) {
            System.out.println("There Is Nothing For The Graph");
        }
        return true;
    }
    public String getStartVertex(AdjList graph) {
        if (graph.getVertices().isEmpty()) {
            return null;
        }
        return  graph.getVertices().getFirst().getName();
    }
}