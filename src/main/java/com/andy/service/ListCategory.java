package com.andy.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Lim, Andy
 * @Date: 2022/1/6
 * @Proposal:
 */
public class ListCategory {

    public List toUnmodifiableList(List<Object> list) {
        //unmodificable list
        list = Collections.unmodifiableList(list);
        return list;
    }
}
