package view.custom.saury.pixelgridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class PixelGridCustomView extends View {

    private Paint paintPrimary, paintSecondary, paintTertiary;
    private Context context;
    private int primaryGridColor = Color.BLACK, secondaryGridColor = Color.BLACK, tertiaryGridColor = Color.BLACK;
    private int gridLeadDirection = GridDirection.HORIZONTAL;
    private int gridStyle = GridStyle.GRID_SINGLE;
    private int numPrimaryGrids = 30;

    public class GridDirection {
        public static final int HORIZONTAL = 0;
        public static final int VERTICAL = 1;

    }

    public class GridStyle {
        public static final int GRID_SINGLE = 0;
        public static final int GRID_DOUBLE = 1;
        public static final int GRID_TRIPLE = 2;

    }

    public PixelGridCustomView(Context context) {
        super(context);
        //paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.context = context;
        init();
    }

    public int getPrimaryGridColor() {
        return primaryGridColor;
    }

    public void setPrimaryGridColor(int primaryGridColor) {
        this.primaryGridColor = primaryGridColor;
    }

    public int getSecondaryGridColor() {
        return secondaryGridColor;
    }

    public void setSecondaryGridColor(int secondaryGridColor) {
        this.secondaryGridColor = secondaryGridColor;
    }

    public int getTertiaryGridColor() {
        return tertiaryGridColor;
    }

    public void setTertiaryGridColor(int tertiaryGridColor) {
        this.tertiaryGridColor = tertiaryGridColor;
    }

    public int getGridLeadDirection() {
        return gridLeadDirection;
    }

    public void setGridLeadDirection(int gridLeadDirection) {
        this.gridLeadDirection = gridLeadDirection;
    }

    public int getGridStyle() {
        return gridStyle;
    }

    public void setGridStyle(int gridStyle) {
        this.gridStyle = gridStyle;
    }

    public int getNumPrimaryGrids() {
        return numPrimaryGrids;
    }

    public void setNumPrimaryGrids(int numPrimaryGrids) {
        this.numPrimaryGrids = numPrimaryGrids;
    }


    private void init() {
        paintPrimary = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintPrimary.setColor(primaryGridColor);
        paintSecondary = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintSecondary.setColor(secondaryGridColor);
        paintTertiary = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintTertiary.setColor(tertiaryGridColor);
    }


    public PixelGridCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.PixelGridCustomView, 0, 0);
            gridStyle = typedArray.getInt(R.styleable.PixelGridCustomView_gridStyle, GridStyle.GRID_SINGLE);
            gridLeadDirection = typedArray.getInt(R.styleable.PixelGridCustomView_gridLeadDirection, GridDirection.HORIZONTAL);
            numPrimaryGrids = typedArray.getInt(R.styleable.PixelGridCustomView_numPrimaryGrids, 30);
            primaryGridColor = typedArray.getColor(R.styleable.PixelGridCustomView_gridPrimaryColor, Color.BLACK);
            secondaryGridColor = typedArray.getColor(R.styleable.PixelGridCustomView_gridSecondaryColor, Color.BLACK);
            tertiaryGridColor = typedArray.getColor(R.styleable.PixelGridCustomView_gridTertiaryColor, Color.BLACK);
        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
        init();
    }

  /*  public PixelGridCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }*/

  /*  public CustomGridView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }*/

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int diff;
        if (gridLeadDirection == GridDirection.HORIZONTAL) {
            diff = getWidth() / numPrimaryGrids;
        } else {
            diff = getHeight() / numPrimaryGrids;
        }

        for (int i = diff; i < getWidth(); i += diff) {
            canvas.drawLine(i, 0, i, getHeight(), paintPrimary);
        }for (int i = diff; i < getHeight(); i += diff) {
            canvas.drawLine(0, i, getWidth(), i, paintPrimary);
        }

        if(gridStyle == GridStyle.GRID_DOUBLE || gridStyle == GridStyle.GRID_TRIPLE){
            diff*=5;
            for (int i = diff; i < getWidth(); i += diff) {
                canvas.drawLine(i, 0, i, getHeight(), paintSecondary);
            }for (int i = diff; i < getHeight(); i += diff) {
                canvas.drawLine(0, i, getWidth(), i, paintSecondary);
            }

        }
        if(gridStyle == GridStyle.GRID_TRIPLE){
            diff*=2;
            for (int i = diff; i < getWidth(); i += diff) {
                canvas.drawLine(i, 0, i, getHeight(), paintTertiary);
            }for (int i = diff; i < getHeight(); i += diff) {
                canvas.drawLine(0, i, getWidth(), i, paintTertiary);
            }

        }

       /* paint.setColor(ContextCompat.getColor(context, android.R.color.black));
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(50);
        int diff = getWidth() / 80;
        for (int i = diff; i < getWidth(); i += diff) {
            canvas.drawLine(i, 0, i, getHeight(), paint);
        }
        for (int i = diff; i < getHeight(); i += diff) {
            canvas.drawLine(0, i, getWidth(), i, paint);
        }
        canvas.drawCircle(100, 100, 20, paint);
        paint.setAlpha(100);
        diff *= 5;
        for (int i = diff; i < getWidth(); i += diff) {
            canvas.drawLine(i, 0, i, getHeight(), paint);
        }
        for (int i = diff; i < getHeight(); i += diff) {
            canvas.drawLine(0, i, getWidth(), i, paint);
        }*/
    }
}
