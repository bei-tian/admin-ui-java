package com.beitian.adminuijava.controller;

import com.beitian.adminuijava.entity.Admin;
import com.beitian.adminuijava.object.Result;
import com.beitian.adminuijava.repository.AdminRepository;
import com.beitian.adminuijava.util.MD5Util;
import com.beitian.adminuijava.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    AdminRepository adminRepository;

    @GetMapping(value = "/login")
    public String index() {
        return "login";
    }



    //登陆操作
    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@Valid Admin admin, BindingResult bindingResult, HttpSession session) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception(bindingResult.getFieldError().getDefaultMessage());
        }
        String account = admin.getAccount();
        String password = MD5Util.MD5(admin.getPassword());
        Admin exist = adminRepository.findByAccountAndPassword(account, password);
        if (exist == null) {
            throw new Exception("账号或密码错误");
        }

        session.setAttribute("id", exist.getId());
        session.setAttribute("account", account);
        return ResultUtil.success(exist);
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public Optional<Admin> test() {
        return adminRepository.findById(1);
    }
}
