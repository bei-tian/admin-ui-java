package com.beitian.adminuijava.controller;

import com.beitian.adminuijava.entity.Admin;
import com.beitian.adminuijava.entity.InfoCate;
import com.beitian.adminuijava.object.Result;
import com.beitian.adminuijava.repository.InfoCateRepository;
import com.beitian.adminuijava.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/info_cate")
public class InfoCateController {

    @Autowired
    InfoCateRepository infoCateRepository;

    @GetMapping("/index")
    public String  index(Model model, @PageableDefault(value = 15) Pageable pageable) {
        Page<InfoCate> page = infoCateRepository.findAll(pageable);
        model.addAttribute("page",page);
        return "/info_cate/index";
    }

    @GetMapping("/add")
    public String add(Model model, @RequestParam(value = "id", defaultValue = "0") int id) {
        InfoCate infoCate = null;
        if(id >0) {
            Optional<InfoCate> item = infoCateRepository.findById(id);
            infoCate = item.get();
        }

        model.addAttribute("item", infoCate);
        return "/info_cate/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Result save(InfoCate infoCate) {
        infoCateRepository.save(infoCate);

        return ResultUtil.success(null);
    }
}
