package com.example.localloop.helpers;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;

public class Divider {
    public static View create(Context context) {
        View divider = new View(context);
        LinearLayout.LayoutParams dividerParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                2
        );
        dividerParams.setMargins(0, 8, 0, 8);
        divider.setLayoutParams(dividerParams);
        divider.setBackgroundColor(ContextCompat.getColor(context, android.R.color.darker_gray));
        return divider;
    }
}
