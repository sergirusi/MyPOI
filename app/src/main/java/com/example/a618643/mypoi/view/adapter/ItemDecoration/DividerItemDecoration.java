package com.example.a618643.mypoi.view.adapter.ItemDecoration;

import com.example.a618643.mypoi.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by a618643 on 15/02/2016.
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private Drawable divider;

    public DividerItemDecoration(Context context) {
        divider = context.getResources().getDrawable(R.drawable.line_divider);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int leftBound = parent.getPaddingLeft();
        int rightBound = parent.getWidth() - parent.getPaddingRight();

        int count = parent.getChildCount();

        for(int i = 0; i < count; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int topBound = child.getBottom() + params.bottomMargin;
            int bottomBound = topBound + divider.getIntrinsicHeight();

            divider.setBounds(leftBound,topBound,rightBound,bottomBound);
            divider.draw(c);
        }
    }
}
