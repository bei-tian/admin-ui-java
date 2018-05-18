package com.beitian.adminuijava.service;


import com.beitian.adminuijava.entity.Menu;
import com.beitian.adminuijava.object.MenuTree;
import com.beitian.adminuijava.repository.MenuRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    public List<MenuTree> getTree(int parentId) {
        List<Menu> list = menuRepository.findByParentId(parentId);
        List<MenuTree> out = new LinkedList<>();
        for (Menu menu: list) {
            MenuTree menuTree = new MenuTree();
            BeanUtils.copyProperties(menu,menuTree);
            List<MenuTree> sub = getTree(menu.getId());
            menuTree.setSub(sub);
            out.add(menuTree);
        }
        return out;
    }
}
