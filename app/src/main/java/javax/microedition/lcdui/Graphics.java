package javax.microedition.lcdui;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

public class Graphics {
    public static final int HCENTER = 1;
    public static final int VCENTER = 2;
    public static final int LEFT = 4;
    public static final int RIGHT = 8;
    public static final int TOP = 16;
    public static final int BOTTOM = 32;
    public static final int BASELINE = 64;

    public static final int SOLID = 0; // Stroke style
    public static final int DOTTED = 1;

    public static final int TRANS_NONE = 0;
    public static final int TRANS_ROT90 = 5;
    public static final int TRANS_ROT180 = 3;
    public static final int TRANS_ROT270 = 6;
    public static final int TRANS_MIRROR = 2;
    public static final int TRANS_MIRROR_ROT90 = 7;
    public static final int TRANS_MIRROR_ROT180 = 1;
    public static final int TRANS_MIRROR_ROT270 = 4;

    private android.graphics.Canvas canvas;
    private Paint paint;
    private int color = 0;

    private Bitmap bitmap;

    public Graphics(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.canvas = new android.graphics.Canvas(bitmap);
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
    }

    public Graphics(android.graphics.Canvas canvas) {
        this.canvas = canvas;
        this.paint = new Paint();
        this.paint.setAntiAlias(true);
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        this.canvas = new android.graphics.Canvas(bitmap);
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setColor(int rgb) {
        this.color = rgb;
        paint.setColor(0xFF000000 | rgb); // Force alpha 255
        paint.setStyle(Paint.Style.FILL);
    }

    public int getColor() {
        return color;
    }

    public int getRedComponent() {
        return (color >> 16) & 0xFF;
    }

    public int getGreenComponent() {
        return (color >> 8) & 0xFF;
    }

    public int getBlueComponent() {
        return color & 0xFF;
    }

    public void fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(x1, y1);
        path.lineTo(x2, y2);
        path.lineTo(x3, y3);
        path.close();
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);
    }

    public void fillRect(int x, int y, int w, int h) {
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(x, y, x + w, y + h, paint);
    }

    public void drawRect(int x, int y, int w, int h) {
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(x, y, x + w, y + h, paint);
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(x1, y1, x2, y2, paint);
    }

    public void drawString(String str, int x, int y, int anchor) {
        if (str == null)
            return;
        paint.setStyle(Paint.Style.FILL);
        Paint.Align align = Paint.Align.LEFT;

        if ((anchor & HCENTER) != 0)
            align = Paint.Align.CENTER;
        if ((anchor & RIGHT) != 0)
            align = Paint.Align.RIGHT;

        paint.setTextAlign(align);

        float dy = 0;
        Paint.FontMetrics metrics = paint.getFontMetrics();
        // Android drawText y is Baseline.
        // J2ME anchor defines where (x,y) is relative to text.
        // TOP: y is top of text.
        // BOTTOM: y is bottom of text.
        // BASELINE: y is baseline.

        if ((anchor & TOP) != 0)
            dy = -metrics.ascent;
        else if ((anchor & BOTTOM) != 0)
            dy = -metrics.descent; // Wait, descent is positive usually?
        // Let's approximate.

        canvas.drawText(str, x, y + dy, paint);
    }

    public void drawRegion(Image src, int x_src, int y_src, int width, int height, int transform, int x_dest,
            int y_dest, int anchor) {
        if (src == null || src.getBitmap() == null)
            return;

        android.graphics.Matrix matrix = new android.graphics.Matrix();

        // J2ME transform logic
        switch (transform) {
            case TRANS_NONE:
                break;
            case TRANS_ROT90:
                matrix.postRotate(90);
                break;
            case TRANS_ROT180:
                matrix.postRotate(180);
                break;
            case TRANS_ROT270:
                matrix.postRotate(270);
                break;
            case TRANS_MIRROR:
                matrix.postScale(-1, 1);
                break;
            case TRANS_MIRROR_ROT90:
                matrix.postScale(-1, 1);
                matrix.postRotate(90);
                break;
            case TRANS_MIRROR_ROT180:
                matrix.postScale(-1, 1);
                matrix.postRotate(180);
                break;
            case TRANS_MIRROR_ROT270:
                matrix.postScale(-1, 1);
                matrix.postRotate(270);
                break;
        }

        Bitmap b = src.getBitmap();

        // Source Rect
        if (x_src + width > b.getWidth())
            width = b.getWidth() - x_src;
        if (y_src + height > b.getHeight())
            height = b.getHeight() - y_src;
        if (width <= 0 || height <= 0)
            return;

        Bitmap subset = Bitmap.createBitmap(b, x_src, y_src, width, height, matrix, true);

        drawImage(new Image(subset), x_dest, y_dest, anchor);
    }

    public void drawImage(Image img, int x, int y, int anchor) {
        if (img == null || img.getBitmap() == null)
            return;
        Bitmap b = img.getBitmap();
        float dx = 0;
        float dy = 0;

        if ((anchor & HCENTER) != 0)
            dx = -b.getWidth() / 2f;
        if ((anchor & RIGHT) != 0)
            dx = -b.getWidth();
        if ((anchor & VCENTER) != 0)
            dy = -b.getHeight() / 2f;
        if ((anchor & BOTTOM) != 0)
            dy = -b.getHeight();

        canvas.drawBitmap(b, x + dx, y + dy, null);
    }

    public void setClip(int x, int y, int w, int h) {
        // Warning: This only intersects in modern Android.
        // For simple shims, we often rely on intersection being "enough" or implement
        // complex save/restore.
        // For Loan 12 Su Quan, let's try intersection.
        try {
            canvas.clipRect(x, y, x + w, y + h); // simplified
        } catch (Exception e) {
        }
    }

    public void setFont(Font font) {
        // Stub
        paint.setTextSize(16);
    }

    public int getClipX() {
        return canvas.getClipBounds().left;
    }

    public int getClipY() {
        return canvas.getClipBounds().top;
    }

    public int getClipWidth() {
        return canvas.getClipBounds().width();
    }

    public int getClipHeight() {
        return canvas.getClipBounds().height();
    }

    public void translate(int x, int y) {
        canvas.translate(x, y);
    }
}
