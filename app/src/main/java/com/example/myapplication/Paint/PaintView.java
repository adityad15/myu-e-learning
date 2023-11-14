package com.example.myapplication.Paint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class PaintView extends View {

    private Paint paint;
    private Path path;

    private int currentColor = Color.BLACK;
    private float currentBrushSize = 10;

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        path = new Path();

        paint.setAntiAlias(true);
        paint.setColor(currentColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(currentBrushSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                break;
            default:
                return false;
        }

        invalidate(); // Redraw the view
        return true;
    }

    public void setColor(int color) {
        currentColor = color;
        paint.setColor(currentColor);
    }

    public void setBrushSize(float size) {
        currentBrushSize = size;
        paint.setStrokeWidth(currentBrushSize);
    }
}
