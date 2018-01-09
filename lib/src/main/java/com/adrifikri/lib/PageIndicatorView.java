package com.adrifikri.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by elevenian on 1/9/18.
 */

public class PageIndicatorView extends View {

    private Paint paintFill;
    private Paint paintStroke;
    private int fillColor;
    private int strokeColor;
    private boolean isSelected;

    private int strokeWidth;

    public PageIndicatorView(Context context) {
        super(context);

        init(context, null);
    }

    public PageIndicatorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    public PageIndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PageIndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PageIndicatorView);
        fillColor = typedArray.getColor(R.styleable.PageIndicatorView_fillColor, Color.parseColor("#1e88e5"));
        strokeColor = typedArray.getColor(R.styleable.PageIndicatorView_strokeColor, Color.parseColor("#14b793"));
        strokeWidth = typedArray.getDimensionPixelOffset(R.styleable.PageIndicatorView_strokeWidth, 10);

        paintFill = new Paint();
        paintFill.setColor(fillColor);
        paintFill.setStyle(Paint.Style.FILL);
        paintFill.setAntiAlias(true);

        paintStroke = new Paint();
        paintStroke.setStyle(Paint.Style.STROKE);
        paintStroke.setAntiAlias(true);
        paintStroke.setColor(strokeColor);
        setStrokeWidth(strokeWidth);

        typedArray.recycle();
    }

    public void setFillColor(int fillColor){
        this.fillColor = fillColor;
        invalidate();
    }

    public void setStrokeColor(int strokeColor){
        this.strokeColor = strokeColor;
        invalidate();
    }

    public void setSelected(boolean isSelected){
        this.isSelected = isSelected;
        invalidate();
    }

    public void setStrokeWidth(int strokeWidth){
        this.strokeWidth = strokeWidth;
        if (paintStroke != null) paintStroke.setStrokeWidth(strokeWidth);
        requestLayout();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isSelected){
            canvas.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2-getWidth()/10, paintStroke);
        }

        canvas.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2-getWidth()/8, paintFill);
    }
}
