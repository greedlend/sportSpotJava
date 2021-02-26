package com.andy.enums;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/19
 * @Proposal:
 */
public enum Pagination {
    NEXT_PAGE(1),
    PREVIOUS_PAGE(2);

    private int value;
    Pagination(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
