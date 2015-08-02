package com.takeoffandroid.tabwithrecyclerview.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

/**
 * Created by Chandru-MacBook on 8/2/15.
 */
public class Util {

    public static Drawable setActionBarIcon(Context context, MaterialDrawableBuilder.IconValue icon, int color) {
     return   MaterialDrawableBuilder.with(context)
                .setIcon(icon)
                .setColor(color)
                .setToActionbarSize()
                .build();
    }

    public static Drawable setIconForViews(Context context, MaterialDrawableBuilder.IconValue icon, int color,int size) {
        return   MaterialDrawableBuilder.with(context)
                .setIcon(icon)
                .setColor(color)
                .setSizeDp(size)
                .build();
    }
}
