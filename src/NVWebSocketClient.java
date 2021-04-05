import com.google.gson.Gson;
import com.neovisionaries.ws.client.*;
import model.WSData;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class NVWebSocketClient extends WebSocketAdapter {
    WebSocket socket;
    Gson gson = new Gson();


    public NVWebSocketClient(URI uri) {
        try {
            socket = new WebSocketFactory().createSocket(uri);
            socket.addListener(this);
            socket.connect();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (OpeningHandshakeException e) {
            e.printStackTrace();
        } catch (WebSocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTextMessage(WebSocket websocket, String text) throws Exception {
        super.onTextMessage(websocket, text);
        System.out.println("onTextMessage: " + text);

        WSData data = gson.fromJson(text, WSData.class);
        System.out.println(data);
    }

    @Override
    public void onConnectError(WebSocket websocket, WebSocketException exception) throws Exception {
        super.onConnectError(websocket, exception);
        System.out.println("onConnectError");
    }

    @Override
    public void onConnected(WebSocket websocket, Map<String, List<String>> headers) throws Exception {
        super.onConnected(websocket, headers);
        System.out.println("onConnected");
    }

    @Override
    public void onError(WebSocket websocket, WebSocketException cause) throws Exception {
        super.onError(websocket, cause);
        System.out.println("onError");
    }

    @Override
    public void onCloseFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        super.onCloseFrame(websocket, frame);
        System.out.println("onClose");
    }

    @Override
    public void onMessageError(WebSocket websocket, WebSocketException cause, List<WebSocketFrame> frames) throws Exception {
        super.onMessageError(websocket, cause, frames);
        System.out.println("onMessageError");
    }

    @Override
    public void onSendError(WebSocket websocket, WebSocketException cause, WebSocketFrame frame) throws Exception {
        super.onSendError(websocket, cause, frame);
        System.out.println("onSendError");
    }

    @Override
    public void onTextMessageError(WebSocket websocket, WebSocketException cause, byte[] data) throws Exception {
        super.onTextMessageError(websocket, cause, data);
        System.out.println("onTextMessageError");
    }


    public void sendText(String message) {
        if (socket != null && message != null)
            socket.sendText(message);
    }

    public void close(){
        socket.disconnect();
//        socket.sendClose();
    }


}
