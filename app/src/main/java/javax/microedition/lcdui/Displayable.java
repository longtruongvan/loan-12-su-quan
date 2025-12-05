package javax.microedition.lcdui;

public abstract class Displayable {
    private CommandListener listener;

    public void addCommand(Command cmd) {
        // Implementation for Android logic would go here
    }

    public void removeCommand(Command cmd) {
    }

    public void setCommandListener(CommandListener l) {
        this.listener = l;
    }

    public int getWidth() {
        return 240;
    } // Stub

    public int getHeight() {
        return 320;
    } // Stub
    // Stub
}
