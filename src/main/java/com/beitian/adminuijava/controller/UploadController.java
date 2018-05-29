package com.beitian.adminuijava.controller;

import com.beitian.adminuijava.object.Result;
import com.beitian.adminuijava.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UploadController {

    @Value("${uploadPath}")
    private String uploadPath;

    @Autowired
    ResourceLoader resourceLoader;

    @PostMapping("/upload")
    @ResponseBody
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());
        File dir = new File(uploadPath + date);
        if (!dir.exists()) {
            dir.mkdir();
        }

        SimpleDateFormat timeFormat = new SimpleDateFormat("hhmmss");
        String[] arr = file.getOriginalFilename().split("\\.");
        String fileName = timeFormat.format(new Date()) + "." +arr[arr.length -1];
        //文件名:时间.后缀
        FileOutputStream out = new FileOutputStream(uploadPath + date + "/" + fileName);
        out.write(file.getBytes());
        out.flush();
        out.close();

        return ResultUtil.success(date + "/" + fileName);
    }



}
