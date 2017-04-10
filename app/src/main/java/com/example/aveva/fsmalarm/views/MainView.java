package com.example.aveva.fsmalarm.views;

import android.content.Context;

/**
 * Created by aveva on 07.04.2017.
 */

public interface MainView {
    Context getContext();

    void isArmed(boolean isArmed, String state);
}
