package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PhotoController extends BaseController {


   @Autowired
   private UploadService uploadService;


    /**
     *  单文件上传
     * @param file
     * @return
     */
    @PostMapping(value = "/uploadHead",produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadHead(@RequestPart MultipartFile file){ {
        System.out.println( "provider层"+file.getOriginalFilename());

       String path =uploadService.uploadHead(file);
        return path;
         }
       }

    /***
     * 多文件上传
     */
    @PostMapping(value = "/upload",headers = "content-type=multipart/form-data")
    public String upload(@RequestPart(value = "file") MultipartFile[] file) {
             String path="";
            String paths="";
             System.out.println(file.length);
        Map<String,Object> map= new HashMap<String,Object>();
          for (MultipartFile fina : file) {
            System.out.println("provider层" + fina.getOriginalFilename());
            path= uploadService.uploadHead(fina);
            path=path+";";
            paths+=path;
        }
        System.out.println("================"+paths);
        return paths;
    }

}
