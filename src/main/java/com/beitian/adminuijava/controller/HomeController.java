package com.beitian.adminuijava.controller;

import com.beitian.adminuijava.entity.InfoCate;
import com.beitian.adminuijava.entity.Menu;
import com.beitian.adminuijava.repository.MenuRepository;
import com.beitian.adminuijava.service.MenuService;
import com.beitian.adminuijava.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private MenuService menuService;

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/")
    public String index() {
        return "home";
    }



    @GetMapping("/home/nav")
    @ResponseBody
    public Object nav() {

        return ResultUtil.success(menuService.getTree(0));
    }





    @GetMapping("/test222")
    @ResponseBody
    public Page<Menu> test(@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {

        return menuRepository.findAll(pageable);

    }
}
