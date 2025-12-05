package javax.microedition.lcdui;

import android.content.Context;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public abstract class Canvas extends Displayable {
    public static final int KEY_NUM0 = 48;
    public static final int KEY_NUM1 = 49;
    public static final int KEY_NUM2 = 50;
    public static final int KEY_NUM3 = 51;
    public static final int KEY_NUM4 = 52;
    public static final int KEY_NUM5 = 53;
    public static final int KEY_NUM6 = 54;
    public static final int KEY_NUM7 = 55;
    public static final int KEY_NUM8 = 56;
    public static final int KEY_NUM9 = 57;
    public static final int KEY_STAR = 42;
    public static final int KEY_POUND = 35;

    public static final int UP = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 5;
    public static final int DOWN = 6;
    public static final int FIRE = 8;

    public static final int GAME_A = 9;
    public static final int GAME_B = 10;
    public static final int GAME_C = 11;
    public static final int GAME_D = 12;

    private AndroidView view;

    protected abstract void paint(Graphics g);

    protected void keyPressed(int keyCode) {
    }

    protected void keyReleased(int keyCode) {
    }

    protected void pointerPressed(int x, int y) {
    }

    protected void pointerReleased(int x, int y) {
    }

    protected void pointerDragged(int x, int y) {
    }

    public View getView(Context context) {
        if (view == null) {
            view = new AndroidView(context);
        }
        return view;
    }

    public void repaint() {
        if (view != null) {
            view.triggerRepaint();
        }
    }

    public void serviceRepaints() {
        // invoke repaint immediately?
        repaint();
    }

    public void setFullScreenMode(boolean mode) {
    }

    public int getWidth() {
        return view != null ? view.getWidth() : 240;
    }

    public int getHeight() {
        return view != null ? view.getHeight() : 320;
    }

    public int getKeyCode(int gameAction) {
        // Simple mapping
        return gameAction;
    }

    public int getGameAction(int keyCode) {
        if (keyCode == UP)
            return UP;
        if (keyCode == DOWN)
            return DOWN;
        if (keyCode == LEFT)
            return LEFT;
        if (keyCode == RIGHT)
            return RIGHT;
        if (keyCode == FIRE)
            return FIRE;
        return 0;
    }

    public boolean hasPointerEvents() {
        return true;
    }

    private class AndroidView extends SurfaceView implements SurfaceHolder.Callback {
        public AndroidView(Context context) {
            super(context);
            getHolder().addCallback(this);
            setFocusable(true);
            setFocusableInTouchMode(true);
        }

        public void triggerRepaint() {
            SurfaceHolder holder = getHolder();
            android.graphics.Canvas c = null;
            try {
                c = holder.lockCanvas();
                if (c != null) {
                    Canvas.this.paint(new Graphics(c));
                }
            } catch (Exception e) {
            } finally {
                if (c != null)
                    holder.unlockCanvasAndPost(c);
            }
        }

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            triggerRepaint();
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            triggerRepaint();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
        }

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            int j2meKey = mapKey(keyCode);
            Canvas.this.keyPressed(j2meKey);
            return true;
        }

        @Override
        public boolean onKeyUp(int keyCode, KeyEvent event) {
            int j2meKey = mapKey(keyCode);
            Canvas.this.keyReleased(j2meKey);
            return true;
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Canvas.this.pointerPressed(x, y);
                    break;
                case MotionEvent.ACTION_UP:
                    Canvas.this.pointerReleased(x, y);
                    break;
                case MotionEvent.ACTION_MOVE:
                    Canvas.this.pointerDragged(x, y);
                    break;
            }
            return true;
        }

        private int mapKey(int androidKey) {
            switch (androidKey) {
                case KeyEvent.KEYCODE_DPAD_UP:
                    return UP;
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    return DOWN;
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    return LEFT;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    return RIGHT;
                case KeyEvent.KEYCODE_DPAD_CENTER:
                case KeyEvent.KEYCODE_ENTER:
                    return FIRE;
                case KeyEvent.KEYCODE_0:
                    return KEY_NUM0;
                case KeyEvent.KEYCODE_1:
                    return KEY_NUM1;
                case KeyEvent.KEYCODE_2:
                    return KEY_NUM2;
                case KeyEvent.KEYCODE_3:
                    return KEY_NUM3;
                case KeyEvent.KEYCODE_4:
                    return KEY_NUM4;
                case KeyEvent.KEYCODE_5:
                    return KEY_NUM5;
                case KeyEvent.KEYCODE_6:
                    return KEY_NUM6;
                case KeyEvent.KEYCODE_7:
                    return KEY_NUM7;
                case KeyEvent.KEYCODE_8:
                    return KEY_NUM8;
                case KeyEvent.KEYCODE_9:
                    return KEY_NUM9;
                case KeyEvent.KEYCODE_STAR:
                    return KEY_STAR;
                case KeyEvent.KEYCODE_POUND:
                    return KEY_POUND;
                default:
                    return 0;
            }
        }
    }
}
