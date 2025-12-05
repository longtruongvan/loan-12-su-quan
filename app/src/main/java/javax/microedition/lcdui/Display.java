package javax.microedition.lcdui;

import javax.microedition.midlet.MIDlet;
import android.app.Activity;

public class Display {
    private static Display instance;
    private Displayable current;

    public boolean vibrate(int duration) {
        // Stub implementation
        return true;
    }

    public static Display getDisplay(MIDlet midlet) {
        if (instance == null) {
            instance = new Display();
        }
        return instance;
    }

    public void setCurrent(Displayable nextDisplayable) {
        this.current = nextDisplayable;
        Activity activity = MIDlet.getActivity();
        if (activity != null && nextDisplayable instanceof Canvas) {
            final Canvas canvas = (Canvas) nextDisplayable;
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Activity act = MIDlet.getActivity();
                    if (act != null) {
                        act.setContentView(canvas.getView(act));
                        canvas.setFullScreenMode(true);
                    }
                }
            });
        }
    }

    public Displayable getCurrent() {
        return current;
    }
}
