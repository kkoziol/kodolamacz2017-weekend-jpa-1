package weekend.examples;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MySysIn extends InputStream {

    private List<String> toRead = new ArrayList<String>();
    private InputStream in;

    public void addStringToRead(String string) {
        toRead.add(string + "\n");
    }

    @Override
    public synchronized int read() throws IOException {

        if (in == null) {
            if (!setNextAvailableStream()) {
                return -1;
            }
        }
        int readed = in.read();
        System.out.print(".");
        return readed;
    }

    @Override
    public synchronized void close() throws IOException {
        if (in != null) {
            in.close();
        }
    }

    @Override
    public synchronized int read(byte[] b, int off, int len) throws IOException {
        if (in == null) {
            if (!setNextAvailableStream()) {
                return -1;
            }
        }
        return in.read(b, off, len);
    }

    @Override
    public synchronized int read(byte[] b) throws IOException {
        if (in == null) {
            if (!setNextAvailableStream()) {
                return -1;
            }
        }
        return in.read(b);
    }

    @Override
    public synchronized int available() throws IOException {
        if (in.available() == 0) {
            in = null;
            return 0;
        }
        return in.available();
    }

    @Override
    public synchronized long skip(long n) throws IOException {
        if (in == null) {
            return 0;
        }
        return in.skip(n);
    }

    private boolean setNextAvailableStream() {
        if (toRead.size() > 0) {
            in = new ByteArrayInputStream(toRead.get(0).getBytes(StandardCharsets.UTF_8));
            System.out.print(toRead.get(0));
            toRead.remove(0);
            return true;
        } else {
            return false;
        }

    }

}