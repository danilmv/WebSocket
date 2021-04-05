import javax.websocket.WebSocketContainer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;;

public class Finnhub {
    static URI uri;
    static NVWebSocketClient client;

    static {
        try {
            uri = new URI("wss://ws.finnhub.io?token=c116i2748v6t4vh00200");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        try {
//            Client client = new Client(uri);
//            System.out.println("{\"type\":\"subscribe\",\"symbol\":\"AAPL\"}");
        new Thread(() -> {
            client = new NVWebSocketClient(uri);
            client.sendText("{\"type\":\"subscribe\",\"symbol\":\"AAPL\"}");
        }).start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Scanner scanner = new Scanner(System.in);

        do {

        } while (!scanner.nextLine().equals("q"));
        client.close();
    }
}
