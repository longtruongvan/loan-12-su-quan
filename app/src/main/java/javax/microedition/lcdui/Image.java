package javax.microedition.lcdui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.io.IOException;

public class Image {
    private Bitmap bitmap;
    private Graphics graphics;

    public Image(Bitmap b) {
        this.bitmap = b;
    }

    public static Image createImage(String name) throws java.io.IOException {
        try {
            String assetPath = name.startsWith("/") ? name.substring(1) : name;
            java.io.InputStream is = javax.microedition.midlet.MIDlet.getActivity().getAssets().open(assetPath);
            if (is == null)
                throw new java.io.IOException("Image not found: " + name);
            return createImage(is);
        } catch (Exception e) {
            throw new java.io.IOException(e.getMessage());
        }
    }

    public static Image createImage(java.io.InputStream stream) throws java.io.IOException {
        Bitmap b = BitmapFactory.decodeStream(stream);
        if (b == null)
            throw new java.io.IOException("Failed to decode image stream");
        return new Image(b);
    }

    public static Image createImage(Image source, int x, int y, int width, int height, int transform) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        switch (transform) {
            case Graphics.TRANS_ROT90:
                matrix.postRotate(90);
                break;
            case Graphics.TRANS_ROT180:
                matrix.postRotate(180);
                break;
            case Graphics.TRANS_ROT270:
                matrix.postRotate(270);
                break;
            case Graphics.TRANS_MIRROR:
                matrix.postScale(-1, 1);
                break;
            case Graphics.TRANS_MIRROR_ROT90:
                matrix.postScale(-1, 1);
                matrix.postRotate(90);
                break;
            case Graphics.TRANS_MIRROR_ROT180:
                matrix.postScale(-1, 1);
                matrix.postRotate(180);
                break;
            case Graphics.TRANS_MIRROR_ROT270:
                matrix.postScale(-1, 1);
                matrix.postRotate(270);
                break;
        }

        Bitmap subset = Bitmap.createBitmap(source.getBitmap(), x, y, width, height, matrix, true);
        return new Image(subset);
    }

    public static Image createImage(int w, int h) {
        Bitmap b = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        return new Image(b);
    }

    public static Image createImage(byte[] data, int off, int len) {
        Bitmap b = BitmapFactory.decodeByteArray(data, off, len);
        return new Image(b);
    }

    public Graphics getGraphics() {
        if (graphics == null) {
            android.graphics.Canvas c = new android.graphics.Canvas(bitmap);
            graphics = new Graphics(c);
        }
        return graphics;
    }

    public int getWidth() {
        return bitmap != null ? bitmap.getWidth() : 0;
    }

    public int getHeight() {
        return bitmap != null ? bitmap.getHeight() : 0;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
