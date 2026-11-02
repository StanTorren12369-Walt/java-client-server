import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;
        serverSocket = new ServerSocket(6969);

        while (true) {
            try {
                socket = serverSocket.accept();
                inputStreamReader = new InputStreamReader(socket.getInputStream());
                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

                bufferedReader = new BufferedReader(inputStreamReader);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                Scanner scanner = new Scanner(System.in);

                while (true) {
                    String messageClient = bufferedReader.readLine();
                    System.out.println("Client: " + messageClient);

                    bufferedWriter.write("Message recieved");
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    if (messageClient.equalsIgnoreCase("Poop"))
                        break;

                }

                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
