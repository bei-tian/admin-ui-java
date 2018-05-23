package com.beitian.adminuijava.controller;

import com.beitian.adminuijava.entity.Info;
import com.beitian.adminuijava.object.Result;
import com.beitian.adminuijava.repository.InfoRepository;
import com.beitian.adminuijava.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/info")
public class InfoController {

    @Autowired
    InfoRepository infoRepository;

    @GetMapping("")
    public String index(Model model, @PageableDefault(value = 15) Pageable pageable) {
        Page<Info> page = infoRepository.findAll(pageable);
        model.addAttribute("page", page);
        return "/info/index";
    }


    @GetMapping("/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        if (id > 0 ){
            Info item = infoRepository.findById(id).get();
            model.addAttribute("item", item);
        }
        return "/info/form";
    }




    @PutMapping("/{id}")
    @ResponseBody
    public Result save(Info info) {
        infoRepository.save(info);
        return ResultUtil.success();
    }



    @DeleteMapping("/{id}")
    @ResponseBody
    public Result del(@PathVariable Integer id) {
        infoRepository.deleteById(id);
        return ResultUtil.success();
    }
}
