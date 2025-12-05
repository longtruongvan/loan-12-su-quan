package javax.wireless.messaging;

import javax.microedition.io.Connection;
import java.io.IOException;

public interface MessageConnection extends Connection {
    public static final String TEXT_MESSAGE = "text";
    public static final String BINARY_MESSAGE = "binary";

    public Message newMessage(String type);

    public Message newMessage(String type, String address);

    public void send(Message msg) throws IOException;

    public Message receive() throws IOException;

    public void setMessageListener(MessageListener listener) throws IOException;

    public int numberOfSegments(Message msg);
}
