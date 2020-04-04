package Socket_CLIENT;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Connecting to server");

        Socket sock = new Socket("127.0.0.1", 9999);

        System.out.println("Connected to server");
        System.out.println("Enter product name : ");

        Scanner scan = new Scanner(System.in);
        String product = scan.nextLine();

        InputStream in = sock.getInputStream();
        OutputStream out = sock.getOutputStream();

        System.out.println("Sending product info");
        out.write(product.getBytes());

        byte [] response = new byte[100];
        in.read(response);

        String strResponse = new String(response).trim();

        System.out.println("Obtained response is - " + strResponse);

        sock.close();
    }
}
