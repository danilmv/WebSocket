
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class Client implements WebSocket.Listener {
    WebSocket webSocket;

    public Client(URI uri) {
        HttpClient client = HttpClient.newHttpClient();
        CompletableFuture<WebSocket> ws = client.newWebSocketBuilder()
                .buildAsync(uri, this);
    }

    @Override
    public void onOpen(WebSocket webSocket) {
        System.out.println("onOpen");
        webSocket.sendText(new StringBuffer("{\"type\":\"subscribe\",\"symbol\":\"AAPL\"}"), true);
        this.webSocket = webSocket;
    }

    @Override
    public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
        System.out.println("onText: " + data.toString());
        return null;
    }

    @Override
    public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
        System.out.println("onClose");
        return null;
    }

    public void sendMessage(String message) {
        if (webSocket != null)
            webSocket.sendText(new StringBuffer(message), true);
    }

}
