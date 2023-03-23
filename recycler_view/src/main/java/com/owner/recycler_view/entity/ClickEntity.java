
package com.owner.recycler_view.entity;


public class ClickEntity {
    public static final int CLICK_ITEM_VIEW = 1;
    public static final int CLICK_ITEM_CHILD_VIEW = 2;
    public static final int LONG_CLICK_ITEM_VIEW = 3;
    public static final int LONG_CLICK_ITEM_CHILD_VIEW = 4;
    private final int type;

    public ClickEntity(final int type) {
        this.type = type;
    }

    public int getItemType() {
        return type;
    }
}
