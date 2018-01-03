package com.example.administrator.progressview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * <pre>
 *     author : Leero
 *     e-mail : 925230519@qq.com
 *     time  : 2017-12-28
 *     desc  :
 *     version: 1.0
 * </pre>
 */
public class ProgressView extends View {

    private int progressColor;
    private int textSize;
    private int textColor;
    private int progress;
    /**
     * 包裹文字的矩形
     */
    private Rect rect = new Rect();
    /**
     * 画百分比文字的画笔
     */
    private Paint paintText = new Paint();
    /**
     * 画进度条的画笔
     */
    private Paint paintProgress = new Paint();
    /**
     * 要画的文字的宽度
     */
    private int textWidth;
    /**
     * 得到自定义视图的宽度
     */
    private int viewWidth;
    /**
     * 得到自定义视图的Y轴中心点
     */
    private int viewCenterY;
    /**
     * 文字总共移动的长度（即从0%到100%文字左侧移动的长度）
     */
    private int totalMovedLength;
    /**
     * 画文字时底部的坐标
     */
    private float textBottomY;

    public ProgressView(Context context) {
        this(context, null);
    }

    public ProgressView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ProgressView, defStyleAttr, 0);
        progressColor = array.getColor(R.styleable.ProgressView_progressColorValue, Color.RED);
        textSize = array.getDimensionPixelSize(R.styleable.ProgressView_textSize, (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 15, getResources().getDisplayMetrics()));
        textColor = array.getColor(R.styleable.ProgressView_textColor, Color.BLACK);
        progress = array.getInt(R.styleable.ProgressView_progressValue, 10);
        array.recycle();

        // 画笔设置
        paintProgress.setColor(progressColor);
        paintProgress.setStrokeWidth(textSize);
        paintText.setColor(textColor);
        paintText.setTextSize(textSize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //得到包围文字的矩形的宽高
        paintText.getTextBounds("000%", 0, "000%".length(), rect);
        textWidth = rect.width();

        //得到自定义视图的高度
        int viewHeight = getMeasuredHeight();
        viewWidth = getMeasuredWidth();
        viewCenterY = viewHeight / 2;
        textBottomY = viewCenterY + rect.height() / 2;
        totalMovedLength = viewWidth - textWidth - 15;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //得到float型进度
        float progressFloat = progress / 100.0f;
        //当前文字移动的长度
        float currentMovedLentgh = totalMovedLength * progressFloat;
        //绘画进度条，长度为从Veiw左端到文字的左侧
        canvas.drawLine(0, viewCenterY, currentMovedLentgh, viewCenterY, paintProgress);
        //画文字(注意：文字要最后画，因为文字和进度条可能会有重合部分，所以要最后画文字，用文字盖住重合的部分)
        canvas.drawText(progress + "%", currentMovedLentgh + 10, textBottomY, paintText);
    }

    /**
     * @param progress 外部传进来的当前进度
     */
    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }

    /**
     * 获取进度值
     */
    public int getProgress() {
        return progress;
    }

}
