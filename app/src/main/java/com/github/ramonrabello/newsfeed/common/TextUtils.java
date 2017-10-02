package com.github.ramonrabello.newsfeed.common;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

public class TextUtils {

    public static final String OPEN_SANS_LIGHT = "OpenSans-Light.ttf";
    public static final String OPEN_SANS_REGULAR = "OpenSans-Regular.ttf";

    public static void asLight(AssetManager assetsManager, TextView textView) {
        Typeface font = Typeface.createFromAsset(assetsManager, "fonts/" + OPEN_SANS_LIGHT);
        textView.setTypeface(font);
    }

    public static void asRegular(AssetManager assetsManager, TextView textView) {
        Typeface font = Typeface.createFromAsset(assetsManager, "fonts/" + OPEN_SANS_REGULAR);
        textView.setTypeface(font);
    }

    public static void spanToolbarTitle(Context context, CharSequence text, int size, ActionBar actionBar) {
        SpannableStringBuilder titleSpannable = new SpannableStringBuilder(text);
        titleSpannable.setSpan(new CustomTypefaceSpan(Typeface.createFromAsset(context.getAssets(), "fonts/" + OPEN_SANS_LIGHT)), 0, titleSpannable.length(), Spannable.SPAN_COMPOSING);
        actionBar.setTitle(titleSpannable);
    }
}
