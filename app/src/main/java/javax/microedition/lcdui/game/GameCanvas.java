package javax.microedition.lcdui.game;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

public abstract class GameCanvas extends Canvas {
    public static final int UP_PRESSED = 1 << 1;
    public static final int DOWN_PRESSED = 1 << 6;
    public static final int LEFT_PRESSED = 1 << 2;
    public static final int RIGHT_PRESSED = 1 << 5;
    public static final int FIRE_PRESSED = 1 << 8;
    public static final int GAME_A_PRESSED = 1 << 9;
    public static final int GAME_B_PRESSED = 1 << 10;
    public static final int GAME_C_PRESSED = 1 << 11;
    public static final int GAME_D_PRESSED = 1 << 12;

    private Graphics graphics;

    protected GameCanvas(boolean suppressKeyEvents) {
        // Initialize an off-screen buffer or just stub
        // Since we don't have a real buffer yet, we might need one.
        // For simplicity, we can let getGraphics return a dummy or hook into
        // SurfaceView
        // But getGraphics() is usually called once.
        // We will create a dummy Graphics for now, or one backed by a Bitmap.
        // We rely on 'repaint' or 'flushGraphics' to actually draw.
        // In J2ME, GameCanvas drawing is usually done to an off-screen buffer.
    }

    protected Graphics getGraphics() {
        if (graphics == null) {
            // Create a bitmap-backed graphics
            int w = getWidth();
            int h = getHeight();
            if (w <= 0)
                w = 240;
            if (h <= 0)
                h = 320;
            android.graphics.Bitmap b = android.graphics.Bitmap.createBitmap(w, h,
                    android.graphics.Bitmap.Config.ARGB_8888);
            graphics = new Graphics(new android.graphics.Canvas(b));
            graphics.setBitmap(b); // We need to add setBitmap to Graphics shim? Or just hold reference?
            // Actually Graphics shim holds 'canvas'.
        }
        return graphics;
    }

    public void flushGraphics(int x, int y, int width, int height) {
        repaint(); // Trigger repaint on SurfaceView
    }

    public void flushGraphics() {
        repaint();
    }

    public int getKeyStates() {
        return 0; // Stub
    }
}
