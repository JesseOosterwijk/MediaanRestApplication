package Socket_SERVER;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


class QuoteService{
    Map<String, String> productInfo = new HashMap<String, String>();

    public QuoteService() {
        productInfo.put("a", "100");
        productInfo.put("b", "200");
        productInfo.put("c", "300");
        productInfo.put("d", "400");

    }
    public String getQuote(String product) {
        return productInfo.get(product);
    }
}

class ServiceThread extends Thread{

    Socket sock;

    QuoteService quoteService = new QuoteService();

    public ServiceThread(Socket sock) {
        this.sock = sock;
    }

    public void run() {
        try {
            //from client
            InputStream in = sock.getInputStream();
            //to client
            OutputStream out = sock.getOutputStream();

            System.out.println("Waiting for product info from client...");
            byte request[] = new byte[100];
            in.read(request);
            String product = new String(request).trim();


            System.out.println("Received product name - ..." + product);

            String price = quoteService.getQuote(product);
            if(price == null) {
                price = "Invalid";
            }

            out.write(price.getBytes());

            System.out.println("Response send....");

            sock.close();
        }
        catch(Exception e){

        }
    }
}
public class Server {

    public static void main(String[] args) throws IOException {



        ServerSocket serSocket = new ServerSocket(9999);

        System.out.println("Listening to 9999...");

        while(true) {
            System.out.println("Waiting for client...");
            Socket sock = serSocket.accept();

            // create a new thread to service client
            System.out.println("Starting a thread for the client");
            new ServiceThread(sock).start();
        }

    }
}
