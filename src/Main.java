import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(" Shortest Path To A Letter In A Graph ");
            System.out.println("1 Select A Letter From The Graph ");
            System.out.println("2 Exit The Program ");
            System.out.print(" Enter A Number Choice: ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                System.out.println(" Start At A Chose A Letter To Travel To ");
                System.out.println(" Options: A B C D E F G H I J ");
                System.out.print(" Enter A Letter From The Graph: ");
                String graphLetter = scanner.nextLine();

                System.out.print(graphLetter.getshortestPath());


            } else if (input.equals("2")) {
                System.out.println("Exiting The Program");
                break;
            }
            else {
                System.out.println("Try Again, Select From One Of The Choieces");
            }
        }
        scanner.close();
    }
}