import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n ------- Graph Menu ------- \n");
            System.out.println(" 1 Select A Graph To Be Used ");
            System.out.println(" 2 Exit The Program ");
            System.out.print("\n Enter A Number Choice: ");

            String input = scanner.next();

            if (input.equals("1")) {
                while (true) {
                    System.out.println("\n ------- Graph Selection ------- ");
                    System.out.println(" Example: graph1.csv \n");
                    System.out.println(" Enter A Graph's File Name To Be Used For Dijkstra's Algorithm ");
                    System.out.println(" Enter EXIT To Leave \n");
                    System.out.print(" Enter In A Input: ");

                    input = scanner.next();

                    if (input.equals("EXIT")) {
                        System.out.println(" Closing The Program...");
                        break;
                    } else {

                        String filePath = "datafiles/" + input;
                        AdjList adjL = new AdjList();

                        GraphReader reader = new GraphReader();
                        boolean success = reader.readGraph(filePath, adjL);

                        if (success) {
                            System.out.println("\n ------- Dijkstra's Algorithm ------- ");
                            System.out.println(" Select A Letter From The Graph To Travel Through Vertices");
                            System.out.println(" All The Vertices Options: ");

                            for (Vertex vertex : adjL.getVertices()) {
                                int num = adjL.vertices.indexOf(vertex) + 1;
                                System.out.println(num + ". " + vertex.getName());
                            }
                            System.out.print(" Enter A Letter From The Graph: ");
                            System.out.println(" Enter EXIT To Leave ");

                            input = scanner.next();

                            if (input.equals("EXIT")) {
                                System.out.println("Closing Program...");
                                break;
                            }else {
                                Vertex selectedLetter = adjL.nameVertex(input);

                                if (selectedLetter != null) {
                                    System.out.println(" You Have Selected: " + selectedLetter.getName());
                                    adjL.Dijkstra(selectedLetter);
                                } else {
                                    System.out.println("Try Again, Select From One Of The Choices");
                                }
                            }
                        }
                    }
                    if (input.equals("EXIT")) {
                        System.out.println("Closing The Program...");
                        break;
                    }
                }
                if (input.equals("EXIT")) {
                    break;
                }
            }
            if (input.equals("2")) {
                System.out.println("Closing The Program...");
                break;
            } else {
                System.out.println("Try Again, Select From One Of The Choices");
            }
        }
    }
}
