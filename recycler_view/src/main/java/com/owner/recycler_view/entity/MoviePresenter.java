package com.owner.recycler_view.entity;

import android.view.View;

import com.owner.recycler_view.utils.Tips;


/**
 *  16/10/24.
 */

public class MoviePresenter {
    public void buyTicket(View view, Movie movie) {
        Tips.show("buy ticket: " + movie.name);
    }
}
