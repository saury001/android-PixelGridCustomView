package view.custom.saury.pixelgridview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class PixelGridCustomView extends View {

    Paint paint;
    Context context ;

    public PixelGridCustomView(Context context) {
        super(context);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
         this.context = context;
    }

    public PixelGridCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    public PixelGridCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

  /*  public CustomGridView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }*/

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(ContextCompat.getColor(context,android.R.color.black));
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(50);
        int diff = getWidth()/80;
        for(int i = diff; i < getWidth(); i+=diff)
        {
            canvas.drawLine(i,0,i,getHeight(),paint);
        }
        for(int i = diff; i < getHeight(); i+=diff)
        {
            canvas.drawLine(0,i,getWidth(),i,paint);
        }
        canvas.drawCircle(100,100,20,paint);
        paint.setAlpha(100);
        diff*=5;
        for(int i = diff; i < getWidth(); i+=diff)
        {
            canvas.drawLine(i,0,i,getHeight(),paint);
        }
        for(int i = diff; i < getHeight(); i+=diff)
        {
            canvas.drawLine(0,i,getWidth(),i,paint);
        }
    }
}
