package com.beitian.adminuijava.object;

import com.beitian.adminuijava.entity.Menu;

import java.util.List;

public class MenuTree extends Menu {
    private List<MenuTree> sub;

    public MenuTree() {
    }

    public List<MenuTree> getSub() {
        return sub;
    }

    public void setSub(List<MenuTree> sub) {
        this.sub = sub;
    }

    @Override
    public String toString() {
        return "MenuTree{" +
                "sub=" + sub +
                '}';
    }
}
