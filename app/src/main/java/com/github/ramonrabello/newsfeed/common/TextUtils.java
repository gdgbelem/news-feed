package com.github.ramonrabello.newsfeed.common;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.github.ramonrabello.newsfeed.R;

public class TextUtils {

    public static final String OPEN_SANS_BOLD = "OpenSans-Bold.ttf";
    public static final String OPEN_SANS_SEMI_BOLD = "OpenSans-Semibold.ttf";
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
        titleSpannable.setSpan(new AbsoluteSizeSpan(size, true), 0, titleSpannable.length(), Spannable.SPAN_COMPOSING);
        actionBar.setTitle(titleSpannable);
    }
}
