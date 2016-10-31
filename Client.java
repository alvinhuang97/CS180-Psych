import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * Client
 *
 * Client for the FoilMaker Game
 *
 * @author Luca
 * @version 10/31/2016.
 */
public class Client {
    public String serverIP = "localhost";
    public int serverPort = 50000;
    public String message = " ";

    public void SendMessage(String message) {
        try {
            Socket socket = new Socket(serverIP, serverPort);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            out.println(message);
            String serverMessage = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

