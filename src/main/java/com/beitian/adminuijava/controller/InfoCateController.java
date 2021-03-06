package com.beitian.adminuijava.controller;

import com.beitian.adminuijava.entity.InfoCate;
import com.beitian.adminuijava.object.Result;
import com.beitian.adminuijava.repository.InfoCateRepository;
import com.beitian.adminuijava.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/info_cate")
public class InfoCateController {

    @Autowired
    InfoCateRepository infoCateRepository;

    @GetMapping("")
    public String index(Model model, @PageableDefault(value = 15) Pageable pageable) {
        Page<InfoCate> page = infoCateRepository.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("base", "info_cate");
        return "/info_cate/index";
    }


    @GetMapping("/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        if (id > 0 ){
            InfoCate item = infoCateRepository.findById(id).get();
            model.addAttribute("item", item);
        }
        return "/info_cate/form";
    }




    @PutMapping("/{id}")
    @ResponseBody
    public Result save(InfoCate infoCate) {
        infoCateRepository.save(infoCate);
        return ResultUtil.success();
    }



    @DeleteMapping("/{id}")
    @ResponseBody
    public Result del(@PathVariable Integer id) {
        infoCateRepository.deleteById(id);
        return ResultUtil.success();
    }

}
