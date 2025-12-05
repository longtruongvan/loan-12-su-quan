package javax.microedition.lcdui;

public class TextBox extends Screen {
    private String string;
    private int maxSize;
    private int constraints;

    public TextBox(String title, String text, int maxSize, int constraints) {
        this.string = text;
        this.maxSize = maxSize;
        this.constraints = constraints;
    }

    public String getString() {
        return string;
    }

    public void setString(String text) {
        this.string = text;
    }
}
