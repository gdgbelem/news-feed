package com.github.ramonrabello.newsfeed.news;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Base view holder for all application view holders. If a new view holder is created, it should inherit from
 * this class.
 *
 * @param <T> The type associated to this view holder.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    /**
     * Binds data type to view holder content.
     *
     * @param modelType The type to be bound in the view holder.
     */
    public abstract void bind(T modelType);

    protected Context getContext(){
        return itemView.getContext();
    }

    protected Resources getResources(){
        return itemView.getContext().getResources();
    }

    protected AssetManager getAssets(){
        return itemView.getContext().getAssets();
    }

    protected String getString(@StringRes int resId, Object... formatArgs){
        return itemView.getContext().getString(resId, formatArgs);
    }

    protected int getColor(@ColorRes int resId){
        return ContextCompat.getColor(getContext(), resId);
    }
}