package weekend.examples;

import java.io.PrintStream;

public class MySysOut extends PrintStream {

    public StringBuilder printed = new StringBuilder();

    public MySysOut() {
        super(System.out, false);
    }

    public String getPrintedString() {
        return printed.toString();
    }

    public void resetPrintedString() {
        printed = new StringBuilder();
    }

    @Override
    public void println(String string) {
        print(string + "\n");
    }

    @Override
    public void print(String string) {
        printed.append(string);
        super.print(string);
    }

}