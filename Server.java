import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                     ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

                    System.out.println("Client connected...");

                    Object obj;
                    while ((obj = in.readObject()) != null) {
                        if (obj instanceof String && obj.equals("Q")) {
                            break;
                        }

                        if (obj instanceof Shape) {
                            Shape shape = (Shape) obj;
                            double area = shape.calculateArea();
                            out.writeObject(area);
                            System.out.println("Calculated area: " + area);
                        } else {
                            System.out.println("Received invalid object.");
                        }
                    }
                } catch (EOFException e) {
                    System.out.println("Connection closed by client.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
