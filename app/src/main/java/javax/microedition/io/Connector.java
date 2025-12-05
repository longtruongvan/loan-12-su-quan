package javax.microedition.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class Connector {
    public static final int READ = 1;
    public static final int WRITE = 2;
    public static final int READ_WRITE = 3;

    public static Connection open(String name) throws IOException {
        return open(name, READ_WRITE);
    }

    public static Connection open(String name, int mode) throws IOException {
        return open(name, mode, false);
    }

    public static Connection open(String name, int mode, boolean timeouts) throws IOException {
        // Stub implementation
        return new Connection() {
            public void close() throws IOException {
            }
        };
    }

    public static DataInputStream openDataInputStream(String name) throws IOException {
        throw new IOException("Not supported");
    }

    public static DataOutputStream openDataOutputStream(String name) throws IOException {
        throw new IOException("Not supported");
    }

    public static InputStream openInputStream(String name) throws IOException {
        throw new IOException("Not supported");
    }

    public static OutputStream openOutputStream(String name) throws IOException {
        throw new IOException("Not supported");
    }
}
