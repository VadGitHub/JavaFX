import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) throws IOException {
        int count = 0;
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");

        while (true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted " + (++count)  );

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            clientSocket.getOutputStream()));

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));

            String request = reader.readLine();

            String response = "#" + count + " request len " + request.length();

//            writer.write( "You are client #" + count + "\n");
            writer.write(response);
            writer.newLine();
            writer.flush();

            writer.close();
            reader.close();
            clientSocket.close();


//            writer.write("HTTP/1.0 200 OK\r\n" +
//                    "Content-type: text/html\r\n" +
//                    "\r\n" +
//                    "<h1>Java " + count + "</h1>\r\n");
        }


//        for (int j = 48; j < 58; j++)
//            clientSocket.getOutputStream().write(j);


//        clientSocket.getOutputStream().write("<h2>Hello</h2>".getBytes());



        //serverSocket.close();


    }

}
