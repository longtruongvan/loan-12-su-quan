package javax.microedition.midlet;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public abstract class MIDlet {
    private static Activity activity;

    public static void setActivity(Activity activity) {
        MIDlet.activity = activity;
    }

    public static Activity getActivity() {
        return activity;
    }

    public abstract void startApp() throws MIDletStateChangeException;

    public abstract void pauseApp();

    public abstract void destroyApp(boolean unconditional) throws MIDletStateChangeException;

    public void notifyDestroyed() {
        if (activity != null) {
            activity.finish();
        }
    }

    public String getAppProperty(String key) {
        return null; // Return null to indicate no specific property
    }

    public boolean platformRequest(String url) {
        if (activity != null && url != null) {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                activity.startActivity(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
