import java.io.*;
import java.net.Socket;
import java.util.Scanner;

// Client
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to server. Enter 'Q' to quit.");

            while (true) {
                System.out.println("Enter shape type (Circle/Rectangle): ");
                String shapeType = scanner.nextLine();

                if (shapeType.equalsIgnoreCase("Q")) {
                    out.writeObject("Q");
                    System.out.println("Closing connection...");
                    break;
                }

                Shape shape = null;
                switch (shapeType.toLowerCase()) {
                    case "circle":
                        System.out.println("Enter radius: ");
                        double radius = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                        shape = new Circle(radius);
                        break;

                    case "rectangle":
                        System.out.println("Enter length: ");
                        double length = scanner.nextDouble();
                        System.out.println("Enter width: ");
                        double width = scanner.nextDouble();
                        scanner.nextLine(); // Consume the newline character
                        shape = new Rectangle(length, width);
                        break;

                    default:
                        System.out.println("Invalid shape type. Try again.");
                        continue;
                }

                out.writeObject(shape);

                Object response = in.readObject();
                if (response instanceof Double) {
                    System.out.println("Server calculated area: " + response);
                } else {
                    System.out.println("Invalid response from server.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
