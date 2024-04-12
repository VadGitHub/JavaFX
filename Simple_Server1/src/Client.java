import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket clientSocket = new Socket("127.0.0.1", 8000);

        //поток чтения
//        byte[] bytes = new byte[256];
//        clientSocket.getInputStream().read(bytes);
//        System.out.println(new String(bytes));
        //поток записи
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        clientSocket.getOutputStream()));

        //поток чтения
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));


        writer.write("Get me some info");
        writer.newLine();
        writer.flush();

        String response = reader.readLine();
        System.out.println(response);

        writer.close();
        reader.close();
        clientSocket.close();

    }
}
