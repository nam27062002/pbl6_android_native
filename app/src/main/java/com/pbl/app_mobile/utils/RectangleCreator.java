package com.pbl.app_mobile.utils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pbl.app_mobile.R;

public class RectangleCreator {

    private Context context;
    private LinearLayout linearLayout;
    private int size;
    private int target;

    public RectangleCreator(Context context, LinearLayout linearLayout, int size, int target) {
        this.context = context;
        this.linearLayout = linearLayout;
        this.size = size;
        this.target = target;
    }

    public int getTarget() {
        return target;
    }

    public void createRectangles() {
        linearLayout.removeAllViews();
        for (int i = 0; i < size; i++) {
            ImageView imageView = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(50, 10);
            layoutParams.setMargins(0, 0, 2, 0);
            imageView.setLayoutParams(layoutParams);

            if (i == target) {
                imageView.setBackgroundResource(R.drawable.deep_green_rectangle);
            } else {
                imageView.setBackgroundResource(R.drawable.grey_retangle);
            }
            linearLayout.addView(imageView);
        }
    }

    public void changeTarget(int target) {
        this.target = target;
        createRectangles();
    }

    public Boolean isTargetEnd() {
        return size == target + 1;
    }
}
